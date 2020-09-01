package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.impl.CustomerServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			Customer customer = new Customer();
			customer.setName(name);
			customer.setPassword(password);
			
			CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			List<Customer> customers = customerServiceImpl.findCustomerByNameAndPassword(customer);
			if (customers.size() == 0) {
				session.setAttribute("loginMsg", "用户名或密码错误");
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			} else {
				session.setAttribute("loginMsg", "登陆成功");
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				for (Customer cus : customers) {
					session.setAttribute("customer", cus);
				}
				session.setAttribute("isLogin", "1");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
