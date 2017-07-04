package com.country.plat.invoicing.service;

import cn.gfire.base.jpa.service.BaseService;
import com.country.plat.accounting.domain.BaseAccount;
import com.country.plat.accounting.service.BillService;
import com.country.plat.goods.domain.Goods;
import com.country.plat.goods.service.GoodsService;
import com.country.plat.invoicing.domain.Invoicing;
import com.country.utils.CalDoubelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author wust
 * @date 2017/5/29
 * @vsrsion
 * @desc
 */
@Service
public class InvoicingService extends BaseService<Invoicing, Long> {

    @Resource
    private BillService billService;
    @Resource
    private GoodsService goodsService;
//
    @Transactional
    public void saveInvoc(Invoicing invoicing, BaseAccount account) {
        Goods goods = goodsService.findOne(invoicing.getGoods().getId()).get();
        Double invocNum = invoicing.getInvocNum();
        Double inPrice = goods.getInPrice();
        Double totalFee = CalDoubelUtils.mul(invocNum, inPrice);
        invoicing.setInvocTotal(totalFee);
        Invoicing newInvoc = save(invoicing).get();
        //增加库存
        Double currStore = goods.getStore() == null ? 0.0 : goods.getStore();
        goods.setStore(CalDoubelUtils.add(invocNum, currStore));
        if (newInvoc.getPayState() == 1) {
            String invocDesc = goods.getGoodstitle() + " 商品进货";
            billService.createBill(invocDesc, 0, account, newInvoc.getInvocTotal(), 1);
        }
    }
}
