package dao;

import java.util.List;
import data.Book;

public interface BookDAO {

	List<Book> getAllBooks();
	void insertBook();
}
