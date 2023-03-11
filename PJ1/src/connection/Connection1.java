package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {
	
private Connection con; //접속객체
	
	public Connection getConnection() { // 접속객체 getter 작성
		return con;
	}

	
	public Connection1() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:"  
		+"1521:xe","hr","hr");
	}

}
