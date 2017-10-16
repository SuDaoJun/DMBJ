package com.ly.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ly.dao.UserDAO;
import com.ly.entity.User;
import com.ly.utils.JdbcUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> getAll() {

		// 提升作用域
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet executeQuery = null;
		try {
			// 获取数据库连接
			connection = JdbcUtils.getConnection();
			// 建立sql语句
			String sql = "select * from dmbj ";
			// sql预处理
			prepareStatement = connection.prepareStatement(sql);
			// 开始获取数据
			executeQuery = prepareStatement.executeQuery();
			// 装数据
			ArrayList<User> listUsers = new ArrayList<User>();
			// 循环取
			while (executeQuery.next()) {
				User user = new User();
				user.setId(executeQuery.getString("id"));
				user.setUsername(executeQuery.getString("username"));
				user.setPassword(executeQuery.getString("password"));
				user.setDate(executeQuery.getString("date"));
				user.setContent(executeQuery.getString("content"));
				// 注意：添加进集合
				listUsers.add(user);
			}
			// 最后记得将数据返回出去
			return listUsers;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 永远执行，哪怕报错
			// 关闭资源一般都放在这里进行
			JdbcUtils.release(connection, prepareStatement, executeQuery);
		}
		return null;
	}

	@Override
	public boolean add(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into dmbj (id,username,password,date,content) value(?,?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			// 替换占位符
			prepareStatement.setString(1, user.getId());
			prepareStatement.setString(2, user.getUsername());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setString(4, user.getDate());
			prepareStatement.setString(5, user.getContent());
			// 执行,大于0成功
			return prepareStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, prepareStatement, null);
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "delete from dmbj where id = ?";
			prepareStatement = connection.prepareStatement(sql);
			// 替换占位符
			prepareStatement.setString(1, id);
			// 执行,大于0成功
			return prepareStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, prepareStatement, null);
		}
		return false;
	}

	@Override
	public boolean select(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select password from dmbj where username = ?";
			prepareStatement = connection.prepareStatement(sql);
			// 替换占位符
			prepareStatement.setString(1, user.getUsername());
			ResultSet executeQuery = prepareStatement.executeQuery();
			if (executeQuery.next()) {
				String password = executeQuery.getString("password");
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, prepareStatement, null);
		}
		return false;
	}

}
