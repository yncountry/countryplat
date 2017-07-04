package com.country.plat.goods.service;

import cn.gfire.base.jpa.service.BaseService;
import com.country.common.goods.domain.SaleGoodsInfo;
import com.country.plat.goods.dao.GoodsDao;
import com.country.plat.goods.domain.Goods;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/30.
 */
@Service
public class SaleGoodsInfoSevice extends BaseService<SaleGoodsInfo, Long> {

    private String SUCCESS = "success";

    @Resource
    private GoodsDao goodsDao;

    public String saveSaleGods(SaleGoodsInfo saleGoodsInfo, Goods goods) {
        if (goods == null || saleGoodsInfo == null) {
            return "上架商品不存在或信息不完整";
        }
        save(handSaleGoods(saleGoodsInfo,goods));
        goods.setState(4);
        goodsDao.save(goods);
        return SUCCESS;
    }

    private SaleGoodsInfo handSaleGoods(SaleGoodsInfo saleGoodsInfo, Goods goods) {
         saleGoodsInfo.setImageUrl_1(goods.getMainImage_1());
         saleGoodsInfo.setImageUrl_2(goods.getMainImage_2());
         saleGoodsInfo.setImageUrl_3(goods.getMainImage_3());
         saleGoodsInfo.setDetail(goods.getDetail());
         saleGoodsInfo.setGoodsId(goods.getId());
         return saleGoodsInfo;
    }
}
