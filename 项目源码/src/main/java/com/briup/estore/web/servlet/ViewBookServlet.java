package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.impl.BookServiceImpl;
/**
 * 	查看图书时跳转的服务器
 * @author ghost
 *
 */
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getSession().getServletContext();
		
		int bookId = Integer.parseInt(request.getParameter("id"));
		System.out.println(bookId);
		Book book = new BookServiceImpl().findBookById(bookId);
		application.setAttribute("book", book);
		System.out.println(book);
		response.sendRedirect(request.getContextPath()+"/viewBook.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
