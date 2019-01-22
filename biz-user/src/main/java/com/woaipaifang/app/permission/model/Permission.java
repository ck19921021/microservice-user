/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.permission.model;

import com.woaipaifang.core.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="permission")
public class Permission extends BaseEntity {


    private static final long serialVersionUID = 5909038843745409618L;

    @Column(name = "name")
    private String name;//权限名称

    @Column(name = "uri")
    private String uri;//权限资源路径

    @Column(name = "parent_id")
    private long parentId;//父级权限ID

    @Column(name = "method_type")
    private String methodType;//请求类型

    @Column(name = "status")
    private int status;//0:正常;1:禁止

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


