package com.country.plat.goods.domain;

import cn.gfire.base.jpa.domain.BaseDomain;
import com.country.common.emmun.UnitType;
import com.country.plat.invoicing.domain.Supplier;
import org.hibernate.cfg.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author wust
 * @date 2017/5/24
 * @vsrsion
 * @desc 商品信息类
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Goods extends BaseDomain<Long> {

    @Comment("商品标题")
    private String goodstitle;

    @Comment("商品编号")
    private String goodsNo;

    @Comment("商品描述")
    private String goodsDesc;

    @Comment("销售单价")
    private Double price;

    @Comment("商品状态 0 发布，1 已进货 2 在售 3 冻结 4 已经上架 5 下架")
    private Integer state;

    @Comment("库存")
    private Double store;

    @Comment("进货价")
    private Double inPrice;

    @Comment("主图2")
    private String mainImage_1;

    @Comment("主图1")
    private String mainImage_2;

    @Comment("主图1")
    private String mainImage_3;


    @Comment("详情")
    @Column(columnDefinition="TEXT")
    private String detail;

    /**
     * 这里说明 为了瞒住所每件商品都能够查询到快递新，
     * 所以采取快递单号不在订单中
     */
    @Comment("快递单号")
    private String expereNo;


    @Comment("创建时间")
    @CreatedDate
    @Column(updatable = false)
    private Date createTime;

    @Comment("进销信息")
    @ManyToMany(mappedBy = "goodsList")
    private List<Supplier> suppliers;


    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    private UnitType unitType;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
    public String getExpereNo() {
        return expereNo;
    }

    public void setExpereNo(String expereNo) {
        this.expereNo = expereNo;
    }


    public String getGoodstitle() {
        return goodstitle;
    }

    public void setGoodstitle(String goodstitle) {
        this.goodstitle = goodstitle;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStore() {
        return store;
    }

    public void setStore(Double store) {
        this.store = store;
    }

    public Double getInPrice() {
        return inPrice;
    }

    public void setInPrice(Double inPrice) {
        this.inPrice = inPrice;
    }

    public String getMainImage_1() {
        return mainImage_1;
    }

    public void setMainImage_1(String mainImage_1) {
        this.mainImage_1 = mainImage_1;
    }

    public String getMainImage_2() {
        return mainImage_2;
    }

    public void setMainImage_2(String mainImage_2) {
        this.mainImage_2 = mainImage_2;
    }

    public String getMainImage_3() {
        return mainImage_3;
    }

    public void setMainImage_3(String mainImage_3) {
        this.mainImage_3 = mainImage_3;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
