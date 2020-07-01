package com.lsp.helloworld.spu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lsp.helloworld.spu.bean.SpuBean;
import com.lsp.helloworld.spu.contanst.KeyWordContanst;
import com.lsp.helloworld.spu.parser.FasterJsonParser;
import com.lsp.helloworld.spu.parser.IJsonParser;
import com.lsp.helloworld.spu.read.BufferedTextRead;
import com.lsp.helloworld.spu.read.FastTextRead;
import com.lsp.helloworld.spu.read.ITextRead;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author lsp
 * @date 2020/6/18/12:48 AM
 */
public class KeyWordTest {

    private final String path = "/Users/lsp/data/logs/test/json.log";

    private static void accept(Map.Entry<String, Object> entrySet) {
        String key = entrySet.getKey();
        JSONObject value = (JSONObject) entrySet.getValue();

        String keyWord = (String) value.get(KeyWordContanst.KEY_WORD);
        BigDecimal opt = (BigDecimal) value.get(KeyWordContanst.OPT_TYPE);
        BigDecimal pos = (BigDecimal) value.get(KeyWordContanst.POS_NAME);
        BigDecimal score = (BigDecimal) value.get(KeyWordContanst.SCORE_NAME);
        System.out.printf("\t keyWord = %s",keyWord);
        System.out.printf("\t opt = %s",opt);
        System.out.printf("\t pos = %s",pos);
        System.out.printf("\t score = %s",score);
        System.out.printf("\t key = %s",key);
    }

    private List<String> read(String path){
        long start = System.currentTimeMillis();
        List<String> lineS = new ArrayList<>();
        try (BufferedTextRead read = new BufferedTextRead(path) ) {
            read.init();
            String line;
            while ((line = read.readLine()) != null){
//                System.out.println(line);
                lineS.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long ent = System.currentTimeMillis();
        System.out.println(ent - start);
        return lineS;
    }

    @Test
    public void testTextRead(){
        long start = System.currentTimeMillis();
        ITextRead read = null;
        try {
            read = new BufferedTextRead(path);
            read.init();
            String line;
            while ((line = read.readLine()) != null){
                System.out.println(line);
            }
            long ent = System.currentTimeMillis();
            System.out.println(ent - start);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (read != null){
                read.stop();
            }
        }

    }

    @Test
    public void testTextReadV1(){
        List<String> readS = read(path);
        readS.forEach(System.out::println);
    }


    @Test
    public void getJson() {
        List<String> keyWordS = new ArrayList<>();
        keyWordS.add("黑鸭");
        keyWordS.add("红鸭");
        keyWordS.add("白鸭");
        Random r = new Random();

        List<SpuBean> list = new ArrayList<>();
        for (Integer i = 0; i < 100; i++) {
            SpuBean json = new SpuBean();
//            JSONObject jsonObject = new JSONObject();
            json.setSpuId(i.toString());
            json.setKeyWord(keyWordS.get(r.nextInt(keyWordS.size())));
            json.setOptType(BigDecimal.valueOf(Math.random()));
            json.setPos(BigDecimal.valueOf(Math.random()));
            json.setScore(BigDecimal.valueOf(Math.random()));
//            json.put(i.toString(),jsonObject);
            list.add(json);
        }
        for (SpuBean jsonObject : list) {
            Map<String,SpuBean> map = new HashMap<>();
            map.put(jsonObject.getSpuId(),jsonObject);

            System.out.println(JSON.toJSONString(map));
        }
    }

    @Test
    public void writeJson(){
        String line = "{\"99\":{\"keyWord\":\"黑鸭\",\"optType\":0.16130692671176572,\"pos\":0.2588251474604131,\"score\":0.0296812607917345,\"spuId\":\"99\"}}";
        JSONObject jsonObject = JSON.parseObject(line);
        jsonObject.entrySet().forEach(KeyWordTest::accept);
    }

    @Test
    public void parserTest() {
        IJsonParser parser = new FasterJsonParser();
//        List<SpuBean> spuBeans = parser.parser(null);
//        System.out.println(JSON.toJSONString(spuBeans));
        List<String> readS = read(path);
        List<SpuBean> spuBeans = new ArrayList<>();
        readS.forEach(read -> {
            try {
                List<SpuBean> spuS = parser.parser(read);
                spuBeans.addAll(spuS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(JSON.toJSONString(spuBeans));
    }

    @Test
    public void testEngin(){
        KeyWordEngin engin = new KeyWordEngin();
        try {
            engin.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFastTextRead(){
        StopWitch stopWitch = new StopWitch();
        stopWitch.start();
        ITextRead iTextRead = new FastTextRead("/Users/lsp/data/logs/test/json.txt");
        String line;
        try {
            iTextRead.init();
            while ((line = iTextRead.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        stopWitch.end();
    }
}
