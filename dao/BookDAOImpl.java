package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import data.Book;
import utils.DataReader;

public class BookDAOImpl implements BookDAO {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/library";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	@Override
	public List<Book> getAllBooks() {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		List<Book> bookList = new LinkedList<>();

		String query = "SELECT * FROM BOOKS ORDER BY TITLE";

		try {

			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String title = rs.getString("title");
				String author = rs.getString("author");
				int cost = rs.getInt("price");
				bookList.add(new Book(title, author, cost));

			}

			for (Book book : bookList) {
				System.out.println(book);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			closeConnection(preparedStatement, dbConnection);
		}
		return bookList;
	}

	@Override
	public void insertBook() {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "INSERT INTO BOOKS" + "(title, author, price) values" + "(?, ?, ?)";

		Book newBook = new DataReader().createBook();
		
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(query);

			preparedStatement.setString(1, newBook.getTitle());
			preparedStatement.setString(2, newBook.getAuthor());
			preparedStatement.setInt(3, newBook.getCost());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			closeConnection(preparedStatement, dbConnection);
		}

	}

	private static void closeConnection(PreparedStatement p, Connection c) {
		if (p != null) {
			try {
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return dbConnection;
	}

	@Override
	public void deleteBook(int id) {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "DELETE FROM BOOKS WHERE id=?";
		
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(query);

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			closeConnection(preparedStatement, dbConnection);
		}
	}
}
