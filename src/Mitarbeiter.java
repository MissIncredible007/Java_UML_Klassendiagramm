import java.time.LocalDate;

public abstract class Mitarbeiter extends Person {
	
	private static int anzahl = 0;
	
	public Mitarbeiter(String vorname, String nachname, LocalDate geburtsdatum, long svnr, String email, Adresse wohnort) {
		super(vorname, nachname, geburtsdatum, svnr, email, wohnort);
		Mitarbeiter.anzahl++;
	}
	
	public int getAnzahl() {
		return Mitarbeiter.anzahl;
	}
}
