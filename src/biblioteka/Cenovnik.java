package biblioteka;

public class Cenovnik {
	private Cena monthRate = new Cena(1000, null, null);
	private Cena yearRate = new Cena(10000, null, null); 
	private double popustZaDecu = 0.5; 
	private double popustZaStudente = 0.3;
	private double popustZaPenzionere = 0.2; 
	private double popustZaUcenike = 0.1; 
	private Cena ceneZaPrioritetnoPreuzimanje = new Cena(200, null, null);
	private Cena ceneZaPrioritetnoVracanje = new Cena(200, null, null);
	private Cena ceneZaProduzavanjeRokaPoDanu = new Cena(50, null, null);
	private double kazna = 100;
	
	public Cena getMonthRate() {
		return monthRate;
	}
	public void setMonthRate(Cena monthRate) {
		this.monthRate = monthRate;
	}
	public Cena getYearRate() {
		return yearRate;
	}
	public void setYearRate(Cena yearRate) {
		this.yearRate = yearRate;
	}
	public double getPopustZaDecu() {
		return popustZaDecu;
	}
	public void setPopustZaDecu(double popustZaDecu) {
		this.popustZaDecu = popustZaDecu;
	}
	public double getPopustZaStudente() {
		return popustZaStudente;
	}
	public void setPopustZaStudente(double popustZaStudente) {
		this.popustZaStudente = popustZaStudente;
	}
	public double getPopustZaPenzionere() {
		return popustZaPenzionere;
	}
	public void setPopustZaPenzionere(double popustZaPenzionere) {
		this.popustZaPenzionere = popustZaPenzionere;
	}
	public double getPopustZaUcenike() {
		return popustZaUcenike;
	}
	public void setPopustZaUcenike(double popustZaUcenike) {
		this.popustZaUcenike = popustZaUcenike;
	}
	public Cena getCeneZaPrioritetnoPreuzimanje() {
		return ceneZaPrioritetnoPreuzimanje;
	}
	public void setCeneZaPrioritetnoPreuzimanje(Cena ceneZaPrioritetnoPreuzimanje) {
		this.ceneZaPrioritetnoPreuzimanje = ceneZaPrioritetnoPreuzimanje;
	}
	public Cena getCeneZaPrioritetnoVracanje() {
		return ceneZaPrioritetnoVracanje;
	}
	public void setCeneZaPrioritetnoVracanje(Cena ceneZaPrioritetnoVracanje) {
		this.ceneZaPrioritetnoVracanje = ceneZaPrioritetnoVracanje;
	}
	public Cena getCeneZaProduzavanjeRokaPoDanu() {
		return ceneZaProduzavanjeRokaPoDanu;
	}
	public void setCeneZaProduzavanjeRokaPoDanu(Cena ceneZaProduzavanjeRokaPoDanu) {
		this.ceneZaProduzavanjeRokaPoDanu = ceneZaProduzavanjeRokaPoDanu;
	}
	public double getKazna() {
		return kazna;
	}
	public void setKazna(double kazna) {
		this.kazna = kazna;
	}
	
	
	
	
	//svaka cena ima datum pocetka i kraja
	//priority se naplacuje jednokratno
	
}
