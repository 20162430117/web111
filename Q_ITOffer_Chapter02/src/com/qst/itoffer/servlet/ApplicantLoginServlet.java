package com.qst.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.itoffer.dao.ApplicantDAO;

/**
 * 求职者登录功能实现
 * 
 * @author QST青软实训
 *
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicantLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// 登录验证
		ApplicantDAO dao = new ApplicantDAO();
		int applicantID = dao.login(email,password);
		if(applicantID !=0 )
			// 用户登录成功，判断是否已填写简历
			
				
				response.sendRedirect("login.html");
			
		
	}

}
