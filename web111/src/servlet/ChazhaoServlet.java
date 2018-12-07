package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.Studao;

/**
 * Servlet implementation class ChazhaoServlet
 */
@WebServlet("/ChazhaoServlet")
public class ChazhaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChazhaoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuno = request.getParameter("chazhao");

		// int id=Integer.parseInt(request.getParameter("chazhao"));
		Student student = new Student();
		student.setStuno(stuno);
		Studao detailStudao = new Studao();
		student = detailStudao.getStudentInfo(student);
		if (student.getStuno() == null) {
			PrintWriter out=response.getWriter();
		out.println("<h1>请输入正确学号<h1>");
			//response.sendRedirect("chazhao.jsp");
		}
		else {
//			HttpSession session = request.getSession();
//			session.setAttribute("student1", student);
			request.setAttribute("student1", student);
			request.getRequestDispatcher("stuxinxi.jsp").forward(request, response);
		}

	}
}
