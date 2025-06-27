package com.cmh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Entity //聲明為實體類, ORM映射對象
@Table(name = "user") // 資料表名稱
public class User {
	@Id // 聲明為主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動產生流水號
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private int gender;
	@Column(name="permissions")
	private int permissions;
	@Column(name="phone")
	private String phone;
	@Column(name="status")
	private int status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getPermissions() {
		return permissions;
	}
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}