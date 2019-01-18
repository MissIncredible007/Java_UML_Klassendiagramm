import java.util.Comparator;
import java.util.TreeSet;

public class Fach {
	
	public static final Fach DEUTSCH	= new Fach("Deutsch",	2,	Raumtyp.KLASSENZIMMER	);
	public static final Fach MATHE		= new Fach("Mathe",		2,	Raumtyp.KLASSENZIMMER	);
	public static final Fach HWE 		= new Fach("HWE",		10,	Raumtyp.LABORRAUM		);
	public static final Fach FSST		= new Fach("FSST",		3,	Raumtyp.KAFFEEHAUS		);
	public static final Fach PHYSIK		= new Fach("Physik",		3,	Raumtyp.LABORRAUM		);
	public static final Fach WIRTSCHAFT	= new Fach("Wirtschaft",		3,	Raumtyp.KLASSENZIMMER	);
	
	
	private String name;
	private int wochenstunden;
	private Raumtyp raumanforderungen;
	private TreeSet<Lehrer> lehrer = new TreeSet<>(new NamenVergleich());
	private TreeSet<Klasse> klassen = new TreeSet<>(new Comparator<Klasse>() {	public int compare(Klasse k1, Klasse k2) { return k1.getName().compareTo(k2.getName());}});
	
	public Fach(String name, int wochenstunden, Raumtyp raumanforderungen) {
		this.name = name;
		this.wochenstunden = wochenstunden;
		this.raumanforderungen = raumanforderungen;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWochenstunden() {
		return this.wochenstunden;
	}
	
	public Raumtyp getRaumanforderung() {
		return raumanforderungen;
	}
	
	public void addLehrer(Lehrer l) {
		this.lehrer.add(l);
		//System.out.print(this.getName()+" wird jetzt von "+l.getName()+" unterrichtet!\n");
	}
	
	public TreeSet<Lehrer> getLehrer(){
		return this.lehrer;
	}
	
	public void addKlasse(Klasse k) {
		this.klassen.add(k);
		System.out.println("Die "+k.getName()+" wird jetzt in "+this.getName()+" von "+k.getLehrerZuweisung().get(this).getName()+" unterrichet!");
	}
	
	public void removeKlasse(Klasse k) {
		this.klassen.remove(k);
		System.out.println("Die "+k.getName()+" wird nicht mehr in "+this.getName()+" unterrichet!");
	}

	public void printLehrer() {
		System.out.print("\n"+this.getName()+" unterrichten: ");
		for(Lehrer l:this.lehrer) {System.out.print(l.getName()+", ");}
		System.out.print("\n");
	}
	
}