package com.country.plat.credit.domain;

import cn.gfire.base.jpa.domain.BaseDomain;
import org.hibernate.cfg.annotations.Comment;

import javax.persistence.Entity;

/**
 * @author wust
 * @date 2017/5/25
 * @vsrsion
 * @desc 信用
 */
@Entity
public class Credit extends BaseDomain<Long> {

    private Integer countryCredit;

    private Integer creditClass;

    @Comment("失信次数")
    private Integer dishonestyCount;

}
