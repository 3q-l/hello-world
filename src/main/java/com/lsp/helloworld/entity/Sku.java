package com.lsp.helloworld.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author lsp
 * @date 2018/12/11/3:56 PM
 */
@Data
public class Sku {
    private Long id;
    private String name;
    private String desc;
    private Integer price;
    private String specKey;
    private String specValue;

    public static void main(String[] args) {
        Sku sku = new Sku();
        sku.setId(521L);
        sku.setName("为你写诗");
        sku.setDesc("为你静止");
        sku.setPrice(521);
        sku.setSpecKey("521");
        sku.setSpecValue("为你做不可能的事");
        System.err.println(JSON.toJSONString(sku));
    }
}
