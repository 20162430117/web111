package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.CourseDao;

/**
 * Servlet implementation class TeaQueryCourse1Servlet
 */
@WebServlet("/TeaQueryCourse1Servlet")
public class TeaQueryCourse1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public TeaQueryCourse1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
					
					Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
					CourseDao cdao = new CourseDao();
					
					try{
						ArrayList courses = cdao.getCourseByTeano(tea.getTeano());//获取教师开设的所有课程
						if(courses.size()!=0){
							request.setAttribute("courses",courses);
						}
						request.getRequestDispatcher("/teacher/tea_querycourse1.jsp").forward(request, response);//内部跳转
					}catch(Exception ex){	ex.printStackTrace();}
				}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
