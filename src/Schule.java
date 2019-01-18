import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Schule {

	private String name;
	private Long schulkennzahl;
	private String schultyp;
	private Lehrer direktor;
	private Schueler schulsprecher;
	private TreeSet<Abteilung> abteilungen = new TreeSet<>(new AbteilungsVergleich());
	private TreeSet<NichtLehrpersonal> personal;
	private TreeSet<Raum> raeume = new TreeSet<>(new RaumVergleich());

	public Schule(String name, Long schkz, String schultyp) {
		this.name = name;
		this.schulkennzahl = schkz;
		this.schultyp = schultyp;
		System.out.println("Schule "+this.getName()+" erstellt!");
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

		for (Abteilung a : this.getAbteilungen()) {
			try {
				if (a.getAbteilungsvorstand() == direktor) {
					throw new Exception("Lehrer ist bereits AV in " + a.getName());
				}

			} catch (Exception e) {
				/* System.out.println(e); ignore Exception */}
		}
		this.direktor = neuerDirektor;
		System.out.println("Direktor "+neuerDirektor.getName()+" erfolgreich gewählt!");
	}

	public Lehrer getDirektor() throws Exception {
		if (this.direktor == null)
			throw new Exception("Noch kein Direktor gewaehlt!");
		else
			return this.direktor;
	}

	public void addAbteilung(String name, String kuerzel) {
		Abteilung neueAbteilung = new Abteilung(name, kuerzel);
		this.getAbteilungen().add(neueAbteilung);
		System.out.println("Abteilung "+neueAbteilung.getKuerzel()+" zu "+this.getName()+" hinzugefügt!");
		}

	public Abteilung getAbteilung(String kuerzel) {
		for (Abteilung a : this.getAbteilungen()) {
			if (a.getKuerzel().equals(kuerzel))
				return a;
		}
		System.out.println("Abteilung nicht gefunden!");
		return null;
	}

	public TreeSet<Abteilung> getAbteilungen() {
		return abteilungen;
	}

	public TreeSet<Lehrer> getLehrer() {
		TreeSet<Lehrer> alleLehrer = new TreeSet<>(new NamenVergleich());
		for (Abteilung a : this.abteilungen) {
			alleLehrer.addAll(a.getLehrer());
		}
		return alleLehrer;
	}

	public void addPersonal(NichtLehrpersonal neuesPersonal) throws Exception {
		this.personal.add(neuesPersonal);
	}
	
	public void addRaum(Raum r) {
		this.raeume.add(r);
	}

	public void removeRaum(Raum r) {
		this.raeume.remove(r);
	}
	
	public TreeSet<NichtLehrpersonal> getPersonal() {
		return this.personal;
	}

	public String getSchultyp() {
		return schultyp;
	}
	
	private String generateLehrerKuerzel(Lehrer neuerLehrer) {
		String lehrerKuerzel;
		boolean ok = false;
		lehrerKuerzel = neuerLehrer.getNachname().substring(0, 2).toUpperCase()
				+ neuerLehrer.getVorname().substring(0, 2).toUpperCase();
		int i = 0;
		TreeSet<Lehrer> lehrer = this.getLehrer();
		if (lehrer.size() > 0) {
			do {
				for (Lehrer l : lehrer) {
					if (l.getKuerzel().equals(lehrerKuerzel)) {
						i++;
						ok = false;
						System.out.println("Lehrerkürzel angepasst!");
						lehrerKuerzel = neuerLehrer.getNachname().substring(0, 2).toUpperCase()
								+ neuerLehrer.getVorname().substring(0 + i, 2 + i).toUpperCase();
					} else {
						ok = true;
					}
				}
			} while (!ok);
		}
		System.out.println("Neues Lehrerkürzel \""+lehrerKuerzel+"\" generiert!");
		return lehrerKuerzel;
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

		public Klasse addKlasse(Klasse k) {
			this.klassen.add(k);
			System.out.println("Die Klasse "+k.getName()+" gehört jetzt zu "+this.getKuerzel());
			return k;
		}

		public TreeSet<Klasse> getKlassen() {
			return this.klassen;
		}
		
		public void addLehrer(Lehrer neuerLehrer) {
			String lehrerKuerzel = generateLehrerKuerzel(neuerLehrer);
			neuerLehrer.setKuerzel(lehrerKuerzel);
			this.lehrer.add(neuerLehrer);
		}

		public boolean containsSchueler(Schueler s1) {
			for (Schueler s : this.getSchueler()) {
				if (s == s1)
					return true;
			}
			return false;
		}

		public boolean containsLehrer(Lehrer l1) {
			for (Lehrer l : this.lehrer) {
				if (l == l1)
					return true;
			}
			return false;
		}

		public Lehrer getAbteilungsvorstand() throws Exception {
			if (this.Abteilungsvorstand == null)
				throw new Exception("Kein AV fuer "+this.getKuerzel()+" gewaehlt");
			else
				return Abteilungsvorstand;
		}

		public void setAbteilungsvorstand(Lehrer neuerAV) throws Exception {
			try {
				HTL.htlstp.getDirektor();
			} catch (Exception e) {
				throw(e);
			}
			
			if (neuerAV.equals(HTL.htlstp.getDirektor())) {
				throw new Exception("Der Direktor kann kein Abteilungsvorstand werden!");
			} else {
				if (this.containsLehrer(neuerAV)) {
					this.Abteilungsvorstand = neuerAV;
					System.out.println("Abteilungsvorstand " + neuerAV.getName() + " erfolgreich für "
							+ this.getKuerzel() + " gewählt!");
				} else
					throw new Exception("Der AV muss Lehrer dieser Abteilung sein");
			}
		}

		public void setAbteilungssprecher(Schueler s) throws Exception {
			if (this.containsSchueler(s)) {
				this.Abteilungssprecher = s;
				System.out.println(
						"Abteilungssprecher " + s.getName() + " erfolgreich für " + this.getKuerzel() + " gewählt!");
			} else
				throw new Exception("Schüler " + s.getVorname() + " " + s.getNachname()
						+ " besucht nicht die Abteilung " + this.getKuerzel() + "!");
		}
		
		public Schueler getAbteilungssprecher() {
			return this.Abteilungssprecher;
		}

		class SchulstufenVergleich implements Comparator<Klasse> {

			public int compare(Klasse k1, Klasse k2) {
				return new Integer(k1.getSchulstufe()).compareTo(new Integer(k2.getSchulstufe()));
			}
		}

		public TreeSet<Lehrer> getLehrer() {
			return this.lehrer;
		}

	}
	
	public enum faecher {
		
		DEUTSCH	(new Fach("Deutsch",				2,	Raumtyp.KLASSENZIMMER	)),
		MATHE	(new Fach("Mathe",					3,	Raumtyp.KLASSENZIMMER	)),
		HWE		(new Fach("Hardwareentwicklung",	5,	Raumtyp.KLASSENZIMMER	)),
		FSST	(new Fach("Softwareentwicklung",	9,	Raumtyp.KAFFEEHAUS		));
		
		public Fach fach;
		
		private faecher(Fach f){
			this.fach = f;
		}
		
	}

	public void addRaeume(TreeSet<Raum> gR) {
		this.raeume.addAll(gR);
	}
	
	public TreeSet<Raum> getRaeume() {
//		System.out.println("Räume in htlstp: "+this.raeume.size());
		return this.raeume;
	}

	public Schueler getSchulsprecher() {
		return this.schulsprecher;
	}

	public void setSchulsprecher(Schueler schulsprecher) {
		this.schulsprecher = schulsprecher;
		System.out.println(schulsprecher.getName()+" als Schulsprecher der "+this.getName()+" gewählt!");
	}

}
