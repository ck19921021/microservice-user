package com.woaipaifang.service.app.impl;

import com.woaipaifang.model.user.mongo.UserLogView;
import com.woaipaifang.service.app.IUserLogService;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserLogServiceImpl implements IUserLogService {

    @Override
    public Map<String, Object> search(UserLogView userLogView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙search...");
        return map;
    }

    @Override
    public Map<String, Object> recommend(UserLogView userLogView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙recommend...");
        return map;
    }
}
