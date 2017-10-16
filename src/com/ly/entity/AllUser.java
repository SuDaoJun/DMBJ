package com.ly.entity;

import java.util.List;

public class AllUser {
	public static final int FAILED = 0;
	public static final int SUCCESS = 1;
	/**
	 * 结果码1：代表成功    0：代表失败    默认是0
	 */
	private int code = FAILED;
	
	/**
	 * 所有用户数据
	 */
	private List<User> users;
	public AllUser(){}
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public static int getFailed() {
		return FAILED;
	}
	
	public static int getSuccess() {
		return SUCCESS;
	}
	
	@Override
	public String toString() {
		return "AllUser [code=" + code + ", users=" + users + "]";
	}
}
