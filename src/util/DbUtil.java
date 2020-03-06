package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	private static Connection connection = null; // variavel para conexão com o banco de dados
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
			// conexão igual a null a conexão não foi criada e vai criar conexão com o banco de dados
			if (connection == null) { 
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/userdb?useTimezone=true&serverTimezone=America/Sao_Paulo",
						user, password); //DriverManeger para o projeto acessar o endereço 
				
				connection.setAutoCommit(false);
				System.out.println("Conectou");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection; // diferente de null já existe uma conexão e retornar a conexão
	}

}
