import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
	private long svnr;
	private String vorname;
	protected String nachname;
	private LocalDate geburtsdatum;
	private String email;
	private Adresse wohnort;
	
	public Person(String vorname, String nachname, LocalDate geburtsdatum, long svnr, String email, Adresse wohnort) {
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
	
	public String getName(){
		return this.vorname+" "+this.nachname;
	}
	
	public LocalDate getGeburtsdatum() {
		return this.geburtsdatum;
	}
	
	public String getEmail() {
		return this.email;
	}

	public Adresse getWohnort() {
		return wohnort;
	}
	
	public int getAlter() {
		Period y = Period.between(this.geburtsdatum,LocalDate.now());
		return y.getYears();
	}
	
	public void printWohnort() {
		this.wohnort.printAdresse();
	}

}
