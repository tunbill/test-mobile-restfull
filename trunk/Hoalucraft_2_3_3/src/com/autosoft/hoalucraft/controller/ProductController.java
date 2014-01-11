package com.autosoft.hoalucraft.controller;

import com.autosoft.hoalucraft.dao.ProductDAO;
import com.autosoft.hoalucraft.model.Product;
import com.autosoft.hoalucraft.view.ProductView;

public class ProductController {
	private Product		model;
	private ProductView	view;

	public ProductController(long productId, ProductView view) {
		super();
		model = ProductDAO.getById(productId);
		this.view = view;

		this.view.fillProductToView(model);
	}

	public Product getModel() {
		return model;
	}

	public ProductView getView() {
		return view;
	}
}
