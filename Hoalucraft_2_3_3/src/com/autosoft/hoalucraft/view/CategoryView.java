package com.autosoft.hoalucraft.view;

import java.util.List;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.autosoft.hoalucraft.activity.MainActivity;
import com.autosoft.hoalucraft.activity.R;
import com.autosoft.hoalucraft.model.Category;

public class CategoryView {
	private MainActivity	activity;
	private ListView		categoryListView;

	public CategoryView(MainActivity activity) {
		super();
		this.activity = activity;
		categoryListView = (ListView) this.activity.findViewById(R.id.listCategory);
	}

	public void fillToListView(List<Category> categories) {
		if (categoryListView != null) {
			ArrayAdapter<Category> adapter = new ArrayAdapter<Category>(categoryListView.getContext(), android.R.layout.simple_list_item_1);

			if (categories != null && categories.size() > 0) {
				for (Category category : categories) {
					adapter.add(category);
				}
				categoryListView.setAdapter(adapter);
			} else {
				categoryListView.setAdapter(null);
			}
		}
	}

	public void setOnListViewClickAction(AdapterView.OnItemClickListener onItemClickListener) {
		if (categoryListView != null) {
			categoryListView.setOnItemClickListener(onItemClickListener);
		}
	}

	public MainActivity getActivity() {
		return activity;
	}

}
