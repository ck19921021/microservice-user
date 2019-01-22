/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.userpermission.service.mysql.impl;

import com.woaipaifang.app.userpermission.model.UserPermission;
import com.woaipaifang.app.userpermission.service.mysql.IUserPermissionService;
import com.woaipaifang.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userPermissionServiceImpl")
@Transactional
public class UserPermissionServiceImpl extends BaseServiceImpl<UserPermission> implements IUserPermissionService {


}
