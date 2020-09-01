package com.briup.estore.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ex.CategoryEx;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;

public class IndexFilter implements Filter {

    public IndexFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		ServletContext application = req.getSession().getServletContext();
		try {
			// 获取分类导航数据
			List<CategoryEx> categories = new CategoryServiceImpl().findCategory();
			
			// 将分类导航数据存到application对象的categories中
			application.setAttribute("categories", categories);
			// 获取排行榜数据
			List<Book> books = new BookServiceImpl().findBooks();
			// 将排行榜数据存到application对象的books中
			application.setAttribute("books", books);
			
			List<Integer> ids = new ArrayList<>();
			for(int i = 0;i < 3;i++) {
				long size = new BookServiceImpl().findBookCount();
				ids.add((int)(Math.random()*size+1));
			}
			// 获取随机推荐列表
			List<Book> book3s = new BookServiceImpl().findBook3s(ids);
			// 遍历测试
//			book3s.forEach(System.out::println);
			// 将随即推荐列表数据存到application对象的book3s中
			application.setAttribute("book3s", book3s);
			} catch (Exception e) {
			}
			chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
