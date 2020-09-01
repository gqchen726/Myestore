package com.briup.estore.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.service.impl.AddressServiceImpl;

public class ConfirmFilter implements Filter {

    public ConfirmFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		try {
			Customer customer = (Customer)session.getAttribute("customer");
			List<ShopAddress> addresses = new AddressServiceImpl().findAddressesByCustomer(customer.getId());
			session.setAttribute("addresses", addresses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(req, resp);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
