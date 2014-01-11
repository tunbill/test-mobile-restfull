package com.autosoft.hoalucraft.model;

public class Category {
	private long	categoryId;
	private String	name;
	private String	type;
	private String	lang;
	private String	image;
	private String	banner;
	private String	url;
	private String	slug;
	private int		discount;
	private String	promotion;
	private String	link;
	private String	description;
	private String	metaTitle;
	private String	metaKeyword;
	private String	metaDescription;
	private long	parentId;
	private int		lft;
	private int		rght;
	private int		status;

	public Category() {
		super();
	}

	public Category(long categoryId, String name, String type, String lang, String image, String banner, String url, String slug, int discount,
			String promotion, String link, String description, String metaTitle, String metaKeyword, String metaDescription, long parentId, int lft,
			int rght, int status) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.type = type;
		this.lang = lang;
		this.image = image;
		this.banner = banner;
		this.url = url;
		this.slug = slug;
		this.discount = discount;
		this.promotion = promotion;
		this.link = link;
		this.description = description;
		this.metaTitle = metaTitle;
		this.metaKeyword = metaKeyword;
		this.metaDescription = metaDescription;
		this.parentId = parentId;
		this.lft = lft;
		this.rght = rght;
		this.status = status;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long catagoryId) {
		this.categoryId = catagoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getLft() {
		return lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getRght() {
		return rght;
	}

	public void setRght(int rght) {
		this.rght = rght;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return getName();
	}
}
