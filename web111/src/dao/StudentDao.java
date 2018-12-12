package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import bean.Student;

public class StudentDao {
		private Connection conn = null;
		/** 
		 * FunName:           initConnection 
		 * Description :      ʵ�����ݿ�ĳ�ʼ������
		 */
		public void initConnection() throws Exception{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
		}
		
		
		
		
		public Student getStudentByStuno(String stuno) throws Exception{//ͨ��ѧ�Ż��ѧ����Ϣ
			Student stu = null;//attention��
			this.initConnection();
			//Statement stat = conn.createStatement();
			//String sql = "select * from s_student where stuno='"+stuno+"'";
			String sql = "select * from s_student where stuno=?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, stuno);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				stu = new Student();
				stu.setStuno(stuno);				
				stu.setPassword(rs.getString("stupwd").trim());
				stu.setStuname(rs.getString("stuname").trim());	
				stu.setStusex(rs.getString("stusex").trim());
				stu.setStugrade(rs.getString("stugrade").trim());
				stu.setHeadShot(rs.getString("headshot").trim());
			}
			this.closeConnection();
			return stu;		
		}
		
		
		
		
		
		public void updateStudent(Student stu) throws Exception{//�޸�ѧ��������Ϣ
			this.initConnection();
			String sql = "update s_student set stupwd=? where stuno=?";
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setString(1, stu.getPassword());
			ps.setString(2, stu.getStuno());
			ps.executeUpdate();
			this.closeConnection();
		}
		
		/**
		 * ������Ƭ����
		 * 
		 * @param basicinfoId
		 * @param newFileName
		 * @throws Exception 
		 */
		public void updateHeadShot(String basicinfoId, String newFileName)  {
			try {
				this.initConnection();
				//String sql = "UPDATE tb_resume_basicinfo SET head_shot=? WHERE basicinfo_id=?";
				String sql = "UPDATE s_student SET headshot=? WHERE stuno=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1, newFileName);
					ps.setString(2, basicinfoId);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					this.closeConnection();
				}
				
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			
			
		}
		
		
		public void closeConnection() throws Exception{
			conn.close();
		}
}
