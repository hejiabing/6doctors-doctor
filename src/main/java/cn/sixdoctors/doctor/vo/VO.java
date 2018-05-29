package cn.sixdoctors.doctor.vo;

import cn.sixdoctors.doctor.exception.ExceptionMsg;


public class VO<T extends Object> {

    public static final VO SUCCESS = new VO<>(null);

    //    用户级
    public static final VO INVALID_TOKEN = new VO<>(401, ExceptionMsg.INVALID_TOKEN, null);
    public static final VO PASSWORD_ERROR = new VO<>(401, ExceptionMsg.PASSWORD_ERROR, null);
    public static final VO ACCOUNT_NOT_FOUND = new VO<>(401, ExceptionMsg.ACCOUNT_NOT_FOUND, null);

    //////////////////////////////////////////////////////////////////
    private int status;
    private String msg;
    private T data;

    public VO(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public VO(T data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

    public VO() {
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
