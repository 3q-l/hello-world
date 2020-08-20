package com.lsp.helloworld.framework.rpc.serializable;


/**
 * @author lishuaipeng
 * @date 2020/8/10/7:20 下午
 */
public interface SerializableInt  {
    /**
     * 编码
     * @param obj
     * @return
     */
    byte[] enCoding(Object obj) throws Exception;

    <T>T decode(byte[] msg, Class<T> clazz) throws Exception ;
}
