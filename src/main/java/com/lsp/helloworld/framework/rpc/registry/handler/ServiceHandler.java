package com.lsp.helloworld.framework.rpc.registry.handler;

import com.alibaba.fastjson.JSON;
import com.lsp.helloworld.framework.rpc.common.MyContent;
import com.lsp.helloworld.framework.rpc.common.RPCEnumS;
import com.lsp.helloworld.framework.rpc.common.ResponseContent;
import com.lsp.helloworld.framework.rpc.registry.BaseRegistry;
import com.lsp.helloworld.framework.rpc.registry.RegistryConfig;
import com.lsp.helloworld.framework.rpc.serializable.SerializableInt;
import com.lsp.helloworld.framework.rpc.serializable.StreamSerializable;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.SneakyThrows;

import java.util.List;

/**
 * @author lishuaipeng
 * @date 2020/8/10/7:10 下午
 */
@ChannelHandler.Sharable
public class ServiceHandler extends ChannelInboundHandlerAdapter {

    private RegistryConfig registry;

    private SerializableInt serializable;

    public ServiceHandler(){
        this.registry = new BaseRegistry();
        this.serializable = new StreamSerializable();
    }

    public ServiceHandler(RegistryConfig registry, SerializableInt serializable){
        this.registry = registry;
        this.serializable = serializable;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client  注册...");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client active...");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(JSON.toJSONString(msg));
        MyContent content = (MyContent) msg;
        // 使用netty自己的eventloop来处理业务及返回
        ctx.executor().execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                RPCEnumS handle = content.getHandle();
                switch (handle){
                    case PING:
                        // 心跳检测 检测服务提供者是否存活
                        // 判断出提供者已经死亡 需要剔除服务
                        break;
                    case REGISTRY:
                        System.out.println("REGISTRY------------------------");
                        registry.registry(content);
                        break;
                    case UN_REGISTRY:
                        System.out.println("UN_REGISTRY------------------------");
                        registry.unRegister(content);
                        break;
                    case LOOKUP:
                        List<MyContent> lookup = registry.lookup(content);
                        ResponseContent response = new ResponseContent();
                        response.setList(lookup);
                        byte[] bytes = serializable.enCoding(response);
                        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(bytes.length);
                        byteBuf.writeBytes(bytes);
                        ctx.writeAndFlush(byteBuf);
                        break;
                    case REQUEST:
                        break;
                    case RESPONSE:
                        break;
                }
            }
        });
    }

}
