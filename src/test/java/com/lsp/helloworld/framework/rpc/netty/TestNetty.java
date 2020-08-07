package com.lsp.helloworld.framework.rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;

import java.net.InetSocketAddress;

/**
 * @author lishuaipeng
 * @date 2020/8/7/3:49 下午
 */
public class TestNetty {

    @Test
    public void testClient() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MyClientHandler());
                    }
                })
                .connect(new InetSocketAddress("localhost", 9090));
        Channel client = connect.sync().channel();
        try {
//            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("sleep  error");
        }
        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        client.writeAndFlush(buf).sync();

        // 直接结束关闭连接
//        client.closeFuture();
        // 等待返回值
        // 短连接的话配合 MyClientHandler -> channelRead ctx.close();这个关闭
        client.closeFuture().sync();
    }

    @Test
    public void testService() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        ServerBootstrap bs = new ServerBootstrap();
        ChannelFuture bind = bs.group(group, group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MyServiceHandler());
                    }
                })
                .bind(new InetSocketAddress("localhost", 9090));
        System.out.println("service 启动成功。。。。。。");
        bind.sync().channel().closeFuture().sync();
        System.out.println("service 结束。。。。。。");
    }


}
