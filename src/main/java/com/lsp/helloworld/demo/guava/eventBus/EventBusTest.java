package com.lsp.helloworld.demo.guava.eventBus;

import com.google.common.eventbus.EventBus;

/**
 * @author lishuaipeng
 * @date 2020/12/4 下午1:38
 */
public class EventBusTest {

    public static void main(String[] args) {
        // 1、创建事件总线
        EventBus eventBus = new EventBus();
        // 2、注册监听器
        eventBus.register(new MyListeners());
        // 3、发送消息
        eventBus.post(new OrderEvent("2020120411111234"));
        eventBus.post(new PayEvent("2020120411111234","PAY_2020120411111234"));
    }
}
