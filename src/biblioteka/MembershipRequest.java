package biblioteka;

public class MembershipRequest {
	private Member member;
	private Clanarina clanarina;
	private Status status;
	
	enum Status {
		NA_CEKANJU,
		ODOBRENO,
		ODBIJENO
	}
	
	public MembershipRequest(Member member, Clanarina clanarina, Status status) {
		super();
		this.member = member;
		this.clanarina = clanarina;
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Clanarina getClanarina() {
		return clanarina;
	}

	public void setClanarina(Clanarina clanarina) {
		this.clanarina = clanarina;
	}
	
	
}
