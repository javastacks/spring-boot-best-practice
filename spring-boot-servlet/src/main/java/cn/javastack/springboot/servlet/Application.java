package cn.javastack.springboot.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

/**
 * 微信公众号：Java技术栈
 */
@ServletComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public ServletRegistrationBean registerServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new RegisterServlet(), "/registerServlet");
        servletRegistrationBean.addInitParameter("name", "javastack");
        servletRegistrationBean.addInitParameter("sex", "man");
        return servletRegistrationBean;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return (servletContext) -> {
            ServletRegistration initServlet = servletContext
                    .addServlet("initServlet", InitServlet.class);
            initServlet.addMapping("/initServlet");
            initServlet.setInitParameter("name", "javastack");
            initServlet.setInitParameter("sex", "man");
        };
    }

}
