package com.autosoft.hoalucraft.activity.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class CustomProductListView extends ListView {
	private boolean	isLoading	= false;

	public CustomProductListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CustomProductListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomProductListView(Context context) {
		super(context);
	}

	public boolean isLoading() {
		return isLoading;
	}

	public void setLoading(boolean isLoading) {
		this.isLoading = isLoading;
	}
}
