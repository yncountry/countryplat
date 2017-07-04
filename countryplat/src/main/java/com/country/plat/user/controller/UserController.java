package com.country.plat.user.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseForm;
import com.country.common.user.domain.User;

/**
 * @author wust
 * @date 2017/6/16
 * @vsrsion
 * @desc
 */

public class UserController extends CrudController<User,Long> {

    @Override
    protected BaseForm<User, Long> getBlankForm() {
        return null;
    }

    @Override
    protected BaseForm<User, Long> getForm(User user) {
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
