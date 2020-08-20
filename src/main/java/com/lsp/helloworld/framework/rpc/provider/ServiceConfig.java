package com.lsp.helloworld.framework.rpc.provider;

import com.lsp.helloworld.framework.rpc.lifecycle.ILifecycle;

/**
 * 服务提供者
 * @author lishuaipeng
 * @date 2020/8/10/4:06 下午
 */
public interface ServiceConfig<T> extends ILifecycle {

    T getService();


}
