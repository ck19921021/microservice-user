package com.woaipaifang.service.app;

import com.woaipaifang.model.user.mysql.user.model.Account;
import com.woaipaifang.service.app.impl.AccountServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@FeignClient(value = "BIZ-QX-PRO",fallback = AccountServiceImpl.class)
public interface IAccountService {

    @RequestMapping(value="/app/account/signup", method = RequestMethod.POST)
    public Map<String, Object> signup(@RequestParam("type") int type,
                                       @RequestParam("phone") String phone,
                                      @RequestParam("loginPassword") String loginPassword);

    @RequestMapping(value="/app/account/signin", method = RequestMethod.POST)
    Map<String, Object> signin(@RequestParam("phone") String phone,
                               @RequestParam("loginPassword") String loginPassword);

    @RequestMapping(value="/app/account/search", method = RequestMethod.POST)
    Map<String, Object> search(@RequestBody Account account);

    @RequestMapping(value="/app/account/recommend", method = RequestMethod.POST)
    Map<String, Object> recommend(@RequestBody  Account account);

}
