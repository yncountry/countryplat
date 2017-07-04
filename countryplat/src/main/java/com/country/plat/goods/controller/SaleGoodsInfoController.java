package com.country.plat.goods.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseDataResponse;
import cn.gfire.base.mvc.form.BaseForm;
import cn.gfire.base.mvc.utils.OptionalUtils;
import com.country.common.emmun.UnitType;
import com.country.common.goods.domain.SaleGoodsInfo;
import com.country.plat.goods.domain.Goods;
import com.country.plat.goods.form.SaleGoodsInfoForm;
import com.country.plat.goods.query.SaleGoodsQuery;
import com.country.plat.goods.service.GoodsService;
import com.country.plat.goods.service.SaleGoodsInfoSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/29.
 */
@Controller
@RequestMapping("saleGoods")
public class SaleGoodsInfoController extends CrudController<SaleGoodsInfo, Long> {

    public String ADD_URL = "goods/sale/add";
    public String LIST_URL = "goods/sale/list";
    @Resource
    private GoodsService goodsService;


    @GetMapping("add/{goodsId}")
    public String add(Model model, @PathVariable Long goodsId) {
        Goods goods = goodsService.findOne(goodsId).get();
        model.addAttribute("form", goods);
        model.addAttribute("UnitType", OptionalUtils.getOptional(UnitType.class));
        return ADD_URL;
    }

    @PostMapping("add")
    @ResponseBody
    public BaseDataResponse add(SaleGoodsInfoForm form, BindingResult bindingResult) {

        String result = ((SaleGoodsInfoSevice) service).saveSaleGods(form.as(), goodsService.findOne(form.getGoodsId()).get());

        return "success".equals(result) ? BaseDataResponse.ok().jumpUrl("/saleGoods/list").detail("商品上架成功") : BaseDataResponse.fail().detail("商品上架失败");
    }

    @GetMapping(value = {"","list"})
    public String  list(Model model, SaleGoodsQuery query) {
        return super.list(model, query);
    }

    @Override
    protected BaseForm<SaleGoodsInfo, Long> getBlankForm() {
        return null;
    }

    @Override
    protected BaseForm<SaleGoodsInfo, Long> getForm(SaleGoodsInfo saleGoodsInfo) {
        return null;
    }

    @Override
    protected String getListUrl() {
        return LIST_URL;
    }

    @Override
    protected String getFormUrl() {
        return ADD_URL;
    }
}
