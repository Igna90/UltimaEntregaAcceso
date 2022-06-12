package com.TrabajoFinal.IgnaShop.model;

import java.util.Date;

public class TransactionModel {
	
	private int id;
	private int buyerUser_id;
	private int sellerUser_id;
	private Date dateBuy;
	private int cart_id;
	
	
	public TransactionModel() {
		super();
	}

	public TransactionModel(int id, int buyerUser_id, int sellerUser_id, int cart_id, Date dateBuy) {
		super();
		this.id = id;
		this.buyerUser_id = buyerUser_id;
		this.sellerUser_id = sellerUser_id;
		this.dateBuy = dateBuy;
		this.cart_id = cart_id;

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
	public int getSellerUser_id() {
		return sellerUser_id;
	}
	public void setSellerUser_id(int sellerUser_id) {
		this.sellerUser_id = sellerUser_id;
	}
	public Date getDateBuy() {
		return dateBuy;
	}
	public void setDateBuy(Date dateBuy) {
		this.dateBuy = dateBuy;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	@Override
	public String toString() {
		return "TransactionModel [id=" + id + ", buyerUser_id=" + buyerUser_id + ", sellerUser_id=" + sellerUser_id
				+ ", dateBuy=" + dateBuy + ", cart_id=" + cart_id + "]";
	}
	
	
	
	
}
