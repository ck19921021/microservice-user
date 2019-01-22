package com.woaipaifang.controller.app;

import com.woaipaifang.model.user.mongo.UserLogView;
import com.woaipaifang.service.app.IUserLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/app/userlog/")
public class UserLogController {

    private static final Logger log = LoggerFactory.getLogger(UserLogController.class);

    @Autowired
    IUserLogService iUserLogService;

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public Map<String, Object> search(@RequestBody UserLogView userLogView) {
        log.info("search----------------");
        return iUserLogService.search(userLogView);
    }

    @RequestMapping(value = "recommend", method = RequestMethod.POST)
    public Map<String, Object> recommend(@RequestBody UserLogView userLogView) {
        log.info("recommend----------------");
        return iUserLogService.recommend(userLogView);
    }

}
