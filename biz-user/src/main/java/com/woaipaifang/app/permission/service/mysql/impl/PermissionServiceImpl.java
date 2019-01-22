/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.permission.service.mysql.impl;

import com.woaipaifang.app.permission.model.Permission;
import com.woaipaifang.app.permission.service.mysql.IPermissionService;
import com.woaipaifang.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("permissionServiceImpl")
@Transactional
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {


}
