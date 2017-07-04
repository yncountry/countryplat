package com.country.plat.accounting.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseDataResponse;
import cn.gfire.base.mvc.form.BaseForm;
import com.country.plat.accounting.domain.Bill;
import com.country.plat.accounting.form.BillForm;
import com.country.plat.accounting.query.BillQuery;
import com.country.plat.accounting.service.BaseAccountService;
import com.country.plat.accounting.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wust
 * @date 2017/6/19
 * @vsrsion
 * @desc
 */
@Controller
@RequestMapping("bill")
public class BillerController extends CrudController<Bill,Long> {

    private String LSIT_URL="finance/bill/list";
    private String ADD_URL="finance/bill/add";

    @Resource
    private BaseAccountService baseAccountService;

    @PostMapping("add")
    @ResponseBody
    public BaseDataResponse add(BillForm billForm,BindingResult bindingResult){
        String result = ((BillService) service).createBill(billForm.getBillDesc(), billForm.getBillType(), baseAccountService.findOne(billForm.getBaseAccount().getId()).get(), billForm.getSumTotal(), billForm.getBillState());
        return BaseDataResponse.ok().data(result).jumpUrl("list");
    }

    @RequestMapping("list")
    public String list(Model model , BillQuery query){
        model.addAttribute("baseAccount",baseAccountService.findAll());
        String list = super.list(model, query);
        return  list;
    }

    @Override
    protected BaseForm<Bill, Long> getBlankForm() {
        return new BillForm();
    }

    @Override
    protected BaseForm<Bill, Long> getForm(Bill bill) {
        return new BillForm();
    }

    @Override
    protected String getListUrl() {
        return LSIT_URL;
    }

    @Override
    protected String getFormUrl() {
        return ADD_URL;
    }
}
