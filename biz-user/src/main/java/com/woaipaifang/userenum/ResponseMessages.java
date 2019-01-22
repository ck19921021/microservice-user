package com.woaipaifang.user.userenum;

public enum ResponseMessages {

    PHONE_OR_PASSWORD_ERROR(1, "手机号码或密码错误"),
    LOGIN_SUCCESS(2,"用户登录成功"),
    NO_PHONE_REG(3, "该手机号码未注册，请重新输入"),
    PHONE_ERROR_FROMAT(4, "手机号码格式不正确"),
    ALREADY_PHONE_REG(5, "该手机号码已被注册，请重新输入或直接登录"),
    REG_SUCCESS(6, "用户注册成功");

    private int retCode;
    private String retMsg;

    ResponseMessages(int retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
