package com.briup.estore.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;

public class ListFilter implements Filter {

    public ListFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		@SuppressWarnings("unused")
		HttpServletResponse resp = (HttpServletResponse)response;
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		System.out.println("id:"+req.getParameter("id"));
		// 根据一级分类的id值获取二级分类的数据
		List<Category> categoryIds = new CategoryServiceImpl().findCategoryById(id);
		categoryIds.forEach(System.out::println);
		// 根据二级分类的id值查找书
		List<Book> books = new BookServiceImpl().findBookByCategoryId(categoryIds );
		books.forEach(System.out::println);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
