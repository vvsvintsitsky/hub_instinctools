package wsvintsitsky.instinctools.dataaccess.sqlnosql.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import wsvintsitsky.instinctools.dataaccess.ClientDao;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;

public class ClientDaoImpl extends AbstractDaoImpl<Client, Long> implements ClientDao {

	private static final String FIND_CLIENT = "SELECT * FROM client WHERE id = ?";
	private static final String INSERT_CLIENT = "INSERT INTO client (name, email, password) VALUES (?, ?, ?)";
	private static final String UPDATE_CLIENT = "UPDATE client SET name = ?, email = ?, password = ? WHERE id = ?";
	private static final String DELETE_CLIENT = "DELETE FROM client WHERE id = ?";
	private static final String DELETE_ALL_CLIENTS = "DELETE FROM client";
	
	public ClientDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Client find(Long id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		Client client = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(FIND_CLIENT);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long clientId = rs.getLong("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				client = new Client();
				client.setId(clientId);
				client.setName(name);
				client.setEmail(email);
				client.setPassword(password);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
		return client;
	}

	@Override
	public Client insert(Client entity) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(INSERT_CLIENT, new String[] { "id" });
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getPassword());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				entity.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
		return entity;
	}

	@Override
	public Client update(Client entity) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(UPDATE_CLIENT);
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getPassword());
			ps.setLong(4, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
		return entity;
	}

	private void closeConnectionAndStatement(Connection connection, PreparedStatement ps) throws SQLException {
		if (ps != null) {
			ps.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	@Override
	public void delete(Long id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(DELETE_CLIENT);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
	}
	
	@Override
	public void deleteAll() throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(DELETE_ALL_CLIENTS);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
	}
}
