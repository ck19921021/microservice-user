/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.user.biz.impl;

import com.woaipaifang.app.user.biz.IUserBiz;
import com.woaipaifang.app.user.model.User;
import com.woaipaifang.app.user.service.mysql.IUserService;
import com.woaipaifang.app.user.service.redis.impl.UserRedisServiceImpl;
import com.woaipaifang.core.util.MD5Util;
import com.woaipaifang.core.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service("userBizImpl")
@Transactional
public class UserBizImpl implements IUserBiz {

    @Resource
    HttpServletRequest request;

    @Autowired
    IUserService iUserService;

    @Autowired
    UserRedisServiceImpl userRedisServiceImpl;

    public Map<String, Object> add() {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setAddress("chenzhou");
        user.setLatitude("0");
        user.setLongitude("0");
        user.setLoginPassword(MD5Util.getMD5("123456"));
        user.setLoginQrcode("qrcode.jpg");
        user.setLoginUsername("13397352359");
        user.setMemberName("ck");
        user.setRoleName("买家");
        user.setStatus(0);
        user.setCreateTime(new Date());
        user.setLastUpdateTime(new Date());
        user.setUuid(UUID.randomUUID().toString());
        user.setSex(0);
        user.setEmail("2464017733@qq.com");
        user.setAvatar("/01avatar.jpg");
        iUserService.insert(user);
        map.put("user", user);
        return map;
    }


    public Map<String, Object> list(int page, int rows) throws Exception {
        Map<String, Object> map1 = userRedisServiceImpl.mget(request.getRequestURI(), Object.class);
        if(null != map1.get("page")){
            return map1;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Example example = new Example(User.class);
        example.setOrderByClause("id desc");
        Page<User> page1 = iUserService.findPage(page,rows,example);
        map.put("page", page1.getData());
        userRedisServiceImpl.setMap(request.getRequestURI(), map, 15);
        return map;
    }
}
