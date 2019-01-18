import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeSet;

public class Lehrer extends Mitarbeiter {

	private String kuerzel = "NAN";
	public TreeSet<Fach> faecher = new TreeSet<>(new FachVergleich());
	public Klasse vorstand1;
	public Klasse vorstand2;
	public StundenPlan stundenplan = new StundenPlan();

	public Lehrer(String vorname, String nachname, LocalDate geburtsdatum, long svnr, String email, Adresse wohnort) {
		super(vorname, nachname, geburtsdatum, svnr, email, wohnort);
		System.out.println(this.getVorname()+" ist ein Lehrer!");
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public String getKuerzel() {
		return this.kuerzel;
	}
	
	public boolean makeKlassenvorstand(Klasse k) {
		if(vorstand1 == null) {
			k.setKlassenvorstand(this);
			this.vorstand1 = k;
			return true;
			
		} else if (vorstand2 == null) {
			k.setKlassenvorstand(this);
			this.vorstand2 = k;
			return true;
			
		} else {
			return false;
		}
		
	}
	
	public void addFach(Fach f) {
		this.faecher.add(f);
		System.out.print(this.getName()+" unterrichtet jetzt "+f.getName()+"! ");
		f.addLehrer(this);
	}
	
	public TreeSet<Fach> getFaecher(){
		return this.faecher;
	}
	
	public void addBelegung(Belegung b) {
		this.stundenplan.addBelegung(b);
	}
	
	// Overrides toString
	public String toString(){
		return this.getName()+" ("+this.getKuerzel()+") ist "+this.getAlter()+" Jahre alt und lebt in "+this.getWohnort().getOrt()+", Email: "+this.getEmail()+", SVNR:"+this.getSvnr();
	}

	public void exportStundenplan() {
		for(HashMap.Entry<Unterrichtstag, StundenPlan.Tagesplan> tag : this.stundenplan.getEntrySet()) {
			System.out.print("\n\n"+tag.getKey()+": ");
			//System.out.println(tag.getValue().belegungsListe.toString());
			int i = 0;
			for(Belegung b : tag.getValue().belegungsListe) {
				System.out.print(b.toString());
				i++;
			}
		}		
	}
	
}
