package com.woaipaifang.service.app.impl;

import com.woaipaifang.model.user.mongo.UserView;
import com.woaipaifang.service.app.IUserService;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserServiceImpl implements IUserService {

    @Override
    public Map<String, Object> search(UserView userView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙search...");
        return map;
    }

    @Override
    public Map<String, Object> recommend(UserView userView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙recommend...");
        return map;
    }
}
