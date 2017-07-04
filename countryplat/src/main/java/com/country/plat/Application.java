package com.country.plat;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.country.common.admin.domain.AdminUser;
import com.country.plat.admin.auditing.AdminUserAudit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author XuHui(xh@gfire.cn)
 * @date 2017/5/16
 * @desc
 */
@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(value = "com.country.*.*.dao", repositoryBaseClass =cn.gfire.base.jpa.dao.impl.BaseRepositoryImpl.class)
@EnableJpaAuditing
@EntityScan(value = {"com.country.*.*.domain"})
public class Application {

    /**
     * spring -data 的审计
     * @return
     */
    @Bean
    public AuditorAware<AdminUser> auditorProvider() {
        return new AdminUserAudit();
    }


//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        super.addArgumentResolvers(argumentResolvers);
//        argumentResolvers.add(new AnnexHandlerMethodArgumentResolver());
//        argumentResolvers.add(new UserHandlerMethodArgumentResolver());
//    }


    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
