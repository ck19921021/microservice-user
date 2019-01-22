package com.woaipaifang.service.app.impl;

import com.woaipaifang.model.user.mysql.user.model.Account;
import com.woaipaifang.service.app.IAccountService;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccountServiceImpl implements IAccountService {

    @Override
    public Map<String, Object> signup(int type, String phone, String loginPassword) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail"," 服务繁忙,稍后注册...");
        return map;
    }

    @Override
    public Map<String, Object> signin(String phone, String loginPassword) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙,稍后登录...");
        return map;
    }

    @Override
    public Map<String, Object> search(Account account) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙search...");
        return map;
    }

    @Override
    public Map<String, Object> recommend(Account account) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙recommend...");
        return map;
    }
}
