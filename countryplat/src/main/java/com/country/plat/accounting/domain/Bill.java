package com.country.plat.accounting.domain;

import cn.gfire.base.jpa.domain.BaseDomain;
import org.hibernate.cfg.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Bill extends BaseDomain<Long> {

    @Comment("账单编号")
    private String billNum;

    @Comment("账单类型 0 支出 1收入")
    private Integer billType;

    @Comment("金额")
    private Double sumTotal;

    @Comment("账单状态 1 已付款 2 清算中")
    private Integer billState;

    @Comment("账单描述")
    private String billDesc;

    @Comment("对应资金账户")
    @ManyToOne
    private BaseAccount baseAccount;


    @Comment("创建时间")
    @CreatedDate
    @Column(updatable = false)
    private Date createTime;


    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Double getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Double sumTotal) {
        this.sumTotal = sumTotal;
    }

    public Integer getBillState() {
        return billState;
    }

    public void setBillState(Integer billState) {
        this.billState = billState;
    }

    public String getBillDesc() {
        return billDesc;
    }

    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc;
    }

    public BaseAccount getBaseAccount() {
        return baseAccount;
    }

    public void setBaseAccount(BaseAccount baseAccount) {
        this.baseAccount = baseAccount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
