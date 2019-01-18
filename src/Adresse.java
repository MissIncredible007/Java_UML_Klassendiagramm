
public class Adresse {

	private String ort;
	private String strasse;
	private int hausnummer;
	private int plz;

	Adresse(String ort, String strasse, int hausnummer, int plz) {
		this.ort = ort;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
	}

	public void printAdresse() {
		System.out.println("Adresse:\n " + strasse + " " + hausnummer + "\n " + plz + " " + ort);
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

}
