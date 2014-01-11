package com.autosoft.hoalucraft.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.controller.ProductListController;
import com.autosoft.hoalucraft.view.ProductListView;

public class ProductListActivity extends Activity {
	private ProductListController	controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		HoaLuCraftApp.configLanguageAndLocate(this);
		this.setTitle(R.string.title_activity_product_list);
		setContentView(R.layout.activity_product_list);

		Intent intent = getIntent();
		long categoryId = intent.getLongExtra("categoryId", 0L);

		ProductListView view = new ProductListView(this);

		controller = new ProductListController(view, categoryId);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_list, menu);
		return true;
	}

}
