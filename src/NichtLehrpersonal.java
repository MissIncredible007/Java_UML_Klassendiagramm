import java.time.LocalDate;

public class NichtLehrpersonal extends Mitarbeiter{
	
	private String beschaeftigung;
	
	public NichtLehrpersonal(String vorname, String nachname, long svnr, LocalDate gebdat, String email, Adresse wohnort, String beschaeftigung) {
		super(vorname, nachname,  gebdat, svnr, email, wohnort);
		this.beschaeftigung = beschaeftigung;
		System.out.println(this.getVorname()+" ist ein nicht-lehrender Angestellter!");
	}
	
	public String getBeschaeftigung(){
		return this.beschaeftigung;
	}
}
