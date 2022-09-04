package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
	
	private static Connection con = null;
	private static final String URL = "jdbc:oracle:thin@localhost:1521:xe";
	private static final String USER = "madan";
	private static final String PASSWORD = "madan";
	
	public static Connection getConnection() {
		if (con==null) {
			try {
				//For mySQl use
				//Class.forName("com.sql.jdbc.Driver");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection(URL,USER,PASSWORD);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			if (con!=null && !con.isClosed()) {
				con.close();
			}
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
