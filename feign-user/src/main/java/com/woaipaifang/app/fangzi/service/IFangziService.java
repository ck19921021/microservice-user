/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.fangzi.service;

import com.woaipaifang.app.fangzi.service.impl.FangziServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "BIZ-QX-PRO",fallback = FangziServiceImpl.class)
public interface IFangziService {

    @RequestMapping(value="/app/fangzi/list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestParam("page") int page,
                                    @RequestParam("rows") int rows);

}
