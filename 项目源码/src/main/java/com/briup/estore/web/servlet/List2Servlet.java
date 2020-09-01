package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.impl.BookServiceImpl;
/**
 *	接收 二级分类被点击时的get请求
 * @author ghost
 *
 */
public class List2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public List2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getSession().getServletContext();
		try {
			// 获取二级分类的id值
			int id2 = Integer.parseInt(request.getParameter("id"));
			// 根据二级分类的id查询出所有书
			List<Book> books = new BookServiceImpl().findBookByOneCategoryId(id2);
			// 把书本信息放到application范围中
			application.setAttribute("books", books);
			// 打印输出测试
			books.forEach(System.out::println);
			// 重定向到list.jsp页面
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
