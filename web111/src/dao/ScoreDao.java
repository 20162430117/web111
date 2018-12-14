package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Dbutil;

import bean.Score;

public class ScoreDao {
//	private Connection conn = null;	
//	/** 
//	 * FunName:           initConnection 
//	 * Description :      ʵ�����ݿ�ĳ�ʼ������
//	 */
//	public void initConnection() throws Exception{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SCHOOL","scott","orcl");
//	}
//		
	public ArrayList getScoreByStuno(String stuno) {//�����Ӧѧ�ŵĿ�����Ϣ
		//this.initConnection();
		Connection conn = Dbutil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList al = new ArrayList();
		Statement stat;
		try {
			stat = conn.createStatement();
			String sql = "select * from s_score A join s_student B on A.stuno=B.stuno join s_course C on A.courseno=C.courseno" 
					+ " where A.stuno='"+stuno+"'";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Score sco = new Score();
				sco.setStuno(stuno);
				sco.setStuname(rs.getString("stuname").trim());
				sco.setCourseno(rs.getString("courseno").trim());
				sco.setCoursename(rs.getString("coursename").trim());
				sco.setScore(rs.getFloat("score"));
				al.add(sco);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {
			Dbutil.closeJDBC(rs, ps, conn);
		}
	//	this.closeConnection();
		return al;
	}
		
	
	public void insertScore(Score sco){//�����µĿ�����Ϣ
		Connection conn = Dbutil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//this.initConnection();
		String sql = "insert into s_score(stuno,courseno,type) values(?,?,?)";
		//String sql = "insert into t_score(stuno,courseno,type) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sco.getStuno());
			ps.setString(2, sco.getCourseno());
			ps.setString(3, sco.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {
			Dbutil.closeJDBC(rs, ps, conn);
		}
		
		//this.closeConnection();
	}
	
	public ArrayList getScoreByCourseno(String courseno) {//���ĳ�γ̵Ŀ�����Ϣ
		//this.initConnection();
		Connection conn = Dbutil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList al = new ArrayList();
		Statement stat;
		try {
			stat = conn.createStatement();
			String sql = "select * from s_score A join s_course B on A.courseno=B.courseno join s_student C on A.stuno=C.stuno" 
					+ " where A.courseno='"+courseno+"'";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Score sco = new Score();
				sco.setStuno(rs.getString("stuno").trim());
				sco.setStuname(rs.getString("stuname").trim());
				sco.setCourseno(courseno);
				sco.setCoursename(rs.getString("coursename").trim());
				sco.setScore(rs.getFloat("score"));
				String str = rs.getString("state");
				if(str!=null){
					sco.setState(str.trim());
				}
				al.add(sco);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Dbutil.closeJDBC(rs, ps, conn);
		}

		return al;
	}
	
	
	
//	public void closeConnection() throws Exception{
//		conn.close();
//	}

	/** 
	 * FunName:           updateScore 
	 * Description :      ���¿�����Ϣ
	 * @param��			  Score sco
	 * @return��			  ��
	 */
	public void updateScore(Score sco){
		Connection conn = Dbutil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update s_score set type=?,score=?,state=? where stuno=? and courseno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sco.getType());
			ps.setFloat(2, sco.getScore());
			ps.setString(3, sco.getState());
			ps.setString(4, sco.getStuno());
			ps.setString(5, sco.getCourseno());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	finally {
			Dbutil.closeJDBC(rs, ps, conn);
		}	


	}

	
}
