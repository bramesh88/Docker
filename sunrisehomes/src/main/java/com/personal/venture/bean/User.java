package com.personal.venture.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All details about the student. ")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	//@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	private String desc;

	public User() {
		super();
	}

	public User(String name, String desc) {
		this.name = name;
		this.desc = desc;

	}

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
