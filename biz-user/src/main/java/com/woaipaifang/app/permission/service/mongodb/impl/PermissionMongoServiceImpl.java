/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.permission.service.mongodb.impl;

import com.woaipaifang.app.permission.service.mongodb.IPermissionMongoService;
import com.woaipaifang.app.permission.view.PermissionView;
import com.woaipaifang.core.service.impl.BaseMongoServiceImpl;
import org.springframework.stereotype.Service;

@Service("iPermissionMongoService")
public class PermissionMongoServiceImpl extends BaseMongoServiceImpl<PermissionView> implements IPermissionMongoService {

}
