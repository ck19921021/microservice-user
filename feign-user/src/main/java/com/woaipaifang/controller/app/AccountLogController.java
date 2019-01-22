package com.woaipaifang.controller.app;

import com.woaipaifang.model.user.mongo.AccountLogView;
import com.woaipaifang.service.app.IAccountLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/app/accountlog")
public class AccountLogController {

    private static final Logger log = LoggerFactory.getLogger(AccountLogController.class);

    @Autowired
    IAccountLogService iAccountLogService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Map<String, Object> search(@RequestBody AccountLogView accountLogView) {
        return iAccountLogService.search(accountLogView);
    }

    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public Map<String, Object> recommend(@RequestBody AccountLogView accountLogView) {
        log.info("recommend----------------");
        return iAccountLogService.recommend(accountLogView);
    }

}
