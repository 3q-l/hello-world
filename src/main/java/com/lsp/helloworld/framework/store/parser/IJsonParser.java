package com.lsp.helloworld.framework.store.parser;

import com.lsp.helloworld.framework.store.bean.SpuBean;

import java.util.List;

/**
 * @author lsp
 * @date 2020/6/20/4:04 PM
 */
public interface IJsonParser {

    List<SpuBean> parser(String line) throws Exception;
}
