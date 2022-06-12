package com.TrabajoFinal.IgnaShop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "comments")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotEmpty(message = "Debe introducir un texto")
	@Size(min = 1, max = 1024, message = "El texto debe tener de 1 a 1024 caracteres")
	@Column(name = "text", nullable = false, length = 1024)
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "authorId")
	private UsersEntity authorId;
	
	@ManyToOne
	@JoinColumn(name = "receiverId")
	private UsersEntity receiverId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "registerDate")
	public Date registerDate;
	
	private int stars;
	
	
	public CommentEntity() {
		super();
	}
	
	
	public CommentEntity(int id, String text, UsersEntity authorId,
			UsersEntity receiverId, Date registerDate, int stars) {
		super();
		this.id = id;
		this.text = text;
		this.authorId = authorId;
		this.receiverId = receiverId;
		this.registerDate = registerDate;
		this.stars = stars;
		
		

	}

	

	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
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

	public UsersEntity getAuthorId() {
		return authorId;
	}

	public void setAuthorId(UsersEntity authorId) {
		this.authorId = authorId;
	}

	public UsersEntity getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(UsersEntity receiverId) {
		this.receiverId = receiverId;
	}


	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", text=" + text + ", authorId=" + authorId + ", receiverId=" + receiverId
				+ ", registerDate=" + registerDate + ", stars=" + stars + "]";
	}


	public int getStars() {
		return stars;
	}


	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	
}
