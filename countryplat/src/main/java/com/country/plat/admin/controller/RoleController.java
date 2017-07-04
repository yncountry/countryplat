package com.country.plat.admin.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseForm;
import com.country.plat.admin.form.RoleForm;
import com.country.plat.admin.service.PermissionService;
import com.country.common.admin.domain.Permission;
import com.country.common.admin.domain.Role;
import com.country.plat.admin.query.RoleQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wust
 * @date 2017/5/23
 * @vsrsion
 * @desc
 */

@Controller
@RequestMapping("admin/role")
public class RoleController extends CrudController<Role,Long> {

    private String ADD_URL ="admin/role/add";

    private String LIST_URL="admin/role/list";

    @Resource
    private PermissionService permissionService;


    @GetMapping("add")
    public String add(Model model){
        super.add(model);
        setBaseData(model, permissionService.findAll());
       return ADD_URL;
    }

    @GetMapping("list")
    public  String list(Model model, RoleQuery query) {
        return super.list(model, query);
    }


    private void setBaseData(Model model, List<Permission> permissions) {
        model.addAttribute("perms", permissions);
        Map<String, List<Permission>> stringListMap = new HashMap<>();
        permissions.forEach(tmp -> {
            if (stringListMap.get(tmp.getParentModeName()) != null) {
                stringListMap.get(tmp.getParentModeName()).add(tmp);
            } else {
                List<Permission> permissionList = new ArrayList<>();
                permissionList.add(tmp);
                stringListMap.put(tmp.getParentModeName(), permissionList);
            }
        });
        model.addAttribute("permissionMap", stringListMap);
    }


    @Override
    protected String getFormUrl() {
        return LIST_URL;
    }

    @Override
    protected String getListUrl() {
        return LIST_URL;
    }

    @Override
    protected BaseForm<Role, Long> getBlankForm() {
        return new RoleForm();
    }

    @Override
    protected BaseForm<Role, Long> getForm(Role role) {
        return new RoleForm();
    }
}
