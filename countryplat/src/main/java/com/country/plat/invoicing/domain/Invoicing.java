package com.country.plat.invoicing.domain;

import cn.gfire.base.jpa.domain.BaseDomain;
import com.country.common.admin.domain.AdminUser;
import com.country.common.emmun.UnitType;
import com.country.plat.base.enumtype.AccountType;
import com.country.plat.goods.domain.Goods;
import org.hibernate.cfg.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wust
 * @date 2017/5/25
 * @vsrsion
 * @desc 进货信息描述
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Invoicing extends BaseDomain<Long> {

    @Comment("进入数量")
    private Double invocNum;

    @Comment("单位")
    private UnitType unitType;

    @Comment("欠款 0  付款 1")
    private Integer payState;

    @Comment("账户类型")
    private AccountType accountType;

    @Comment("进货总价")
    private Double invocTotal;

    @Comment("进销商品")
//    @OneToMany(mappedBy ="invoicing")
    @OneToOne
    private Goods goods;

    @Comment("创建时间")
    @CreatedDate
    @Column(updatable = false)
    private Date createTime;


    @ManyToOne
    private Supplier supplier;


    @CreatedBy
    @ManyToOne
    @JoinColumn(name="CREATE_USER",updatable = false)
    private AdminUser createUser;

    public Double getInvocTotal() {
        return invocTotal;
    }

    public void setInvocTotal(Double invocTotal) {
        this.invocTotal = invocTotal;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getInvocNum() {
        return invocNum;
    }

    public void setInvocNum(Double invocNum) {
        this.invocNum = invocNum;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public AdminUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(AdminUser createUser) {
        this.createUser = createUser;
    }
}
