package com.lsp.helloworld.framework.rpc.util;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author lishuaipeng
 * @date 2020/8/10/7:02 下午
 */
public class NettyUtils {

    /**
     * 客户端发送信息
     * @param hostName
     * @param port
     * @param handler
     * @throws InterruptedException
     */
    public void client(String hostName, int port, ChannelHandler handler) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(handler);
                    }
                })
                .connect(new InetSocketAddress(hostName, port));
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

    /**
     * 服务端接收数据
     * @param hostName
     * @param port
     * @param handler
     * @throws InterruptedException
     */
    public void service(String hostName, int port, ChannelHandler handler) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        ServerBootstrap bs = new ServerBootstrap();
        ChannelFuture bind = bs.group(group, group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(handler);
                    }
                })
                .bind(new InetSocketAddress(hostName, port));
        System.out.println("service 启动成功。。。。。。");
        bind.sync().channel().closeFuture().sync();
        System.out.println("service 结束。。。。。。");
    }
}
