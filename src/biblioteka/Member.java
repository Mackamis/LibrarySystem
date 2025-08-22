package biblioteka;


import biblioteka.Clanarina.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Member extends Person{
	private Kategorija kategorija;
	private Clanarina clanarina;
	private LocalDateTime penaltyUntil;
	
	enum Kategorija{
		DETE,
		UCENIK,
		STUDENT,
		PENZIONER
	}
	
	public Member(String name, String lName, Gender gender, LocalTime birthDate, String number, String adress,
			String username, String pass, Kategorija kategorija, Clanarina clanarina, LocalDateTime penaltyUntil) {
		super(name, lName, gender, birthDate, number, adress, username, pass);
		this.kategorija = kategorija;
		this.clanarina = clanarina;
		this.penaltyUntil = penaltyUntil;
	}
	
	
//	public void browseBooks(String title) {
//		//trazi za odredjen datum
//		//trazi po naslovu knjige
//		//ako postoji moze traziti rezervaciju
//		//moze traziti za sutra ili odredjen datum
//	}
	public boolean reservation(Book book, LocalDate date, boolean isPriorityPreuzimanje, boolean isPriorityVracanje, boolean isExtendedRok, int days, ArrayList<Reservation> rezervacije) {
		double price = 0;
		Cenovnik cenovnik = new Cenovnik();
		//mozda treba dodati verifikaciju datuma cena
		//funkcija validDate() koja proverava da li je trenutni datum validan
		//sta ako nije?
		//npr ako datum nije validan dati poslednju cenu?
		if (isPriorityPreuzimanje) {
			price += cenovnik.getCeneZaPrioritetnoPreuzimanje().getPrice();
		}
		if (isPriorityVracanje) {
			price += cenovnik.getCeneZaPrioritetnoVracanje().getPrice();
		}
		if (isExtendedRok) {
			price += cenovnik.getCeneZaProduzavanjeRokaPoDanu().getPrice() * days;
		}
		if (this.getKategorija() == Kategorija.DETE) {
			price *= 1 - cenovnik.getPopustZaDecu();
		} else if (this.getKategorija() == Kategorija.UCENIK) {
			price *= 1 - cenovnik.getPopustZaUcenike();
		} else if (this.getKategorija() == Kategorija.STUDENT) {
			price *= 1- cenovnik.getPopustZaStudente();
		} else if (this.getKategorija() == Kategorija.PENZIONER) {
			price *= 1 - cenovnik.getPopustZaPenzionere();
		}
		Reservation reservation = new Reservation(this, book, LocalDate.now(), price);
		rezervacije.add(reservation);
		//sad bibliotekar treba da potvrdi rezervaciju
		return true;
	}
	public void requestForMembership(Type tip, ArrayList<MembershipRequest> requests) {
		Clanarina clanarina = new Clanarina(tip, Clanarina.Status.INACTIVE, null, null);
		MembershipRequest request = new MembershipRequest(this, clanarina, MembershipRequest.Status.NA_CEKANJU);
		requests.add(request);
		//bibliotekar treba da odobri ili odbije zahtev
	}
	public void report() {
		//moze da vidi rezervacije i njihov status
		//dodatni troskovi(kazne i produzavanje)
	}
	public boolean cancelReservation(Reservation reservationChoosen) {
		reservationChoosen.setStatus(Reservation.Status.OTKAZANA);
		this.penaltyUntil = LocalDateTime.now().plusHours(24);
		JOptionPane.showMessageDialog(null, "Rezervacija je otkazana. Nemate pravo na novu rezervaciju naredna 24h.");
		return true;
		//ako otkaze nema pravo na drugu rezervaciju naredna 24h
		//postavlja se status otkazana na reszevaciju
		
	}
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	public Clanarina getClanarina() {
		return clanarina;
	}
	public void setClanarina(Clanarina clanarina) {
		this.clanarina = clanarina;
	}
	public LocalDateTime getPenaltyUntil() {
		return penaltyUntil;
	}
	public void setPenaltyUntil(LocalDateTime penaltyUntil) {
		this.penaltyUntil = penaltyUntil;
	}

	
	
}
