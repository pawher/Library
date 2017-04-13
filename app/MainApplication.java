package app;

import dao.BookDAOImpl;
import utils.DataReader;

public class MainApplication {


	public static void main(String[] args) {

		Option option; 
		System.out.println("Library application");
		System.out.println("-------------------");
		
		//new DataReader().createBook();
		for(Option o: Option.values()) {
			System.out.println(o);
		}
		System.out.println();
		
		new BookDAOImpl().getAllBooks();
		new BookDAOImpl().insertBook();
		new BookDAOImpl().getAllBooks();

	}
}
