package com.lsp.helloworld.demo.pattern.responsibilityChain;

/**
 * 责任链模式
 * Created by lisp on 2020/5/28/上午11:29.
 */
public class responsibilityChainPattern {

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }
    public static void main(String[] args) {
        AbstractLogger chainOfLoggers = getChainOfLoggers();
        chainOfLoggers.logMessage(AbstractLogger.ERROR,"This is ERROR");
        chainOfLoggers.logMessage(AbstractLogger.DEBUG,"This is DEBUG");
        chainOfLoggers.logMessage(AbstractLogger.INFO,"This is INFO");

    }
}
