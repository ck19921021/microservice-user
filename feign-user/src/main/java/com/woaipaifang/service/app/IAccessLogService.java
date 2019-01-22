/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.service.app;

import com.woaipaifang.model.user.mysql.user.model.AccessLog;
import com.woaipaifang.service.app.impl.AccessLogServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@FeignClient(value = "BIZ-QX-PRO",fallback = AccessLogServiceImpl.class)
public interface IAccessLogService {

    @RequestMapping(value="/app/accesslog/search", method = RequestMethod.POST)
    Map<String, Object> search(@RequestBody AccessLog accessLog);

    @RequestMapping(value="/app/accesslog/recommend", method = RequestMethod.POST)
    Map<String, Object> recommend(@RequestBody AccessLog accessLog);

}
