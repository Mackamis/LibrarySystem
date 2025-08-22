package biblioteka;

import java.time.LocalTime;

public class Bibliotekar extends Person {
	private String nivoStrucneSpreme;
	private int godineStaz;
	private double plata;
	
	public Bibliotekar(String name, String lName, Gender gender, LocalTime birthDate, String number, String adress,
			String username, String pass, String nivoStrucneSpreme, int godineStaz, double plata) {
		super(name, lName, gender, birthDate, number, adress, username, pass);
		this.nivoStrucneSpreme = nivoStrucneSpreme;
		this.godineStaz = godineStaz;
		this.plata = plata;
	}
	
	public void plata() {
			//osnova*(koeficijent + 0.004*godine_staza).
	}
	public void register() {
		
	}
	public void newMember() {
		// daje email i to mu je username
	}
	
	public void manageReservation() {
		//moze odbiti (status odbijena na knjigu
		//prilikom potvrdjivanja
		//da li postoji bar jedna slobodna knjiga za dati datum
		//prikazati gresku ako ne postoji
		//ako rezervacija nije prihvacena do datuma njenog pocetka automatski odbiti(istekao datum)
		
	}
	public void giveBook() {
		//odabir slobodne knjige
		//status knjige mora biti dostupna
		//moze dodeliti dodatne usluge ako mu clan zatrazi(a on operisan)
		//naplacuju dodatne usluge po cenovniku
		//dodeljuje knjigu rezervaciji
		//status knjige ide na izdata
	}
	public void returnBook() {
		//status knjige na dostpuna
		//ako kasni ovde mu se naplati
	}
	public void handleMembership() {
		//ako korisnik ima vise od 5 kazni zahtev odbijen
	}
	public void reportReservations() {
		
	}
	public void reportBooks() {
		
	}
	public String getNivoStrucneSpreme() {
		return nivoStrucneSpreme;
	}
	public void setNivoStrucneSpreme(String nivoStrucneSpreme) {
		this.nivoStrucneSpreme = nivoStrucneSpreme;
	}
	public int getGodineStaz() {
		return godineStaz;
	}
	public void setGodineStaz(int godineStaz) {
		this.godineStaz = godineStaz;
	}
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	}
