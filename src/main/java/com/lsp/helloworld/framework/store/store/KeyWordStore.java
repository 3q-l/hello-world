package com.lsp.helloworld.framework.store.store;

import com.lsp.helloworld.framework.store.bean.ConditionBean;
import com.lsp.helloworld.framework.store.bean.SpuBean;
import com.lsp.helloworld.framework.store.lifecycle.AbstractLifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lsp
 * @date 2020/6/20/8:18 PM
 */
public class KeyWordStore extends AbstractLifecycle implements IKeyWordStore {
    Map<String,List<SpuBean>> map = new HashMap<>(160);

    @Override
    public List<String> getSpuIdByKeyWord(String keyWord) throws Exception {
        return null;
    }

    @Override
    public List<String> getSpuIdByKeyWordAndCondition(String keyWord, ConditionBean conditionBean) throws Exception {
        return null;
    }

    @Override
    public void put(SpuBean spuBean) throws Exception {
        List<SpuBean> list = map.get(spuBean.getKeyWord()) != null ?
                map.get(spuBean.getKeyWord()) : new ArrayList<>();
        list.add(spuBean);
        map.put(spuBean.getKeyWord(),list);
    }

    @Override
    public void stop() {
        super.stop();
        map = null;
    }
}
