package com.lsp.helloworld.framework.spu.read;

import com.lsp.helloworld.framework.spu.lifecycle.ILifecycle;

/**
 * @author lsp
 * @date 2020/6/18/12:20 AM
 */
public interface ITextRead extends ILifecycle {
    /**
     * 读一行 返回json串
     * @param
     * @author lsp
     * @date 2020/6/18 12:24 AM
     * @return json
     */
    String readLine() throws Exception;
}
