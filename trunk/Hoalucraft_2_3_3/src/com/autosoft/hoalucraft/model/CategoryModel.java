package com.autosoft.hoalucraft.model;

import java.util.List;

import com.autosoft.hoalucraft.dao.CategoryDao;

public class CategoryModel {
	private List<Category>	categories;

	public CategoryModel() {
		super();

	}

	public List<Category> getCategories() {
		return categories;
	}

	public void loadData() {
		categories = CategoryDao.getByLanguage();
	}
}
