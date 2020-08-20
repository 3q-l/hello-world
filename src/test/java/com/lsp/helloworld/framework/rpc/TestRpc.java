package com.lsp.helloworld.framework.rpc;

import com.alibaba.fastjson.JSON;
import com.lsp.helloworld.framework.rpc.common.*;
import com.lsp.helloworld.framework.rpc.registry.BaseRegistry;
import com.lsp.helloworld.framework.rpc.registry.RegistryConfig;
import com.lsp.helloworld.framework.rpc.serializable.SerializableInt;
import com.lsp.helloworld.framework.rpc.serializable.StreamSerializable;
import com.lsp.helloworld.framework.rpc.serializable.handle.ClientSerializableHandle;
import com.lsp.helloworld.framework.rpc.util.IpUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.HashMap;

/**
 * 自研基于netty的rpc调用
 * @author lishuaipeng
 * @date 2020/8/7/3:05 下午
 */
public class TestRpc {

    // 注册中心的数据仓库+注册中心的仓库
//    private final static RegistryCenter center;
    private Integer registryPort = 9090;

    private Integer clientRegistryPort = 9091;

    private final static String ip = IpUtils.getIp();
//    static {
//        center = new BaseRegistryCenter();
//    }

    /**
     * 启动注册中心
     * @throws Exception
     */
    @Test
    public void startRegistry() throws Exception{
        RegistryConfig registry = new BaseRegistry(registryPort);
        registry.init();
        registry.start();
    }

    @Test
    public void testRegistry() throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ClientSerializableHandle());
                        p.addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ResponseContent response = (ResponseContent) msg;
                                System.out.println(JSON.toJSONString(response));
                                ctx.close();
                            }
                        });
                    }
                })
                .connect(new InetSocketAddress("localhost", registryPort));
        Channel client = connect.sync().channel();
        try {
//            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("sleep  error");
        }
        DemoService demoService = new DemoServiceImpl();
        InetSocketAddress socketAddress = (InetSocketAddress) client.localAddress();
        MyContent content = getContent(RPCEnumS.REGISTRY, socketAddress.getPort(), demoService);
        SerializableInt serializableInt = new StreamSerializable();
        byte[] bytes = serializableInt.enCoding(content);
        ByteBuf buf = Unpooled.copiedBuffer(bytes);
        client.writeAndFlush(buf).sync();
        client.closeFuture().sync();
    }

    @Test
    public void testLookup() throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ClientSerializableHandle());
                        p.addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ResponseContent response = (ResponseContent) msg;
                                System.out.println("client succent ~~~~~~~~");
                                System.out.println(JSON.toJSONString(response));
                                ctx.close();
                            }
                        });
                    }
                })
                .connect(new InetSocketAddress("localhost", registryPort));
        Channel client = connect.sync().channel();
        try {
//            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("sleep  error");
        }
        DemoService demoService = new DemoServiceImpl();
        InetSocketAddress socketAddress = (InetSocketAddress) client.localAddress();
        MyContent content = getContent(RPCEnumS.LOOKUP, socketAddress.getPort(), demoService);
        SerializableInt serializableInt = new StreamSerializable();
        byte[] bytes = serializableInt.enCoding(content);
        ByteBuf buf = Unpooled.copiedBuffer(bytes);
        client.writeAndFlush(buf).sync();
        client.closeFuture().sync();
    }


    private MyContent getContent(RPCEnumS handle,Integer port,Object obj){
        Class<?> aClass = obj.getClass();
        String className = aClass.getInterfaces()[0].getName();
//        Map
//        for (Method method : methods) {
//
//        }
        MyContent content = MyContent.builder()
                .handle(handle)
                .ip(ip)
                .port(port)
                .className(className)
                .build();
        return content;
    }

    @Test
    public void test111(){
        HashMap<String,String> map = new HashMap();
        map.put("1","1");
    }

}
