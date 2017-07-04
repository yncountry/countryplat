package com.country.plat.admin.controller;

import cn.gfire.base.mvc.controller.BaseController;
import com.country.common.admin.domain.AdminUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wust
 * @date 2017/5/26
 * @vsrsion
 * @desc
 */

@Controller
@RequestMapping("country")
public class HomeController extends BaseController {

    private String INDEX = "home/login";
    private String HOME_URL = "home/index";


    @RequestMapping("index")
    public String index(){
        AdminUser user = (AdminUser) SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
            return HOME_URL;
        }
        return INDEX;
    }

//    @RequestMapping("home")
//    public String home(Model model){
//        return  HOME_URL;
//    }
}
