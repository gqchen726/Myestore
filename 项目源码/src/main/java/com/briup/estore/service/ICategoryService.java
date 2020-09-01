package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Category;
import com.briup.estore.bean.ex.CategoryEx;

public interface ICategoryService {
	List<CategoryEx> findCategory() throws RuntimeException;
	List<Category> findCategoryById(int id) throws RuntimeException;
}
