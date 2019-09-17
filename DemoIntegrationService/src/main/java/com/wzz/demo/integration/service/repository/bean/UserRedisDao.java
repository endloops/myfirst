package com.wzz.demo.integration.service.repository.bean;

import java.io.Serializable;

public class UserRedisDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2576763984332387525L;

	
	private String username;
	
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserRedisDao [username=" + username + ", age=" + age + "]";
	}

	public UserRedisDao(String username, Integer age) {
		super();
		this.username = username;
		this.age = age;
	}
}
