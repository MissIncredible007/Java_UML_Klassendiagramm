import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Klasse {

	private String bezeichnung;
	private int schulstufe;
	
	Klasse(String bezeichnung, int schulstufe){
		this.bezeichnung = bezeichnung;
		this.schulstufe = schulstufe;
	}
	
	
	TreeSet<Schueler> schuelerListe = new TreeSet<Schueler>(new NachnameVergleich());
	
	class NachnameVergleich implements Comparator<Schueler>{
		 
	    public int compare(Schueler e1, Schueler e2) {
	        return e1.getNachname().compareTo(e2.getNachname());
	    }
	}
	
	
	public String getBezeichnung(){
		return this.bezeichnung;
	}
	public int getSchulstufe() {
		return this.schulstufe;
	}
	
	
	
	
	public float getDurchschnittsalter() {
		int summe = 0;
		for(Schueler S : schuelerListe) {
			summe += S.getAlter();
		}
		return summe / schuelerListe.size();
	}
	
	
	
	public boolean addSchueler(Schueler schueler){
		if(this.schuelerListe.size() <= 36) {
			this.schuelerListe.add(schueler);
			return true;
		}
		else {
			return false;
		}			
	}
	
	
	public boolean setKlassensprecher() {
		// Ob es schon einen gibt
		if(this.getKlassensprecher() != null) return false;
		
		int i=0, random = ThreadLocalRandom.current().nextInt(0, schuelerListe.size() + 1);
		for(Schueler S : this.schuelerListe) {
			if(i == random) {
				S.setKlassensprecher(true);
				return true;
			}
			i++;
		}
		return false;
	}
	
	public Schueler getKlassensprecher() {
		for (Schueler S : this.schuelerListe) {
			if(S.getKlassensprecher()) {
				return S;
			}
		}
		return null;
	}
	
	
	public void exportStundenplan() {
		
		
	}
	
	//Verbindungen
	public TreeSet<Schueler> getSchueler() {
		return this.schuelerListe;
	}


}
