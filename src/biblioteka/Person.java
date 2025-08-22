package biblioteka;

import java.time.LocalTime;

public abstract class Person {
	private String name;
	private String lName;
	private Gender gender;
	private LocalTime birthDate;
	private String number;
	private String adress;
	private String username;
	private String pass;
	
	enum Gender {
		MUSKO,
		ZENSKO,
		OSTALO
	}
	
	
	public Person(String name, String lName, Gender gender, LocalTime birthDate, String number, String adress,
			String username, String pass) {
		super();
		this.name = name;
		this.lName = lName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.number = number;
		this.adress = adress;
		this.username = username;
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalTime birthDate) {
		this.birthDate = birthDate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
