package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.Teacher;

public class TeacherDao {
	private Connection conn = null;
	/** 
	 * FunName:           initConnection 
	 * Description :      实现数据库的初始化连接
	
	 */
	public void initConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
	}
	/** 
	 * FunName:           getTeacherByTeano 
	 * Description :      根据职工号获取对应的教师信息
	 * @param：			  String teano
	 * @return：			  Teacher

	 */
	public Teacher getTeacherByTeano(String teano) throws Exception{
		Teacher tea = null;
		this.initConnection();
//		Statement stat = conn.createStatement();
//		String sql = "select * from t_teacher where teano='"+teano+"'";
//		ResultSet rs = stat.executeQuery(sql);
		String sql = "select * from t_teacher where teano=?";
		PreparedStatement ps = conn.prepareStatement(sql);	
		ps.setString(1, teano);
		//ResultSet rs = ps.executeQuery(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			tea = new Teacher();
			
			tea.setTeano(teano);
			tea.setPassword(rs.getString("teapwd").trim());
			tea.setTeaname(rs.getString("teaname").trim());
			tea.setTeasex(rs.getString("teasex").trim());
			tea.setTitle(rs.getString("title").trim());
		}
		this.closeConnection();
		return tea;		
	}
	/** 
	 * FunName:           updateTeacher 
	 * Description :      更新教师信息到数据库
	 * @param：			  Teacher tea
	 * @return：			  无

	 */
	public void updateTeacher(Teacher tea) throws Exception{
		this.initConnection();
		String sql = "update t_teacher set teapwd=? where teano=?";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setString(1, tea.getPassword());
		ps.setString(2, tea.getTeano());
		ps.executeUpdate();
		this.closeConnection();
	} 
	/** 
     * FunName:           closeConnection 
     * Description :      关闭数据库的连接
     * @param：			  无
     * @return：			  无

     */
	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
