package com.woaipaifang.web;

import com.woaipaifang.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hi(@RequestParam String name){
        return schedualServiceHi.hi(name);
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String info(){
        return "{}";
    }

    @RequestMapping(value = "/health",method = RequestMethod.GET)
    public String health(){
        return schedualServiceHi.health();
    }
}
