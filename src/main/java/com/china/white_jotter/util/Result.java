package com.china.white_jotter.util;



import java.io.Serializable;

/**
 * @author majiaju
 * @date
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 200;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 401;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public Result() {
        super();
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    public Result(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public Result(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = FAIL;
    }

    public Result(int code, String msg , T data) {
        super();
        this.msg = msg;
        this.code = code;
        this.data = data;

    }

    public Result(int code,String msg){
        this.msg = msg;
        this.code = code;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
