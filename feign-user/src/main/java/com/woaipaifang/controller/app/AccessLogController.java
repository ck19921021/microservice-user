/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.controller.app;

import com.woaipaifang.model.user.mysql.user.model.AccessLog;
import com.woaipaifang.service.app.IAccessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/app/accesslog")
public class AccessLogController {

    @Autowired
    IAccessLogService iAccessLogService;

    private static final Logger log = LoggerFactory.getLogger(AccessLogController.class);

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Map<String, Object> search(@RequestBody AccessLog accessLog) {
        return iAccessLogService.search(accessLog);
    }

    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public Map<String, Object> recommend(@RequestBody AccessLog accessLog) {
        log.info("recommend----------------");
        return iAccessLogService.recommend(accessLog);
    }

}
