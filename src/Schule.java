import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Schule {
	private String name;
	private Long schulkennzahl;
	private String schultyp;
	private Lehrer Direktor;
	private TreeSet<Abteilung> abteilungen = new TreeSet<>(new AbteilungsVergleich());
		
	public Schule(String name, Long schkz, String schultyp) {
		this.name = name;
		this.schulkennzahl = schkz;
		this.schultyp = schultyp;
	}
	
	public Schule(String name, Long schkz, TreeSet<Abteilung> abteilungen) {
		this.name = name;
		this.schulkennzahl = schkz;
		for(Abteilung a : abteilungen) {
			this.addAbteilung(a.name, a.kuerzel);
		}
	}
	
	public ArrayList<Schueler> getSchueler() {
		ArrayList<Schueler> alleSchueler = new ArrayList<>();
		for (Abteilung a : getAbteilungen()) {
			alleSchueler.addAll(a.getSchueler());
		}
		return alleSchueler;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public Long getKennzahl() {
		return this.schulkennzahl;
	}
	
	public void setDirektor(Lehrer neuerDirektor) throws Exception {
		// Check, ob er schon Abteilungsvorstand ist
		// Exception oder else ist oke, nichts nicht
		
		for(Abteilung a : this.getAbteilungen()) {
			try {
				if (a.getAbteilungsvorstand() == Direktor) {
					throw new Exception("Lehrer ist bereits AV in "+a.getName());
				}
			
			} catch (Exception e) {/*System.out.println(e); ignore Exception*/}
		}
		this.Direktor = neuerDirektor;
		System.out.println("Direktor erfolgreich gewählt");
	}
	
	public Lehrer getDirektor() throws Exception{
		if(this.Direktor == null) throw new Exception("Noch kein Direktor gewaehlt!");
		else return this.Direktor;
	}

	public void addAbteilung(String name, String kuerzel) {
		Abteilung neueAbteilung = new Abteilung(name, kuerzel);
		this.getAbteilungen().add(neueAbteilung);
		//return neueAbteilung;
	}
	
	public Abteilung getAbteilung(String kuerzel) throws Exception {
		for(Abteilung a : this.getAbteilungen()) {
			if(a.getKuerzel().equals(kuerzel)) return a;
		}
		throw new Exception("Abteilung nicht gefunden!");
		
	}
		
	public TreeSet<Abteilung> getAbteilungen() {
		return abteilungen;
	}
	
	public TreeSet<Lehrer> getLehrer() {
		TreeSet<Lehrer> alleLehrer = new TreeSet<>(new NamenVergleich());
		for(Abteilung a : this.abteilungen) {
			alleLehrer.addAll(a.getLehrer());
		}
		return alleLehrer;
	}


	public String getSchultyp() {
		return schultyp;
	}

	
	class Abteilung {
		private String kuerzel;
		private String name;
		private Lehrer Abteilungsvorstand;
		private Schueler Abteilungssprecher;
		private TreeSet<Klasse> klassen = new TreeSet<>(new SchulstufenVergleich());
		private TreeSet<Lehrer> lehrer = new TreeSet<>(new NamenVergleich());
		
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
		
		public ArrayList<Schueler> getSchueler() {
			ArrayList<Schueler> alleSchueler = new ArrayList<>();
			for (Klasse k : klassen) {
				alleSchueler.addAll(k.getSchueler());
			}
			return alleSchueler;
		}

		public Klasse addKlasse (Klasse k) {
			this.klassen.add(k);
			return k;
		}
		
		public TreeSet<Klasse> getKlassen() {
			return this.klassen;
		}

		public void addLehrer(Lehrer neuerLehrer) throws Exception {
			String lehrerKuerzel = generateLehrerKuerzel(neuerLehrer);
			neuerLehrer.setKuerzel(lehrerKuerzel);
			this.lehrer.add(neuerLehrer);		
		}
		
		private String generateLehrerKuerzel(Lehrer neuerLehrer) {
			String lehrerKuerzel;
			boolean ok = false;
			lehrerKuerzel = neuerLehrer.getNachname().substring(0, 2).toUpperCase()+neuerLehrer.getVorname().substring(0, 2).toUpperCase();
			int i = 0;
			if (this.lehrer.size() > 0) {
				do {
					for(Lehrer l : this.lehrer) {
						if (l.getKuerzel().equals(lehrerKuerzel)) {
							i++;
							ok = false;System.out.println("always true");
							lehrerKuerzel = neuerLehrer.getNachname().substring(0, 2).toUpperCase()+neuerLehrer.getVorname().substring(0+i, 2+i).toUpperCase();
						}
						else {
							ok = true;
						}
					}
				} while(!ok);	
			}
			return lehrerKuerzel;
		}

		public boolean containsSchueler(Schueler s1) {
			for(Schueler s : this.getSchueler()){
				if (s == s1) return true;
			}
			return false;
		}
		
		public boolean containsLehrer(Lehrer l1) {
			for(Lehrer l : this.lehrer){
				if (l == l1) return true;
			}
			return false;
		}
		
		public Lehrer getAbteilungsvorstand() throws Exception {
			if(this.Abteilungsvorstand == null) throw new Exception("Kein AV gewaehlt");
			else return Abteilungsvorstand;
		}
		
		public void setAbteilungsvorstand(Lehrer neuerAV, Lehrer direktor) throws Exception {
			 if (neuerAV.equals(direktor)) {
				 throw new Exception("Der Direktor kann kein Abteilungsvorstand werden!");
			 }
			 else {
				 if(this.containsLehrer(neuerAV)) {
					 this.Abteilungsvorstand = neuerAV;
					 System.out.println("Abteilungsvorstand "+neuerAV.getName()+" erfolgreich für "+this.getKuerzel()+" gewählt!");
				 }
				 else throw new Exception("Der AV muss Lehrer dieser Abteilung sein");
			 }
		}
		
		public void setAbteilungssprecher(Schueler s) throws Exception{
			if (this.containsSchueler(s)){
				this.Abteilungssprecher = s;
				System.out.println("Abteilungssprecher "+s.getName()+" erfolgreich für "+this.getKuerzel()+" gewählt!");
			} else throw new Exception("Schüler "+s.getVorname()+" "+s.getNachname()+" besucht nicht die Abteilung "+this.getKuerzel()+"!");
		}
		
		class SchulstufenVergleich implements Comparator<Klasse>{
			 
		    public int compare(Klasse k1, Klasse k2) {
		        return new Integer(k1.getSchulstufe()).compareTo(new Integer(k2.getSchulstufe()));
		    }
		}

		public TreeSet<Lehrer> getLehrer() {
			return this.lehrer;
		}
		
	}
	
}
