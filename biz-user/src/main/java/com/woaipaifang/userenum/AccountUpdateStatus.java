package com.woaipaifang.user.userenum;

public enum AccountUpdateStatus {
    NOUPDATED(0, "未修改"),
    UPDATED(1,"已修改");

    private int retCode;
    private String retMsg;

    AccountUpdateStatus(int retCode, String retMsg) {
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
