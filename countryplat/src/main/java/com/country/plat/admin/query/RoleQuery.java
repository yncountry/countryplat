package com.country.plat.admin.query;

import cn.gfire.base.jpa.dao.query.BaseWordQuery;
import cn.gfire.base.jpa.dao.query.QueryWord;
import com.country.common.admin.domain.Role;

/**
 * @author wust
 * @date 2017/5/23
 * @vsrsion
 * @desc
 */

public class RoleQuery extends BaseWordQuery<Role> {

    @QueryWord
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
