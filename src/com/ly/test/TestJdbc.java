package com.ly.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.ly.utils.JdbcUtils;

public class TestJdbc {
	
	//单元测试： 1，@Test  2，方法没有返回值
	
	@Test
	public void testJdbcConnect() throws SQLException{
//		System.out.println(1/0);    测试
		Connection connection = JdbcUtils.getConnection(); // ctrl + 1 选择第一个
		System.out.println(connection);
		
	}
	
//	@BeforeClass
//	@Before
//	@Test
//	@After
//	@AfterClass
	
	public void testJdbcConnect1() throws SQLException{
//		System.out.println(1/0);    测试
		Connection connection = JdbcUtils.getConnection(); // ctrl + 1 选择第一个
		System.out.println(connection);
		
	}
	
}
