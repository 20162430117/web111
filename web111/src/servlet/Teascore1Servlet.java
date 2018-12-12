package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.CourseDao;

/**
 * Servlet implementation class Teascore1Servlet
 */
@WebServlet("/Teascore1Servlet")
public class Teascore1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Teascore1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
		CourseDao cdao = new CourseDao();
		
		try{
			ArrayList courses = cdao.getCourseByTeano(tea.getTeano());//获取教师开设的所有课程，方便教师选择课程进行成绩录入
			if(courses.size()!=0){
				request.setAttribute("courses",courses);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/teacher/tea_entryscore1.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}catch(Exception ex){	ex.printStackTrace();}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
