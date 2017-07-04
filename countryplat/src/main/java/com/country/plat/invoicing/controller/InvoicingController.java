package com.country.plat.invoicing.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseDataResponse;
import cn.gfire.base.mvc.form.BaseForm;
import cn.gfire.base.mvc.utils.OptionalUtils;
import com.country.plat.accounting.service.BaseAccountService;
import com.country.plat.goods.service.GoodsService;
import com.country.plat.invoicing.domain.Invoicing;
import com.country.plat.invoicing.form.InvoicingForm;
import com.country.plat.invoicing.query.InvoicingQuery;
import com.country.plat.invoicing.service.InvoicingService;
import com.country.plat.invoicing.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wust
 * @date 2017/5/29
 * @vsrsion
 * @desc
 */
@Controller
@RequestMapping("invoicing")
public class InvoicingController extends CrudController<Invoicing, Long> {

    private String LIST_URL = "inviocing/list";
    private String ADD_URL = "inviocing/add";
    @Resource
    private GoodsService goodsService;

    @Resource
    private BaseAccountService baseAccountService;

    @Resource
    private SupplierService supplierService;

    @GetMapping("add")
    public String add(Model model, Long goodsId) {
        model.addAttribute("goods", goodsService.findOne(goodsId).get());
        model.addAttribute("accountType", baseAccountService.findAll());
        return ADD_URL;
    }

    @PostMapping("add")
    @ResponseBody
    public BaseDataResponse add(InvoicingForm form) {
        Invoicing invoicing = form.as();
        invoicing.setSupplier(supplierService.findOne(form.getSupplier().getId()).get());
        invoicing.setUnitType(goodsService.findOne(form.getGoods().getId()).get().getUnitType());
        ((InvoicingService) service).saveInvoc(invoicing, form.getBaseAccount());
        return BaseDataResponse.ok().jumpUrl("list");
    }

    @GetMapping("list")
    public String list(Model model, InvoicingQuery query) {
        super.list(model, query);
        return LIST_URL;
    }


    @Override
    protected String getListUrl() {
        return LIST_URL;
    }

    @Override
    protected String getFormUrl() {
        return LIST_URL;
    }

    @Override
    protected BaseForm<Invoicing, Long> getBlankForm() {
        return null;
    }

    @Override
    protected BaseForm<Invoicing, Long> getForm(Invoicing invoicing) {
        return null;
    }
}
