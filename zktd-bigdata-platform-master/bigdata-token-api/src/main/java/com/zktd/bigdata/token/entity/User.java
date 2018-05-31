package com.zktd.bigdata.token.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zktd.bigdata.common.util.ConvertUtils;

import lombok.Data;

 
@Data
@Document(collection = "user")
public class User implements java.io.Serializable{

	@Id
	private String id;
	@Field
    private String userName;
	@Field
    private String password;
    
	@Field
	private String createTime = ConvertUtils.dateToString(new Date());

	@Field
    private String status;//用户状态:0-未审核，1-已审核 ，2-锁定

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}