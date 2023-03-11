package point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connection1;

public class PointDAO {

	private Connection con;
	PreparedStatement pstm = null;
	ResultSet rs = null; //전역
	private int point;
	private int result;
	private int number;
	

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public PointDAO() throws ClassNotFoundException, SQLException {
	 
	con = new Connection1().getConnection();
	}
	
	
	public boolean Select(int number) {  
		String sql = "SELECT *"
				+ " FROM member1"
				+ " WHERE memid = ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, number);
			rs = pstm.executeQuery();
			while (rs.next()) {
				setNumber(rs.getInt("memid"));
				setPoint(rs.getInt("point1"));
			}
		} catch (SQLException e) {
			return false;
		}
		
		
		return true;
		
		
	}
	
	

	public boolean UPDATE1(int number){ // 포인트 1씩증가 메소드
		String sql = "UPDATE member1"
				+ " SET point1 = ?"
				+ " WHERE memid = ?";
		int po = getPoint();
		po++;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, po);
			pstm.setInt(2, number);
			pstm.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		
		setResult(po);
		
		return true;
		
	}
	
	public boolean UPDATE2(int number1){  //포인트 5달성시 포인트 초기화메소드 
		String sql = "UPDATE member1"
				+ " SET point1 = ?"
				+ " WHERE memid = ?";
		int po = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, po);
			pstm.setInt(2, number1);
			pstm.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		
		setResult(po);
		
		return true;
		
	}
		
	
	
	
}
		
	
