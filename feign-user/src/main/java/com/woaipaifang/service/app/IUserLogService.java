package com.woaipaifang.service.app;

import com.woaipaifang.model.user.mongo.UserLogView;
import com.woaipaifang.service.app.impl.UserLogServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@FeignClient(value = "BIZ-QX-PRO",fallback = UserLogServiceImpl.class)
public interface IUserLogService {

    @RequestMapping(value="/app/userlog/search", method = RequestMethod.POST)
    Map<String, Object> search(@RequestBody UserLogView userLogView);

    @RequestMapping(value="/app/userlog/recommend", method = RequestMethod.POST)
    Map<String, Object> recommend(@RequestBody UserLogView userLogView);

}
