package com.lsp.helloworld.framework.rpc.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lishuaipeng
 * @date 2020/8/11/10:02 上午
 */
@Data
public class ResponseContent implements Serializable {
    private static final long serialVersionUID = -1L;
    private List<MyContent> list;
}
