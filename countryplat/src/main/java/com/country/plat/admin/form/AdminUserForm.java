package com.country.plat.admin.form;

import cn.gfire.base.mvc.form.BaseForm;
import com.country.common.admin.domain.AdminUser;

/**
 * @author wust
 * @date 2017/5/16
 * @vsrsion
 * @desc
 */

public class AdminUserForm extends BaseForm<AdminUser,Long> {

    private String userName;

    private String loginName;
    private String password;
    private String sex;
    private String idCardNum;
    private String phoneNum;
    private String wxchatNum;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWxchatNum() {
        return wxchatNum;
    }

    public void setWxchatNum(String wxchatNum) {
        this.wxchatNum = wxchatNum;
    }

    @Override
    public String getName() {
        return null;
    }
}
