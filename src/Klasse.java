import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Klasse {

	private String bezeichnung;
	private int schulstufe;
	TreeSet<Schueler> schuelerListe = new TreeSet<>(new NamenVergleich());
	
	Klasse(int schulstufe, String bezeichnung){
		this.bezeichnung = bezeichnung;
		this.schulstufe = schulstufe;
	}
		
	
	
	public String getBezeichnung(){
		return this.bezeichnung;
	}
	public int getSchulstufe() {
		return this.schulstufe;
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
			return true;
			
		} else return false;			
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
					return true;
				}
				i++;
			}
		}
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
	
	public void exportStundenplan() {
		
	}
	
	public TreeSet<Schueler> getSchueler() {
		return this.schuelerListe;
	}


}
