/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.user.model;

import com.woaipaifang.core.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1977926698653588045L;

    @Column(name = "login_username")
    private String loginUsername;//登录用户名

    @Column(name = "login_password")
    private String loginPassword;//登录密码

    @Column(name = "status")
    private int status;//0:正常;1:禁止

    @Column(name = "member_name")
    private String memberName;//会员名

    @Column(name = "role_name")
    private String roleName;//角色名

    @Column(name = "longitude")
    private String longitude;//经度

    @Column(name = "latitude")
    private String latitude;//纬度

    @Column(name = "address")
    private String address;//地址

    @Column(name = "login_qrcode")
    private String loginQrcode;//登录二维码

    @Column(name = "sex")
    private int sex;//0:男;1:女

    @Column(name = "email")
    private String email;//邮箱

    @Column(name = "avatar")
    private String avatar;//头像

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoginQrcode() {
        return loginQrcode;
    }

    public void setLoginQrcode(String loginQrcode) {
        this.loginQrcode = loginQrcode;
    }
}


