package com.woaipaifang.controller.app;

import com.woaipaifang.model.user.mongo.UserView;
import com.woaipaifang.service.app.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/app/user/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Map<String, Object> search(@RequestBody UserView userView) {
        log.info("search----------------");
        return iUserService.search(userView);
    }

    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public Map<String, Object> recommend(@RequestBody UserView userView) {
        log.info("recommend----------------");
        return iUserService.recommend(userView);
    }

}
