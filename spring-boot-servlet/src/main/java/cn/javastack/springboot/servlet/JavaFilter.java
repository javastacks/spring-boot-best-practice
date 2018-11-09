package cn.javastack.springboot.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 微信公众号：Java技术栈
 */
@WebFilter(filterName = "javaFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "name", value = "javastack"),
		@WebInitParam(name = "code", value = "123456") })
public class JavaFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("java filter init.");
		String name = filterConfig.getInitParameter("name");
		String code = filterConfig.getInitParameter("code");
		System.out.println("name is " + name);
		System.out.println("code is " + code);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("java filter processing.");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("java filter destroy.");
	}

}
