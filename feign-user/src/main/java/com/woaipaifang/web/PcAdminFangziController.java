package com.woaipaifang.web;

import com.woaipaifang.service.SchedualServiceFangzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PcAdminFangziController {

    @Autowired
    SchedualServiceFangzi schedualServiceFangzi;

    @RequestMapping("/pc/admin/fangzi/list/{currPage}/{pageSize}")
    public Map<String, Object> list(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize) {
        return schedualServiceFangzi.list(currPage, pageSize);
    }

    @RequestMapping(value="/pc/admin/fangzi/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestParam("phone") String phone,
                                   @RequestParam(name="title") String title,
                                   @RequestParam(name="spjzwz") String spjzwz,
                                   @RequestParam(name="spwzhz") String spwzhz,
                                   @RequestParam(name="requestId") String requestId,
                                   @RequestParam(name="videoId") String videoId){
        return schedualServiceFangzi.add(phone, title, spjzwz, spwzhz, requestId, videoId);
    }

}
