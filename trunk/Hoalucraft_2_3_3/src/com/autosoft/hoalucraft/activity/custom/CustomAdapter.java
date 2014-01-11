package com.autosoft.hoalucraft.activity.custom;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.activity.R;
import com.autosoft.hoalucraft.model.Product;
import com.autosoft.hoalucraft.util.ImageLoader;

public class CustomAdapter extends ArrayAdapter<Product> {
	private Activity		activity;
	private List<Product>	products;
	private ImageLoader		imageLoader;

	public CustomAdapter(Activity context, int resource) {
		super(context, R.layout.list_demo);
		this.activity = context;
		products = new ArrayList<Product>();
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	@Override
	public void add(Product object) {
		if (products == null)
			products = new ArrayList<Product>();
		products.add(object);
	}

	@Override
	public int getCount() {
		return products != null ? products.size() : 0;
	}

	@Override
	public Product getItem(int position) {
		return products != null && products.size() > 0 && position < products.size() ? products.get(position) : null;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(activity);
		View rowView = inflater.inflate(R.layout.list_demo, null, false);

		TextView productNameTextView = (TextView) rowView.findViewById(R.id.product_item_name);
		ImageView productImageView = (ImageView) rowView.findViewById(R.id.product_item_image);
		TextView productDescriptionTextView = (TextView) rowView.findViewById(R.id.product_item_description);
		TextView productPriceTextView = (TextView) rowView.findViewById(R.id.product_item_price);

		Product product = getItem(position);

		if (product != null) {
			productNameTextView.setText(product.getName());
			productDescriptionTextView.setText(product.getDescription() != null ? Html.fromHtml(product.getDescription()) : "");
			productPriceTextView.setText(String.valueOf(product.getPrice()));

			// productImageView.setImageDrawable(product.getImage() != null ?
			// product.getImage() :
			// activity.getResources().getDrawable(R.drawable.logo));

			imageLoader.DisplayImage(HoaLuCraftApp.ROOT_IMAGES + "/products/" + product.getImageURL(), productImageView);
		}
		return rowView;
	}

}
