package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.UserTMapper;
import com.study.model.UserT;
import com.study.service.IUserService;
  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {
	
	@Autowired
    private UserTMapper userTDao;  
    
    @Override
    public UserT getUserById(Integer userId) {  
        return this.userTDao.selectById(userId);  
    }

	@Override
	public void saveUser(UserT user) {
		this.userTDao.insert(user);
	}

	@Override
	public List<UserT> getAllUser() {
		return this.userTDao.selectAll(null); 
	}  
  
}  
