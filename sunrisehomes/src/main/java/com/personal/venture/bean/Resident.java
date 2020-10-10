package com.personal.venture.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Resident {

	@Id
	@GeneratedValue
	private Integer Id;

	private String title;

	private String desc;

	private String firstName;

	private String lastName;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "residentDetails_id",referencedColumnName = "Id")
	private ResidentDetails residentDetails_id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public ResidentDetails getResidentDetails_id() {
		return residentDetails_id;
	}

	public void setResidentDetails_id(ResidentDetails residentDetails_id) {
		this.residentDetails_id = residentDetails_id;
	}

}
