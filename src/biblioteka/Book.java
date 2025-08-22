package biblioteka;

public class Book {
	private String title;
    private String author;
    private String genre;
    private int numOfReservations;
    private int numOfHandouts;
    private Status status = Status.DOSTUPNA;
	enum Status{
		IZDATA,
		DOSTUPNA
	}
	
	public Book(String title, String author, String genre, int numOfReservations, int numOfHandouts, Status status) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.status = status;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getNumOfReservations() {
		return numOfReservations;
	}
	public void setNumOfReservations(int numOfReservations) {
		this.numOfReservations = numOfReservations;
	}
	public int getNumOfHandouts() {
		return numOfHandouts;
	}
	public void setNumOfHandouts(int numOfHandouts) {
		this.numOfHandouts = numOfHandouts;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
