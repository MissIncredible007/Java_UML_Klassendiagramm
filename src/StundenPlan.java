import java.util.TreeSet;
import java.util.TreeMap;
//import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StundenPlan {
	private static final int tagessatz = 6;
	
	//public ArrayList<Belegung> belegungen = new ArrayList<>();
	public Map<Unterrichtstag,StundenPlan.Tagesplan> stundenplan = new TreeMap<Unterrichtstag,Tagesplan>(new TagesVergleich());
	
	public StundenPlan() {
		for(Unterrichtstag ut : Unterrichtstag.values()) {
			this.stundenplan.put(ut, new Tagesplan());
		}
	}
	
	public void addBelegung(Belegung b) {
		this.stundenplan.get(b.getWochentag()).addBelegung(b);
	}
	
	public void makeStundenplan(Belegung b) throws Exception {
		//this.belegungen.add(b);
				//System.out.println("Neue Belegung: "+b.toString());
				Tagesplan tagesplan;
				Unterrichtstag wochentag;
				int fachstunden = b.getUnterrichtsFach().getWochenstunden();
				while(fachstunden >= 1) {
					for(Map.Entry<Unterrichtstag, StundenPlan.Tagesplan> tag : this.getEntrySet()) {
						tagesplan = tag.getValue();
						wochentag = tag.getKey();
						if(!tagesplan.full()) {
							Belegung neu = new Belegung(b,tagesplan.getPlan().size()+1,wochentag);
							//System.out.println("Unterrichtseinheit " + neu.getUnterrichtsEinheit());
							tagesplan.addBelegung(neu);
							b.getUnterrichtsRaum().addBelegung(neu);
							b.getLehrer().addBelegung(neu);
							fachstunden--;
							break;
						}
						else {
							
						}
					}
				}
				
	}
				
//		Tagesplan tagesplan;
//		Unterrichtstag wochentag;
//		int fachstunden;
//		//for(Belegung b : this.belegungen) {
//		fachstunden = b.getUnterrichtsFach().getWochenstunden();
//			for(Map.Entry<Unterrichtstag, StundenPlan.Tagesplan> tag : this.getEntrySet()) {
//				tagesplan = tag.getValue();
//				wochentag = tag.getKey();
//				System.out.println(wochentag.name()+": ");
//					for(int i= 0; tagesplan.getPlan().size()+1 < tagessatz; i++) {
//						tagesplan.addBelegung(b);
//						fachstunden--;
//						System.out.println(b.toString());
//					}
//				if(fachstunden < 1) break;
//				}
//		//}
//	}
//				System.out.println(wochentag.name()+": ");
//				for(Belegung b : this.belegungen) {
//				fachstunden = b.getUnterrichtsFach().getWochenstunden();
//				for(int i= 0; i<fachstunden; i++) {
//					tagesplan.addBelegung(b);
//					fachstunden--;
//					if (tagesplan.laenge+1 > tagessatz) {
//					break;
//				}
//			}
//		}
//	}

		
		
//		Iterate over alle Wochentage
//		for(Map.Entry<Unterrichtstag, StundenPlan.Tagesplan> tag : this.getEntrySet()) {
//			if(wochenstunden < 1) break;
//			tagesplan = tag.getValue();
//			wochentag = tag.getKey();
//			System.out.println("Tag: "+wochentag.name());
//			
//			// Check whether the Tag schon voll ist oder nicht
//			
//			if (tagesplan.getPlan().size() < tagessatz) {
//				// Iterate over alle tagesstunden
//				for(int i = 0; i<wochenstunden; i++) {
//				tagesplan.addBelegung(new Belegung(b,(tagesplan.getPlan().size()+1)));
//				wochenstunden--;
//				System.out.println("Wochen h "+ wochenstunden+"Tages h "+tagesplan.getPlan().size());
//				if(tagesplan.getPlan().size()>tagessatz) break;
//				}
//			} else {
//				System.out.println(wochentag.name()+" ist voll!");
//				//break;
//			}
//		}
	
	public Map<Unterrichtstag,StundenPlan.Tagesplan> get() {
		return this.stundenplan;
	}
	
	public Set<Entry<Unterrichtstag, StundenPlan.Tagesplan>> getEntrySet() {
		return this.stundenplan.entrySet();
	}
	
	public Fach getFach(int einheit,Unterrichtstag wochentag) throws Exception {
		for(Map.Entry<Unterrichtstag, StundenPlan.Tagesplan> tag : this.getEntrySet()) {
			for(Belegung b : tag.getValue().getPlan()) {
				if(b.getUnterrichtsEinheit() == einheit) {
					return b.getUnterrichtsFach();
				}
			}
		}
		throw new Exception("keinen derartigen Eintrag gefunden!");
	}
	
	
	public class Tagesplan {
		
		public TreeSet<Belegung> belegungsListe = new TreeSet<>(new BelegungsVergleich());
		public int laenge = 0;
		
		public Tagesplan() {
			this.belegungsListe.add(new Belegung());
		}
		
		public boolean full() {
			return (this.belegungsListe.size()+1 > tagessatz);
		}

		public void addBelegung(Belegung b) {
			this.belegungsListe.add(b);
			laenge ++;
		}
		
		public Belegung getBelegung(int Unterrichtseinheit) {
			return null;
		}
		public TreeSet<Belegung> getPlan(){
			return this.belegungsListe;
		}
	}
	
	class TagesVergleich implements Comparator<Unterrichtstag> {
	@Override
	public int compare(Unterrichtstag o1, Unterrichtstag o2) {
		return o1.compareTo(o2);
	}
	}
}


