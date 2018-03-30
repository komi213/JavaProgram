package com.study.model;

public class UserT {
    /**
	 * ,所属表字段为user_t.id
	 * @flysky_generated
	 */
	private Integer id;

	/**
	 * ,所属表字段为user_t.password
	 * @flysky_generated
	 */
	private String password;

	/**
	 * ,所属表字段为user_t.age
	 * @flysky_generated
	 */
	private Integer age;

	/**
	 * 获取  字段:user_t.id
	 * @return  user_t.id, 
	 * @flysky_generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置  字段:user_t.id
	 * @param id  user_t.id, 
	 * @flysky_generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取  字段:user_t.password
	 * @return  user_t.password, 
	 * @flysky_generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置  字段:user_t.password
	 * @param password  user_t.password, 
	 * @flysky_generated
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取  字段:user_t.age
	 * @return  user_t.age, 
	 * @flysky_generated
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 设置  字段:user_t.age
	 * @param age  user_t.age, 
	 * @flysky_generated
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * ,所属表字段为user_t.user_name
	 * @flysky_generated
	 */
	private String userName;

	/**
	 * 获取  字段:user_t.user_name
	 * @return  user_t.user_name, 
	 * @flysky_generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置  字段:user_t.user_name
	 * @param userName  user_t.user_name, 
	 * @flysky_generated
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserT [id=" + id + ", password=" + password + ", age=" + age
				+ ", userName=" + userName + "]";
	}
	
	
}