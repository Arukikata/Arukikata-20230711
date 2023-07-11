package arukikata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArukikataDao {
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public ArrayList<DataBean> selectData() {
		ArrayList<DataBean> beanList = new ArrayList<DataBean>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arukikata_db?autoReconnect=true&useSSL=false",
					  "root",
					  "root");
			
			ps = con.prepareStatement("SELECT * FROM facility JOIN facility_link ON facility.id = facility_link.facility_id JOIN facility_info ON facility_link.info_id = facility_info.info_id;");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DataBean bean = new DataBean();
				
				bean.setName(rs.getString("name"));
				bean.setExplanation(rs.getString("explanation"));
				bean.setLatitude(rs.getDouble("latitude"));
				bean.setLongitude(rs.getDouble("longitude"));
				bean.setPath(rs.getString("path"));
				bean.setInfo_name(rs.getString("info_name"));
				bean.setInfo_path(rs.getString("info_path"));
				bean.setEx_detail(rs.getString("ex_detail"));
				
				beanList.add(bean);
			}
		}
		catch(ClassNotFoundException ce) {
			System.out.println("[Error] ClassNotFoundException");
			ce.printStackTrace();
		}
		catch(SQLException se) {
			System.out.println("[Error] SQLException");
			se.printStackTrace();
		}
		finally {
			this.close();
		}
		
		return beanList;
	}
	
	private void close() {
		try {
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
