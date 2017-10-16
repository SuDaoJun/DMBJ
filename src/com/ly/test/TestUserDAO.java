package com.ly.test;

import java.util.List;

import org.junit.Test;

import com.ly.dao.impl.UserDAOImpl;
import com.ly.entity.User;

public class TestUserDAO {
	
	@Test
	public void testGetAll(){
		UserDAOImpl daoImpl = new UserDAOImpl();
		List<User> all = daoImpl.getAll();
		//System.out.println(1/all.size()); 没有数据就会报异常
		System.out.println(all);
	}
	@Test
	public void testAdd(){
		User user = new User();
		user.setId(Math.random()+"");
		user.setUsername("sj");
		user.setPassword("13");
		user.setDate("2017");
		user.setContent("sss");
		UserDAOImpl daoImpl = new UserDAOImpl();
		System.out.println(daoImpl.add(user));
	}
	@Test
	public void testDelete(){
		UserDAOImpl daoImpl = new UserDAOImpl();
		System.out.println(daoImpl.delete("s"));
	}
	public void testSelect(){
		UserDAOImpl daoImpl = new UserDAOImpl();
//		System.out.println(daoImpl.select("a"));
	}
	
}
