package com.woaipaifang.util;

import java.util.Map;

public class ResponseUtils {

    public static Map<String, Object> regSuccess(Map<String, Object> map){
        map.put("status", com.woaipaifang.user.userenum.ResponseMessages.REG_SUCCESS.getRetCode());
        map.put("msg", com.woaipaifang.user.userenum.ResponseMessages.REG_SUCCESS.getRetMsg());
        return map;
    }

    public static Map<String, Object> alreadyPhoneReg(Map<String, Object> map){
        map.put("status", com.woaipaifang.user.userenum.ResponseMessages.ALREADY_PHONE_REG.getRetCode());
        map.put("msg", com.woaipaifang.user.userenum.ResponseMessages.ALREADY_PHONE_REG.getRetMsg());
        return map;
    }

    public static Map<String, Object> phoneErrorFormat(Map<String, Object> map){
        map.put("status", com.woaipaifang.user.userenum.ResponseMessages.PHONE_ERROR_FROMAT.getRetCode());
        map.put("msg", com.woaipaifang.user.userenum.ResponseMessages.PHONE_ERROR_FROMAT.getRetMsg());
        return map;
    }

    public static Map<String, Object> noPhoneReg(Map<String, Object> map){
        map.put("msg", com.woaipaifang.user.userenum.ResponseMessages.NO_PHONE_REG.getRetMsg());
        map.put("status", com.woaipaifang.user.userenum.ResponseMessages.NO_PHONE_REG.getRetCode());
        return map;
    }

    public static Map<String, Object> phoneOrPasswordError(Map<String, Object> map){
        map.put("msg", com.woaipaifang.user.userenum.ResponseMessages.PHONE_OR_PASSWORD_ERROR.getRetMsg());
        map.put("status", com.woaipaifang.user.userenum.ResponseMessages.PHONE_OR_PASSWORD_ERROR.getRetCode());
        return map;
    }

    public static Map<String, Object> loginSuccess(Map<String, Object>  map){
        map.put("status", com.woaipaifang.user.userenum.ResponseMessages.LOGIN_SUCCESS.getRetCode());
        map.put("msg", com.woaipaifang.user.userenum.ResponseMessages.LOGIN_SUCCESS.getRetMsg());
        return map;
    }

}
