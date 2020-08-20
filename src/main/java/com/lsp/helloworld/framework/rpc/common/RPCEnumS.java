package com.lsp.helloworld.framework.rpc.common;

/**
 * @author lishuaipeng
 * @date 2020/8/11/9:24 上午
 */
public enum RPCEnumS {
    PING,
    // 跟注册中心通信
    REGISTRY,
    UN_REGISTRY,
    LOOKUP,

    // 请求逻辑
    REQUEST,
    // 返回逻辑
    RESPONSE,
}
