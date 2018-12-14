package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import util.Dbutil;
import bean.Course;

public class CourseDao {

//	private Connection conn = null;	
//	/** 
//	 * FunName:           initConnection 
//	 * Description :      实现数据库的初始化连接
//	 */
//	public void initConnection() throws Exception{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
//	}
	public ArrayList getAllCourse() {//获得所有课程
		Connection conn = Dbutil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList al = new ArrayList();
		//this.initConnection();
		//String sql = "select * from t_course A join t_teacher B on A.teano = B.teano";
		String sql = "select * from s_course A join t_teacher B on A.teano = B.teano";
		Statement stat;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Course cou = new Course();
				cou.setCourseno(rs.getString("courseno").trim());
				cou.setCoursename(rs.getString("coursename").trim());
				cou.setCredit(rs.getFloat("credit"));
				cou.setTeano(rs.getString("teano").trim());
				cou.setTeaname(rs.getString("teaname").trim());
				al.add(cou);
		} 
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			Dbutil.closeJDBC(rs, pstmt, conn);
		}
		//this.closeConnection();
		return al;
	}
	
	
	
	
	
	public ArrayList getAllCoursename() {//获得所有课程名称
		Connection conn = Dbutil.getConnection();
		PreparedStatement pstmt = null;
		ArrayList al = new ArrayList();
		ResultSet rs = null;
//		this.initConnection();
		//String sql = "select distinct(coursename) from t_course";
		String sql = "select distinct(coursename) from s_course";
		Statement stat;
		try {
			stat = conn.createStatement();
			 rs = stat.executeQuery(sql);
			while(rs.next()){
				al.add(rs.getString("coursename").trim());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			Dbutil.closeJDBC(rs, pstmt, conn);
		}
		//this.closeConnection();
		return al;
	}
	
	
	
	public Course getCourseByCourseno(String courseno){//根据课程号获取课程信息
		//this.initConnection();
		Connection conn = Dbutil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Course cou = null;
		//String sql = "select * from t_course A join t_teacher B on A.teano = B.teano where A.courseno='"+courseno+"'";
		String sql = "select * from s_course A join t_teacher B on A.teano = B.teano where A.courseno='"+courseno+"'";
		Statement stat;
		try {
			stat = conn.createStatement();
			 rs = stat.executeQuery(sql);
				if(rs.next()){
					cou = new Course();
					cou.setCourseno(courseno);
					cou.setCoursename(rs.getString("coursename").trim());
					cou.setCredit(rs.getFloat("credit"));
					cou.setTeano(rs.getString("teano").trim());
					cou.setTeaname(rs.getString("teaname").trim());
		} }
		catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			Dbutil.closeJDBC(rs, pstmt, conn);
		}
		
		//this.closeConnection();
		return cou;
	}
	
	
	public ArrayList getCourseByStuno(String stuno){//获得相应学号选修好的课程
		Connection conn = Dbutil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList al = new ArrayList();
		//this.initConnection();
//		String sql = "select * from t_course A join t_score B on A.courseno=B.courseno join t_teacher C on A.teano=C.teano" 
//			+" where B.stuno='"+stuno+"'";
		String sql = "select * from s_course A join s_score B on A.courseno=B.courseno join t_teacher C on A.teano=C.teano" 
				+" where B.stuno='"+stuno+"'";
		Statement stat;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Course cou = new Course();
				cou.setCourseno(rs.getString("courseno").trim());
				cou.setCoursename(rs.getString("coursename").trim());
				cou.setCredit(rs.getFloat("credit"));
				cou.setTeano(rs.getString("teano").trim());
				cou.setTeaname(rs.getString("teaname").trim());
				al.add(cou);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			Dbutil.closeJDBC(rs, pstmt, conn);
		}
		
		
		//this.closeConnection();
		return al;
	}
	
	
	public ArrayList getCourseByTeano(String teano){//获得相应职工号的开课情况
		Connection conn = Dbutil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList al = new ArrayList();
		//this.initConnection();
		String sql = "select * from t_course A join t_teacher B on A.teano = B.teano where B.teano='"+teano+"'";;
		
		
		try {
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Course cou = new Course();
				cou.setCourseno(rs.getString("courseno").trim());
				cou.setCoursename(rs.getString("coursename").trim());
				cou.setCredit(rs.getFloat("credit"));
				cou.setTeano(teano);
				cou.setTeaname(rs.getString("teaname").trim());
				al.add(cou);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//this.closeConnection();
		return al;
	}
	
//	public void closeConnection() throws Exception{
//		conn.close();
//	}
//	
}
