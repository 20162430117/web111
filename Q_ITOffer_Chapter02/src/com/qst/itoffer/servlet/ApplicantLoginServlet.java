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
 * ��ְ�ߵ�¼����ʵ��
 * 
 * @author QST����ʵѵ
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
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// ��¼��֤
		ApplicantDAO dao = new ApplicantDAO();
		int applicantID = dao.login(email,password);
		if(applicantID !=0 )
			// �û���¼�ɹ����ж��Ƿ�����д����
			
				
				response.sendRedirect("login.html");
			
		
	}

}
