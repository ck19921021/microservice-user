/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.user.view;

import com.woaipaifang.core.entity.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class UserView extends BaseEntity {


    private static final long serialVersionUID = -9073190967107706254L;
}


