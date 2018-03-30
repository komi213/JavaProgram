package com.study.service;

import java.util.List;

import com.study.model.UserT;

public interface IUserService {  
    UserT getUserById(Integer userId);

	void saveUser(UserT user);

	List<UserT> getAllUser(); 
}
