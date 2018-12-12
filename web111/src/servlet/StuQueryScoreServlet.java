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
import dao.ScoreDao;

/**
 * Servlet implementation class StuQueryScoreServlet
 */
@WebServlet("/StuQueryScoreServlet")
public class StuQueryScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public StuQueryScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu = (Student)request.getSession().getAttribute("student");
  		ScoreDao sdao = new ScoreDao();
  		
  		try{
  			ArrayList score = sdao.getScoreByStuno(stu.getStuno());//��ȡ�����Ŀ�����Ϣ
  			if(score==null){
  				request.setAttribute("msg3", "�Բ���,����û��ѡ�Σ�");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("score", score);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/student/stu_queryscore.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
  		}catch(Exception ex){	ex.printStackTrace();}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
