package com.woaipaifang.user.util;

import com.woaipaifang.core.util.Constants;
import com.woaipaifang.core.util.JwtUtil;
import io.jsonwebtoken.Claims;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolUtils {

    //向请求客户端下发能够使用服务的密钥
    public static Map<String, Object> secretKey(Map<String, Object> map, String uuid) {
//        String subject = new Gson().toJson(uuid);
        String jwt = JwtUtil.createJWT(Constants.JWT_ID, "ck", uuid, Constants.JWT_TTL);
        Claims claims = JwtUtil.parseJWT(jwt);
        map.put("claims", claims);
        map.put("token", jwt);
        return map;
    }

    public static boolean isPhone(String phone) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[5,7])| (17[0,1,3,5-8]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
