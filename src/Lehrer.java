import java.time.LocalDate;

public class Lehrer extends Mitarbeiter {

	String kuerzel = "NAN";
	
	public Lehrer(String vorname, String nachname, LocalDate geburtsdatum, long svnr, String email, Adresse wohnort) {
		super(vorname, nachname, geburtsdatum, svnr, email, wohnort);
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel=kuerzel;
	}
	
	public String getKuerzel() {
		return this.kuerzel;
	}

}
