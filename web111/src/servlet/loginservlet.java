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

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import dao.TeacherDao;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String account1 ="account";
		String code = request.getParameter("code");//验证码
		String account = request.getParameter(account1);//帐号
		String password = request.getParameter("password");//密码
    	String type = request.getParameter("type"); //身份（教师或者学生）
    	String rememberMe = request.getParameter("rememberMe");
    	if(account.equals("")||password.equals("")) {
    		request.setAttribute("msg1", "帐号或密码输入有误,登录失败！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
			return;
    	}
    	
    	/*1.验证码输入要正确*/
    	if(code.equals(request.getSession().getAttribute("code"))) {
			/*2.帐号输入不能为空*/
			if(account!=null && !account.equals("")){
				// 通过Cookie记住邮箱和密码
				rememberMe(rememberMe, account, password, request, response);
				
				/*3.1 学生登录*/
				if(type.equals("student")){ 
					StudentDao sdao = new StudentDao();
					type = "学生";
					try{
						Student stu = sdao.getStudentByStuno(account);
						//验证学生登录信息
						if(stu==null || !stu.getPassword().equals(password)){
							request.setAttribute("msg1", "帐号或密码输入有误,登录失败！");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
							dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
						}
						else{	
							request.getSession().setAttribute("stuno",account);
							request.getSession().setAttribute("student",stu);
							request.getSession().setAttribute("type",type);
							RequestDispatcher dispatcher = request.getRequestDispatcher("stupe.jsp");
							dispatcher.forward(request, response);
							//response.sendRedirect("/filter/stuope.jsp");
						}
					}catch(Exception ex){	ex.printStackTrace();}
				}
				/*3.2 教师登录*/
				else if(type.equals("teacher")){ 
					TeacherDao tdao = new TeacherDao();
					type = "教师";
					try{
						Teacher tea = tdao.getTeacherByTeano(account);
						//验证教师登录信息
						if(tea==null || !tea.getPassword().equals(password)){
							request.setAttribute("msg1", "帐号或密码输入有误,登录失败！");
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
			}
    	}
		/*4.验证码错误处理*/
    	else {
			request.setAttribute("msg1", "验证码输入错误");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	private void rememberMe(String rememberMe, String email, String password,
			HttpServletRequest request, HttpServletResponse response) {
		// 判断是否需要通过Cookie记住邮箱和密码
		if ("true".equals(rememberMe)) {
			// 记住邮箱及密码
			Cookie cookie = new Cookie("COOKIE_APPLICANTEMAIL",
					CookieEncryptTool.encodeBase64(email));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);

			cookie = new Cookie("COOKIE_APPLICANTPWD",
					CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			// 将邮箱及密码Cookie清空
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
