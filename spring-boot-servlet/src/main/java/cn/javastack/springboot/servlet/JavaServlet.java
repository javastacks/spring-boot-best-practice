package cn.javastack.springboot.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信公众号：Java技术栈
 */
@WebServlet(name = "javaServlet", urlPatterns = "/javaServlet", asyncSupported = true,
		initParams = {
		@WebInitParam(name = "name", value = "javastack"),
		@WebInitParam(name = "sex", value = "man") })
public class JavaServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = getServletConfig().getInitParameter("name");
		String sex = getServletConfig().getInitParameter("sex");

		resp.getOutputStream().println("name is " + name);
		resp.getOutputStream().println("sex is " + sex);

	}

}
