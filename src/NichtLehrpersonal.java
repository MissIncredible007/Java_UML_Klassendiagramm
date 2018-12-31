import java.time.LocalDate;

public class NichtLehrpersonal extends Mitarbeiter{
	
	private String beschaeftigung;
	
	public NichtLehrpersonal(String vorname, String nachname, long svnr, LocalDate gebdat, String email, Adresse wohnort, String beschaeftigung) {
		super(svnr, vorname, nachname, gebdat, email, wohnort);
		this.beschaeftigung = beschaeftigung;
	}
	
	public String getBeschaeftigung(){
		return this.beschaeftigung;
	}
}
