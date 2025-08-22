package biblioteka;

import java.time.LocalTime;

public class Admin extends Person{
	private String nivoStrucneSpreme;
	private int godineStaz;
	private double plata;
	
	public Admin(String name, String lName, Gender gender, LocalTime birthDate, String number, String adress,
			String username, String pass, String nivoStrucneSpreme, int godineStaz, double plata) {
		super(name, lName, gender, birthDate, number, adress, username, pass);
		this.nivoStrucneSpreme = nivoStrucneSpreme;
		this.godineStaz = godineStaz;
		this.plata = plata;
	}
	
	public void plata() {
		//osnova*(koeficijent + 0.004*godine_staza).
	}
	//treba implementirati manage za svaki entitet
	public void newEmployee() {
		
	}
	public void reportEmployee() {
		//uvid u podatke, prihode i rashode? za odredjen period
	}
	public void bookLendTime() {
		//moze da menja kolko traje najam knjige
		//default 7 dana
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
