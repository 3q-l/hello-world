package com.lsp.helloworld.spu.bean;

import lombok.Data;

import java.util.List;

/**
 * @author lsp
 * @date 2020/6/18/12:12 AM
 */
@Data
public class ConditionBean {

    private String fieldName;
    private ConditionEnum conditionEnum;
    private String value;
    private LogicCondition logicCondition;
    private List<ConditionBean> conditionBeanList;

    public enum ConditionEnum{
        // <
        LT,
        // >
        GT,
        // =
        EQ,
        // >=
        GET,
        // <=
        LET
    }

    public enum LogicCondition{
        AND,OR
    }
}
