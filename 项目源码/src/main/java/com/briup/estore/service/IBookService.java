package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;

public interface IBookService {
	List<Book> findBookByCategoryId(List<Category> categoryIds) throws RuntimeException;
	List<Book> findBookByOneCategoryId(int id) throws RuntimeException;
	Book findBookById(int id) throws RuntimeException;
	List<Book> findBooks() throws RuntimeException;
	List<Book> findBook3s(List<Integer> ids) throws RuntimeException;
	public long findBookCount() throws RuntimeException;
}
