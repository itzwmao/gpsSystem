package com.gps.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午7:25:28 </p>
 * <p>类说明：用户登录验证过滤器</p>
 * <p>修改记录： </p> 
 */
@WebFilter(urlPatterns= {"/*"},initParams = {
        @WebInitParam(name = "excludedPages", value = ""
        		+ "/register.do,"
        		+ "/login.do,"
        		+ "/pages/front/login.jsp,"
        		+ "/pages/front/failure.jsp,"
        		+ "/pages/front/register.jsp,"
        		+ "/swagger-ui.html,"
        		+ "/swagger-resources,"
        		+ "/v2,/webjars"),
        @WebInitParam(name = "charSet", value = "utf-8")
        })
public class LoginFilter implements Filter {

	private String excludedPages;
	private String[] excludedPageArray;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludedPages = filterConfig.getInitParameter("excludedPages");
        if (null != excludedPages && excludedPages.length() > 0) {
            excludedPageArray = excludedPages.split(",");
        }
        return;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isExcludedPage = false;
		String servletPath = ((HttpServletRequest) request).getServletPath();
        for (String page : excludedPageArray) {
            if (((HttpServletRequest) request).getServletPath().equals(page) || servletPath.startsWith(page)) {
                isExcludedPage = true;
                break;
            }
        }
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		if(session.getAttribute("name")!=null || isExcludedPage) {
			chain.doFilter(req, res);
		}else {
			//登陆验证不通过，直接跳转到登陆页面
			res.sendRedirect("/pages/front/login.jsp");
		}
	}

	@Override
	public void destroy() {

	}

}
