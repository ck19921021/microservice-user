package com.woaipaifang.service.app.impl;

import com.woaipaifang.model.user.mongo.AccountLogView;
import com.woaipaifang.service.app.IAccountLogService;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccountLogServiceImpl implements IAccountLogService {

    @Override
    public Map<String, Object> search(AccountLogView accountLogView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙search...");
        return map;
    }

    @Override
    public Map<String, Object> recommend(AccountLogView accountLogView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙recommend...");
        return map;
    }
}
