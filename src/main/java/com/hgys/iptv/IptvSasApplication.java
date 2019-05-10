package com.hgys.iptv;

import com.hgys.iptv.common.VerifyServlet;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
        (exclude={
        //org.activiti.spring.boot.SecurityAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        org.activiti.runtime.api.conf.TaskRuntimeAutoConfiguration.class
})
public class IptvSasApplication {
    public static void main(String[] args) { SpringApplication.run(IptvSasApplication.class, args); }
    /**
     * 注入验证码servlet
     */
    //@Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }

    /**
     * 注入JPAQueryFactory
     * @param entityManager
     * @return
     */
    @Bean
    @Autowired
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
