package com.lsp.helloworld.common;

import lombok.Data;

/**
 * @author lsp
 * @date 2018/12/11/2:56 PM
 */
@Data
public class Response<T> {
    private Integer error_code;
    private String err_msg;
    private T data;

    public Response(){
    }

    public Response(Integer error_code,String err_msg,T data){
        this.error_code = error_code;
        this.err_msg = err_msg;
        this.data = data;
    }
}
