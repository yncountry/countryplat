package com.country.plat.base.pojo;

import cn.gfire.base.jpa.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wust
 * @date 2017/5/25
 * @vsrsion
 * @desc 公共的人员属性信息 用于继承使用
 */
@MappedSuperclass
public class BasePerson<ID extends Serializable> extends BaseDomain<ID>{

    private String personName;

    private String phoneNo;

    private String wchatImg;

    private String wecahtNet;

    private String address;

    private Integer sex;

    private String wchatNum;

    private String qqNum;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getWchatNum() {
        return wchatNum;
    }

    public void setWchatNum(String wchatNum) {
        this.wchatNum = wchatNum;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getWchatImg() {
        return wchatImg;
    }

    public void setWchatImg(String wchatImg) {
        this.wchatImg = wchatImg;
    }

    public String getWecahtNet() {
        return wecahtNet;
    }

    public void setWecahtNet(String wecahtNet) {
        this.wecahtNet = wecahtNet;
    }
}
