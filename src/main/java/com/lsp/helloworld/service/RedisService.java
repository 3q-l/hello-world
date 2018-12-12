package com.lsp.helloworld.service;

import java.util.concurrent.TimeUnit;

/**
 * @author lsp
 * @date 2018/12/12/11:13 AM
 */
public interface RedisService {

    /**
     * 有效时间存入
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     */
    void insertValue(String key, String value, Integer time, TimeUnit timeUnit);

    /**
     * 取值
     * @param key
     * @return
     */
    String getValue(String key);
}
