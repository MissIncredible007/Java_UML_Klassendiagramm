import java.util.ArrayList;
import java.util.List;

public class Klasse {

	private String bezeichnung;
	private int schulstufe;
	
	List<Schueler> schuelerliste  = new ArrayList<>();
	
<<<<<<< HEAD
=======
	
	
>>>>>>> master
	public String getBezeichnung(){
		return this.bezeichnung;
	}
	public int getSchulstufe() {
		return this.schulstufe;
	}
	public float getDurchschnittsalter() {
		int summe = 0;
		for(Schueler S : schuelerliste) {
			summe += S.getAlter();
		}
		return summe / schuelerliste.size();
	}
	
	public boolean setKlassensprecher(Schueler schueler) {
		
	}
	
	public boolean addSchueler(Schueler schueler){
		if(this.schuelerliste.size() <= 36) {
			this.schuelerliste.add(schueler);
			return true;
		}
		else {
			return false;
		}
				
	}
	public void exportStundenplan() {
		
		
	}
	
	//Verbindungen
	public List<Schueler> getSchueler() {
		return this.schuelerliste;
	}


}
