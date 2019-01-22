/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.user.controller;

import com.woaipaifang.app.user.biz.IUserBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app/user/")
@RefreshScope
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserBiz iUserBiz;

    @RequestMapping("add")
    public Map<String, Object> add(){
        log.info("add-----");
        return  iUserBiz.add();
    }

    @RequestMapping("list")
    public Map<String, Object> list(int page, int rows){
        log.info("list-----");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map = iUserBiz.list(page, rows);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
