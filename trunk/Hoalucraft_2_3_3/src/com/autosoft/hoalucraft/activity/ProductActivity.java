package com.autosoft.hoalucraft.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.controller.ProductController;
import com.autosoft.hoalucraft.view.ProductView;

public class ProductActivity extends Activity {
	private ProductController	controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		HoaLuCraftApp.configLanguageAndLocate(this);
		this.setTitle(R.string.title_activity_product);
		setContentView(R.layout.activity_product);

		Intent intent = getIntent();
		long productId = intent.getLongExtra("productId", 0L);

		ProductView view = new ProductView(this);

		controller = new ProductController(productId, view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.product, menu);

		return true;
	}

}
