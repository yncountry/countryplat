package com.country.plat.base.enumtype;

import cn.gfire.base.jpa.domain.StringRemarkEnmu;

/**
 * @author wust
 * @date 2017/5/16
 * @vsrsion
 * @desc 性别类型
 */

public enum  GenderType implements StringRemarkEnmu {

     MALE("男"),
    FEMALE("女"),
    UNKNOWN("未知"),
    ;

    private String remark;

    GenderType(String remark){
        this.remark=remark;
    }

    @Override
    public String getRemark() {
        return remark;
    }

}
