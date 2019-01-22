package com.woaipaifang.service.app;

import com.woaipaifang.model.user.mongo.AccountLogView;
import com.woaipaifang.service.app.impl.AccountLogServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@FeignClient(value = "BIZ-QX-PRO",fallback = AccountLogServiceImpl.class)
public interface IAccountLogService {

    @RequestMapping(value="/app/accountlog/search", method = RequestMethod.POST)
    Map<String, Object> search(@RequestBody AccountLogView accountLogView);

    @RequestMapping(value="/app/accountlog/recommend", method = RequestMethod.POST)
    Map<String, Object> recommend(@RequestBody AccountLogView accountLogView);

}
