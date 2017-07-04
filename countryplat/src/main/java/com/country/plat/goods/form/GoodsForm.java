package com.country.plat.goods.form;

import cn.gfire.base.mvc.form.BaseForm;
import com.country.common.emmun.UnitType;
import com.country.plat.goods.domain.Goods;
import com.country.plat.utils.UUIDGenerator;
import com.country.utils.FileOpUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author wust
 * @date 2017/5/24
 * @vsrsion
 * @desc
 */
@ConfigurationProperties(prefix = "com.country")
public class GoodsForm extends BaseForm<Goods, Long> {


    private String goodImages;

    private MultipartFile[] mainImage_1;

    private MultipartFile[] mainImage_2;

    private MultipartFile[] mainImage_3;

    private UnitType unitType;

    private String detail;

    private String goodstitle;

    private String goodsDesc;

    private Double price;

    private Integer store = 0;

    private String expereNo;

    private Double inPrice;

    private String goodsNo;

    public String getGoodsNo() {
        return goodsNo;
    }

    @Override
    public Goods as() {
        Goods goods = super.as();
        //生成商品编号
        goods.setGoodsNo(UUIDGenerator.getNumUUID());
        try {
            //保存主图
            if (mainImage_1 != null && mainImage_1.length != 0) {
                File file = FileOpUtils.uplaodFile(mainImage_1[0], goodImages);
                goods.setMainImage_1(file==null?null:file.getPath());
            }
            if (mainImage_2 != null && mainImage_2.length != 0) {
                File file = FileOpUtils.uplaodFile(mainImage_2[0], goodImages);
                goods.setMainImage_2(file==null?null:file.getPath());
            }
            if (mainImage_3 != null && mainImage_3.length != 0) {
                File file = FileOpUtils.uplaodFile(mainImage_3[0], goodImages);
                goods.setMainImage_3(file==null?null:file.getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goods;
    }

    public String getGoodImages() {
        return goodImages;
    }

    public void setGoodImages(String goodImages) {
        this.goodImages = goodImages;
    }

    public MultipartFile[] getMainImage_1() {
        return mainImage_1;
    }

    public void setMainImage_1(MultipartFile[] mainImage_1) {
        this.mainImage_1 = mainImage_1;
    }

    public MultipartFile[] getMainImage_2() {
        return mainImage_2;
    }

    public void setMainImage_2(MultipartFile[] mainImage_2) {
        this.mainImage_2 = mainImage_2;
    }

    public MultipartFile[] getMainImage_3() {
        return mainImage_3;
    }

    public void setMainImage_3(MultipartFile[] mainImage_3) {
        this.mainImage_3 = mainImage_3;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getExpereNo() {
        return expereNo;
    }

    public void setExpereNo(String expereNo) {
        this.expereNo = expereNo;
    }

    public Double getInPrice() {
        return inPrice;
    }

    public void setInPrice(Double inPrice) {
        this.inPrice = inPrice;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    @Override
    public String getName() {
        return null;
    }

}
