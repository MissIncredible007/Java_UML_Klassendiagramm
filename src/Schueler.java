
public class Schueler extends Person {
	
<<<<<<< HEAD
	private int katalognummer;
	private boolean eigenberechtigung;
	private LocalDate eintrittsdatum;

	Schueler(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, Adresse wohnort, int katalognummer, boolean eigenberechtigung, LocalDate eintrittsdatum){
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
	}
		
=======
	Schueler(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, Adresse wohnort, int katalognummer, boolean eigenberechtigung, LocalDate eintrittsdatum, String klassenbezeichnung, boolean klassensprecher){
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
	}
	
	
		
	private int katalognummer;
	private boolean eigenberechtigung;
	private LocalDate eintrittsdatum;
	private String klassenbezeichnung;
	private boolean klassensprecher;
	
>>>>>>> master
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
