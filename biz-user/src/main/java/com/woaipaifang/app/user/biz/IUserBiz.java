package com.woaipaifang.app.user.biz;

import java.util.Map;

public interface IUserBiz {

    public Map<String, Object> add();

    public Map<String, Object> list(int page, int rows) throws Exception;
}
