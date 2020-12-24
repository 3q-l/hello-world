package com.lsp.helloworld.demo.guava.eventBus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lishuaipeng
 * @date 2020/12/4 下午1:48
 */
@Data
@AllArgsConstructor
public class OrderEvent {

    private String orderSn;

}
