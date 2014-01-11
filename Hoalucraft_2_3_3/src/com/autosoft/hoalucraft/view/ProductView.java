package com.autosoft.hoalucraft.view;

import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.activity.ProductActivity;
import com.autosoft.hoalucraft.activity.R;
import com.autosoft.hoalucraft.model.Product;
import com.autosoft.hoalucraft.util.ImageLoader;

public class ProductView {
	private ProductActivity	activity;
	private ImageLoader		imageLoader;

	public ProductView(ProductActivity activity) {
		super();
		this.activity = activity;
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	public void fillProductToView(Product product) {
		if (product != null) {
			TextView nameTextView = (TextView) activity.findViewById(R.id.product_name_view);
			if (nameTextView != null) {
				nameTextView.setText(product.getName());
			}

			ImageView imageView = (ImageView) activity.findViewById(R.id.product_image_view);
			if (imageView != null) {
				imageLoader.DisplayImage(HoaLuCraftApp.ROOT_IMAGES + "/products/" + product.getImageURL(), imageView);
			}

			TextView priceView = (TextView) activity.findViewById(R.id.product_price_view);
			if (priceView != null) {
				priceView.setText("Gia: " + String.valueOf(product.getPrice()));
			}

			RatingBar ratingBar = (RatingBar) activity.findViewById(R.id.product_rating_view);
			if (ratingBar != null) {
				Log.i("product.getVoteStar():", String.valueOf(product.getVoteStar()));
				ratingBar.setRating(product.getVoteStar());
			}

			TextView descriptionView = (TextView) activity.findViewById(R.id.product_description_view);
			if (descriptionView != null) {
				if (product.getDescription() != null)
					descriptionView.setText(Html.fromHtml(product.getDescription()));
			}
		}
	}
}
