import java.util.Date;

public class Person {
	private long svnr;
	private String vorname;
	private String nachname;
	private Date geburtsdatum;
	private String email;
	private Adresse wohnort;
	
	public Person(long svnr, String vorname, String nachname, Date geburtsdatum, String email, Adresse wohnort) {
		this.svnr = svnr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.email = email;
		this.wohnort = wohnort;
	}
	
	
	public long getSvnr() {
		return this.svnr;
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


	public Adresse getWohnort() {
		return wohnort;
	}

}
