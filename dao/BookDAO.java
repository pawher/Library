package dao;

import java.util.List;
import data.Book;


public interface BookDAO {

	public List<Book> getAllBooks();
	public void insertBook();
	public void deleteBook(int id);
}

