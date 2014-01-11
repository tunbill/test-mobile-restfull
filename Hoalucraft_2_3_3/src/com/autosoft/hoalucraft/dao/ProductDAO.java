package com.autosoft.hoalucraft.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.util.Log;

import com.autosoft.hoalucraft.HoaLuCraftApp;
import com.autosoft.hoalucraft.model.Product;

@SuppressLint("DefaultLocale")
public class ProductDAO {

	public static final String	PRODUCT				= "product";
	public static final String	PRODUCT_ID			= "id";
	public static final String	CATEGORY_ID			= "product_category_id";
	public static final String	PRODUCT_MAKER_ID	= "product_maker_id";
	public static final String	USER_ID				= "user_id";
	public static final String	NAME				= "name";
	public static final String	LANG				= "lang";
	public static final String	SKU					= "sku";
	public static final String	MODEL				= "model";
	public static final String	IMAGE_URL			= "image";
	public static final String	QUANTITY			= "quantity";
	public static final String	PRICE				= "price";
	public static final String	UNIT				= "unit";
	public static final String	DISCOUNT			= "discount";
	public static final String	DISCOUNT_UNIT		= "discount_unit";
	public static final String	PROMOTION			= "promotion";
	public static final String	WARRANTY			= "warranty";
	public static final String	SUMMARY				= "summary";
	public static final String	DESCRIPTION			= "description";
	public static final String	TAB1				= "tab1";
	public static final String	TAB2				= "tab2";
	public static final String	TAB3				= "tab3";
	public static final String	SLUG				= "slug";
	public static final String	TAG					= "tag";
	public static final String	TAG_ENCODE			= "tag_encode";
	public static final String	META_TITLE			= "meta_title";
	public static final String	META_KEYWORD		= "meta_keyword";
	public static final String	META_DESCRIPTION	= "meta_description";
	public static final String	VIEW				= "view";
	public static final String	VOTE_COUNTER		= "vote_counter";
	public static final String	VOTE_STAR			= "vote_star";
	public static final String	FILE				= "file";
	public static final String	CREATED				= "created";
	public static final String	MODIFIRED			= "modifired";
	public static final String	STATUS				= "status";

	public static final String	COUNT				= "count";

	@SuppressWarnings("finally")
	public static List<Product> getByCategoryId(long categoryId, int start, int count) {
		String url = HoaLuCraftApp.ROOT_SERVICES + "/product/products/" + categoryId + "/" + HoaLuCraftApp.getInstance().getLanguage() + "/" + start
				+ "/" + count;

		JSONParser jParser = new JSONParser();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);

		if (json != null) {
			List<Product> products = new ArrayList<Product>();
			try {
				JSONArray arrayCategories = json.getJSONArray(PRODUCT);
				if (arrayCategories != null && arrayCategories.length() > 0) {
					for (int i = 0; i < arrayCategories.length(); i++) {
						JSONObject object = arrayCategories.getJSONObject(i);

						if (object != null) {
							products.add(convertJSONObject(object));
						}
					}

					return products;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			} finally {
				return products;
			}
		}
		return null;
	}

	@SuppressWarnings("finally")
	public static Product getById(long productId) {
		String url = HoaLuCraftApp.ROOT_SERVICES + "/product/product/" + productId + "/" + HoaLuCraftApp.getInstance().getLanguage();

		JSONParser jParser = new JSONParser();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);
		if (json != null) {
			Product product = null;
			boolean isNotExceptionOccur = false;
			try {
				JSONArray arrayCategories = json.getJSONArray(PRODUCT);
				if (arrayCategories != null && arrayCategories.length() > 0) {
					JSONObject object = arrayCategories.getJSONObject(0);
					if (object != null) {
						product = convertJSONObject(object);
						isNotExceptionOccur = true;
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			} finally {
				return isNotExceptionOccur ? product : null;
			}
		}
		return null;
	}

	public static int count(long categoryId) {
		String url = HoaLuCraftApp.ROOT_SERVICES + "/product/count/" + categoryId + "/" + HoaLuCraftApp.getInstance().getLanguage();

		JSONParser jParser = new JSONParser();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);

		if (json != null) {
			try {
				return json.getInt(COUNT);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@SuppressWarnings("finally")
	private static Product convertJSONObject(JSONObject object) {
		boolean isSuccessConverted = false;
		Product product = new Product();
		if (object != null) {
			try {
				String str = null;

				str = object.getString(CATEGORY_ID);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setCategoryId(Long.parseLong(str));
				} else {
					product.setCategoryId(0);
				}

				str = object.getString(CREATED);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setCreated(Integer.parseInt(str));
				} else {
					product.setCreated(0);
				}

				str = object.getString(DESCRIPTION);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setDescription(str);
				} else {
					product.setDescription(null);
				}

				str = object.getString(DISCOUNT);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setDiscount(Double.parseDouble(str));
				} else {
					product.setDiscount(0D);
				}

				str = object.getString(DISCOUNT_UNIT);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setDiscountUnit(str);
				} else {
					product.setDiscountUnit(null);
				}

				str = object.getString(FILE);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setFile(str);
				} else {
					product.setFile(null);
				}

