package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import com.sun.jmx.snmp.SnmpStringFixed;

import bean.Student;
import dao.Studao;

/**
 * Servlet implementation class modifyStuServlet
 */
@WebServlet("/modifyStuServlet")
public class modifyStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public modifyStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("stuname");
		String sex=request.getParameter("stusex");
		String sno=request.getParameter("stuId");
		String grade=request.getParameter("stugrade");
		//String gradename=request.getParameter("stuGrade");
		
		
		Student stu=new Student();
		
		stu.setStuno(sno);
		stu.setStusex(sex);
		stu.setStugrade(grade);
		stu.setStuname(name);

		
		Studao studa=new Studao();
	
		int n=8;
		n=studa.modifystudent(stu);
//			int id=Integer.parseInt(request.getParameter("stuId"));
//			stu.setId(id);
//			n=studa.modifyStudent(stu);
	System.out.println(n);
			if(n>0) {
				PrintWriter out=response.getWriter();
				out.println("<h1>修改成功<h1>");
			}
				//response.sendRedirect("11.jsp");}
			else {
				PrintWriter out=response.getWriter();
				out.println("<font size=\"5\" color=\"red\"><b>请输入正确的性别</b></font>");
				
			}
				//response.sendRedirect("addStu.jsp");
	}

}
