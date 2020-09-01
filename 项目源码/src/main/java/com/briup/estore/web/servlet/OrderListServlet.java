package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.service.impl.OrderServiceImpl;

public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			Customer customer = (Customer)session.getAttribute("customer");
			List<OrderForm> orders = new OrderServiceImpl().findOrderFormsByCustomerId(customer.getId());
			
			session.setAttribute("orders", orders);
			response.sendRedirect(request.getContextPath()+"/orderlist.jsp");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
