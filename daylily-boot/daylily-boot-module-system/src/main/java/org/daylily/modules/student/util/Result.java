package org.daylily.modules.student.util;

public class Result {
    private Integer state;
    private String msg;
    private Object data;

    public Result() {
        this.state=200;
        this.msg="成功";
    }

    public Result(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Result(Integer state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
