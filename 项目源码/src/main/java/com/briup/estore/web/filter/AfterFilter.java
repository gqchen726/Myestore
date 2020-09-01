package com.briup.estore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AfterFilter implements Filter {

    public AfterFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		//session.getAttribute("customer") == null
		if (session.getAttribute("customer") == null) {
			session.setAttribute("msg", "请先登录");
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
			return ;
		}
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
