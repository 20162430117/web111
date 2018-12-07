package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Score;

public class ScoreDao {
	private Connection conn = null;	
	/** 
	 * FunName:           initConnection 
	 * Description :      ʵ�����ݿ�ĳ�ʼ������
	 */
	public void initConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
	}
		
	public ArrayList getScoreByStuno(String stuno) throws Exception{//�����Ӧѧ�ŵĿ�����Ϣ
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from s_score A join s_student B on A.stuno=B.stuno join s_course C on A.courseno=C.courseno" 
				+ " where A.stuno='"+stuno+"'";
//		String sql = "select * from t_score A join s_student B on A.stuno=B.stuno join t_course C on A.courseno=C.courseno" 
//			+ " where A.stuno='"+stuno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Score sco = new Score();
			sco.setStuno(stuno);
			sco.setStuname(rs.getString("stuname").trim());
			sco.setCourseno(rs.getString("courseno").trim());
			sco.setCoursename(rs.getString("coursename").trim());
			//sco.setScore(rs.getFloat("score"));
			al.add(sco);
		}
		this.closeConnection();
		return al;
	}
		
	
	public void insertScore(Score sco)throws Exception{//�����µĿ�����Ϣ
		this.initConnection();
		String sql = "insert into s_score(stuno,courseno) values(?,?)";
		//String sql = "insert into t_score(stuno,courseno,type) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sco.getStuno());
		ps.setString(2, sco.getCourseno());
		//ps.setString(3, sco.getType());
		ps.executeUpdate();
		this.closeConnection();
	}
	
	public ArrayList getScoreByCourseno(String courseno) throws Exception{//���ĳ�γ̵Ŀ�����Ϣ
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
//		String sql = "select * from t_score A join t_course B on A.courseno=B.courseno join t_student C on A.stuno=C.stuno" 
//			+ " where A.courseno='"+courseno+"'";
		String sql = "select * from s_score A join s_course B on A.courseno=B.courseno join s_student C on A.stuno=C.stuno" 
				+ " where A.courseno='"+courseno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Score sco = new Score();
			sco.setStuno(rs.getString("stuno").trim());
			sco.setStuname(rs.getString("stuname").trim());
			sco.setCourseno(courseno);
			sco.setCoursename(rs.getString("coursename").trim());
			//sco.setScore(rs.getFloat("score"));
			//String str = rs.getString("state");
//			if(str!=null){
//				sco.setState(str.trim());
//			}
			al.add(sco);
		}
		this.closeConnection();
		return al;
	}
	
	
	
	public void closeConnection() throws Exception{
		conn.close();
	}

	
}
