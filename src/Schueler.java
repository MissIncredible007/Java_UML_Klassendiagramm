import java.time.LocalDate;

public class Schueler extends Person {
	
	Schueler(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, Adresse wohnort, int katalognummer, boolean eigenberechtigung, LocalDate eintrittsdatum, String klassenbezeichnung, boolean klassensprecher){
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
	}
	
	
		
	private int katalognummer;
	private boolean eigenberechtigung;
	private LocalDate eintrittsdatum;
	private String klassenbezeichnung;
	private boolean klassensprecher;
	
	public  int getKatalognummer() {
		return this.katalognummer;
	}
	
	public boolean isEigenberechtigt() {
		return this.eigenberechtigung;
	}
	public LocalDate getEintrittsdatum() {
		return this.eintrittsdatum;
	}
	public 
}
