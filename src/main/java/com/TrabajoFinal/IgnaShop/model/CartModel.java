package com.TrabajoFinal.IgnaShop.model;

public class CartModel {

	private int id;
	private int buyerUser_id;
	private int article_id;

	public CartModel(int id, int buyerUser_id, int article_id) {
		super();
		this.id = id;
		this.buyerUser_id = buyerUser_id;
		this.article_id = article_id;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuyerUser_id() {
		return buyerUser_id;
	}

	public void setBuyerUser_id(int buyerUser_id) {
		this.buyerUser_id = buyerUser_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	@Override
	public String toString() {
		return "CartModel [id=" + id + ", buyerUser_id=" + buyerUser_id + ", article_id=" + article_id + "]";
	}

}
