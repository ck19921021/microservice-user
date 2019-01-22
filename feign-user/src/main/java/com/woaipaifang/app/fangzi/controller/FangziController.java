/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.fangzi.controller;

import com.woaipaifang.app.fangzi.service.IFangziService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/app/fangzi/")
public class FangziController {

    private static final Logger log = LoggerFactory.getLogger(FangziController.class);

    @Autowired
    IFangziService iFangziService;

    @RequestMapping(value="list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestParam("page") int page,
                                       @RequestParam("rows") int rows) {
       return iFangziService.list(page, rows);
    }

}
