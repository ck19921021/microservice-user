package com.woaipaifang.user.userenum;

public enum AccountUseStatus {
    NORMAL(0, "正常"),
    PROHIBIT(1,"禁止");

    private int retCode;
    private String retMsg;

    AccountUseStatus(int retCode, String retMsg) {
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
