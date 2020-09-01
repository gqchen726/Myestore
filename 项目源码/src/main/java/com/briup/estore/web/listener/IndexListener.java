package com.briup.estore.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ex.CategoryEx;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;

public class IndexListener implements ServletContextListener {

    public IndexListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
		try {
			// 获取分类导航数据
			List<CategoryEx> categories = new CategoryServiceImpl().findCategory();
			
			// 将分类导航数据存到application对象的categories中
			application.setAttribute("categories", categories);
			// 获取排行榜数据
			List<Book> book2s = new BookServiceImpl().findBooks();
			book2s.forEach(System.out::println);
			// 将排行榜数据存到application对象的books中
			application.setAttribute("book2s", book2s);
			
			List<Integer> ids = new ArrayList<>();
			for(int i = 0;i < 3;i++) {
				long size = new BookServiceImpl().findBookCount();
				ids.add((int)(Math.random()*size+1));
			}
			// 获取随即推荐列表
			List<Book> book3s = new BookServiceImpl().findBook3s(ids);
			// 遍历测试
//			book3s.forEach(System.out::println);
			// 将随即推荐列表数据存到application对象的book3s中
			application.setAttribute("book3s", book3s);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
    }
	
}
