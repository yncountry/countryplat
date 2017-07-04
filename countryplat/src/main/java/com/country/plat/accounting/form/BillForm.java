package com.country.plat.accounting.form;

import cn.gfire.base.mvc.form.BaseForm;
import com.country.plat.accounting.domain.BaseAccount;
import com.country.plat.accounting.domain.Bill;
import com.country.plat.utils.UUIDGenerator;
import com.country.utils.StringUtils;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */
public class BillForm extends BaseForm<Bill,Long> {
    private String billNum;
    private Integer billType;
    private Double sumTotal;
    private Integer billState;
    private String billDesc;
    private BaseAccount baseAccount;


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

    public String getBillNum() {
        return billNum;
    }
    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    @Override
    public String getName() {
        return null;
    }
}
