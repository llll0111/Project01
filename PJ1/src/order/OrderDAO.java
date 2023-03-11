package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Connection1;

public class OrderDAO {
	
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private String name1;
	private int money;
	private int cho;
	
	
	
	public int getCho() {
		return cho;
	}


	public void setCho(int cho) {
		this.cho = cho;
	}


	public String getName1() {
		return name1;
	}


	public void setName1(String name1) {
		this.name1 = name1;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	// 생성자
	public OrderDAO() throws ClassNotFoundException, SQLException {
		
		con = new Connection1().getConnection();
		
	}
	
	
	public boolean ODelete() {  // 메뉴주문시 메뉴테이블 초기화 메소드 
		String sql = "DELETE cafetable";
				
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
		
	}

	

	public boolean UPDATE1(String name,int cho,int money){  // 1번이상 주문시 메뉴테이블에 주문 누적 
		String sql = "UPDATE cafetable"
				+ " SET choice = ?,price = ?"
				+ " WHERE menuname = ?";
		int m1 = getMoney(); // select에서 set값 받아오는변수
		int ch1 = getCho();  // select에서 set값 받아오는변수
		ch1+=cho;	
		//메뉴에서 받은 개수랑 원래컬럼값을 더해서 테이블 누적 
		m1+=(money*cho);
		//메뉴에서 받은 가격이랑 원래컬럼값을 더해서 테이블 누적

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ch1);
			pstmt.setInt(2, m1);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		
		
		
		return true;
		
	}
	
	public boolean Select(String name) {	 // 메뉴테이블 비교할때 사용 
		String sql = "SELECT *"
				+ " FROM cafetable"
				+ " WHERE menuname = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				setName1(rs.getString("menuname"));
				setMoney(rs.getInt("price"));
				setCho(rs.getInt("choice"));
			}
		} catch (SQLException e) {
			return false;
		}
		
		
		return true;
		
		
	}
	
	
	// 메뉴 선택 메소드
	// CafeMenu에서 case1 ~ 5를 선택하게 되면 실행되는 메소드
	public boolean insert_product(String menuName, int choice,int menuPrice) {
		
		String sql = "insert into cafetable values(?, ?, ?)";
		// DB에 넣게되는 sql 구문
		int price = choice*menuPrice;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menuName);
			// 첫번째 ?에 menuName
			
			pstmt.setInt(2, choice);
			
			pstmt.setInt(3, price);
			// 두번째 ?에 menuPrice
			
			pstmt.executeUpdate();
			// 둘 다 넣고 DB로 insert
			
		}catch(SQLException e) {
			System.out.println("insert Exception");
			return false;
			// 문제발생하면 false 반환
		}
		return true; // insert가 되었으면 true 반환
		
	}
	
	
	// 결제 시 CafeOrderTable에 있는 모든 데이터를 출력하기위해 사용
	
	public ArrayList<OrderVO> getAllInfo() throws SQLException{
		
		ArrayList<OrderVO> tiarray = new ArrayList();

		
		String sql = "SELECT * FROM cafetable"
				+ " ORDER BY 1";
		// CafeOrderTable에 있는 모든 데이터 출력
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		// 이러면 rs에는 테이블의 모든 meneName과 menuPrice가 들어가게 된다.
		
		while(rs.next()) {
			
			
			String Name = rs.getString(1);
			int Choice = rs.getInt(2);
			int Price = rs.getInt(3);
			// 그리고 rs에 있는 데이터를 java변수로 이동시킨다.
			
			OrderVO cf = new OrderVO(Name,Choice ,Price);
			// java변수에 넣은 데이터를 CafeVO타입 cf객체의 초기값으로 넣으면서 객체생성
			
			tiarray.add(cf);
			// 생성된 cf변수를 위에서 생성한 tiarray에 추가한다
			
		}// while문 끝, rs에서 모든 데이터가 나올때까지 무한반복, 데이터가 없으면 while문 종료
		
		
		return tiarray; // 테이블에 있는 모든 데이터가 들어간 tiarray객체를 반환한다.
		
	}
	
	
}

