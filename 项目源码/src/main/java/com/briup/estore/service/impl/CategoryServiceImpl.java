package com.briup.estore.service.impl;

import java.util.List;

import com.briup.estore.bean.Category;
import com.briup.estore.bean.CategoryExample;
import com.briup.estore.bean.ex.CategoryEx;
import com.briup.estore.mapper.CategoryMapper;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class CategoryServiceImpl implements ICategoryService{
	@Override
	public List<CategoryEx> findCategory() throws RuntimeException {
		
		List<CategoryEx> categoriess = MyBatisSqlSessionFactory.
				openSession().
					getMapper(com.briup.estore.mapper.ex.CategoryMapperEx.class).
						selectOnceCategories();
		if(categoriess != null) {
			return categoriess;
		} else {
			return null;
		}
	}
	@Override
	public List<Category> findCategoryById(int id) throws RuntimeException {
		CategoryMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(CategoryMapper.class);
		CategoryExample example = new CategoryExample();
		
		example.createCriteria().andParentIdEqualTo(id);
		List<Category> categoryIds = mapper.selectByExample(example);
		categoryIds.forEach(System.out::println);
		return categoryIds;
	}
}
