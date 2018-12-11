package com.lsp.helloworld.common;

/**
 * @author lsp
 * @date 2018/12/11/2:57 PM
 */
public enum ErrorCode {
    SUCCESS(0, "success"),
    FAIL(-1, "服务器出错了"),
    ERR_PARAM(-2, "参数错误"),
    ERR_NOT_EXIST(-3, "资源不存在");

    public final int code;
    public final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
