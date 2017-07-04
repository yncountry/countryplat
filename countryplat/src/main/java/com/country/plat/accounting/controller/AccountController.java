package com.country.plat.accounting.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseForm;
import com.country.plat.accounting.domain.BaseAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wust
 * @date 2017/6/19
 * @vsrsion
 * @desc
 */
@Controller
@RequestMapping("account")
public class AccountController extends CrudController<BaseAccount,Long> {


    /**
     * 账务中心
     * @param model
     * @return
     */
    @GetMapping("accountCenter")
    public String accountCenter(Model model){
        return "finance/account/account";
    }

    /**
     * 资金监控
     * @param model
     * @return
     */
    @GetMapping("fundMointor")
    public String fundMointor(Model model){
        return "finance/account/rescount";
    }

    /**
     * 资金分析
     * @param model
     * @return
     */
    @GetMapping("fundAnalysis")
    public String fundAnalysis(Model model){
        return "finance/account/rescount";
    }


    @Override
    protected BaseForm<BaseAccount, Long> getBlankForm() {
        return null;
    }

    @Override
    protected BaseForm<BaseAccount, Long> getForm(BaseAccount baseAccount) {
        return null;
    }

    @Override
    protected String getListUrl() {
        return null;
    }

    @Override
    protected String getFormUrl() {
        return null;
    }
}
