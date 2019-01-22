/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.userpermission.model;

import com.woaipaifang.core.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="user_permission")
public class UserPermission extends BaseEntity {

    private static final long serialVersionUID = 5903562843388392034L;

    @Column(name = "name")
    private String name;//权限名称

    @Column(name = "user_id")
    private String userId;

    @Column(name = "permission_id")
    private String permissionId;

    @Column(name = "status")
    private int status;

    @Column(name = "uri")
    private String uri;

    @Column(name = "permission_parent_id")
    private long permissionParentId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getPermissionParentId() {
        return permissionParentId;
    }

    public void setPermissionParentId(long permissionParentId) {
        this.permissionParentId = permissionParentId;
    }
}


