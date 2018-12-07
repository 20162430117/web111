package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dao.ScoreDao;

/**
 * Servlet implementation class TeaQueryCourse2Servlet
 */
@WebServlet("/TeaQueryCourse2Servlet")
public class TeaQueryCourse2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaQueryCourse2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				String courseno = request.getParameter("courseno");
		  		ScoreDao sdao = new ScoreDao();	
		  		
				try{
					ArrayList scores = sdao.getScoreByCourseno(courseno);//��ȡ��ѡ�γ̵Ŀ�����Ϣ
					if(scores.size()==0){
						request.getSession().setAttribute("msg7", "�Բ���,����ѧ��ѡ�޸��ſγ̣�");
					}
					else{
						request.setAttribute("msg7", null);
						request.setAttribute("scores", scores);
					}
					request.getRequestDispatcher("/teacher/tea_querycourse2.jsp").forward(request, response);//�ڲ���ת
				}catch(Exception ex){	ex.printStackTrace();}
			}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
