package com.autosoft.hoalucraft.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.controller.CategoryController;
import com.autosoft.hoalucraft.view.CategoryView;

public class MainActivity extends Activity {
	private CategoryController	controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		HoaLuCraftApp.configLanguageAndLocate(this);
		this.setTitle(R.string.app_name);
		setContentView(R.layout.activity_main);

		CategoryView view = new CategoryView(this);

		controller = new CategoryController(view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		controller.reloadByLanguage(item);
		return true;
	}
}
