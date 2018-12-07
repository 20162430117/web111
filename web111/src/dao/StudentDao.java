package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.Student;

public class StudentDao {
		private Connection conn = null;
		/** 
		 * FunName:           initConnection 
		 * Description :      实现数据库的初始化连接
		 */
		public void initConnection() throws Exception{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
		}
		
		
		
		
		public Student getStudentByStuno(String stuno) throws Exception{//通过学号获得学生信息
			Student stu = null;//attention！
			this.initConnection();
			Statement stat = conn.createStatement();
			String sql = "select * from s_student where stuno='"+stuno+"'";
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()){
				stu = new Student();
				stu.setStuno(stuno);
				stu.setPassword(rs.getString("stupwd").trim());
				stu.setStuname(rs.getString("stuname").trim());	
				stu.setStusex(rs.getString("stusex").trim());
				stu.setStugrade(rs.getString("stugrade").trim());
			}
			this.closeConnection();
			return stu;		
		}
		
		
		
		
		
		public void updateStudent(Student stu) throws Exception{//修改学生密码信息
			this.initConnection();
			String sql = "update s_student set stupwd=? where stuno=?";
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setString(1, stu.getPassword());
			ps.setString(2, stu.getStuno());
			ps.executeUpdate();
			this.closeConnection();
		}
		
		
		
		
		public void closeConnection() throws Exception{
			conn.close();
		}
}
