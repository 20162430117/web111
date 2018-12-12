package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Guanli;
import bean.Student;

public class GuanliDao {
	private Connection conn = null;
	/** 
	 * FunName:           initConnection 
	 * Description :      实现数据库的初始化连接
	 */
	public void initConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
	}
	

	public Guanli getguanlibyid(String id) {
		
		try {
			Guanli guanli=null; 
			this.initConnection();
			String sql = "select * from s_guanli where guanno=?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				guanli=new Guanli();
				guanli.setId(id);
				guanli.setPassword(rs.getString(2));
			}
			this.closeConnection();
			return guanli;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
//			Student stu = null;//attention！
//			this.initConnection();
//			//Statement stat = conn.createStatement();
//			//String sql = "select * from s_student where stuno='"+stuno+"'";
//			String sql = "select * from s_student where stuno=?";
//			PreparedStatement ps = conn.prepareStatement(sql);	
//			ps.setString(1, stuno);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()){
//				stu = new Student();
//				stu.setStuno(stuno);				
//				stu.setPassword(rs.getString("stupwd").trim());
//				stu.setStuname(rs.getString("stuname").trim());	
//				stu.setStusex(rs.getString("stusex").trim());
//				stu.setStugrade(rs.getString("stugrade").trim());
//				stu.setHeadShot(rs.getString("headshot").trim());
//			}
//			this.closeConnection();
//			return stu;		
//		}
//		
		return null;
	}
	public void closeConnection() throws Exception{
		conn.close();
	}
}
