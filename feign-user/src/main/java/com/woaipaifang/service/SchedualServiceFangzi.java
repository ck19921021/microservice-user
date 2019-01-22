package com.woaipaifang.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@FeignClient(value = "BIZ-QX-PRO",fallback = SchedualServiceFangziHystric.class)
public interface SchedualServiceFangzi {

    @RequestMapping("/pc/admin/fangzi/list/{currPage}/{pageSize}")
    public Map<String, Object> list(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize);

    @RequestMapping(value="/pc/admin/fangzi/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestParam(name="phone") String phone,
                                   @RequestParam(name="title") String title,
                                   @RequestParam(name="spjzwz") String spjzwz,
                                   @RequestParam(name="spwzhz") String spwzhz,
                                   @RequestParam(name="requestId") String requestId,
                                   @RequestParam(name="videoId") String videoId);
}
