import java.util.Date;

public class Person {
	private long svrn;
	private String vorname;
	private String nachname;
	private Date geburtsdatum;
	private String email;
	
	public Person(long svrn, String vorname, String nachname, Date geburtsdatum, String email) {
		this.svrn = svrn;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.email = email;
	}
	
	
	public long getSvnr() {
		return this.svrn;
	}

	public String getVorname() {
		return this.vorname;
	}

	public String getNachname() {
		return this.nachname;
	}
	
	public Date getGeburtsdatum() {
		return this.geburtsdatum;
	}
	
	public String getEmail() {
		return this.email;
	}
}
