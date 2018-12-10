import java.util.Date;

public class Mitarbeiter extends Person {
	
	private static int anzahl = 0;
	
	public Mitarbeiter(long svnr, String vorname, String nachname, Date geburtsdatum, String email, Adresse wohnort) {
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
		this.anzahl++;
	}
	
	public int getAnzahl() {
		return this.anzahl;
	}
}
