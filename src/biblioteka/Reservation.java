package biblioteka;

import java.time.LocalDate;

public class Reservation {
	private Member member;
    private Book book;
    private LocalDate startDate;
    private Status status = Status.NA_CEKANJU;
    private double price;
	enum Status{
		NA_CEKANJU,
		POTVRDJENA,
		ODBIJENA,
		OTKAZANA
	}
	//Konstruktor za membere
	public Reservation(Member member, Book book, LocalDate startDate, double price) {
		super();
		this.member = member;
		this.book = book;
		this.startDate = startDate;
		this.price = price;
	}
	//Konstruktor za bibliotekare
	public Reservation(Member member, Book book, LocalDate startDate, Status status, double price) {
		super();
		this.member = member;
		this.book = book;
		this.startDate = startDate;
		this.status = status;
		this.price = price;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Reservation [member=" + member + ", book=" + book + ", startDate=" + startDate + ", status=" + status
				+ ", price=" + price + "]";
	}
	
	
	//default je na cekanju dok bibliotekar ne obradi zahtev
	//onda postaje potvrdjena ili odbijena
	//ako se ne pojavi da preuzme postaje otkazana i neko drugi je moze rezervisati
	//taj clan ne moze narednih 24h da rezervise
	//cena se obracunava prilikom rezervacije po cenovniku i 
	//upisuje se u samu rezervaciju
}
