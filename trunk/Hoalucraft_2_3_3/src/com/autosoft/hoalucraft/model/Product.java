package com.autosoft.hoalucraft.model;

import android.graphics.drawable.Drawable;

public class Product {
	private long	productId;
	private long	categoryId;
	private long	productMaketId;
	private long	userId;
	private String	name;
	private String	lang;
	private String	sku;
	private String	model;
	private String	imageURL;
	private int		quantity;
	private double	price;
	private String	unit;
	private double	discount;
	private String	discountUnit;
	private String	promotion;
	private int		varranty;
	private String	summary;
	private String	description;
	private String	tab1;
	private String	tab2;
	private String	tab3;
	private String	slug;
	private String	tag;
	private String	tagEncode;
	private String	metaTitle;
	private String	metaKeyword;
	private String	metaDescription;
	private int		view;
	private int		voteCount;
	private int		voteStar;
	private String	file;
	private int		created;
	private int		modifired;
	private int		status;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, long categoryId, long productMaketId, long userId, String name, String lang, String sku, String model,
			String imageURL, int quantity, double price, String unit, double discount, String discountUnit, String promotion, int varranty,
			String summary, String description, String tab1, String tab2, String tab3, String slug, String tag, String tagEncode, String metaTitle,
			String metaKeyword, String metaDescription, int view, int voteCount, int voteStar, String file, int created, int modifired, int status) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productMaketId = productMaketId;
		this.userId = userId;
		this.name = name;
		this.lang = lang;
		this.sku = sku;
		this.model = model;
		this.imageURL = imageURL;
		this.quantity = quantity;
		this.price = price;
		this.unit = unit;
		this.discount = discount;
		this.discountUnit = discountUnit;
		this.promotion = promotion;
		this.varranty = varranty;
		this.summary = summary;
		this.description = description;
		this.tab1 = tab1;
		this.tab2 = tab2;
		this.tab3 = tab3;
		this.slug = slug;
		this.tag = tag;
		this.tagEncode = tagEncode;
		this.metaTitle = metaTitle;
		this.metaKeyword = metaKeyword;
		this.metaDescription = metaDescription;
		this.view = view;
		this.voteCount = voteCount;
		this.voteStar = voteStar;
		this.file = file;
		this.created = created;
		this.modifired = modifired;
		this.status = status;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getProductMaketId() {
		return productMaketId;
	}

	public void setProductMaketId(long productMaketId) {
		this.productMaketId = productMaketId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDiscountUnit() {
		return discountUnit;
	}

	public void setDiscountUnit(String discountUnit) {
		this.discountUnit = discountUnit;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public int getVarranty() {
		return varranty;
	}

	public void setVarranty(int varranty) {
		this.varranty = varranty;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTab1() {
		return tab1;
	}

	public void setTab1(String tab1) {
		this.tab1 = tab1;
	}

	public String getTab2() {
		return tab2;
	}

	public void setTab2(String tab2) {
		this.tab2 = tab2;
	}

	public String getTab3() {
		return tab3;
	}

	public void setTab3(String tab3) {
		this.tab3 = tab3;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTagEncode() {
		return tagEncode;
	}

	public void setTagEncode(String tagEncode) {
		this.tagEncode = tagEncode;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public int getVoteStar() {
		return voteStar;
	}

	public void setVoteStar(int voteStar) {
		this.voteStar = voteStar;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getCreated() {
		return created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public int getModifired() {
		return modifired;
	}

	public void setModifired(int modifired) {
		this.modifired = modifired;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return name;
	}
}
