package com.woaipaifang.controller.app;

import com.woaipaifang.model.user.mongo.AccountLogView;
import com.woaipaifang.model.user.mongo.UserRegSourceView;
import com.woaipaifang.service.app.IAccountLogService;
import com.woaipaifang.service.app.IUserRegSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/app/userregsource/")
public class UserRegSourceController {
    @Autowired
    IUserRegSourceService iUserRegSourceService;

    private static final Logger log = LoggerFactory.getLogger(UserRegSourceController.class);

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public Map<String, Object> search(@RequestBody UserRegSourceView userRegSourceView) {
        log.info("search----------------");
        return iUserRegSourceService.search(userRegSourceView);
    }

    @RequestMapping(value = "recommend", method = RequestMethod.POST)
    public Map<String, Object> recommend(@RequestBody UserRegSourceView userRegSourceView) {
        log.info("recommend----------------");
        return iUserRegSourceService.recommend(userRegSourceView);
    }

}
