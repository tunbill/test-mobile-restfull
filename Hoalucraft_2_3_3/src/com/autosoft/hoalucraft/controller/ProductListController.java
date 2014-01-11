package com.autosoft.hoalucraft.controller;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.activity.ProductActivity;
import com.autosoft.hoalucraft.dao.CategoryDao;
import com.autosoft.hoalucraft.model.Product;
import com.autosoft.hoalucraft.model.ProductListModel;
import com.autosoft.hoalucraft.view.ProductListView;

public class ProductListController {
	private ProductListModel	model;
	private ProductListView		view;
	private long				categoryId;
	private boolean				isLoading	= false;

	public ProductListController(ProductListView view, long categoryId) {
		super();
		this.view = view;
		this.categoryId = categoryId;

		if (isLoading == false)
			new ProductLoadDBAsyncTask().execute();

		this.view.setLoadMoreAction(new AbsListView.OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView listView, int scrollState) {
			}

			@Override
			public void onScroll(AbsListView listView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					if (model != null) {
						if (model.hasNext()) {
							if (isLoading == false)
								new ProductNextDBAsyncTask().execute();
						}
					}
				}
			}
		});

		this.view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Product product = (Product) parent.getItemAtPosition(position);

				if (product != null) {
					Intent intent = new Intent(ProductListController.this.view.getActivity(), ProductActivity.class);

					intent.putExtra("productId", product.getProductId());
					ProductListController.this.view.getActivity().startActivity(intent);
				}
			}
		});
	}

	class ProductLoadDBAsyncTask extends AsyncTask<Void, Void, Void> {

		private ProgressDialog	dialog;
		private boolean			loadingAccept	= false;

		@Override
		protected Void doInBackground(Void... params) {
			if (loadingAccept == true) {
				if (model != null) {
					model.next();
				} else {
					model = new ProductListModel(CategoryDao.getById(categoryId));
				}
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			if (isLoading == false) {
				isLoading = true;
				loadingAccept = true;
				dialog = ProgressDialog.show(view.getActivity(), null, null);
			} else {
				loadingAccept = false;
			}
		}

		@Override
		protected void onPostExecute(Void result) {
			if (model != null) {
				view.fillToListView(model.getProducts());
				ProductListController.this.view.setLoadingVisiable(false);
			}
			if (dialog != null)
				dialog.dismiss();

			loadingAccept = false;
			isLoading = false;
		}
	}

	class ProductNextDBAsyncTask extends AsyncTask<Void, Void, Void> {
		private boolean			loadingAccept	= false;
		private List<Product>	products		= null;

		@Override
		protected Void doInBackground(Void... params) {
			if (loadingAccept == true) {
				if (model != null) {
					products = model.next();
				}
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			if (isLoading == false) {
				isLoading = true;
				loadingAccept = true;
			} else {
				loadingAccept = false;
			}
			ProductListController.this.view.setLoadingVisiable(true);
		}

		@Override
		protected void onPostExecute(Void result) {
			if (model != null && products != null && products.size() > 0) {
				view.addToListView(products);
			}

			loadingAccept = false;
			isLoading = false;
			ProductListController.this.view.setLoadingVisiable(false);
		}
	}
}
