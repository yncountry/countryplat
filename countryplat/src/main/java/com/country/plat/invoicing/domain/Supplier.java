package com.country.plat.invoicing.domain;


import com.country.plat.base.pojo.BasePerson;
import com.country.plat.credit.domain.Credit;
import com.country.plat.goods.domain.Goods;
import org.hibernate.cfg.annotations.Comment;

import javax.persistence.*;
import java.util.List;

/**
 * @author wust
 * @date 2017/5/25
 * @vsrsion
 * @desc
 */
@Entity
public class Supplier extends BasePerson<Long> {

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id" ))
    private List<Goods>  goodsList;

    @Comment("供货评价")
    private String suppEval;

    private Integer creditClass;

    @OneToOne
    @JoinColumn( name = "CREDIT_ID")
    private Credit credit;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public String getSuppEval() {
        return suppEval;
    }

    public void setSuppEval(String suppEval) {
        this.suppEval = suppEval;
    }

    public Integer getCreditClass() {
        return creditClass;
    }

    public void setCreditClass(Integer creditClass) {
        this.creditClass = creditClass;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
