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
 * Servlet implementation class BmiDeleteServlet
 */
@WebServlet("/BmiSelectServlet")
public class BmiSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmiSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 允许跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean ok = businessServiceImpl.selectUser(user);
		//添加成功返回1，失败返回0
		if(ok){
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
