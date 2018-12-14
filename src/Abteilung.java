import java.util.ArrayList;
import java.util.List;

public class Abteilung {
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
			alleSchueler.add(k.getSchueler());
		}
		return alleSchueler;
	}

	public List<Klasse> getKlassen() {
		return klassen;
	}
}
