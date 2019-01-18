import java.util.HashMap;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Raum {
		
	private String raumNummer;
	private int maxSitzplaetze;
	private Raumtyp raumtyp;
	//private Belegung belegung;
	private StundenPlan stundenplan = new StundenPlan();
	
	public Raum (String raumnr, int plaetze, Raumtyp art) {
		this.raumNummer = raumnr;
		this.maxSitzplaetze = plaetze;
		this.raumtyp = art;
	}
	
	public String getRaumNummer() {
		return this.raumNummer;
	}
	
	public static String randomRaumNummer() {
		StringBuilder nr = new StringBuilder();
		Integer random;
		int i;
		for(i = 0; i<2; i++) {
			random = ThreadLocalRandom.current().nextInt('A','J');
			nr.append((char)(random.intValue()));
		}
		for(i = 0; i<1; i++) {
			random = ThreadLocalRandom.current().nextInt(0,4);
			nr.append(random.intValue());
		}
		for(i = 0; i<2; i++) {
			random = ThreadLocalRandom.current().nextInt(0,9);
			nr.append(random.intValue());
		}
		//System.out.println("Raumnummer \""+nr.toString()+"\" generiert!");
		return nr.toString();
	}
	
	public void addBelegung(Belegung b) {
		this.stundenplan.addBelegung(b);
		//System.out.println("Belegung von "+this.getRaumNummer()+": "+b.toString());
	}
	
	public void exportBelegung() {
		for(HashMap.Entry<Unterrichtstag, StundenPlan.Tagesplan> tag : this.stundenplan.getEntrySet()) {
			System.out.print("\n\n"+tag.getKey()+": ");
			//System.out.println(tag.getValue().belegungsListe.toString());
			int i = 0;
			for(Belegung b : tag.getValue().belegungsListe) {
				System.out.print(b.toString());
				i++;
			}
		}
	}
	
	public int getMaxSitzplaetze() {
		return this.maxSitzplaetze;
	}
	public Raumtyp getRaumtyp() {
		return this.raumtyp;
	}

	public static TreeSet<Raum> generateRaeume(TreeSet<Lehrer> lehrer) {
		TreeSet<Raum> raeume = new TreeSet<>(new RaumVergleich());
		String nr;
		for(Lehrer l : lehrer) {
			System.out.println("Lehrer: "+l.getName());
			for(Fach f : l.getFaecher()) {
				nr = Raum.randomRaumNummer();
				raeume.add(new Raum(nr, 36,f.getRaumanforderung()));
				System.out.println("Für das Fach: "+f.getName()+" bekommt er: "+nr+" ("+f.getRaumanforderung().name().toLowerCase()+")");
			}
		}
		return raeume;
			
	}

	public static Raum getRandomRaum(Raumtyp anforderung) throws Exception {
			TreeSet<Raum> passendeRaeume = new TreeSet<>(new RaumVergleich());
			Raum raum1 = null;
			int randomRaum, i = 0;
			System.out.println("Passende Räume: ");
			for(Raum r : HTL.htlstp.getRaeume()) {
				if(anforderung == r.getRaumtyp()) {
					//System.out.print("Anford.:"+fach1.getRaumanforderung().name()+" Raum: "+r.getRaumtyp().name()+" ");
					passendeRaeume.add(r);
					System.out.println(r.getRaumNummer());
				}
			}
			
			if(passendeRaeume.size() >= 1) randomRaum = ThreadLocalRandom.current().nextInt(0,passendeRaeume.size());
			else throw new Exception("Fach hat keinen passenden Raum!");
			
			for(Raum r : passendeRaeume) {
				if(i == randomRaum) {
					raum1 = r;
					i = 0;
					System.out.println("Genommen: "+r.getRaumNummer());
					break;
				}
				i++;
			}
			return raum1;
	}
	
}
