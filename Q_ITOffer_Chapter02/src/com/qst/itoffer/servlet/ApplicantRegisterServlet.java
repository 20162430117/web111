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
 * ��ְ��ע�Ṧ��ʵ��
 * 
 * @author QST����ʵѵ
 *
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicantRegisterServlet() {
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
		// �ж������Ƿ��ѱ�ע��
		ApplicantDAO dao = new ApplicantDAO();
		boolean flag = dao.isExistEmail(email);
		if(flag){
			// ������ע��,���д�����ʾ
			out.print("<script type='text/javascript'>");
			out.print("alert('�����ѱ�ע�ᣬ���������룡');");
			out.print("window.location='register.html';");
			out.print("</script>");
		}else{
			// ����δ��ע�ᣬ����ע���û���Ϣ
			dao.save(email,password);
			// ע��ɹ����ض��򵽵�¼ҳ��
			response.sendRedirect("login.html");
		}
	}

}
