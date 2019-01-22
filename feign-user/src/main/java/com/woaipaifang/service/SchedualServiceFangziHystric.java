package com.woaipaifang.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Component
public class SchedualServiceFangziHystric implements SchedualServiceFangzi {

    @Override
    public Map<String, Object> list(int currPage, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sorry"," sorry!");
        return  map;
    }

    @Override
    public Map<String, Object> add(String phone, String title, String spjzwz,String spwzhz, String requestId, String videoId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("add"," fail add!");
        return map;
    }
}
