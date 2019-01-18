import java.util.HashMap;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Klasse {

	private String bezeichnung;
	private int schulstufe;
	private String name;
	private TreeSet<Schueler> schuelerListe = new TreeSet<>(new NamenVergleich());
	public Lehrer klassenvorstand;
	public Raum stammRaum;
	private TreeSet<Fach> faecher = new TreeSet<Fach>(new FachVergleich());
	private StundenPlan stundenplan = new StundenPlan();
	private HashMap<Fach, Lehrer> lehrerZuweisung = new HashMap<>();
	
	Klasse(int schulstufe, String bezeichnung, Lehrer kv, Raum stammRaum){
		this.bezeichnung = bezeichnung;
		this.schulstufe = schulstufe;
		this.name = schulstufe+bezeichnung;
		this.klassenvorstand = kv;
		this.stammRaum = stammRaum;
		HTL.htlstp.addRaum(stammRaum);
		kv.makeKlassenvorstand(this);
		System.out.println("Klasse "+this.getName()+" ("+stammRaum.getRaumNummer()+") erstellt! - Klassenvorstand ist "+kv.getName());
	}
	
	
	public String getBezeichnung(){
		return this.bezeichnung;
	}
	
	public int getSchulstufe() {
		return this.schulstufe;
	}
	
	public String getName() {
		return this.name;
	}

	public float getDurchschnittsalter() {
		float summe = 0;
		for(Schueler S : schuelerListe) {
			summe += S.getAlter();
		}
		return summe / schuelerListe.size();
	}
	
	public boolean addSchueler(Schueler schueler){
		
		if(this.schuelerListe.size() <= 36) {
			this.schuelerListe.add(schueler);
			// Klassenbezeichnung setzen
			schueler.setKlassenbezeichnung(this.bezeichnung);
			schueler.setSchulstufe(this.schulstufe);
			// alle Katalognummern neu vergeben
			int i = 0;
			for(Schueler S : this.schuelerListe) {
				i++;
				S.setKatalognummer(i);
			}
			System.out.println("Schüler "+schueler.getName()+" zur Klasse "+this.getName()+" hinzugefügt!");
			return true;
			
		} else {
			System.out.println("Klasse "+this.getName()+" voll - Schüler nicht hinzugefügt!");
			return false;			
		}
	}
	
	public boolean setKlassensprecher() {
		// Ob es schon einen gibt
		try {
			this.getKlassensprecher();
		} catch (Exception e) { // Nur wenn es noch keinen Klassensprecher gibt, waehlen
			int i=0, random = ThreadLocalRandom.current().nextInt(0, schuelerListe.size());
			//System.out.println("rand: "+random);
			for(Schueler S : this.schuelerListe) {
				//System.out.println("i: "+i);
				if(i == random) {
					S.setKlassensprecher(true);
					System.out.println(S.getName()+" wurde als Klassensprecher der "+this.getName()+" gewählt!");
					return true;
				}
				i++;
			}
		}
		System.out.println("Es gibt bereits einen Klassensprecher!");
		return false;
	}
	
	public Schueler getKlassensprecher() throws Exception {
		for (Schueler S : this.schuelerListe) {
			if(S.getKlassensprecher()) {
				return S;
			}
		}
		throw new Exception("Kein Klassensprecher gewaehlt!");
	}
	
	public Lehrer getKlassenvorstand() {
			return this.klassenvorstand; 
	}
	
	public void setBelegung(Fach fach1) throws Exception {
		
		System.out.println("Belegung für Fach "+fach1.getName());
		Lehrer lehrer1 = this.lehrerZuweisung.get(fach1);
		Raum raum1;
		
		if(fach1.getRaumanforderung() == Raumtyp.KLASSENZIMMER) {
			raum1 = this.stammRaum;
		} else {
			raum1 = Raum.getRandomRaum(fach1.getRaumanforderung());		
		}
		
		if(raum1 == null) throw new Exception("Fach-Raum Zuweisungsfehler!");
		
		this.stundenplan.makeStundenplan(new Belegung(raum1, fach1, lehrer1, this));
	}
	
	public void exportStundenplan() throws Exception {
		//this.stundenplan.exportStundenplan(this);
		for(HashMap.Entry<Unterrichtstag, StundenPlan.Tagesplan> tag : this.stundenplan.getEntrySet()) {
			System.out.print("\n"+tag.getKey()+": ");
			//System.out.println(tag.getValue().belegungsListe.toString());
			int i = 0;
			for(Belegung b : tag.getValue().belegungsListe) {
				System.out.print(b.toString());
				i++;
			}
		}
	}
	
	public TreeSet<Schueler> getSchueler() {
		return this.schuelerListe;
	}
	
	public boolean setKlassenvorstand(Lehrer l) {
		if(this.klassenvorstand != null) {
			return false;
		} else {
			this.klassenvorstand = l;
			return true;
		}
		
	}
	
	public boolean addFach(Fach f) {
		Lehrer lehrer1 = null;
		
		System.out.print("Lehrer für diese Klasse: ");
		int random = ThreadLocalRandom.current().nextInt(0,f.getLehrer().size()), i = 0;
		
		for(Lehrer l : f.getLehrer()) {
			if (i==random) {
				lehrer1 = l;
			}
			i++;
		}
		
		this.faecher.add(f);
		
		if(lehrer1 == null) {
			System.out.println("Kein Lehrer!");
			return false;
		} else {
			this.lehrerZuweisung.put(f,lehrer1);
			System.out.println("Die "+this.getName()+" bekommt "+lehrer1.getName()+" in "+f.getName());
		}
		
		f.addKlasse(this);
		
		try {
			setBelegung(f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}
	
	public void removeFach(Fach f) {
		this.faecher.remove(f);
		f.removeKlasse(this);
	}
	
	public TreeSet<Fach> getFaecher() throws Exception{
		if (this.faecher != null)
		return this.faecher;
		else throw new Exception("Klasse "+this.getName()+" hat noch keine Fächer!");
	}


	public HashMap<Fach, Lehrer> getLehrerZuweisung() {
		return lehrerZuweisung;
	}


	public void setLehrerZuweisung(HashMap<Fach, Lehrer> lehrerZuweisung) {
		this.lehrerZuweisung = lehrerZuweisung;
	}
	
}
