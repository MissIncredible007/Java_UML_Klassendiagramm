import java.util.Comparator;

public class FachVergleich implements Comparator<Fach> {
	public int compare(Fach f1, Fach f2) {
		return f1.getName().compareTo(f2.getName());
	}
}