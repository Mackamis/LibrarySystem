package biblioteka;

import java.time.LocalDate;

public class Cena {
	private double price;
	private LocalDate startDate;
	private LocalDate endDate;
	public Cena(double price, LocalDate startDate, LocalDate endDate) {
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
