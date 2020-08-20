package com.lsp.helloworld.framework.rpc.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lishuaipeng
 * @date 2020/8/10/4:03 下午
 */
@Data
@Builder
public class MyContent implements Serializable {
    private static final long serialVersionUID = -1985165475234910535L;
    private int port;
    private String ip;

    private String className;
//    private Map<String, Class<?>[]> methodParameters;

    // 事件
    private RPCEnumS handle;

    private String methodName;
    private Object[] args;
}
