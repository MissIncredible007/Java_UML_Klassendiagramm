import java.util.ArrayList;
import java.util.List;

public class Klasse {

	private String bezeichnung;
	private int schulstufe;
	
	List<Schueler> schuelerliste  = new ArrayList<>();
	
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
		return 
	}
	public boolean addSchueler(Schueler schueler){
		return		
				
	}
	public void exportStundenplan() {
		
		
	}
	
	public List<Schueler> getSchueler() {
		return this.schuelerliste;
	}


}
