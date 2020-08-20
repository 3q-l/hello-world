package com.lsp.helloworld.framework.rpc.serializable.handle;

import com.lsp.helloworld.framework.rpc.common.MyContent;
import com.lsp.helloworld.framework.rpc.serializable.SerializableInt;
import com.lsp.helloworld.framework.rpc.serializable.StreamSerializable;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author lishuaipeng
 * @date 2020/8/11/10:18 上午
 */
//@ChannelHandler.Sharable
public class ServiceSerializableHandle extends ByteToMessageDecoder {

    private SerializableInt serializable;

    public ServiceSerializableHandle(){
        this.serializable = new StreamSerializable();
    }

    public ServiceSerializableHandle(SerializableInt serializable){
        this.serializable = serializable;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buf, List<Object> list) throws Exception {
        byte[] bytes = new byte[buf.readableBytes()];
        buf.getBytes(buf.readerIndex(),bytes);
        MyContent contest = serializable.decode(bytes, MyContent.class);
        list.add(contest);
    }
}
