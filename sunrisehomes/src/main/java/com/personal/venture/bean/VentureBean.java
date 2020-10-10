package com.personal.venture.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VentureBean {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String lpNumber;

	private String layoutNumber;

	private String layoutPicture;

	private String addess;

	private String phoneNumber;

	private String emailid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLpNumber() {
		return lpNumber;
	}

	public void setLpNumber(String lpNumber) {
		this.lpNumber = lpNumber;
	}

	public String getLayoutNumber() {
		return layoutNumber;
	}

	public void setLayoutNumber(String layoutNumber) {
		this.layoutNumber = layoutNumber;
	}

	public String getLayoutPicture() {
		return layoutPicture;
	}

	public void setLayoutPicture(String layoutPicture) {
		this.layoutPicture = layoutPicture;
	}

	public String getAddess() {
		return addess;
	}

	public void setAddess(String addess) {
		this.addess = addess;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
