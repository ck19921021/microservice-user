/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.userpermission.service.mongodb.impl;

import com.woaipaifang.app.userpermission.service.mongodb.IUserPermissionMongoService;
import com.woaipaifang.app.userpermission.view.UserPermissionView;
import com.woaipaifang.core.service.impl.BaseMongoServiceImpl;
import org.springframework.stereotype.Service;

@Service("iUserPermissionMongoService")
public class UserPermissionMongoServiceImpl extends BaseMongoServiceImpl<UserPermissionView> implements IUserPermissionMongoService {

}
