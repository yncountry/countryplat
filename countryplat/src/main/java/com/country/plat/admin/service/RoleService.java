package com.country.plat.admin.service;

import cn.gfire.base.jpa.service.BaseService;
import com.country.common.admin.domain.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wust
 * @date 2017/5/23
 * @vsrsion
 * @desc
 */
@Service
public class RoleService extends BaseService<Role,Long> {

    /**
     * 根据id查询
     * @param roleIds
     * @return
     */
    public List<Role> findRoleByIds(Long[] roleIds) {
        return  queryRoleByIds(roleIds);
    }

    public List<Role> queryRoleByIds(Long[] roleIds){
        List<Role> list = new ArrayList<>();
        for (Long id:roleIds){
            list.add(findOne(id).get());
        }
        return list;
    }

}
