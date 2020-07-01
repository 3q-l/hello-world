package com.lsp.helloworld.spu.read;

import com.lsp.helloworld.spu.lifecycle.AbstractLifecycle;

import java.io.*;

/**
 * @author lsp
 * @date 2020/6/18/12:41 AM
 */
public class BufferedTextRead extends AbstractLifecycle implements ITextRead,Closeable {

    private String path;
    private BufferedReader bufferedReader;

    public BufferedTextRead(String path) {
        this.path = path;
    }


    @Override
    public String readLine() throws Exception {
        return bufferedReader.readLine();
    }

    @Override
    public void init() throws Exception {
        super.init();
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

    }

    @Override
    public void close() throws IOException {
        path = null;
        if (bufferedReader != null){
            bufferedReader.close();
        }
    }

    @Override
    public void stop() {
        try {
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
