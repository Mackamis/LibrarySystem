package biblioteka;

import java.time.LocalDate;

public class Clanarina {
    private Type type;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
	enum Type {
		GODISNJA,
		MESECNA
	}
	enum Status {
		ACTIVE,
		INACTIVE
	}
	public Clanarina(Type type, Status status, LocalDate startDate, LocalDate endDate) {
		super();
		this.type = type;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
