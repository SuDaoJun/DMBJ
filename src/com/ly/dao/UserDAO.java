package com.ly.dao;

import java.util.List;
import com.ly.entity.User;

public interface UserDAO {
	
	/**
	 * 需求：获得所有用户数据
	 * @return
	 */
	List<User> getAll();
	
	/**
	 * 需求：添加新数据
	 * @param user
	 * @return
	 */
	boolean add(User user);
	
	/**
	 * 需求：删除指定单个数据
	 * @param id
	 * @return
	 */
	boolean delete(String id);
	boolean select(User user);
	
}
