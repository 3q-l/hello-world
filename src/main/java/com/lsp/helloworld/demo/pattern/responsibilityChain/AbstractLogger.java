package com.lsp.helloworld.pattern.responsibilityChain;

/**
 * 日志责任链 根据不同的日志级别输出不同的日志
 * Created by lisp on 2020/5/28/上午11:30.
 */
public abstract class AbstractLogger {
    public static Integer INFO = 1;
    public static Integer DEBUG = 2;
    public static Integer ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level == level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
