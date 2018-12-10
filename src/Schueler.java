import java.util.Date;

public class Schueler extends Person {
	
	Schueler(long svnr, String vorname, String nachname, Date geburtsdatum, String email, Adresse wohnort, int katalognummer, boolean eigenberechtigung, Date eintrifftsdatum){
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
	}
	
		
	private int katalognummer;
	private boolean eigenberechtigung;
	private Date eintrittsdatum;
	
	public  int getKatalognummer() {
		return this.katalognummer;
	}
	
	public boolean isEigenberechtigt() {
		return this.eigenberechtigung;
	}
	public Date getEintrittsdatum() {
		return this.eintrittsdatum;
	}
}
