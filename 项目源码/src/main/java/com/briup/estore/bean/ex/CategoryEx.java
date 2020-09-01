package com.briup.estore.bean.ex;

import java.util.List;

import com.briup.estore.bean.Category;

/**
 * 一级分类
 * 
 * @author ghost
 *
 */
public class CategoryEx {
	private Integer id;

	private String name;

	private String description;

	/**
	 * 一级分类对应二级分类
	 */
	private List<Category> categories;
	public CategoryEx() {
		super();
	}
	
	public CategoryEx(Integer id, String name, String description, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	@Override
	public String toString() {
		return "CategoryEx [id=" + id + ", name=" + name + ", description=" + description + ", categories=" + categories
				+ "]";
	}
	
	

}
