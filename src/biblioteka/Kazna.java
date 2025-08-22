package biblioteka;

import java.time.LocalDate;

public class Kazna {
	private double iznos;
	private Member member;
	private LocalDate datum;
	private String opis;
	private Status status = Status.NEPLACENO;
	
	enum Status {
		PLACENO,
		NEPLACENO
	}
	
	public Kazna(double iznos, Member member, LocalDate datum, String opis) {
		super();
		this.iznos = iznos;
		this.member = member;
		this.datum = datum;
		this.opis = opis; 
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}