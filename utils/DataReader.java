package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import data.Book;

public class DataReader {

	private Scanner sc;

	public DataReader() {
		sc = new Scanner(System.in);
	}

	public void close() {
		sc.close();
	}

	public int getInt() throws NumberFormatException {
		int number = 0;
		try {
			number = sc.nextInt();
		} catch (InputMismatchException e) {
			throw new NumberFormatException();
		} finally {
			sc.nextLine();
		}
		return number;
	}

	public Book createBook() throws InputMismatchException {
		try {
			System.out.println("Title: ");
			String title = sc.nextLine();
			System.out.println("Author: ");
			String author = sc.nextLine();
			System.out.println("Cost: ");
			int cost = sc.nextInt();
			sc.nextLine();
			return new Book(title, author, cost);
		} catch (InputMismatchException e) {
			throw e;
		}

	}

}
