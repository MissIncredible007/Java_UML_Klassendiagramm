import java.time.LocalDate;

public class Schueler extends Person {
	
	Schueler(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, Adresse wohnort){
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
	}
	
	private int katalognummer;
	private String klassenbezeichnung;
	private boolean klassensprecher = false;
	
	public  int getKatalognummer() {
		return this.katalognummer;
	}
	
	// Eigenberechtigung berechnen
	public boolean isEigenberechtigt() {	
		if(this.getAlter() >= 18) return true;
		else return false;
	}
	
	
	// F�rs Ordnen nach Nachnamen der Sch�ler in der Klasse
	public String getNachname() {
		return super.getNachname();
	}

	public void setKlassensprecher(boolean truefalse) {
		this.klassensprecher = truefalse;
	}
	
	
	
	public boolean getKlassensprecher() {
		return this.klassensprecher;	
	}
		
	
}
