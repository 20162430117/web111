package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.Studao;

/**
 * Servlet implementation class addStuServlet
 */
@WebServlet("/addStuServlet")
public class addStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("stuname");
		String sex=request.getParameter("sex");
		String profile=request.getParameter("showProfile");
		String stupwd=request.getParameter("stupwd");
		String id=request.getParameter("id");
		Student stu=new Student();
		stu.setStuno(id);
		stu.setPassword(stupwd);
		stu.setStusex(sex);
		stu.setStuname(name);
		stu.setStugrade(profile);
		Studao studao=new Studao();
//		stu.setId(id);
//		stu.setName(name);
//		stu.setAge(age);
//		stu.setSex(sex);
//		//stu.setGradeId(gradename);
//		stu.setProfile(profile);
//		
//		Studao studao=new Studao();
//	
		
		int n=0;
			try {
				n=studao.addStudent(stu);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		
			if(n>0) 
				response.sendRedirect("guanliyuan.jsp");
			else
				response.sendRedirect("addStu.jsp");
	}

}
