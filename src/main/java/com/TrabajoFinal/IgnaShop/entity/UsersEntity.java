package com.TrabajoFinal.IgnaShop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
public class UsersEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NotEmpty(message = "Debe introducir un dni")
	@Size(min = 1, max = 9, message = "El dni debe tener de 1 a 9 caracteres")
	@Column(name = "dni", nullable = false, length = 9)
	private String dni;

	@Pattern(regexp = "^\\D{1,40}$", message = "No puede contener números")
	@NotEmpty(message = "Debe introducir un nombre")
	@Size(min = 1, max = 40, message = "El nombre debe tener de 1 a 40 caracteres")
	@Column(name = "name", nullable = false, length = 40)
	private String name;

	@Pattern(regexp = "^\\D{1,90}$", message = "El apellido no puede contener números, también debe empezar en mayúscula y seguir todo en minúsculas")
	@NotEmpty(message = "Debe introducir un apellido")
	@Size(min = 1, max = 90, message = "El apellido debe tener de 1 a 90 caracteres")
	@Column(name = "surname", nullable = false, length = 90)
	private String surname;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birthday", length = 10)
	private Date birthday;

	@Column(name = "registerDate", updatable = false)
	private Date registerDate;

	@Column(name = "phone", length = 10)
	@NotNull
	@NotEmpty(message = "El campo teléfono no puede ir vacío")
	@Size(min = 3, max = 10, message = "El campo teléfono debe tener entre 3 y 60 caracteres")
	private String phone;

	@Email
	@NotNull
	@NotEmpty(message = "Debe introducir un email")
	@Size(min = 1, max = 50, message = "El email debe tener de 1 a 60 caracteres")
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	
	@Column(name = "password", length = 60)
	private String password;

	
	@Column(name = "passwordConfirm", length = 60)
	private String passwordConfirm;

	@Column(name = "balance")
	private double balance;

	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "NumVentas")
	private int numVentas;

	
	public UsersEntity() {
		super();
	}

	public UsersEntity(int id,
			@Pattern(regexp = "^\\D{1,40}$", message = "No puede contener números") @NotEmpty(message = "Debe introducir un nombre") @Size(min = 1, max = 40, message = "El nombre debe tener de 1 a 40 caracteres") String name,
			@Pattern(regexp = "^\\D{1,60}$", message = "El apellido no puede contener números, también debe empezar en mayúscula y seguir todo en minúsculas") @NotEmpty(message = "Debe introducir un apellido") @Size(min = 1, max = 60, message = "El apellido debe tener de 1 a 60 caracteres") String surname,
			boolean enabled, double balance, Date registerDate, Date birthday,
			@NotNull @NotEmpty(message = "El campo teléfono no puede ir vacío") @Size(min = 3, max = 10, message = "El campo teléfono debe tener entre 3 y 60 caracteres") String phone,
			@Email @NotNull @NotEmpty(message = "Debe introducir un email") @Size(min = 1, max = 50, message = "El email debe tener de 1 a 60 caracteres") String email,
			String password, String passwordConfirm, int numVentas) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.enabled = enabled;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.passwordConfirm = passwordConfirm;
		this.birthday = birthday;
		this.registerDate = registerDate;
		this.numVentas = numVentas;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public int getNumVentas() {
		return numVentas;
	}

	public void setNumVentas(int numVentas) {
		this.numVentas = numVentas;
	}

	@Override
	public String toString() {
		return "UsersEntity [id=" + id + ", dni=" + dni + ", name=" + name + ", surname=" + surname + ", birthday="
				+ birthday + ", registerDate=" + registerDate + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", passwordConfirm=" + passwordConfirm + ", balance=" + balance + ", enabled=" + enabled
				+ ", numVentas=" + numVentas + ", getId()=" + getId() + ", getDni()=" + getDni() + ", getName()="
				+ getName() + ", getSurname()=" + getSurname() + ", getBirthday()=" + getBirthday()
				+ ", getRegisterDate()=" + getRegisterDate() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getPasswordConfirm()=" + getPasswordConfirm()
				+ ", getBalance()=" + getBalance() + ", isEnabled()=" + isEnabled() + ", getNumVentas()="
				+ getNumVentas() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
}


