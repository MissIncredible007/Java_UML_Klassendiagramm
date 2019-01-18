import java.time.LocalDate;

public class Schueler extends Person {
	
	//private int katalognummer;
	private String klassenbezeichnung;
	private boolean klassensprecher = false;
	private int katalognummer;
	private int schulstufe;
	
	Schueler(String vorname, String nachname, LocalDate geburtsdatum, long svnr, String email, Adresse wohnort){
		super(vorname, nachname, geburtsdatum, svnr, email, wohnort);
		System.out.println(this.getVorname()+" ist Schüler!");
	}
	
	
	public  int getKatalognummer() {
		try {
			HTL.htlstp.getAbteilung("EL");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return this.katalognummer;
		
	}
	
	public void setKatalognummer(int nr) {
		this.katalognummer = nr;
	}
	
	// Eigenberechtigung berechnen
	public boolean isEigenberechtigt() {	
		if(this.getAlter() >= 18) return true;
		else return false;
	}

	public void setKlassensprecher(boolean truefalse) {
		this.klassensprecher = truefalse;
	}
	
	public boolean getKlassensprecher() {
		return this.klassensprecher;	
	}
	
	public void setKlassenbezeichnung(String bezeichnung) {
		this.klassenbezeichnung = bezeichnung;
	}
	
	public String getKlassenbezeichnung() {
		return this.klassenbezeichnung;
	}
	
	public int getSchulstufe() {
		return this.schulstufe;
	}

	public void setSchulstufe(int schulstufe) {
		this.schulstufe = schulstufe;
		
	}
	
	
}
