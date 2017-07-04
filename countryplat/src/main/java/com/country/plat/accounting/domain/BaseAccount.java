package com.country.plat.accounting.domain;

import cn.gfire.base.jpa.domain.BaseDomain;
import org.hibernate.cfg.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.util.Date;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class BaseAccount extends BaseDomain<Long> {

    @Comment("账户名,现金账户，支付宝，微信")
    private String accountName;

    @Comment("账户编号，区别账户唯一标识")
    private String typeNo;

    @Comment("总资金")
    private Double Totalfund;

    @Comment("创建时间")
    @CreatedDate
    @Column(updatable = false)
    private Date createTime;

    @Comment("修改时间")
    @LastModifiedDate
    private Date updateTime;


    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getTotalfund() {
        return Totalfund;
    }

    public void setTotalfund(Double totalfund) {
        Totalfund = totalfund;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
