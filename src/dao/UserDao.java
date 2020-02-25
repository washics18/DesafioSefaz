package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			String sql = "insert into users (Nome, Email, Senha, Telefone) values (?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, user.getNome());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getSenha());
				preparedStatement.setString(4, user.getTelefone());
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
					.prepareStatement("update users set Nome=?, Email=?, Senha=?, Telefone=?" + "where userid=?");
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getSenha());
			preparedStatement.setString(4, user.getTelefone());
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
						user.setTelefone(rs.getString("Telefone"));
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
				user.setSenha(rs.getString("Email"));
				user.setTelefone(rs.getString("Telefone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

}
