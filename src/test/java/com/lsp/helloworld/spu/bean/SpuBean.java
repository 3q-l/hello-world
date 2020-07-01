package com.lsp.helloworld.spu;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lsp
 * @date 2020/6/18/12:08 AM
 */
@Data
public class SpuBean {
    private String spuId;
    private String keyWord;
    private BigDecimal optType;
    private BigDecimal pos;
    private BigDecimal score;
}
