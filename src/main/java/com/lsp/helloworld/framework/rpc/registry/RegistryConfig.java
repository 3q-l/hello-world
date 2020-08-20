package com.lsp.helloworld.framework.rpc.registry;

import com.lsp.helloworld.framework.rpc.common.MyContent;
import com.lsp.helloworld.framework.rpc.lifecycle.ILifecycle;

import java.util.List;

/**
 * @author lishuaipeng
 * @date 2020/8/10/4:39 下午
 */
public interface RegistryConfig extends ILifecycle {

    /**
     * 往注册中心注册服务
     * @param myContent
     * @return
     */
    void registry(MyContent myContent) throws Exception;

    /**
     * 取消服务注册
     * @param myContent
     * @return
     */
    void unRegister(MyContent myContent) throws Exception;

    /**
     * 查找服务地址 ----- 消费者调用
     * @param myContent
     * @return
     */
    List<MyContent> lookup(MyContent myContent) throws Exception;
}
