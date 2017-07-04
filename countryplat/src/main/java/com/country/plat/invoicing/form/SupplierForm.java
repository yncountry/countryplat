package com.country.plat.invoicing.form;

import cn.gfire.base.mvc.form.BaseForm;
import cn.gfire.base.mvc.form.WrapIgnore;
import com.country.plat.goods.domain.Goods;
import com.country.plat.invoicing.domain.Supplier;

import java.util.List;

/**
 * @author wust
 * @date 2017/5/26
 * @vsrsion
 * @desc
 */
public class SupplierForm extends BaseForm<Supplier,Long> {

    private String personName;

    private String phoneNo;

    private String wchatImg;

    private String wecahtNet;

    private String address;

    private Integer sex;

    private String wchatNum;

    private String qqNum;

    private String suppEval;

    private Long[] goodsIds;

    @WrapIgnore
    private List<Goods> goodsList;

    @Override
    public Supplier as() {
        Supplier supplier = super.as();
        if(goodsList !=null){
            supplier.setGoodsList(goodsList);
        }
        return supplier;
    }

    public Long[] getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(Long[] goodsIds) {
        this.goodsIds = goodsIds;
    }

    public String getPersonName() {
        return personName;
    }


    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getWchatImg() {
        return wchatImg;
    }

    public void setWchatImg(String wchatImg) {
        this.wchatImg = wchatImg;
    }

    public String getWecahtNet() {
        return wecahtNet;
    }

    public void setWecahtNet(String wecahtNet) {
        this.wecahtNet = wecahtNet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getWchatNum() {
        return wchatNum;
    }

    public void setWchatNum(String wchatNum) {
        this.wchatNum = wchatNum;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getSuppEval() {
        return suppEval;
    }

    public void setSuppEval(String suppEval) {
        this.suppEval = suppEval;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String getName() {
        return null;
    }
}
