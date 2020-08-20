package com.lsp.helloworld.framework.store.store;

import com.lsp.helloworld.framework.store.bean.ConditionBean;
import com.lsp.helloworld.framework.store.bean.SpuBean;

import java.util.List;

/**
 * @author lsp
 * @date 2020/6/20/8:13 PM
 */
public interface IKeyWordStore {

    /**
     * 根据keyWord获取spuId
     * @param keyWord
     * @return
     * @throws Exception
     */
    List<String> getSpuIdByKeyWord(String keyWord) throws Exception;

    /**
     * 根据 keyWord和条件 获取id
     * @param keyWord
     * @param conditionBean
     * @return
     * @throws Exception
     */
    List<String> getSpuIdByKeyWordAndCondition(String keyWord, ConditionBean conditionBean) throws Exception;

    /**
     * 存储
     * @param spuBean
     * @throws Exception
     */
    void put(SpuBean spuBean) throws Exception;
}
