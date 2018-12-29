import java.time.LocalDate;

public abstract class Mitarbeiter extends Person {
	
	private static int anzahl = 0;
	
	public Mitarbeiter(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, Adresse wohnort) {
		super(svnr, vorname, nachname, geburtsdatum, email, wohnort);
		Mitarbeiter.anzahl++;
	}
	
	public int getAnzahl() {
		return Mitarbeiter.anzahl;
	}
}
