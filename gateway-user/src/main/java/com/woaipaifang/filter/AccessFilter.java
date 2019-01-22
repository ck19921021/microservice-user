package com.woaipaifang.filter;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.woaipaifang.core.mapper.AccessLogMapper;
import com.woaipaifang.core.mysql.IAccessLogService;
import com.woaipaifang.model.user.mysql.user.model.AccessLog;
//import com.woaipaifang.core.mysql.IAccessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Component
public class AccessFilter  extends ZuulFilter{

    @Autowired
    IAccessLogService iAccessLogService;

    private static  Logger log = LoggerFactory.getLogger(AccessFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //共享RequestContext，上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info(request.getRequestURI());
        log.info(String.format("%s >>> %s", request.getMethod(), request.getHeader("X-Real-IP")));
        AccessLog accessLog = new AccessLog();
        accessLog.setIp(request.getHeader("X-Real-IP"));
        accessLog.setLongitude(0);
        accessLog.setLatitude(0);
        accessLog.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        accessLog.setCreateTime(new Date());
        accessLog.setLastUpdateTime(new Date());
        accessLog.setUri(request.getRequestURI());
        iAccessLogService.insert(accessLog);
        if ("/feign/qx/app/account/signup".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if("/feign/qx/app/account/signin".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURI().toString()));
        String accessToken = request.getParameter("token");
        Map<String, Object> map = new HashMap<String, Object>();
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            map.put("status", "3");
            map.put("errMsg", "token is empty");
            try {
                ctx.getResponse().getWriter().write(new Gson().toJson(map));
            }catch (Exception e){}

            return null;
        }
//        if(null == JwtUtil.parseJWT(accessToken)){
//            try {
//                map.put("status", "11");
//                ctx.getResponse().getWriter().write(new Gson().toJson(map));
//            }catch (Exception e){}
//        }

        return null;
    }
}
