package com.TrabajoFinal.IgnaShop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name="category")
public class CategoryEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@NotEmpty(message = "Debe introducir un nombre")
	@Size(min = 1, max = 60, message = "El nombre debe tener de 1 a 60 caracteres")
	@Column(name = "name", nullable = false, length = 60)
	private String name;
	
	
	

	public CategoryEntity() {
		super();
	}

	public CategoryEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;

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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
