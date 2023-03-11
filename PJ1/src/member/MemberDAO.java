package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connection1;

public class MemberDAO {
	private Connection con;
	PreparedStatement pstm = null;
	ResultSet rs = null; //전역
	
	public MemberDAO() throws ClassNotFoundException, SQLException {
		con = new Connection1().getConnection();
		
	}

	public boolean MInsert(int number) { // 멤버추가 메소드 
		String sql = "INSERT INTO member1"
				+ " VALUES(?,0)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, number);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("오류");
			return false;
		}
		
		return true;
	}
	
	public boolean MDelete(int number) {  // 멤버 삭제 메소드 
		String sql = "DELETE member1"
				+ " WHERE memid = ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, number);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
		
	}

}
