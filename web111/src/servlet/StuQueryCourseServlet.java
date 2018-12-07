package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.CourseDao;

/**
 * Servlet implementation class StuQueryCourseServlet
 */
@WebServlet("/StuQueryCourseServlet")
public class StuQueryCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StuQueryCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				Student stu = (Student)request.getSession().getAttribute("student");
				CourseDao cdao = new CourseDao();
				
				try{
					ArrayList selectedcourses = cdao.getCourseByStuno(stu.getStuno());//获取该生选修好的课程
					if(selectedcourses.size()==0){
						request.setAttribute("msg4", "对不起,您还没有选课!");
					}
					else{
						request.setAttribute("msg4", null);
						request.setAttribute("selectedcourses",selectedcourses);	
					}
					RequestDispatcher dispatcher = request.getRequestDispatcher("/student/stu_querycourse.jsp");
					dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
				}catch(Exception ex){	ex.printStackTrace();}
			}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
