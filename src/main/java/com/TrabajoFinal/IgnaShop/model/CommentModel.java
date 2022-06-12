package com.TrabajoFinal.IgnaShop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class CommentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	private String text;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerDate;

	private int AuthorId;
	private int receiverId;
	
	private float stars;

	public CommentModel() {
		super();
	}

	public CommentModel(int id, String text, int receiverId, int AuthorId, Date registerDate, float stars) {
		super();
		this.id = id;
		this.text = text;
		this.receiverId = receiverId;
		this.AuthorId = AuthorId;
		this.registerDate = registerDate;
		this.stars = stars;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	@Override
	public String toString() {
		return "CommentModel [id=" + id + ", text=" + text + ", registerDate=" + registerDate + ", AuthorId=" + AuthorId
				+ ", receiverId=" + receiverId + ", stars=" + stars + "]";
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}
	
	

}
