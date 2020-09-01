package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ex.ShopCar;

public class RemoveOrderLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveOrderLineServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		ShopCar car = (ShopCar)session.getAttribute("car");
		car.delete(bookId);
		session.setAttribute("car", car);
		response.sendRedirect(request.getContextPath()+"/shopCar.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
