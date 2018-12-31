import java.util.Comparator;

public 	class AbteilungsVergleich implements Comparator<Schule.Abteilung>{
	 
    public int compare(Schule.Abteilung a1, Schule.Abteilung a2) {
        return a1.getKuerzel().compareTo(a2.getKuerzel());
    }
}
