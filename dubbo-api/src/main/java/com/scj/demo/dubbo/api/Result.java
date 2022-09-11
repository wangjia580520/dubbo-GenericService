package com.scj.demo.dubbo.api;

import lombok.Data;

import java.io.Serializable;

@Data
public  class  Result<T> implements Serializable {

    private T data;

    private Integer code;

    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  static <T>  Result<T> ofSuccess(T data){
        Result<T> result = new Result<T>();
        result.setData(data);
        result.setCode(200);
        result.setMessage("success");
        return result;
    }

    public  static <T>  Result<T> ofFail(Integer code,String message){
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
