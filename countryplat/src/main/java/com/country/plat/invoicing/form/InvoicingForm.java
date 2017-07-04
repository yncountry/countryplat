package com.country.plat.invoicing.form;

import cn.gfire.base.mvc.form.BaseForm;
import com.country.plat.accounting.domain.BaseAccount;
import com.country.plat.goods.domain.Goods;
import com.country.plat.invoicing.domain.Invoicing;
import com.country.plat.invoicing.domain.Supplier;

/**
 * @author wust
 * @date 2017/5/30
 * @vsrsion
 * @desc
 */

public class InvoicingForm extends BaseForm<Invoicing,Long> {

    private Double invocNum;

    private Integer payState;

    private BaseAccount baseAccount;

    private Goods goods;

    private Double invocTotal;

    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String getName() {
        return null;
    }

    public Double getInvocTotal() {
        return invocTotal;
    }

    public void setInvocTotal(Double invocTotal) {
        this.invocTotal = invocTotal;
    }

    public Double getInvocNum() {
        return invocNum;
    }

    public void setInvocNum(Double invocNum) {
        this.invocNum = invocNum;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public BaseAccount getBaseAccount() {
        return baseAccount;
    }

    public void setBaseAccount(BaseAccount baseAccount) {
        this.baseAccount = baseAccount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
