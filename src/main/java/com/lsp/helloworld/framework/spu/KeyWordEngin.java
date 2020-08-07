package com.lsp.helloworld.framework.spu;

import com.lsp.helloworld.framework.spu.lifecycle.AbstractLifecycle;
import com.lsp.helloworld.framework.spu.parser.FasterJsonParser;
import com.lsp.helloworld.framework.spu.parser.IJsonParser;
import com.lsp.helloworld.framework.spu.read.BufferedTextRead;
import com.lsp.helloworld.framework.spu.read.ITextRead;
import com.lsp.helloworld.framework.spu.store.IKeyWordStore;
import com.lsp.helloworld.framework.spu.store.KeyWordStore;

/**
 * @author lsp
 * @date 2020/6/20/8:24 PM
 */
public class KeyWordEngin extends AbstractLifecycle {

    private final String path = "/Users/lsp/data/logs/spu/json.log";

    private ITextRead iTextRead = new BufferedTextRead(path);

    private IJsonParser iJsonParser = new FasterJsonParser();

    private IKeyWordStore iKeyWordStore = new KeyWordStore();

    @Override
    public void init() throws Exception {
        super.init();
        iTextRead.init();
        StopWitch stopWitch = new StopWitch();
        stopWitch.start();
        String line;
        while ((line = iTextRead.readLine()) != null){
            iJsonParser.parser(line).forEach(text -> {
                try {
                    iKeyWordStore.put(text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        stopWitch.print();
    }

    @Override
    public void start() throws Exception {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        iTextRead.stop();

    }
}
