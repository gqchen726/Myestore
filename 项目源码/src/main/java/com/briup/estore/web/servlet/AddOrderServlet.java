package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ex.ShopCar;
import com.briup.estore.service.impl.AddressServiceImpl;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.OrderServiceImpl;

public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理新增收货地址的请求
		String reciveName = request.getParameter("receiveName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		HttpSession session = request.getSession();
		Integer customerId = ((Customer)session.getAttribute("customer")).getId();
		if (reciveName.trim() != "" && address.trim() != "" && phone.trim() != "") {
			ShopAddress shopAddress = new ShopAddress();
			shopAddress.setReceivename(reciveName);
			shopAddress.setAddress(address);
			shopAddress.setPhone(phone);
			shopAddress.setCustomerId(customerId);
			new AddressServiceImpl().addAddress(shopAddress);
			response.sendRedirect(request.getContextPath()+"/confirm.jsp");
			return ;
		} 
		// 将订单信息插入数据库
		ShopCar car = (ShopCar)request.getSession().getAttribute("car");
		// 获取用户选中的收获地址
		String addrId = request.getParameter("addrId");
		Integer shopaddressId = Integer.parseInt(addrId);
		// 将订单插入数据库
		OrderForm orderForm = new OrderForm();
		orderForm.setCustomerId(customerId);
		orderForm.setShopaddressId(shopaddressId);
		orderForm.setOrderdate(new Date());
		orderForm.setCost(car.getCost());
		// 此处返回的orderForm将通过OrderFormMapper.xml中的insert中的selectKey在数据保存到数据库时,将id返回,封装到orderForm对象中
		OrderForm submitOrder = new OrderServiceImpl().submitOrder(orderForm);
		/*
		 *  将订单项插入数据库
		 *  	遍历购物车中的订单项
		 *  	将订单id封装到订单项中
		 *  	将订单项插入数据库
		 */
		Collection<OrderLine> orderLines = car.getLines();
		orderLines.forEach((orderLine)->
			{
				orderLine.setOrderformId(submitOrder.getId());
				Book book = new BookServiceImpl().findBookById(orderLine.getBookId());
				orderLine.setBook(book);
			}
		);
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.addOrderLines(orderLines);
		
		
		
		response.sendRedirect(request.getContextPath()+"/showOrder");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
