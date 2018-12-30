import java.time.LocalDate;

public class HTL {
	
	public static void main(String[] args) {
		
		// Neue Schule anlegen
		Schule htlstp = new Schule("HTBLuVA St. P�lten", (long) 212411);
		
		// Abteilungen hizuf�gen
		htlstp.addAbteilung("Elektronik und Technische Informatik", "EL");
		htlstp.addAbteilung("Informatik", "IF");
		
		// Schwebende Klasse erstellen
		Klasse FBHELS = new Klasse("BHELS", 5);
		
		// Klasse zur Abteilung hinzuf�gen
		//System.out.println(htlstp.abteilungen.get(0).getName());
		htlstp.abteilungen.get(0).addKlasse(FBHELS);
		
		// Schwebende Sch�ler erstellen
		Schueler Agnes = new Schueler(3030, "Agnes", "Thalhammer", LocalDate.of(1999, 11, 01), "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		Schueler Baldrian = new Schueler(3030, "Baldrian", "Burger", LocalDate.of(2001, 11, 01), "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		Schueler Clemens = new Schueler(3030, "Clemens", "Annanas", LocalDate.of(2000, 12, 29), "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		
		// Sch�ler zur Klasse FBHELS hinzuf�gen
		FBHELS.addSchueler(Agnes);
		FBHELS.addSchueler(Baldrian);
		FBHELS.addSchueler(Clemens);
		
		// Einen Klassensprecher w�hlen
		System.out.println("KLASSENSPRECHER\n\nDen Klassensprecher zweimal hintereinander abfragen und w�hlen:");
		try {
			System.out.println("Klassensprecher der 5BHELS ist: "+FBHELS.getKlassensprecher().getVorname());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Wahl hat funktioniert: "+jaNein(FBHELS.setKlassensprecher()));
		
		try {
			System.out.println("Klassensprecher der 5BHELS ist: "+FBHELS.getKlassensprecher().getVorname());
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		System.out.println("Wahl hat funktioniert: "+jaNein(FBHELS.setKlassensprecher()));

		// Ausgabe der Sch�ler
		System.out.println("\nALLE SCH�LER DER KLASSE 5BHELS:\n");
		for(Schueler s: FBHELS.getSchueler()) {
			System.out.println("Nr."+s.getKatalognummer()+" "+s.getVorname()+" "+s.getNachname()+" Eigenberechtigt: "+jaNein(s.isEigenberechtigt())+" ("+s.getAlter()+" Jahre alt)");
		}
		System.out.println("Durchschnittssalter 5BHELS: "+FBHELS.getDurchschnittsalter());
		
		System.out.println("\nALLE SCH�LER DER HTL STP:\n");
		for(Schueler s : htlstp.getSchueler()) {
			System.out.println(s.getSchulstufe()+s.getKlassenbezeichnung()+" "+s.getVorname());
		}
		//System.out.println(Adrian.getAlter());
	}
	
	public static String jaNein(boolean truefalse) {return truefalse ? "ja" : "nein";}

}
