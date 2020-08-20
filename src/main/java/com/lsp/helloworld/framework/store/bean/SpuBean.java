package com.lsp.helloworld.framework.store.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lsp
 * @date 2020/6/18/12:08 AM
 */
@Data
public class SpuBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String spuId;
    private String keyWord;
    private BigDecimal optType;
    private BigDecimal pos;
    private BigDecimal score;

    public SpuBean(String spuId, String keyWord, BigDecimal optType, BigDecimal pos, BigDecimal score) {
        this.spuId = spuId;
        this.keyWord = keyWord;
        this.optType = optType;
        this.pos = pos;
        this.score = score;
    }

    public SpuBean() {
    }
}
