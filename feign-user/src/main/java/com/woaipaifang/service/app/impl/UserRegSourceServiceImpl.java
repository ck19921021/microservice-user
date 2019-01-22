package com.woaipaifang.service.app.impl;

import com.woaipaifang.model.user.mongo.UserRegSourceView;
import com.woaipaifang.service.app.IUserRegSourceService;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRegSourceServiceImpl implements IUserRegSourceService {

    @Override
    public Map<String, Object> search(UserRegSourceView userRegSourceView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙search...");
        return map;
    }

    @Override
    public Map<String, Object> recommend(UserRegSourceView userRegSourceView) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("fail","服务繁忙recommend...");
        return map;
    }
}
