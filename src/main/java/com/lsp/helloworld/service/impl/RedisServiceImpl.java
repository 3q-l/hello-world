package com.lsp.helloworld.service.impl;

import com.lsp.helloworld.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lsp
 * @date 2018/12/12/11:14 AM
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public ValueOperations getRedis(){
        return redisTemplate.opsForValue();
    }

    @Override
    public void insertValue(String key, String value, Integer time, TimeUnit timeUnit) {
        ValueOperations redis = getRedis();
        redis.set(key,value,time,timeUnit);
    }

    @Override
    public String getValue(String key) {
        ValueOperations redis = getRedis();
        String value = (String) redis.get(key);
        return value;
    }
}
