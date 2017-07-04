package com.country.plat.admin.auditing;

import com.country.common.admin.domain.AdminUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.AuditorAware;

/**
 * @author wust
 * @date 2017/5/16
 * @vsrsion
 * @desc 用户审计
 */

public class AdminUserAudit implements AuditorAware<AdminUser> {


    @Override
    public AdminUser getCurrentAuditor() {
        return (AdminUser)SecurityUtils.getSubject().getPrincipal();
    }
}
