import java.time.LocalDate;

public class Schueler extends Person {
	
	private int katalognummer;
	private boolean eigenberechtigung;
	private LocalDate eintrittsdatum;

	Schueler(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, Adresse wohnort, int katalognummer, boolean eigenberechtigung, LocalDate eintrittsdatum){
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
	}
		
	public  int getKatalognummer() {
		return this.katalognummer;
	}
	
	public boolean isEigenberechtigt() {
		return this.eigenberechtigung;
	}
	public LocalDate getEintrittsdatum() {
		return this.eintrittsdatum;
	}
}
