package com.woaipaifang.service.app;

import com.woaipaifang.model.user.mongo.UserRegSourceView;
import com.woaipaifang.service.app.impl.UserRegSourceServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@FeignClient(value = "BIZ-QX-PRO",fallback = UserRegSourceServiceImpl.class)
public interface IUserRegSourceService {

    @RequestMapping(value="/app/userregsource/search", method = RequestMethod.POST)
    Map<String, Object> search(@RequestBody UserRegSourceView userRegSourceView);

    @RequestMapping(value="/app/userregsource/recommend", method = RequestMethod.POST)
    Map<String, Object> recommend(@RequestBody UserRegSourceView userRegSourceView);

}
