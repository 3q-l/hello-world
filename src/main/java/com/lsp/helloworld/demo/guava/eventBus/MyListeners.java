package com.lsp.helloworld.demo.guava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * @author lishuaipeng
 * @date 2020/12/4 下午1:47
 */
public class MyListeners {

    /**
     * 下单事件
     */
    @Subscribe
    public void orderEvent(OrderEvent orderEvent){
        System.out.println("下单成功:订单号：{"+orderEvent.getOrderSn()+"}");
    }

    /**
     * 支付事件
     */
    @Subscribe
    public void payEvent(PayEvent payEvent){
        System.out.println("支付成功:订单号：{"+payEvent.getOrderSn()+"}，支付单号：{"+payEvent+"}");
    }
}
