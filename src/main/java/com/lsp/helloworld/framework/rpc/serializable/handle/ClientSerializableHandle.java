package com.lsp.helloworld.framework.rpc.serializable.handle;

import com.lsp.helloworld.framework.rpc.common.ResponseContent;
import com.lsp.helloworld.framework.rpc.serializable.SerializableInt;
import com.lsp.helloworld.framework.rpc.serializable.StreamSerializable;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 客户端解码
 * @author lishuaipeng
 * @date 2020/8/11/10:04 上午
 */
//@ChannelHandler.Sharable
public class ClientSerializableHandle extends ByteToMessageDecoder {

    private SerializableInt serializable;

    public ClientSerializableHandle(){
        this.serializable = new StreamSerializable();
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buf, List<Object> list) throws Exception {
        byte[] bytes = new byte[buf.readableBytes()];
        buf.getBytes(buf.readerIndex(),bytes);  //从哪里读取，读多少，但是readindex不变
        ResponseContent contest = serializable.decode(bytes, ResponseContent.class);
        list.add(contest);
    }
}
