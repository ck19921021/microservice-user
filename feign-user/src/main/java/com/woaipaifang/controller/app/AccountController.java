package com.woaipaifang.controller.app;

import com.woaipaifang.model.user.mysql.user.model.Account;
import com.woaipaifang.service.app.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/app/account/")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    IAccountService iAccountService;

    @RequestMapping(value="signup", method = RequestMethod.POST)
    public Map<String, Object> signup(@RequestParam("type") int type,
                                       @RequestParam("phone") String phone,
                                       @RequestParam("loginPassword") String loginPassword) {
        // http://wx.lolzhanghao.com:251/app/account/signup?phone=13397352359&password=123456
       return iAccountService.signup(type, phone, loginPassword);
    }

    @RequestMapping(value="signin", method = RequestMethod.POST)
    public Map<String, Object> signin(@RequestParam("phone") String phone,
                                      @RequestParam("loginPassword") String loginPassword) {
        // http://wx.lolzhanghao.com:301/app/account/signin?phone=13397352359&loginPassword=123456
        log.info("signin----------------");
        Map<String, Object> map = iAccountService.signin(phone, loginPassword);
        return map;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Map<String, Object> search(@RequestBody Account account) {
        log.info("search----------------" + account.getPhone());
        return iAccountService.search(account);
    }

    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public Map<String, Object> recommend(@RequestBody Account account) {
        log.info("recommend----------------");
        return iAccountService.recommend(account);
    }

}
