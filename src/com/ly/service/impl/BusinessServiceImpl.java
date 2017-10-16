package com.ly.service.impl;

import java.util.List;

import com.ly.dao.impl.UserDAOImpl;
import com.ly.entity.User;
import com.ly.service.BusinessService;

public class BusinessServiceImpl implements BusinessService{
	private UserDAOImpl daoImpl = new UserDAOImpl();
	@Override
	public List<User> getAllUser() {
		return daoImpl.getAll();
	}

	@Override
	public boolean addUser(User user) {
		return daoImpl.add(user);
	}

	@Override
	public boolean deleteUser(String id) {
		return daoImpl.delete(id);
	}
	@Override
	public boolean selectUser(User user) {
		return daoImpl.select(user);
	}
}
