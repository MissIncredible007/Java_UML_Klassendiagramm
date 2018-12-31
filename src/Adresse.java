
public class Adresse {
	
	private String ort;
	private String strasse;
	private int hausnummer;
	private int plz;

	Adresse(String ort, String strasse, int hausnummer, int plz){
		this.ort = ort;
		this.strasse = strasse;
		this.hausnummer = hausnummer; 
		this.plz = plz;
	}
	
	public void printAdresse(){
		System.out.println("Adresse:\n "+strasse+" "+hausnummer+"\n "+plz+" "+ort);
	}
	
}
