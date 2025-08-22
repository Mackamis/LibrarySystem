package biblioteka;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;

public class App {
	private ArrayList<Person> users = new ArrayList<>();
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<MembershipRequest> membershipRequests = new ArrayList<>();
	private ArrayList<Reservation> reservations = new ArrayList<>();
	private ArrayList<Kazna> kazne = new ArrayList<>();

	public App() {
		// terba ubaaciti load i save
		Clanarina testClanarina = new Clanarina(Clanarina.Type.GODISNJA, // type
				Clanarina.Status.ACTIVE, // status
				java.time.LocalDate.now(), // start date
				java.time.LocalDate.now().plusYears(1));
		Member testMember = new Member("Test", "User", Person.Gender.MUSKO, java.time.LocalTime.now(), "123456",
				"Test Address", "testuser", "testpass", Member.Kategorija.STUDENT, testClanarina, null);
		users.add(testMember);
		books.add(new Book("aa", // title
				"F. Scott Fitzgerald", // author
				"Classic", // genre
				2, // numOfReservations
				5, // numOfHandouts
				Book.Status.DOSTUPNA // status
		));
		reservations.add(new Reservation((Member) users.get(0), // member
				books.get(0), // book
				LocalDate.now(), // startDate
				Reservation.Status.NA_CEKANJU, // status
				100.0 // price
		));
		kazne.add(new Kazna(50.0, // iznos
				(Member) users.get(0), // member
				LocalDate.now(), // date
				"Test penalty" // opis
		));
		new LoginfFrame(this);
	}

	public Person login(String username, String password) {
		for (Person person : users) {
			if (person.getUsername().equals(username) && person.getPass().equals(password)) {
				return person;
			}

		}
		return null;
	}

	public void addUser(Person user) {
		users.add(user);
	}

	public ArrayList<MembershipRequest> getMembershipRequests() {
		return membershipRequests;
	}

	public void setMembershipRequests(ArrayList<MembershipRequest> membershipRequests) {
		this.membershipRequests = membershipRequests;
	}

	public ArrayList<Person> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Person> users) {
		this.users = users;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Kazna> getKazne() {
		return kazne;
	}

	public void setKazne(ArrayList<Kazna> kazne) {
		this.kazne = kazne;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public ArrayList<Reservation> getMemberReservations(Member member) {
		ArrayList<Reservation> memberReservations = new ArrayList<>();
		for (Reservation reservation : reservations) {
			if (reservation.getMember().equals(member)) {
				memberReservations.add(reservation);
			}
		}
		return memberReservations;
	}

	public ArrayList<Kazna> getMemberKazne(Member member) {
		ArrayList<Kazna> memberKazne = new ArrayList<>();
		for (Kazna kazna : kazne) {
			if (kazna.getMember().equals(member)) {
				memberKazne.add(kazna);
			}
		}
		return memberKazne;
	}
//	// Method to check for overdue books and generate penalties
//	public void checkOverdueBooks() {
//		LocalDate today = LocalDate.now();
//		for (Reservation reservation : reservations) {
//			// Check if book is overdue (assuming 14 days loan period)
//			if (reservation.getStatus() == Reservation.Status.AKTIVNA && 
//				reservation.getDate().plusDays(14).isBefore(today)) {
//				
//				// Check if penalty already exists for this reservation
//				boolean penaltyExists = false;
//				for (Kazna kazna : kazne) {
//					if (kazna.getOpis().contains("Overdue book: " + reservation.getBook().getTitle())) {
//						penaltyExists = true;
//						break;
//					}
//				}
//				
//				// Generate penalty if doesn't exist
//				if (!penaltyExists) {
//					long daysOverdue = java.time.temporal.ChronoUnit.DAYS.between(
//						reservation.getDate().plusDays(14), today);
//					double penaltyAmount = daysOverdue * 50.0; // 50 per day
//					
//					Kazna penalty = new Kazna(
//						penaltyAmount,
//						reservation.getMember(),
//						today,
//						"Overdue book: " + reservation.getBook().getTitle() + " (" + daysOverdue + " days late)"
//					);
//					kazne.add(penalty);
//				}
//			}
//		}
//	}
//	
//	// Method to get all overdue reservations (for librarian view)
//	public ArrayList<Reservation> getOverdueReservations() {
//		ArrayList<Reservation> overdue = new ArrayList<>();
//		LocalDate today = LocalDate.now();
//		for (Reservation reservation : reservations) {
//			if (reservation.getStatus() == Reservation.Status.AKTIVNA && 
//				reservation.getDate().plusDays(14).isBefore(today)) {
//				overdue.add(reservation);
//			}
//		}
//		return overdue;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new App();
	}

}