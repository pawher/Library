package app;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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

		try {
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
			case DELETE_BOOK:
				System.out.println("Insert book id to be deleted");
				Scanner sc = new Scanner(System.in);
				int bookID = sc.nextInt();
				bookDAO.deleteBook(bookID);
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Wrong data insertion. Add a book again!");
		} catch (NoSuchElementException | NumberFormatException e) {
			System.out.println("Option does not exist - choose appropriate number!");
		}
	}

	private void printOptions() {
		for (Option option : Option.values()) {
			System.out.println(option);
		}
	}
}
