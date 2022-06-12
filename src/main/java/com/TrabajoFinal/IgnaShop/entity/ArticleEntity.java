package com.TrabajoFinal.IgnaShop.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "article")
public class ArticleEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NotEmpty(message = "Debe introducir un nombre")
	@Size(min = 1, max = 60, message = "El nombre debe tener de 1 a 60 caracteres")
	@Column(name = "name", nullable = false, length = 60)
	private String name;
	@NotEmpty(message = "Debe introducir una descripcion")
	@Size(min = 1, max = 240, message = "La descripcion debe tener de 1 a 240 caracteres")
	@Column(name = "description", nullable = false, length = 240)
	private String description;

//	@NotEmpty(message = "Debe introducir un código")
	@Column(name = "code", nullable = false)
	private int code;

	@Column(name = "price")
	@NotNull
	private float price;
	
	@Column(name = "stock")
	public int stock;

	@Column(name = "image", nullable = false)
	private String image;
	
	@Column(name = "registerDate", updatable = false)
	private Date registerDate;

	@ManyToOne
	@JoinColumn(name = "usersId")
	private UsersEntity usersId;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private CategoryEntity categoryId;

	public ArticleEntity() {
		super();
	}

	public ArticleEntity(int id, String name, String description, float price, String image, UsersEntity usersId,
			CategoryEntity categoryId, int code, Date registerDate, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.usersId = usersId;
		this.categoryId = categoryId;
		this.registerDate = registerDate;
		this.stock = stock;

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public UsersEntity getUsersId() {
		return usersId;
	}

	public void setUsersId(UsersEntity usersId) {
		this.usersId = usersId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryEntity categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ArticleModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", categoryId=" + categoryId + "]";
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public boolean noStock() {
		return this.stock<= 0;
	}
	
	public void increaseStock(int quantity) {
		this.stock += quantity;
	}
	public void reduceStock(int quantity) {
		this.stock-= quantity;
	}

}
