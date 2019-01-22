/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.user.service.mongodb.impl;

import com.woaipaifang.app.user.service.mongodb.IUserMongoService;
import com.woaipaifang.app.user.view.UserView;
import com.woaipaifang.core.service.impl.BaseMongoServiceImpl;
import org.springframework.stereotype.Service;

@Service("iUserMongoService")
public class UserMongoServiceImpl extends BaseMongoServiceImpl<UserView> implements IUserMongoService {

}
