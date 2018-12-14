import java.util.ArrayList;
import java.util.List;

public class Schule {
	private List<Abteilung> abteilungen = new ArrayList<>();
	
	public List<Schueler> getSchueler() {
		List<Schueler> alleSchueler = new ArrayList<>();
		for (Abteilung a : abteilungen) {
			for(Klasse k : a.getKlassen()) {
				alleSchueler.add(k.getSchueler());	
			}
		}
		return alleSchueler;
		
	}
}
