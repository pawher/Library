package app;

import dao.BookDAO;
import dao.BookDAOImpl;
import utils.DataReader;

public class LibraryControl {

	private DataReader dataReader;
	private BookDAO bookDAO;

	public LibraryControl() {
		dataReader = new DataReader();
		bookDAO = new BookDAOImpl();
	}

	public void controlLoop() {
	
		Option option;
		printOptions();

		option = Option.createFromInt(dataReader.getInt());
		switch (option) {
		case EXIT:
			System.exit(0);
			break;
		case ADD_BOOK:
			bookDAO.insertBook();
			break;
		case PRINT_ALL_BOOKS:
			bookDAO.getAllBooks();
			break;
		default:
			break;
		}
	}

	private void printOptions() {
		for (Option option : Option.values()) {
			System.err.println(option);
		}
	}
}
