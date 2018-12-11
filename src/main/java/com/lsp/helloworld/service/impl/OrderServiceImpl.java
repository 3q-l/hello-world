package com.lsp.helloworld.service.impl;

import com.lsp.helloworld.dao.LOrderDao;
import com.lsp.helloworld.dao.LOrderInfoDao;
import com.lsp.helloworld.entity.LOrder;
import com.lsp.helloworld.entity.LOrderExample;
import com.lsp.helloworld.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lsp
 * @date 2018/12/11/3:47 PM
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private LOrderDao lOrderDao;
    @Resource
    private LOrderInfoDao lOrderInfoDao;


    @Override
    public LOrder getOrder(String orderSn) {
        LOrderExample example = new LOrderExample();
        LOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderSnEqualTo(orderSn);

        List<LOrder> orders = lOrderDao.selectByExample(example);

        LOrder order = null;
        if (!CollectionUtils.isEmpty(orders)){
            order = orders.get(0);
        }
        return order;
    }
}
