package com.lsp.helloworld.test;

import com.lsp.helloworld.DBConnector;
import com.lsp.helloworld.common.ErrorCode;
import com.lsp.helloworld.common.Response;
import com.lsp.helloworld.service.RedisService;
import com.lsp.helloworld.dto.UserDTO;
import com.lsp.helloworld.entity.LOrder;
import com.lsp.helloworld.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author lsp
 * @date 2018/12/4/4:58 PM
 */
@Slf4j
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    UserDTO user;
    @Resource
    DBConnector dBconnector;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisService redisService;

    @GetMapping("hi")
    public String hi(){
        log.info("你好");
        dBconnector.configure();
        return "test:hi 你好"+user.getName()
                + user.getValue() +"随机:"+user.getNumber();
    }

    @RequestMapping(value = "orderSn/{orderSn}", method = RequestMethod.GET)
    public Response order(@PathVariable("orderSn") String orderSn){
        LOrder order = orderService.getOrder(orderSn);
        return new Response(ErrorCode.SUCCESS.code,ErrorCode.SUCCESS.message,order);
    }

    @RequestMapping(value = "redis/{key}/{value}/{time}/minutes", method = RequestMethod.GET)
    public Response redis(@PathVariable("key") String key,
                          @PathVariable("value") String value,
                          @PathVariable("time") Integer time){
        redisService.insertValue(key,value,time,TimeUnit.MINUTES);
        return new Response(ErrorCode.SUCCESS.code,ErrorCode.SUCCESS.message,null);
    }

    @RequestMapping(value = "redis/{key}", method = RequestMethod.GET)
    public Response redisValue(@PathVariable("key") String key){
        String value = redisService.getValue(key);
        return new Response(ErrorCode.SUCCESS.code,ErrorCode.SUCCESS.message,value);
    }
}
