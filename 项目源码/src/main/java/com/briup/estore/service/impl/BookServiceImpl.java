package com.briup.estore.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.BookExample;
import com.briup.estore.bean.Category;
import com.briup.estore.mapper.BookMapper;
import com.briup.estore.service.IBookService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookService{
	@Override
	public List<Book> findBookByCategoryId(List<Category> categoryIds) throws RuntimeException {
		List<Integer> ids = new ArrayList<>();
		for (Category category : categoryIds) {
			ids.add(category.getId());
		}
		
		
		BookMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
		BookExample example = new BookExample();
 		example.createCriteria().andCategoryIdIn(ids);
		List<Book> books = mapper.selectByExample(example);
		
		return books;
	}
	@Override
	public List<Book> findBookByOneCategoryId(int id) throws RuntimeException {
		BookMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
		BookExample example = new BookExample();
 		example.createCriteria().andCategoryIdEqualTo(id);
		List<Book> books = mapper.selectByExample(example);
		
		return books;
	}
	@Override
	public Book findBookById(int id) throws RuntimeException {
		BookMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
		Book book = mapper.selectByPrimaryKey(id);
		return book;
	}
	@Override
	public List<Book> findBooks() throws RuntimeException {
		BookMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
		BookExample example = new BookExample();
		example.createCriteria().andIdBetween(1, 6);
		List<Book> books = mapper.selectByExample(example );
		return books;
	}
	@Override
	public List<Book> findBook3s(List<Integer> ids) throws RuntimeException {
		BookMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
		BookExample example = new BookExample();
		example.createCriteria().andIdIn(ids);
		List<Book> books = mapper.selectByExample(example );
		return books;
	}
	@Override
	public long findBookCount() throws RuntimeException {
		BookExample example = new BookExample();
		example.createCriteria().andIdNotEqualTo(0);
		long count = MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class).countByExample(example);
		return count;
	}
}
