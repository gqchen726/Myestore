package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ex.ShopCar;
import com.briup.estore.service.impl.BookServiceImpl;

public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		// 获取书籍信息
		Book book = new BookServiceImpl().findBookById(Integer.parseInt(id));
		// 创建订单项
		OrderLine orderLine = new OrderLine();
		orderLine.setBookId(book.getId());
		orderLine.setBook(book);
		orderLine.setNum(Integer.parseInt(num));
		orderLine.setCost(book.getPrice()*orderLine.getNum());
		
		HttpSession session = request.getSession();
		// 获取购物车
		ShopCar car = (ShopCar)session.getAttribute("car");
		// 没有购物车创建一个购物车
		if (car == null) {
			car = new ShopCar();
			session.setAttribute("car", car);
		} 
		// 有购物车后添加订单项
		car.add(orderLine);
		response.sendRedirect(request.getContextPath()+"/shopCar.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
