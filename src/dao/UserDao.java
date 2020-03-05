package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Telefone;
import model.User;
import util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			String sql = "insert into users (Nome, Email, Senha) values (?, ?, ?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, user.getNome());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getSenha());
				preparedStatement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userId) {
		try {
			String sql = "delete from users where userid = '" + userId + "'";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.execute();
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updteUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set Nome=?, Email=?, Senha=?" + "where userid=?");
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getSenha());
			preparedStatement.setInt(5, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<User> getAllUsers() {
		List<User> listaDeUsuario = new ArrayList<>();
		try {
			String sql = "select * from users";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						User user = new User();
						user.setUserid(rs.getInt("Userid"));
						user.setNome(rs.getString("Nome"));
						user.setEmail(rs.getString("Email"));
						user.setSenha(rs.getString("Senha"));
						listaDeUsuario.add(user);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeUsuario;
	}

	public User getUserById(int userid) {
		User user = new User();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid=?");
			preparedStatement.setInt(1, userid);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setNome(rs.getString("Nome"));
				user.setEmail(rs.getString("Email"));
				user.setSenha(rs.getString("Senha"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
	
	public Boolean login(String email, String senha) {
		Boolean login = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email=? and senha=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			ResultSet rs = preparedStatement.executeQuery();
			login =  rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;

	}

}
