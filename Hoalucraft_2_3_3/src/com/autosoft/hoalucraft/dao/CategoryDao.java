package com.autosoft.hoalucraft.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.annotation.SuppressLint;
import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.model.Category;
import com.autosoft.hoalucraft.model.Product;

@SuppressLint("DefaultLocale")
public class CategoryDao {
	private static final String	CATEGORY			= "category";
	private static final String	CATEGORY_ID			= "id";
	private static final String	NAME				= "name";
	private static final String	TYPE				= "type";
	private static final String	LANG				= "lang";
	private static final String	IMAGE				= "image";
	private static final String	BANNER				= "banner";
	private static final String	URL					= "url";
	private static final String	SLUG				= "slug";
	private static final String	DISCOUNT			= "discount";
	private static final String	PROMOTION			= "promotion";
	private static final String	LINK				= "link";
	private static final String	DESCRIPTION			= "description";
	private static final String	META_TITLE			= "meta_title";
	private static final String	METAKEY_WORD		= "meta_keyword";
	private static final String	META_DESCRIPTION	= "meta_description";
	private static final String	PARENT_ID			= "parent_id";
	private static final String	LFT					= "lft";
	private static final String	RGHT				= "rght";
	private static final String	STATUS				= "status";

	@SuppressWarnings("finally")
	public static List<Category> getByLanguage() {
		String url = HoaLuCraftApp.ROOT_SERVICES + "/category/categories/" + HoaLuCraftApp.getInstance().getLanguage();
		JSONParser jParser = new JSONParser();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);

		List<Category> categories = new ArrayList<Category>();
		try {
			JSONArray arrayCategories = json.getJSONArray(CATEGORY);
			if (arrayCategories != null && arrayCategories.length() > 0) {

				for (int i = 0; i < arrayCategories.length(); i++) {
					JSONObject object = arrayCategories.getJSONObject(i);
					if (object != null) {
						Category category = convertJSONObject(object);

						categories.add(category);
					}
				}
				return categories;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return categories;
		}
	}

	@SuppressWarnings("finally")
	public static List<Category> getByAll() {
		String url = HoaLuCraftApp.ROOT_SERVICES + "/category/categories";
		JSONParser jParser = new JSONParser();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);

		List<Category> categories = new ArrayList<Category>();
		try {
			JSONArray arrayCategories = json.getJSONArray(CATEGORY);
			if (arrayCategories != null && arrayCategories.length() > 0) {

				for (int i = 0; i < arrayCategories.length(); i++) {
					JSONObject object = arrayCategories.getJSONObject(i);
					if (object != null) {
						Category category = convertJSONObject(object);

						categories.add(category);
					}
				}
				return categories;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return categories;
		}
	}

	@SuppressWarnings("finally")
	public static Category getById(long catagoryId) {
		String url = HoaLuCraftApp.ROOT_SERVICES + "/category/category/" + catagoryId;

		JSONParser jParser = new JSONParser();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);
		Category category = null;
		boolean isNotExceptionOccur = false;
		try {
			JSONArray arrayCategories = json.getJSONArray(CATEGORY);
			if (arrayCategories != null && arrayCategories.length() > 0) {

				JSONObject object = arrayCategories.getJSONObject(0);
				if (object != null) {
					category = convertJSONObject(object);
					isNotExceptionOccur = true;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return isNotExceptionOccur ? category : null;
		}
	}

	@SuppressWarnings("finally")
	private static Category convertJSONObject(JSONObject object) {
		boolean isSuccessConverted = false;
		Category category = null;
		if (object != null) {
			category = new Category();
			try {
				String str = null;

				str = object.getString(CATEGORY_ID);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setCategoryId(Long.parseLong(str));
				} else {
					category.setCategoryId(0L);
				}

				str = object.getString(NAME);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setName(str.trim());
				} else {
					category.setName(null);
				}

				str = object.getString(TYPE);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setType(str.trim());
				} else {
					category.setType(null);
				}

				str = object.getString(LANG);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setLang(str.trim());
				} else {
					category.setLang(HoaLuCraftApp.LANG_EN);
				}

				str = object.getString(IMAGE);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setImage(str.trim());
				} else {
					category.setImage(null);
				}

				str = object.getString(BANNER);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setBanner(str.trim());
				} else {
					category.setBanner(null);
				}

				str = object.getString(URL);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setUrl(str.trim());
				} else {
					category.setUrl(null);
				}

				str = object.getString(SLUG);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setSlug(str);
				} else {
					category.setSlug(null);
				}

				str = object.getString(DISCOUNT);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setDiscount(Integer.parseInt(str));
				} else {
					category.setDiscount(0);
				}

				str = object.getString(PROMOTION);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setPromotion(str.trim());
				} else {
					category.setPromotion(null);
				}

				str = object.getString(LINK);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setLink(str.trim());
				} else {
					category.setLink(null);
				}

				str = object.getString(DESCRIPTION);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setDescription(str.trim());
				} else {
					category.setDescription(null);
				}

				str = object.getString(META_TITLE);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setMetaTitle(str.trim());
				} else {
					category.setMetaTitle(null);
				}

				str = object.getString(METAKEY_WORD);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setMetaKeyword(str.trim());
				} else {
					category.setMetaKeyword(null);
				}

				str = object.getString(META_DESCRIPTION);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setMetaDescription(str.trim());
				} else {
					category.setMetaDescription(null);
				}

				str = object.getString(PARENT_ID);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setParentId(Long.parseLong(str.trim()));
				} else {
					category.setParentId(0L);
				}

				str = object.getString(LFT);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setLft(Integer.parseInt(str.trim()));
				} else {
					category.setLft(0);
				}

				str = object.getString(RGHT);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setRght(Integer.parseInt(str.trim()));
				} else {
					category.setRght(0);
				}

				str = object.getString(STATUS);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					category.setStatus(Integer.parseInt(str));
				} else {
					category.setStatus(0);
				}

				isSuccessConverted = true;
			} catch (JSONException e) {
				e.printStackTrace();
			} finally {
				return isSuccessConverted ? category : null;
			}
		}
		return null;
	}
}
