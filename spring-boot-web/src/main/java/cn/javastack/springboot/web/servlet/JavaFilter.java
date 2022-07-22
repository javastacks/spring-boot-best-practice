package cn.javastack.springboot.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 微信公众号：Java技术栈
 */
@WebFilter(filterName = "javaFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "name", value = "javastack"),
        @WebInitParam(name = "code", value = "123456")})
@Slf4j
public class JavaFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("java filter init.");
        String name = filterConfig.getInitParameter("name");
        String code = filterConfig.getInitParameter("code");
        log.info("name is " + name);
        log.info("code is " + code);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("java filter processing.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("java filter destroy.");
    }

}
