package com.lsp.helloworld.framework.rpc.common;

import io.netty.channel.ChannelHandler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lishuaipeng
 * @date 2020/8/11/9:41 上午
 */
@ChannelHandler.Sharable
public class BaseRegistryCenter  implements RegistryCenter{
    /**
     * 类名服务中心
     */
    public final static Map<String, List<MyContent>> nameMap = new ConcurrentHashMap<>(16);

//    public Map<String, List<MyContent>> getMap(){
//        return nameMap;
//    }
}
