package com.ly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ly.entity.AllUser;
import com.ly.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class BmiGetAllServlet
 */
@WebServlet("/BmiGetAllServlet")
public class BmiGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmiGetAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 允许跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		AllUser allUser = new AllUser();
		
		try{
			//拿数据
			BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
			//填充数据
			allUser.setUsers(businessServiceImpl.getAllUser());
			//设置返回码
			allUser.setCode(AllUser.SUCCESS);
			//把对象变成json
			Gson gson = new Gson();
			String result = gson.toJson(allUser,AllUser.class);
			//返回给客户端
			response.getWriter().write(result);
		}catch(Exception e){
			//打印异常
			e.printStackTrace();
			//因为有异常，所以设置为失败
			allUser.setCode(AllUser.FAILED);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
