package com.woaipaifang.service;

import org.springframework.stereotype.Component;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String hi(String name) {
        return "sorry "+name;
    }

//    @Override
//    public String info() {
//        return "sorry ";
//    }

    @Override
    public String health() {
        return "sorry1";
    }
}
