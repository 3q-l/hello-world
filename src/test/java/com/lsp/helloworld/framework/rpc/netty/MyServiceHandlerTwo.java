package com.lsp.helloworld.framework.rpc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author lishuaipeng
 * @date 2020/8/7/5:10 下午
 */
public class MyServiceHandlerTwo extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
//        CharSequence str = buf.readCharSequence(buf.readableBytes(), CharsetUtil.UTF_8);
        CharSequence str = buf.getCharSequence(0,buf.readableBytes(), CharsetUtil.UTF_8);
        System.out.println(str);
        // TODO doing something
        String response = doSomething(ctx,str);
        ByteBuf resBuf = Unpooled.copiedBuffer(response.getBytes());
        ctx.writeAndFlush(resBuf);
    }

    private String doSomething(ChannelHandlerContext ctx, CharSequence str){
        String response = str.toString();
        InetSocketAddress socketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        return response + "-" + socketAddress.getHostName() + "-" + socketAddress.getAddress() + "-" + socketAddress.getPort();
    }
}
