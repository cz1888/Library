package cn.edu.xjtu.se.lib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.edu.xjtu.se.lib.dao.*;
import cn.edu.xjtu.se.lib.entity.User;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		//response.setHeader("Content-Type", "text/html; charset=UTF-8");
		User user=new User();
		UserDao userdao=new UserImpl();
		user.setIdCard(request.getParameter("idCard"));//学号
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setPassword(request.getParameter("password"));
		user.setTotal_num(10);//最多借书数量
		user.setAlready_num(0);
		user.setStatus("normal"); //normal limit 
		System.out.println(user.getName());
		userdao.addUser(user);
		System.out.println("注册成功");
		
		request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
	}

}
