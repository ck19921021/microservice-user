/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.fangzi.service.impl;

import com.woaipaifang.app.fangzi.service.IFangziService;
import com.woaipaifang.model.user.mysql.user.model.Account;
import com.woaipaifang.service.app.IAccountService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FangziServiceImpl implements IFangziService {

    @Override
    public Map<String, Object> list(int page, int rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("msg"," 服务繁忙,稍等一下2...");
        return map;
    }

}
