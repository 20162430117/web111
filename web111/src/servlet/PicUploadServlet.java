package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.Student;
import dao.StudentDao;



/**
 * Servlet implementation class PicUploadServlet
 */
@WebServlet("/PicUploadServlet")
@MultipartConfig
public class PicUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PicUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取上传文件域
		Part part = request.getPart("headSh");
		// 获取上传文件名称
		String fileName = part.getSubmittedFileName();
		// 为防止上传文件重名，对文件进行重命名
		String newFileName = System.currentTimeMillis()
				+ fileName.substring(fileName.lastIndexOf("."));
		// 将上传的文件保存在服务器项目发布路径的applicant/images目录下
		String filepath = getServletContext().getRealPath("/images");
		File f = new File(filepath);
		if (!f.exists())
			f.mkdirs();
		part.write(filepath + "/" + newFileName);
//		Student stu =(Student) request.getSession().getAttribute("student");
//		String stuno=stu.getStuno();
		String stuno=(String) request.getSession().getAttribute("stuno");
		// 更新简历照片
		System.out.println(stuno);
		StudentDao dao=new StudentDao();
		dao.updateHeadShot(stuno, newFileName);
		response.sendRedirect("stuope.jsp");
//		ResumeDAO dao = new ResumeDAO();
//		dao.updateHeadShot(resumeID, newFileName);
//		 照片更新成功，回到“我的简历”页面
//		response.sendRedirect("ResumeBasicinfoServlet?type=select");
	
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//		// 获取上传文件域
//		Part part = request.getPart("headShot");
//		// 获取上传文件名称
//		String fileName = part.getSubmittedFileName();
//		// 为防止上传文件重名，对文件进行重命名
//		String newFileName = System.currentTimeMillis()
//				+ fileName.substring(fileName.lastIndexOf("."));
//		// 将上传的文件保存在服务器项目发布路径的applicant/images目录下
//		String filepath = getServletContext().getRealPath("/applicant/images");
//		System.out.println("头像保存路径为：" + filepath);
//		File f = new File(filepath);
//		if (!f.exists())
//			f.mkdirs();
//		part.write(filepath + "/" + newFileName);
//		// 从会话对象中获取当前用户简历标识
//		int resumeID = (Integer)request.getSession().getAttribute("SESSION_RESUMEID");
//		// 更新简历照片
//		StudentDao dao=new StudentDao();
//		dao.updateHeadShot(resumeID, newFileName);
//		response.sendRedirect("stuope.jsp");
//		ResumeDAO dao = new ResumeDAO();
//		dao.updateHeadShot(resumeID, newFileName);
		// 照片更新成功，回到“我的简历”页面
		//response.sendRedirect("ResumeBasicinfoServlet?type=select");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
