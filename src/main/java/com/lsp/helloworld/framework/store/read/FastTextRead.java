package com.lsp.helloworld.framework.store.read;

import com.lsp.helloworld.framework.store.lifecycle.AbstractLifecycle;
import sun.misc.Cleaner;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * @author lsp
 * @date 2020/6/21/3:53 PM
 */
public class FastTextRead extends AbstractLifecycle implements ITextRead {

    private String path;
    private FileChannel fileChannel;
    private MappedByteBuffer map;

    private Method method;

    private byte nextSymbol = '\n';

    public FastTextRead(String path) {
        this.path = path;
    }


    @Override
    public String readLine() throws Exception {
        int startPos = map.position();
        for (int i = startPos; i < map.position(); i++) {
            byte b = map.get();
            if (b == nextSymbol){
                startPos = i;
                break;
            }
        }
        if (startPos != map.position()){
            byte[] bytes = new byte[map.position() - startPos];
            map.position(startPos);
            map.get(bytes);
            return new String(bytes);
        }
        return null;
    }

    @Override
    public void init() throws Exception {
        super.init();
//        FileInputStream fileInputStream = new FileInputStream(path);
//        fileInputStream.getChannel();
        fileChannel = FileChannel.open(new File(path).toPath(), StandardOpenOption.READ);
        map = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        System.out.printf("size is %d",fileChannel.size());
        System.out.println();
        method = Cleaner.class.getDeclaredMethod("clean");
    }

    @Override
    public void stop(){
        super.stop();
        if (map != null){
//            map.clear();
            try {
                method.invoke(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileChannel != null){
            try {
                fileChannel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
