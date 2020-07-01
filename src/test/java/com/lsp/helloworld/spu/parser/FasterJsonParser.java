package com.lsp.helloworld.spu.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lsp.helloworld.spu.bean.SpuBean;
import com.lsp.helloworld.spu.contanst.KeyWordContanst;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lsp
 * @date 2020/6/20/4:07 PM
 */
public class FasterJsonParser implements IJsonParser {
    @Override
    public List<SpuBean> parser(String line) throws Exception {
        Objects.requireNonNull(line,"json 字符串不能为null");
        List<SpuBean> list = new ArrayList<>(160);
        JSONObject jsonObject = JSON.parseObject(line);
        jsonObject.entrySet().forEach(entrySet -> {
            String key = entrySet.getKey();
            JSONObject value = (JSONObject) entrySet.getValue();
            String keyWord = (String) value.get(KeyWordContanst.KEY_WORD);
            BigDecimal opt = (BigDecimal) value.get(KeyWordContanst.OPT_TYPE);
            BigDecimal pos = (BigDecimal) value.get(KeyWordContanst.POS_NAME);
            BigDecimal score = (BigDecimal) value.get(KeyWordContanst.SCORE_NAME);
            list.add(new SpuBean(key,keyWord,opt,pos,score));
        });
        return list;
    }
}
