package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.MemberVo;

public class MemberDAO {

	private static MemberDAO instance;
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		if(instance==null) instance = new MemberDAO();
		return instance;
	}
	
//	public Connection getConnection() {
//		Connection con = null;
//		try {
//			Context initContext = new InitialContext();
//			Context envContext = (Context)initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envContext.lookup("jdbc/jspbookdb");
//			con = ds.getConnection();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return con;
//	}
	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/jspbookdb";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public ArrayList<MemberVo> getAllMembers(){
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "select * from member";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
