package com.args.sigi.object;

public class User {
	
	private Long id;
	private String name;
	private String lastName;
	private String login;
	private String password;
	private String email;
	private Boolean Isactive;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsactive() {
		return Isactive;
	}
	public void setIsactive(Boolean isactive) {
		Isactive = isactive;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName
				+ ", login=" + login + ", password=" + password + ", email="
				+ email + ", Isactive=" + Isactive + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getLastName()="
				+ getLastName() + ", getLogin()=" + getLogin()
				+ ", getPassword()=" + getPassword() + ", getEmail()="
				+ getEmail() + ", getIsactive()=" + getIsactive()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
