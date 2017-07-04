package com.country.plat.invoicing.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseDataResponse;
import cn.gfire.base.mvc.form.BaseForm;
import com.country.plat.goods.service.GoodsService;
import com.country.plat.invoicing.domain.Supplier;
import com.country.plat.invoicing.form.SupplierForm;
import com.country.plat.invoicing.query.SupplierQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wust
 * @date 2017/5/29
 * @vsrsion,
 * @desc
 */
@Controller
@RequestMapping("supplier")
public class SupplierController extends CrudController<Supplier,Long> {

    private String ADD_URL="supplier/add";

    private String LIST_URL="supplier/list";

    @Resource
    private GoodsService goodsService;

    @GetMapping("add")
    public String add(Model model,Long goodsId,String from ){
        model.addAttribute("invoic",from);
        model.addAttribute("goodsId",goodsId);
        model.addAttribute("goodsList",goodsService.findAll());
        return ADD_URL;
    }

    @PostMapping("add")
    @ResponseBody
    public BaseDataResponse add(Model model, SupplierForm form, BindingResult bindingResult){
        form.setGoodsList(goodsService.queryGoodsByIds(form.getGoodsIds()));
        super.add(form,bindingResult);
        return BaseDataResponse.ok();
    }

    @RequestMapping("list")
    public String list(Model model , SupplierQuery query){
        String list = super.list(model, query);
        return list;
    }

    @Override
    protected String getListUrl() {
        return LIST_URL;
    }

    @Override
    protected String getFormUrl() {
        return ADD_URL;
    }

    @Override
    protected BaseForm<Supplier, Long> getForm(Supplier supplier) {
        return new SupplierForm();
    }

    @Override
    protected BaseForm<Supplier, Long> getBlankForm() {
        return new SupplierForm();
    }
}
