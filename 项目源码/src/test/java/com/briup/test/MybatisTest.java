package com.briup.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.BookExample;
import com.briup.estore.bean.Category;
import com.briup.estore.bean.CategoryExample;
import com.briup.estore.bean.ex.CategoryEx;
import com.briup.estore.mapper.BookMapper;
import com.briup.estore.mapper.CategoryMapper;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class MybatisTest {
	@Test
	public void selectCategoriese() {
		
				List<CategoryEx> categoriess = MyBatisSqlSessionFactory.
					openSession().
						getMapper(com.briup.estore.mapper.ex.CategoryMapperEx.class).
							selectOnceCategories();
				for (CategoryEx categoryEx : categoriess) {
					System.out.println(categoryEx);
				}
	}
	@Test
	public void selectCategories() {
		
				List<CategoryEx> categoriess = MyBatisSqlSessionFactory.
					openSession().
						getMapper(com.briup.estore.mapper.ex.CategoryMapperEx.class).
							selectCategories();
				for (CategoryEx categoryEx : categoriess) {
					System.out.println(categoryEx);
				}
	}
	@Test
	public void selectCategories1() {
		
				List<CategoryEx> categoriess = MyBatisSqlSessionFactory.
					openSession().
						getMapper(com.briup.estore.mapper.ex.CategoryMapperEx.class).
						selectCategories1();
				for (CategoryEx categoryEx : categoriess) {
					System.out.println(categoryEx);
				}
	}
	
	
	
	
	
	
	
	@Test
	public void selectBooks() {
		
			CategoryMapper mapper1 = MyBatisSqlSessionFactory.
					openSession().
						getMapper(CategoryMapper.class);
			CategoryExample example1 = new CategoryExample();
			example1.createCriteria().andParentIdEqualTo(1);
			
			List<Category> categories = mapper1.selectByExample(example1);
			ArrayList<Integer> list = new ArrayList<>();
			for (Category category : categories) {
				list.add(category.getId());
			}
			
			BookMapper mapper2 = MyBatisSqlSessionFactory.
					openSession().
						getMapper(BookMapper.class);
			
			
			
			BookExample example2 = new BookExample();
			example2.createCriteria().andCategoryIdIn(list);
			List<Book> books = mapper2.selectByExample(example2);
			
			
			books.forEach(System.out::println);
			
			
						
	}
	@Test
	public void selectBooks1() {
		
		Integer id = 1;
		System.out.println("id:"+id);
		// 根据一级分类的id值获取二级分类的数据
		List<Category> categoryIds = new CategoryServiceImpl().findCategoryById(id);
		categoryIds.forEach(System.out::println);
		// 根据二级分类的id值查找书
		List<Book> books = new BookServiceImpl().findBookByCategoryId(categoryIds );
		books.forEach(System.out::println);
			
			
						
	}
}	
