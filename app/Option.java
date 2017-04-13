package app;

import java.util.NoSuchElementException;

public enum Option {
	EXIT(0, "EXIT PROGRAM"), ADD_BOOK(1, "ADD BOOK"), PRINT_ALL_BOOKS(2, "PRINT ALL BOOKS"), DELETE_BOOK(3,
			"DELETE BOOK");

	private int value;
	private String description;

	private Option(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return value + " - " + description;
	}

	public static Option createFromInt(int option) throws NoSuchElementException {
		Option result = null;
		try {
			result = Option.values()[option];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
		return result;
	}

}
