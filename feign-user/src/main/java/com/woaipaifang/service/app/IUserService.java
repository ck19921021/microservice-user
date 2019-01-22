package com.woaipaifang.service.app;

import com.woaipaifang.model.user.mongo.UserView;
import com.woaipaifang.service.app.impl.UserServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@FeignClient(value = "BIZ-QX-PRO",fallback = UserServiceImpl.class)
public interface IUserService {

    @RequestMapping(value="/app/user/search", method = RequestMethod.POST)
    Map<String, Object> search(@RequestBody UserView userView);

    @RequestMapping(value="/app/user/recommend", method = RequestMethod.POST)
    Map<String, Object> recommend(@RequestBody UserView userView);

}
