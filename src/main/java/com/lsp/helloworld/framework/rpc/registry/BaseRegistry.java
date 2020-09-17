package com.lsp.helloworld.framework.rpc.registry;

import com.alibaba.fastjson.JSON;
import com.lsp.helloworld.framework.rpc.common.BaseRegistryCenter;
import com.lsp.helloworld.framework.rpc.common.MyContent;
import com.lsp.helloworld.framework.rpc.lifecycle.AbstractLifecycle;
import com.lsp.helloworld.framework.rpc.registry.handler.ServiceHandler;
import com.lsp.helloworld.framework.rpc.serializable.handle.ServiceSerializableHandle;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 基础注册中心
 *  创建需要指定中心仓库+注册中心端口号 如果不传默认使用基础注册中心+端口号9090
 * @author lishuaipeng
 * @date 2020/8/10/4:52 下午
 */

public class BaseRegistry extends AbstractLifecycle implements RegistryConfig {

//    private RegistryCenter registryCenter;
    private String ip;
    private Integer port;

    public BaseRegistry() {
//        this.registryCenter = new BaseRegistryCenter();
        this("localhost",9090);
    }

    public BaseRegistry (String ip,Integer port){
//        this.registryCenter = registryCenter;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void registry(MyContent myContent) throws Exception {
        // 后续考虑
//        if (registryCenter instanceof BaseRegistryCenter){
//            BaseRegistryCenter baseRegistryCenter = (BaseRegistryCenter) registryCenter;
//        }
        System.out.println("start:--------"+JSON.toJSONString(BaseRegistryCenter.nameMap));
//        BaseRegistryCenter baseRegistryCenter = (BaseRegistryCenter) registryCenter;
        Map<String, List<MyContent>> nameMap =
                BaseRegistryCenter.nameMap;
        String className = myContent.getClassName();
        List<MyContent> myContents =
                nameMap.get(className);
        if (CollectionUtils.isEmpty(myContents)){
            myContents = new ArrayList<>();
            myContents.add(myContent);
        } else {
            // 需要替换对应的数据中心所以 要使用fori循环
            for (int i = 0; i < myContents.size(); i++) {
                MyContent content = myContents.get(i);
                if (content.getIp().equals(myContent.getIp()) && content.getPort() == myContent.getPort()){
                    myContents.remove(i);
                    break;
                }
            }
            myContents.add(myContent);
        }
        nameMap.put(myContent.getClassName(),myContents);
//        baseRegistryCenter.setNameMap(nameMap);
//        System.out.println("end:--------"+JSON.toJSONString(registryCenter));
        System.out.println("end:--------"+ JSON.toJSONString(BaseRegistryCenter.nameMap));
    }

    @Override
    public void unRegister(MyContent myContent) throws Exception {
//        BaseRegistryCenter baseRegistryCenter = (BaseRegistryCenter) registryCenter;
        Map<String, List<MyContent>> nameMap =
                BaseRegistryCenter.nameMap;
        String className = myContent.getClassName();
        List<MyContent> myContents =
                nameMap.get(className);
        if (!CollectionUtils.isEmpty(nameMap)){
            // 找到对应的数据中心然后移除
            for (int i = 0; i < myContents.size(); i++) {
                MyContent content = myContents.get(i);
                if (content.getIp().equals(myContent.getIp()) && content.getPort() == myContent.getPort()){
                    myContents.remove(i);
                    break;
                }
            }
        }
        if (CollectionUtils.isEmpty(myContents)){
            nameMap.remove(myContent.getClassName());
        }
    }

    @Override
    public List<MyContent> lookup(MyContent myContent) throws Exception {
        if (StringUtils.isEmpty(myContent.getClassName())){
            return Collections.emptyList();
        }
//        BaseRegistryCenter baseRegistryCenter = (BaseRegistryCenter) registryCenter;
        Map<String, List<MyContent>> nameMap =
                BaseRegistryCenter.nameMap;
        List<MyContent> myContents = nameMap.get(myContent.getClassName());
        return myContents;
    }

    @Override
    public void init() throws Exception {
        super.init();
//        if (registryCenter == null){
//            throw new RuntimeException("注册中心不能为空");
//        }
    }

    @Override
    public void start() throws Exception {
        super.start();
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        ServerBootstrap bs = new ServerBootstrap();
        ChannelFuture bind = bs.group(group, group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ServiceSerializableHandle());
                        p.addLast(new ServiceHandler());
                    }
                })
                .bind(new InetSocketAddress(ip, port));
        System.out.println("service 启动成功。。。。。。");
        bind.sync().channel().closeFuture().sync();
        System.out.println("service 结束。。。。。。");
    }

    @Override
    public void stop() {
        super.stop();
        // 在分布式中 服务提供方与消费方不在同一个jvm中需要注册销毁的时候需要考虑把注册中心销毁
        //   该测试中我会在用一套jvm中测试所以不能清空注册中心数据
        // registryCenter = null;
    }
}
