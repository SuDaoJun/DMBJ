package com.ly.service;

import java.util.List;

import com.ly.entity.User;

public interface BusinessService {
	
	List<User> getAllUser();
	
	boolean addUser(User user);
	
	boolean deleteUser(String id);
	
	boolean selectUser(User user);
	
}
