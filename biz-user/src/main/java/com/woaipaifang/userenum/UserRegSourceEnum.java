package com.woaipaifang.user.userenum;

public enum  UserRegSourceEnum {
    WEIXIN("0", "微信小程序"),
    DINGDING("1","钉钉小程序");

    private String retCode;
    private String retMsg;

    UserRegSourceEnum(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
