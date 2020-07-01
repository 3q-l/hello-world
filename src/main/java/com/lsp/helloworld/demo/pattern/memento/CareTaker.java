package com.lsp.helloworld.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisp on 2020/6/1/下午3:19.
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