				str = object.getString(IMAGE_URL);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setImageURL(str);
				} else {
					product.setImageURL(null);
				}

				str = object.getString(LANG);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setLang(str);
				} else {
					product.setLang(HoaLuCraftApp.LANG_EN);
				}

				str = object.getString(META_DESCRIPTION);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setMetaDescription(str);
				} else {
					product.setMetaDescription(null);
				}

				str = object.getString(META_KEYWORD);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setMetaKeyword(str);
				} else {
					product.setMetaKeyword(null);
				}

				str = object.getString(META_TITLE);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setMetaTitle(str);
				} else {
					product.setMetaTitle(null);
				}

				str = object.getString(MODEL);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setModel(str);
				} else {
					product.setModel(null);
				}

				str = object.getString(MODIFIRED);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setModifired(Integer.parseInt(str));
				} else {
					product.setModifired(0);
				}

				str = object.getString(NAME);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setName(str);
				} else {
					product.setName(null);
				}

				str = object.getString(PRICE);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setPrice(Double.parseDouble(str));
				} else {
					product.setPrice(0D);
				}

				str = object.getString(PRODUCT_ID);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setProductId(Long.parseLong(str));
				} else {
					product.setProductId(0);
				}

				str = object.getString(PRODUCT_MAKER_ID);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setProductMaketId(Long.parseLong(str));
				} else {
					product.setProductMaketId(0);
				}

				str = object.getString(PROMOTION);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setPromotion(str);
				} else {
					product.setPromotion(null);
				}

				str = object.getString(QUANTITY);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setQuantity(Integer.parseInt(str));
				} else {
					product.setQuantity(0);
				}

				str = object.getString(SKU);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setSku(str);
				} else {
					product.setSku(null);
				}

				str = object.getString(SLUG);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setSlug(str);
				} else {
					product.setSlug(null);
				}

				str = object.getString(STATUS);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setStatus(Integer.parseInt(str));
				} else {
					product.setStatus(0);
				}

				str = object.getString(SUMMARY);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setSummary(str);
				} else {
					product.setSummary(null);
				}

				str = object.getString(TAB1);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setTab1(str);
				} else {
					product.setTab1(null);
				}

				str = object.getString(TAB2);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setTab2(str);
				} else {
					product.setTab2(null);
				}

				str = object.getString(TAB3);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setTab3(str);
				} else {
					product.setTab3(null);
				}

				str = object.getString(TAG);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setTag(str);
				} else {
					product.setTag(null);
				}

				str = object.getString(TAG_ENCODE);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setTagEncode(str);
				} else {
					product.setTagEncode(null);
				}

				str = object.getString(UNIT);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setUnit(str);
				} else {
					product.setUnit(null);
				}

				str = object.getString(USER_ID);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setUserId(Long.parseLong(str));
				} else {
					product.setUserId(0);
				}

				str = object.getString(WARRANTY);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setVarranty(Integer.parseInt(str));
				} else {
					product.setVarranty(0);
				}

				str = object.getString(VIEW);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setView(Integer.parseInt(str));
				} else {
					product.setView(0);
				}

				str = object.getString(VOTE_COUNTER);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setVoteCount(Integer.parseInt(str));
				} else {
					product.setVoteCount(0);
				}

				str = object.getString(VOTE_STAR);
				if (str != null && !(str.trim().toLowerCase()).startsWith("null")) {
					product.setVoteStar(Integer.parseInt(str));
				} else {
					product.setVoteStar(0);
				}

				isSuccessConverted = true;
			} catch (JSONException e) {
				e.printStackTrace();
			} finally {
				return isSuccessConverted ? product : null;
			}
		}
		return null;
	}
}
