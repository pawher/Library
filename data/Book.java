package data;

public class Book {

	static int ID; 
	
	private int id;
	private String title;
	private String author;
	private int cost;

	public Book(String title, String author, int cost) {
		this.id = ++ID;
		this.title = title;
		this.author = author;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("Title:%s  Author:%s  Cost:%d  ID:%d", title, author, cost, id);
	}

}
