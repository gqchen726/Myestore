package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.OrderServiceImpl;

public class ShowOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowOrderDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			Integer orderFormId = Integer.parseInt(request.getParameter("id"));
			List<OrderLine> orderLines = new OrderServiceImpl().findOrderLinesByOrderFormId(orderFormId);
			orderLines.forEach((orderLine)->
				{
					Book book = new BookServiceImpl().findBookById(orderLine.getBookId());
					orderLine.setBook(book);
				}
			);
			session.setAttribute("orderLines", orderLines);
			
			response.sendRedirect(request.getContextPath()+"/orderdetail.jsp");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
