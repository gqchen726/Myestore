package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;
/**
 *	接收一级级分类被点击时的get请求
 * @author ghost
 *
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getSession().getServletContext();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			// 根据一级分类的id值获取二级分类的数据
			List<Category> categoryIds = new CategoryServiceImpl().findCategoryById(id);
			// 根据二级分类的id值查找书
			List<Book> books = new BookServiceImpl().findBookByCategoryId(categoryIds );
			application.setAttribute("books", books);
			books.forEach(System.out::println);
			response.sendRedirect(request.getContextPath()+"/list.jsp");
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
