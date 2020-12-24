package com.lsp.helloworld.demo.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * @author lishuaipeng
 * @date 2020/12/4 下午5:42
 */
public class CacheTest {

    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Object, Object> cache = CacheBuilder.newBuilder()
                .build(new CacheLoader<Object, Object>() {
                    @Override
                    public Object load(Object key) throws Exception {
                        System.out.println(key);
                        return "---";
                    }
                });
        cache.put("key1","obj");
        Object value = cache.get("key2");
        System.out.println(value);
    }
}
