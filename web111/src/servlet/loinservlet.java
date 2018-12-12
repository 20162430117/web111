package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieEncryptTool;
import bean.Guanli;
import bean.Student;
import bean.Teacher;
import dao.GuanliDao;
import dao.StudentDao;
import dao.TeacherDao;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loinservlet")
public class loinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String account1 ="account";
		String code = request.getParameter("code");//��֤��
		String account = request.getParameter(account1);//�ʺ�
		String password = request.getParameter("password");//����
    	String type = request.getParameter("type"); //��ݣ���ʦ����ѧ����
    	String rememberMe = request.getParameter("rememberMe");
    	if(account.equals("")||password.equals("")) {
    		request.setAttribute("msg1", "�ʺŻ�������������,��¼ʧ�ܣ�");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
			return;
    	}
    	
    	/*1.��֤������Ҫ��ȷ*/
    	if(code.equals(request.getSession().getAttribute("code"))) {
			/*2.�ʺ����벻��Ϊ��*/
			if(account!=null && !account.equals("")){
				// ͨ��Cookie��ס���������
				rememberMe(rememberMe, account, password, request, response);
				
				/*3.1 ѧ����¼*/
				if(type.equals("student")){ 
					System.out.println(2222);
					StudentDao sdao = new StudentDao();
					type = "ѧ��";
					try{
						Student stu = sdao.getStudentByStuno(account);
						//��֤ѧ����¼��Ϣ
						if(stu==null || !stu.getPassword().equals(password)){
							request.setAttribute("msg1", "�ʺŻ�������������,��¼ʧ�ܣ�");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
							dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
						}
						else{	
							request.getSession().setAttribute("stuno",account);
							request.getSession().setAttribute("student",stu);
							request.getSession().setAttribute("type",type);
							System.out.println(1111);
							RequestDispatcher dispatcher = request.getRequestDispatcher("stuope.jsp");
							dispatcher.forward(request, response);
							//response.sendRedirect("/filter/stuope.jsp");
						}
					}catch(Exception ex){	ex.printStackTrace();}
				}
				/*3.2 ��ʦ��¼*/
				else if(type.equals("teacher")){ 
					TeacherDao tdao = new TeacherDao();
					type = "��ʦ";
					try{
						Teacher tea = tdao.getTeacherByTeano(account);
						//��֤��ʦ��¼��Ϣ
						if(tea==null || !tea.getPassword().equals(password)){
							request.setAttribute("msg1", "�ʺŻ�������������,��¼ʧ�ܣ�");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
							dispatcher.forward(request, response); 
						}
						else{
							request.getSession().setAttribute("teacher",tea);
							request.getSession().setAttribute("type",type);
							response.sendRedirect("zhujiemian.jsp");
						}
					}catch(Exception ex){	ex.printStackTrace();}
				}
				/*3.2 ����Ա��¼*/
				else if(type.equals("guanli")){ 
					System.out.println(1111);
					GuanliDao gdao=new GuanliDao();
					//TeacherDao tdao = new TeacherDao();
					type = "����Ա";
					try{
						Guanli guanli=gdao.getguanlibyid(account);
						if(guanli==null || !guanli.getPassword().equals(password)){
							request.setAttribute("msg1", "�ʺŻ�������������,��¼ʧ�ܣ�");
							request.getRequestDispatcher("/index.jsp").forward(request, response);
							}
							else{
								request.getSession().setAttribute("guanliyuan",guanli);
								request.getSession().setAttribute("type",type);
								response.sendRedirect("guanliyuan.jsp");
							}
						
					}catch(Exception ex){	ex.printStackTrace();}
				}
			}
    	}
		/*4.��֤�������*/
    	else {
			request.setAttribute("msg1", "��֤���������");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	private void rememberMe(String rememberMe, String email, String password, HttpServletRequest request,
			HttpServletResponse response) {
		// �ж��Ƿ���Ҫͨ��Cookie��ס���������
		if ("true".equals(rememberMe)) {
			// ��ס���估����
			Cookie cookie = new Cookie("COOKIE_APPLICANTEMAIL", CookieEncryptTool.encodeBase64(email));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);

			cookie = new Cookie("COOKIE_APPLICANTPWD", CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			// �����估����Cookie���
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("COOKIE_APPLICANTEMAIL".equals(cookie.getName())
							|| "COOKIE_APPLICANTPWD".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
	}
}
