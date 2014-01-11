package com.autosoft.hoalucraft.view;

import java.util.List;

import android.util.Log;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.autosoft.hoalucraft.activity.ProductListActivity;
import com.autosoft.hoalucraft.activity.R;
import com.autosoft.hoalucraft.activity.custom.CustomAdapter;
import com.autosoft.hoalucraft.activity.custom.CustomProductListView;
import com.autosoft.hoalucraft.model.Product;

public class ProductListView {
	private ProductListActivity	activity;
	private ProgressBar			loading;

	public ProductListView(ProductListActivity activity) {
		super();
		this.activity = activity;

		CustomProductListView productListView = (CustomProductListView) activity.findViewById(R.id.product_custom_list_view);
		if (productListView != null) {
			loading = new ProgressBar(activity);
			productListView.addFooterView(loading);
		}
	}

	public void fillToListView(List<Product> products) {
		if (activity != null && activity.findViewById(R.id.product_custom_list_view) != null) {
			CustomProductListView productListView = (CustomProductListView) activity.findViewById(R.id.product_custom_list_view);
			CustomAdapter adapter = new CustomAdapter(activity, android.R.layout.simple_list_item_1);

			if (products != null && products.size() > 0) {

				Adapter adap = productListView.getAdapter();
				int lastSizeOfListView = adap != null ? adap.getCount() : 0;
				for (Product product : products) {
					adapter.add(product);
				}
				productListView.setAdapter(adapter);

				if (productListView.getAdapter() != null && lastSizeOfListView < productListView.getAdapter().getCount()) {
					productListView.smoothScrollToPosition(lastSizeOfListView);

					Log.i("lastSizeOfListView", String.valueOf(lastSizeOfListView));
				}
			} else {
				productListView.setAdapter(null);
			}
		}
	}

	public void addToListView(List<Product> products) {
		if (activity != null && activity.findViewById(R.id.product_custom_list_view) != null) {
			CustomProductListView productListView = (CustomProductListView) activity.findViewById(R.id.product_custom_list_view);

			CustomAdapter adapter = (CustomAdapter) ((HeaderViewListAdapter) productListView.getAdapter()).getWrappedAdapter();

			if (products != null && products.size() > 0) {
				for (Product product : products) {
					adapter.add(product);
				}

				adapter.notifyDataSetChanged();
			}
		}
	}

	public void setLoadMoreAction(AbsListView.OnScrollListener onScrollListener) {
		((ListView) activity.findViewById(R.id.product_custom_list_view)).setOnScrollListener(onScrollListener);
	}

	public ProductListActivity getActivity() {
		return activity;
	}

	public void setLoadingVisiable(boolean isShow) {
		CustomProductListView productListView = (CustomProductListView) activity.findViewById(R.id.product_custom_list_view);

		if (isShow == false)
			productListView.removeFooterView(loading);
		else if (productListView.getFooterViewsCount() == 0)
			productListView.addFooterView(loading);
	}

	public void setOnItemClickListener(OnItemClickListener itemClickListener) {
		CustomProductListView productListView = (CustomProductListView) activity.findViewById(R.id.product_custom_list_view);

		productListView.setOnItemClickListener(itemClickListener);
	}
}
