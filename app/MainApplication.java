package app;

public class MainApplication {

	public static void main(String[] args) {

		System.out.println("Library application - choose option");
		System.out.println("-------------------");

		LibraryControl myLibrary = new LibraryControl();
		myLibrary.controlLoop();

	}
}
