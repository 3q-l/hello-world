package com.lsp.helloworld.spu;

/**
 * @author lsp
 * @date 2020/6/18/12:26 AM
 */
public interface ILifecycle {

    /**
     * 初始化
     * @author lsp
     * @date 2020/6/18 12:26 AM
     * @return
     */
    void init();

    /**
     * 启动
     * @author lsp
     * @date 2020/6/18 12:27 AM
     * @return
     */
    void start();

    /**
     * 关闭
     * @author lsp
     * @date 2020/6/18 12:27 AM
     * @return
     */
    void close();
}
