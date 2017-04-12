package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import data.Book;

public class BookDAOImpl implements BookDAO {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/library";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	@Override
	public List<Book> showBooks() {

		return null;
	}

}
