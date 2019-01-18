import java.util.Comparator;

public class RaumVergleich implements Comparator<Raum>{
	public int compare(Raum r1, Raum r2) {
		return r1.getRaumNummer().compareTo(r2.getRaumNummer());
	}
}