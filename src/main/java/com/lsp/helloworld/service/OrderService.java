package com.lsp.helloworld.service;

import com.lsp.helloworld.entity.LOrder;

/**
 * @author lsp
 * @date 2018/12/11/3:46 PM
 */
public interface OrderService {

    LOrder getOrder(String orderSn);
}
