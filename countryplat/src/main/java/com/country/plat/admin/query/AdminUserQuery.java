package com.country.plat.admin.query;

import cn.gfire.base.jpa.dao.query.BaseWordQuery;
import com.country.common.admin.domain.AdminUser;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author wust
 * @date 2017/5/16
 * @vsrsion
 * @desc
 */

public class AdminUserQuery extends BaseWordQuery<AdminUser> {

    @Override
    public Specification<AdminUser> getSpecification() {
        return null;
    }
}
