package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import bean.Student;




public class Studao {
	private Connection conn = null;
	/** 
	 * FunName:           initConnection 
	 * Description :      ʵ�����ݿ�ĳ�ʼ������
	
	 */
	public void initConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
	}
	//��ȡ����ѧ����Ϣ
	public List<Student> getAllStudent() throws Exception {
		List<Student> list = new ArrayList<Student>();
		this.initConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from s_student";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setStuno(rs.getString("stuno"));
				stu.setStugrade(rs.getString("stugrade"));
				stu.setStuname(rs.getString("stuname"));
				stu.setStusex(rs.getString("stusex"));
				list.add(stu);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
}
	
	//���ѧ��
	public int addStudent(Student student) throws Exception
	{
		int row=0;
		this.initConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into s_student(stuno,stupwd,stusex,stuname,stugrade) values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStuno());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getStusex());
			ps.setString(4, student.getStuname());
			ps.setString(5, student.getStugrade());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	
		  if(row>0) 
			  System.out.println("���ѧ���ɹ�");
		  else
			  System.out.println("���ѧ��ʧ��");
		
		return row;
	}
	//����ѧ��
	public Student getStudentInfo(Student student){
		try {
			this.initConnection();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		Student stu = new Student();

		String sql = "select * from s_student where stuno=?";		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, student.getStuno());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stu.setStuno(rs.getString("stuno"));
				stu.setPassword(rs.getString("stupwd"));
				stu.setStugrade(rs.getString("stugrade"));
				stu.setStuname(rs.getString("stuname"));
				stu.setStusex(rs.getString("stusex"));}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return stu;
	}
	public int modifystudent(Student student) {
		
		int row=0;
		try {
			this.initConnection();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		Student stu = new Student();
		String sql = "update s_student set stusex=?,stuname=?,stugrade=? where stuno=?";	
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, student.getStusex());
			ps.setString(2, student.getStuname());
			ps.setString(3, student.getStugrade());			
			ps.setString(4, student.getStuno());
			 row=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		if(row>0) 
			  System.out.println("�޸�ѧ���ɹ�");
		  else 
			  System.out.println("�޸�ѧ��ʧ��");
		return row;
	}
	
	
	
	public int delstudent(Student student){
		
		int row=0;
		try {
			this.initConnection();
			PreparedStatement ps = null;
			
			String sql="delete from s_student where stuno=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, student.getStuno());
			row=ps.executeUpdate();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		

		if(row>0){
			System.out.println("ɾ��ѧ���ɹ�");
		}else{
			System.out.println("ɾ��ѧ��ʧ��");
		}
		return row;
//		
	}
}
