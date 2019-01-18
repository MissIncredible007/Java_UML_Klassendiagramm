
public class Belegung {
		
	private int unterrichtsEinheit = -1;
	private Raum unterrichtsRaum;
	private Fach unterrichtsFach;
	private Lehrer lehrer;
	private Klasse klasse;
	private Unterrichtstag wochentag;

	public Belegung (Raum raum, Fach fach, Lehrer lehrer, Klasse klasse) {
		this.setUnterrichtsRaum(raum);
		this.unterrichtsFach = fach;
		this.lehrer = lehrer;
		this.klasse = klasse;
	}

	public Belegung(Belegung b, int nr, Unterrichtstag wochentag) {
		this.unterrichtsEinheit = 	nr;
		this.unterrichtsRaum = 	b.unterrichtsRaum;
		this.unterrichtsFach = 	b.unterrichtsFach;
		this.lehrer = 			b.lehrer;
		this.klasse = 			b.klasse;
		this.wochentag = 		wochentag;
	}

	public Belegung() {

	}

	public void setWochentag(Unterrichtstag wt) {
		this.wochentag = wt;
	}
	public Unterrichtstag getWochentag() {
		return this.wochentag;
	}
	
	public void setKlasse(Klasse k) {
		this.klasse = k;
	}
	public Klasse getKlasse() {
		return this.klasse;
	}
	
	public void setLehrer(Lehrer l) {
		this.lehrer = l;
	}
	public Lehrer getLehrer() {
		return this.lehrer;
	}
	
	public void setUnterrichtsEinheit(int unterrichtsEinheit) {
		this.unterrichtsEinheit = unterrichtsEinheit;
	}
	public int getUnterrichtsEinheit() {
		return this.unterrichtsEinheit;
	}
		
	public Raum getUnterrichtsRaum() {
		return unterrichtsRaum;
	}

	public void setUnterrichtsRaum(Raum unterrichtsRaum) {
		this.unterrichtsRaum = unterrichtsRaum;
	}
	
	public void setUnterrichtsFach(Fach f) {
		this.unterrichtsFach = f;
	}
	public Fach getUnterrichtsFach() {
		return this.unterrichtsFach;
	}
	
	@Override
	public String toString() {
		if (this.unterrichtsEinheit != -1)
		return "\n"+this.unterrichtsEinheit+"h: Fach: "+this.getUnterrichtsFach().getName()+" | Klasse: "+this.klasse.getName()+" | Lehrer: "+this.lehrer.getKuerzel()+" | Raum: "+this.getUnterrichtsRaum().getRaumNummer();
		else return "0";
	}

}