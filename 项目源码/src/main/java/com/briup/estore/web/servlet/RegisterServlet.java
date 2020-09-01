package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = null;
		session = request.getSession();
		try {
			// 获取请求携带的参数
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String zipCode = request.getParameter("zipCode");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");
			// 封装到一个对象中
			Customer customer = new Customer();
			customer.setName(name);
			customer.setPassword(password);
			customer.setZipcode(zipCode);
			customer.setTelephone(telephone);
			customer.setEmail(email);
			
			// 测试打印
			System.out.println(customer);
			// 调用service层代码保存数据
			ICustomerService customerServiceImpl = new CustomerServiceImpl();
			customerServiceImpl.saveCustomer(customer);
			
			session.setAttribute("msg", "注册成功,请登录");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		} catch (Exception e) {
			// 把异常的信息以明了的方式返回给客户端
			session.setAttribute("msg", "注册失败"+e.getMessage()+",请重新注册");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
