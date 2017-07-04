package com.country.plat.admin.controller;

import cn.gfire.base.mvc.controller.CrudController;
import cn.gfire.base.mvc.form.BaseDataResponse;
import cn.gfire.base.mvc.form.BaseForm;
import com.country.plat.admin.query.AdminUserQuery;
import com.country.plat.admin.service.RoleService;
import com.country.common.admin.domain.AdminUser;
import com.country.plat.admin.form.AdminUserForm;
import com.country.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wust
 * @date 2017/5/16
 * @vsrsion
 * @desclist
 */
@Controller
@RequestMapping("admin/user")
public class AdminUserController extends CrudController<AdminUser,Long> {

    private String ADD_URL= "user/add";
    private String LIST_URL = "admin/user/list";
    private String LOGIN_URL="home/login";
    private String HOME_URL = "/country/index";

    private String UNKONW_ACCOUNT="账户不存在";
    private String ERROR_PASSEORD="账户密码不正确";


    @Resource
    private RoleService roleService;

    @RequestMapping("logout")
    public String logout(Model model){
        SecurityUtils.getSubject().logout();
        return LOGIN_URL;
    }


    @PostMapping("login")
    public String login(Model model,AdminUserForm form){
        //使用shiro的登录认证
        //1  获取Subject
        Subject currentUser = SecurityUtils.getSubject();
        AdminUser user = (AdminUser) SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
            if(!user.getLoginName().equals(form.getLoginName())){
                //清除session
                SecurityUtils.getSubject().logout();
            }else {
                if(!user.getPassword().equals(form.getPassword())){
                    SecurityUtils.getSubject().logout();
                }
            }
        }
        form.setPassword(MD5Util.Md5SaltEncode(form.getPassword(),"MD5",form.getLoginName()));
        //2 判断当前用户是否登录
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(form.getLoginName(), form.getPassword());
            // rememberme
            token.setRememberMe(true);
            //执行登录操作
            try {
                // 执行登录调用到realm
                currentUser.login(token);
            } catch (UnknownAccountException ue) { //账户不存在
                model.addAttribute("ACCOUNTINFO", UNKONW_ACCOUNT);
                return "forward:/country/index";

            } catch (IncorrectCredentialsException ice) {  //登录密码不对
                model.addAttribute("PASSWORDINFO",ERROR_PASSEORD);
                return "forward:/country/index";
            } catch (AuthenticationException ae) {
                model.addAttribute("logInfo", ae.getMessage());
                return LOGIN_URL;

            }
            model.addAttribute("session", currentUser.getSession());
        }
        return "redirect:/country/index";

    }


    /**
     * 保存用户
     * @param model
     * @param bindingResult
     * @param form
     * @param roleIds
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public BaseDataResponse add(Model model, AdminUserForm form,BindingResult bindingResult,Long[] roleIds){
        AdminUser user = form.as();
        user.setRoles(roleService.findRoleByIds(roleIds));
        service.save(user);
        return BaseDataResponse.ok().jumpUrl("list");
    }


    @GetMapping("list")
    public String list(Model model,AdminUserQuery query){
        model.addAttribute("roles",roleService.findAll());
        return super.list(model,query);
    }


    @Override
    protected BaseForm<AdminUser, Long> getForm(AdminUser adminUser) {
        return new AdminUserForm();
    }

    @Override
    protected String getFormUrl() {
        return LIST_URL;
    }

    @Override
    protected BaseForm<AdminUser, Long> getBlankForm() {
        return new AdminUserForm();
    }

    @Override
    protected String getListUrl() {
        return LIST_URL;
    }
}
