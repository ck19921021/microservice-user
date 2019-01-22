package com.woaipaifang.user.userenum;

public enum AccountDeleteStatus {
    NODELETED(0, "未删除"),
    DELETED(1,"已删除");

    private int retCode;
    private String retMsg;

    AccountDeleteStatus(int retCode, String retMsg) {
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
