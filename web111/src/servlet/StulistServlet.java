package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.Studao;

/**
 * Servlet implementation class StulistServlet
 */
@WebServlet("/StulistServlet")
public class StulistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
     	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studao liststudao=new Studao();
	try {
		List<Student> stulist=liststudao.getAllStudent();
		HttpSession session=request.getSession();
		session.setAttribute("stulist", stulist);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	request.getRequestDispatcher("stulist.jsp").forward(request, response);
}
}
