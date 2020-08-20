package com.lsp.helloworld.framework.rpc.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author lishuaipeng
 * @date 2020/8/10/7:21 下午
 */
public class StreamSerializable implements SerializableInt {

    static ByteArrayOutputStream out = new ByteArrayOutputStream();


    @Override
    public byte[] enCoding(Object obj) throws Exception {
        synchronized (this){
            out.reset();
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(obj);
            byte[] msgBody= out.toByteArray();
            return msgBody;
        }
    }

    @Override
    public <T> T decode(byte[] msg, Class<T> clazz) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(msg);
        ObjectInputStream oin = new ObjectInputStream(in);
        return (T) oin.readObject();
    }
}
