package total;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Connection1;
import order.OrderVO;

public class TotalDAO {
	private Connection con;
	PreparedStatement pstm = null;
	ResultSet rs = null; //전역
	
	private String menu;
	private int cho;
	
	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getCho() {
		return cho;
	}

	public void setCho(int cho) {
		this.cho = cho;
	}

	public TotalDAO() throws ClassNotFoundException, SQLException {
		con = new Connection1().getConnection();
	}
	
	public ArrayList<TotalVO>getSMenue() throws SQLException {  // 상위 2개메뉴 저장후 메뉴에 출력
		
		ArrayList<TotalVO> array = new ArrayList();
		
		String sql = "SELECT ROW_NUMBER() OVER(ORDER BY 1 DESC) 번호,"
				+ " a.*"
				+" FROM total a"
				+" ORDER BY 3 DESC";
	
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1); // 가장많이팔린 번호들 출력
				if(num<=1) { // 1등~3등까지 가장 많이 팔린순
				String name = rs.getString(2); // 메뉴이름 뽑기
				TotalVO to = new TotalVO(name);
				array.add(to);
				}
			
			}
			return array;
	}
	
	
	public void Select(String name) throws SQLException {
		String sql = "SELECT *"
				+ " FROM total"
				+ " WHERE menu = ?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		rs = pstm.executeQuery();
		while(rs.next()) {
			setMenu(rs.getString("menu"));
			setCho(rs.getInt("sum1"));
		}
		
	}
	
	
	
	public void UPdate(String name, int sum) throws SQLException {

		String sql = "UPDATE total"
				+ " SET sum1 = ?"
				+ " WHERE menu = ?";
		int sum1 = getCho()+sum;
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, sum1);
		pstm.setString(2, name);
		rs = pstm.executeQuery();		
				
		
	}
	
	
	public boolean Insert(String name, int sum) {

		String sql = "INSERT INTO total"
				+ " VALUES(?,?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, sum);
			rs = pstm.executeQuery();
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
				
				
		
	}
	
	
	

}
