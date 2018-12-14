package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Guanli;
import util.Dbutil;
public class GuanliDao {


	public Guanli getguanlibyid(String id) {
		Connection conn = Dbutil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			Guanli guanli=null; 
			//this.initConnection();
			String sql = "select * from s_guanli where guanno=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				if(rs.next()) {
					guanli=new Guanli();
					guanli.setId(id);
					guanli.setPassword(rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}	
			finally {
				Dbutil.closeJDBC(rs, ps, conn);
			}

			return guanli;
		
		
	}

}
