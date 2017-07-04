package com.country.plat.admin.form;

import cn.gfire.base.mvc.form.BaseForm;
import com.country.common.admin.domain.Role;

/**
 * @author wust
 * @date 2017/5/23
 * @vsrsion
 * @desc
 */

public class RoleForm extends BaseForm<Role,Long> {

    private String roleName;

    @Override
    public String getName() {
        return null;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
