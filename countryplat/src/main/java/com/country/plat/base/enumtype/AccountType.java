package com.country.plat.base.enumtype;

import cn.gfire.base.jpa.domain.StringRemarkEnmu;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc D定义账户类型
 */

public enum  AccountType implements StringRemarkEnmu {

    WECHTPAY("微信账户"),
    ALIPAY("支付宝账户"),
    CASHPAY("现金账户");

    private String remark;

    AccountType(String remark){
        this.remark=remark;
    }

    @Override
    public String getRemark() {
        return remark;
    }
}
