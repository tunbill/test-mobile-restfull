package com.autosoft.hoalucraft.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.activity.MainActivity;
import com.autosoft.hoalucraft.activity.ProductListActivity;
import com.autosoft.hoalucraft.activity.R;
import com.autosoft.hoalucraft.model.Category;
import com.autosoft.hoalucraft.model.CategoryModel;
import com.autosoft.hoalucraft.view.CategoryView;

public class CategoryController {
	private CategoryModel	model;
	private CategoryView	view;

	public CategoryController(final CategoryView view) {
		super();
		this.model = new CategoryModel();
		this.view = view;

		new CategoryLoadDBAsyncTask().execute();

		this.view.setOnListViewClickAction(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				Category category = (Category) adapterView.getItemAtPosition(position);

				Intent intent = new Intent(CategoryController.this.view.getActivity(), ProductListActivity.class);

				intent.putExtra("categoryId", category.getCategoryId());
				CategoryController.this.view.getActivity().startActivity(intent);
			}
		});

	}

	class CategoryLoadDBAsyncTask extends AsyncTask<Void, Void, Void> {

		private ProgressDialog	dialog	= null;

		@Override
		protected Void doInBackground(Void... params) {
			if (model != null) {
				model.loadData();
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(view.getActivity(), view.getActivity().getResources().getString(R.string.category_dialog_loading_title),
					view.getActivity().getResources().getString(R.string.category_dialog_loading_message));
		}

		@Override
		protected void onPostExecute(Void result) {

			view.fillToListView(model.getCategories());
			dialog.dismiss();
		}
	}

	public void reloadByLanguage(MenuItem item) {
		if (item != null && item.getItemId() == R.id.lang_en && !HoaLuCraftApp.getInstance().getLanguage().equals(HoaLuCraftApp.LANG_EN)) {
			HoaLuCraftApp.getInstance().setLanguage(HoaLuCraftApp.LANG_EN);

			Intent refresh = new Intent(view.getActivity(), MainActivity.class);
			view.getActivity().finish();
			view.getActivity().startActivity(refresh);
		} else if (item != null && item.getItemId() == R.id.lang_vi && !HoaLuCraftApp.getInstance().getLanguage().equals(HoaLuCraftApp.LANG_VI)) {
			HoaLuCraftApp.getInstance().setLanguage(HoaLuCraftApp.LANG_VI);
			Intent refresh = new Intent(view.getActivity(), MainActivity.class);

			view.getActivity().finish();
			view.getActivity().startActivity(refresh);
		}
	}

}
