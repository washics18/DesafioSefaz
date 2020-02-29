package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Telefone;
import util.DbUtil;

public class TelefoneDao {

	private Connection connection;

	public TelefoneDao() {
		connection = DbUtil.getConnection();
	}

	public void addTelefone(Telefone telefone) {
		try {
			String sql = "insert into phone (DDD, Numero, Tipo, Id_users) values (?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setInt(1, telefone.getDDD());
				preparedStatement.setString(2, telefone.getNumero());
				preparedStatement.setString(3, telefone.getTipo());
				preparedStatement.setInt(4, telefone.getUserId());
				preparedStatement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePhone(int phoneId) {
		try {
			String sql = "delete from phone where Id = '" + phoneId + "'";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.execute();
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updtePhone(Telefone telefone) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update phone set DDD=?, Numero=?, Tipo=?, Id_users=?" + "where Id=?");
			preparedStatement.setInt(1, telefone.getDDD());
			preparedStatement.setString(2, telefone.getNumero());
			preparedStatement.setString(3, telefone.getTipo());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Telefone> getPhone(int Id_users) {
		List<Telefone> listaDeTelefone = new ArrayList<>();
		try {
			String sql = "select * from phone where Id_users=? ;";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setInt(1, Id_users);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						Telefone telefone = new Telefone();
						telefone.setId(rs.getInt("Id"));
						telefone.setDDD(rs.getInt("DDD"));
						telefone.setNumero(rs.getString("Numero"));
						telefone.setTipo(rs.getString("Tipo"));
						listaDeTelefone.add(telefone);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeTelefone;
	}

	
		
	

}
