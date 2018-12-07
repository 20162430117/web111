package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.Studao;

/**
 * Servlet implementation class delStudent
 */
@WebServlet("/delStudent")
public class delStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public delStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuno=request.getParameter("id");
		Studao studao=new Studao();
		Student student =new  Student();
		student.setStuno(stuno);
		studao.delstudent(student);
		PrintWriter out=response.getWriter();
		out.println("<h1>É¾³ý³É¹¦<h1>");
		//response.sendRedirect("22.jsp");
		//		int n=0;
//		int id=Integer.parseInt(request.getParameter("id"));
//		Studao studao=new Studao();
//		Students stu=new Students();
//		stu.setId(id);
//		studao.delStudent(stu);
//		response.sendRedirect("stulist.jsp");
	}

}
