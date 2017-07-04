package com.country.plat.base.enumtype;

import cn.gfire.base.jpa.domain.StringRemarkEnmu;

/**
 * @author wust
 * @date 2017/5/16
 * @vsrsion
 * @desc
 */
public enum StateType implements StringRemarkEnmu {

    DELTET("删除"),
    STOP("停用"),
    ENABLE("正常"),;

    private String remark;

    StateType(String remark){
        this.remark=remark;
    }

    @Override
    public String getRemark() {
        return remark;
    }
}
