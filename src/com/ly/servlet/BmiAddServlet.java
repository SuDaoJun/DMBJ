package com.ly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.entity.User;
import com.ly.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class BmiAddServlet
 */
@WebServlet("/BmiAddServlet")
public class BmiAddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
	public BmiAddServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// 允许跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		User user = new User();
		//解析传过来的数据并添加到对象里面去
		user.setId(request.getParameter("id"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setDate(request.getParameter("date"));
		user.setContent(request.getParameter("content"));
		//注意：字符串转化成数值型
		//调用服务添加到数据库
		BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
		boolean ok = businessServiceImpl.addUser(user);
		//添加成功返回1，失败返回0
		if(ok){
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
		
		
		
	}
	
	



}
