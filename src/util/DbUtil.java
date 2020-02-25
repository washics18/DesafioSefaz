package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	private static Connection connection = null;
	private static String user = "washics18";
	private static String password = "camisa10";
	
	static {
		conectar();
	}

	
	
	private DbUtil() {
		// TODO Auto-generated constructor stub
	}

	public static void conectar() {
		try {
			
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/userdb?useTimezone=true&serverTimezone=America/Sao_Paulo",
						user, password);
				
				connection.setAutoCommit(false);
				System.out.println("Conectou");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
