package com.TrabajoFinal.IgnaShop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class UsersModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private String dni;
	private String name;
	private String surname;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Date registerDate;
	private String phone;
	private String email;
	private String password;
	private String passwordConfirm;
	private double balance;
	private boolean enabled;

	public UsersModel() {
		super();
	}

	public UsersModel(int id, String dni, String name, String surname, Date birthday, Date registerDate, String phone,
			String email, String password, String passwordConfirm, double balance, Boolean enabled) {
		super();
		this.id = id;
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.registerDate = registerDate;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.balance = balance;
		this.enabled = enabled;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UsuariosModel [id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday
				+ ", registerDate=" + registerDate + ",   phone=" + phone + ", email=" + email + ", password="
				+ password + ", passwordConfirm=" + passwordConfirm + ", balance=" + balance + ", enabled=" + enabled
				+ "]";
	}

}