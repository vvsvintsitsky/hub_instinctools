package wsvintsitsky.instinctools.dataaccess.sqlnosql.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import wsvintsitsky.instinctools.dataaccess.BookDao;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;

public class BookDaoImpl extends AbstractDaoImpl<Book, Long> implements BookDao {

	private static final String FIND_BOOK = "SELECT * FROM book WHERE id = ?";
	private static final String INSERT_BOOK = "INSERT INTO book (name, client_id) VALUES (?, ?)";
	private static final String UPDATE_BOOK = "UPDATE book SET name = ?, client_id = ? WHERE id = ?";
	private static final String DELETE_BOOK = "DELETE FROM book WHERE id = ?";
	private static final String DELETE_ALL_BOOKS = "DELETE FROM book";
	private static final String FIND_ALL = "SELECT * FROM book";
	private static final String FIND_FREE_BOOKS = "SELECT * FROM book WHERE book.client_id = NULL";

	public BookDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Book find(Long id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		Book book = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(FIND_BOOK);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long bookId = rs.getLong("id");
				String name = rs.getString("name");
				Long clientId = rs.getLong("client_id");
				book = new Book();
				book.setId(bookId);
				book.setName(name);
				if (clientId != null) {
					Client client = new Client();
					client.setId(clientId);
					book.setClient(client);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
		return book;
	}

	@Override
	public Book insert(Book entity) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(INSERT_BOOK, new String[] { "id" });
			ps.setString(1, entity.getName());
			if (entity.getClient() != null) {
				ps.setLong(2, entity.getClient().getId());
			} else {
				ps.setNull(2, java.sql.Types.INTEGER);
			}
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
		return null;
	}

	@Override
	public Book update(Book entity) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(UPDATE_BOOK);
			ps.setString(1, entity.getName());
			if (entity.getClient() != null) {
				ps.setLong(2, entity.getClient().getId());
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
		return entity;
	}

	@Override
	public void delete(Long id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(DELETE_BOOK);
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
			ps = connection.prepareStatement(DELETE_ALL_BOOKS);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
	}

	@Override
	public List<Book> findAll() throws SQLException {
		return findByQuery(FIND_ALL);
	}

	@Override
	public List<Book> findFreeBooks() throws SQLException {
		return findByQuery(FIND_FREE_BOOKS);
	}

	private List<Book> findByQuery(String query) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Book> books = null;
		try {
			connection = getDataSource().getConnection();
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Book book = null;
			books = new ArrayList<Book>();
			while (rs.next()) {
				Long bookId = rs.getLong("id");
				String name = rs.getString("name");
				Long clientId = rs.getLong("client_id");
				book = new Book();
				book.setId(bookId);
				book.setName(name);
				if (clientId != null) {
					Client client = new Client();
					client.setId(clientId);
					book.setClient(client);
				}
				books.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnectionAndStatement(connection, ps);
		}
		return books;
	}

	private void closeConnectionAndStatement(Connection connection, PreparedStatement ps) throws SQLException {
		if (ps != null) {
			ps.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
