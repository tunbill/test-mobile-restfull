package com.autosoft.hoalucraft.model;

import java.util.List;

import com.autosoft.hoalucraft.dao.ProductDAO;

public class ProductListModel {
	public static final int	DEFAULT_COUNT	= 10;

	private int				start;
	private int				count;

	private List<Product>	products;
	private Category		category;

	public ProductListModel(Category category) {
		super();
		this.category = category;
		start = 0;
		count = ProductDAO.count(this.category.getCategoryId());
		products = loadData();
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Product> loadData() {
		if (this.category != null) {
			return ProductDAO.getByCategoryId(this.category.getCategoryId(), start, DEFAULT_COUNT);
		}
		return null;
	}

	public int getCount() {
		return count;
	}

	public boolean hasNext() {
		return start + DEFAULT_COUNT < count ? true : false;
	}

	public List<Product> next() {
		if (hasNext()) {
			start += DEFAULT_COUNT;

			List<Product> subList = loadData();
			if (products != null) {

				if (subList != null && subList.size() > 0) {
					products.addAll(subList);
				}
			} else {
				products = subList;
			}
			return subList;
		}
		return null;
	}

	public int getStart() {
		return start;
	}
}
