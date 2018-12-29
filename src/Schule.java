import java.util.ArrayList;
import java.util.List;

public class Schule {
	private String name;
	private Long schulkennzahl;
	public List<Abteilung> abteilungen = new ArrayList<>();
	
	public Schule(String name, Long schkz) {
		this.name = name;
		this.schulkennzahl = schkz;
	}
	
	public Schule(String name, Long schkz, List<Abteilung> abteilungen) {
		this.name = name;
		this.schulkennzahl = schkz;
		for(Abteilung a : abteilungen) {
			this.addAbteilung(a.name, a.kuerzel);
		}
	}
	
	public List<Schueler> getSchueler() {
		List<Schueler> alleSchueler = new ArrayList<>();
		for (Abteilung a : abteilungen) {
			alleSchueler.addAll(a.getSchueler());
		}
		return alleSchueler;
		
	}

	public void addAbteilung(String name, String kuerzel) {
		Abteilung neueAbteilung = new Abteilung(name, kuerzel);
		this.abteilungen.add(neueAbteilung);
		//return neueAbteilung;
	}
		
	private class Abteilung {
		private String kuerzel;
		private String name;
		private List<Klasse> klassen = new ArrayList<>();
		
		public Abteilung(String name, String kuerzel) {
			this.name = name;
			this.kuerzel = kuerzel;	
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getKuerzel() {
			return this.kuerzel;
		}
		
		public List<Schueler> getSchueler() {
			List<Schueler> alleSchueler = new ArrayList<>();
			for (Klasse k : klassen) {
				alleSchueler.addAll(k.getSchueler());
			}
			return alleSchueler;
		}

		public List<Klasse> getKlassen() {
			return klassen;
		}
	}

}
