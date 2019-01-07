import java.time.LocalDate;


public class HTL {
	
	public static void main(String[] args) {
		
		// Neue Schule anlegen
		Schule htlstp = new Schule("HTL St. Pölten", (long) 212411, "Höhere Technische Bundeslehr- und Versuchsanstalt");
		
		// Abteilungen hizufügen
		htlstp.addAbteilung("Elektronik und Technische Informatik", "EL");
		htlstp.addAbteilung("Informatik", "IF");
		
		//'Schwebende'Klasse erstellen
		Klasse FBHELS = new Klasse(5,"BHELS");
		Klasse VBHELS = new Klasse(4,"BHELS");

		
		// Klasse FBHELS zur Abteilung hinzufügen
		try {
			htlstp.getAbteilung("EL").addKlasse(FBHELS);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Klasse VBHELS zur Abteilung hinzufügen
		try {
			htlstp.getAbteilung("EL").addKlasse(VBHELS);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//'Schwebende'Lehrer erstellen
		Lehrer Kern = new Lehrer("Gunter","Kern",LocalDate.of(1989, 12, 1), 2123, "g.kerni@hotmail.com", new Adresse("Hupfing", "Musterstr.", 12, 1234));
		Lehrer Mueller = new Lehrer("Anton","Mueller",LocalDate.of(1979, 2, 21), 2343, "h.muello@hotmail.de", new Adresse("Hintertupf", "Ing. Jansestr.", 112, 1754));
		Lehrer Muehler = new Lehrer("Anton","Muehler",LocalDate.of(1979, 2, 21), 2343, "h.muello@hotmail.de", new Adresse("Hintertupf", "Ing. Jansestr.", 112, 1754));

		// Lehrer zu einer Abteilung hinzufügen
		try {
			htlstp.getAbteilung("EL").addLehrer(Kern);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.getAbteilung("IF").addLehrer(Mueller);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.getAbteilung("IF").addLehrer(Muehler);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//'Schwebende'Schüler erstellen
		Schueler Agnes = new Schueler("Agnes", "Thalhammer", 	LocalDate.of(1999, 11, 01), 3030, "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		Schueler Baldrian = new Schueler("Baldrian", "Burger", 	LocalDate.of(2001, 11, 01), 3030, "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		Schueler Clemens = new Schueler("Clemens", "Annanas", 	LocalDate.of(2000, 12, 29), 3030, "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		
		Schueler Adrian = new Schueler("Adrian", "Blanda", 		LocalDate.of(1999, 11, 01), 3030, "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		Schueler Bungur = new Schueler("Bungur", "Hollunder", 	LocalDate.of(2001, 11, 01), 3030, "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		Schueler Zoe = new Schueler("Zoe", "Azunder", 			LocalDate.of(2000, 12, 29), 3030, "agnes.thalhammer@gmx.at", new Adresse ("Kleinzell", "Innerhalbach", 30, 3171));
		
		
		// Schüler zur Klasse FBHELS hinzufügen
		FBHELS.addSchueler(Agnes);
		FBHELS.addSchueler(Baldrian);
		FBHELS.addSchueler(Clemens);
		
		// Schüler zur Klasse VBHELS hinzufügen
		VBHELS.addSchueler(Adrian);
		VBHELS.addSchueler(Bungur);
		VBHELS.addSchueler(Zoe);
		
		// Ausgabe der Schüler
		System.out.println("\nALLE SCHÜLER DER KLASSE 5BHELS:\n");
		for(Schueler s: FBHELS.getSchueler()) {
			System.out.println("Nr."+s.getKatalognummer()+" "+s.getVorname()+" "+s.getNachname()+" Eigenberechtigt: "+jaNein(s.isEigenberechtigt())+" ("+s.getAlter()+" Jahre alt)");
		}
		System.out.println("Durchschnittssalter 5BHELS: "+FBHELS.getDurchschnittsalter());
		
		// Wohnort eines Schüler ausgeben
		System.out.println("\nSCHÜLER AGNES\n");
		Agnes.printWohnort();
		
		// Einen Klassensprecher wählen
		System.out.println("\nKLASSENSPRECHER\n\nDen Klassensprecher zweimal hintereinander abfragen und wählen:");
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

		// Abteilungssprecher der EL wählen
		System.out.println("\nABTEILUNGSSPRECHER\n\nin einer falschen Abteilung setzen:");
		try {
			htlstp.getAbteilung("IF").setAbteilungssprecher(Zoe);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("in der richtigen Abteilung setzen:");
		
		try {
			htlstp.getAbteilung("EL").setAbteilungssprecher(Zoe);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Direktor der HTL St. Pölten wählen
		System.out.println("\nDIREKTOR\n\nAbfragen, Waehlen, Abfragen");
		
		try {
			htlstp.getDirektor();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.setDirektor(Kern);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Lehrer d = htlstp.getDirektor();
			System.out.println("Direktor: "+d.getName()+", "+d.getEmail());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Abteilungsvorstand der EL wählen (geht nur, wenn es bereits einen Direktor gibt :)
		System.out.println("\nABTEILUNGSVORSTAND\n\nDirektor Wählen, Lehrer einer anderen Abteilung Wählen, gültige Wahl, Abfrage");
		try {
			htlstp.getAbteilung("EL").setAbteilungsvorstand(Kern, htlstp.getDirektor());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			htlstp.getAbteilung("EL").setAbteilungsvorstand(Mueller, htlstp.getDirektor());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.getAbteilung("IF").setAbteilungsvorstand(Mueller, htlstp.getDirektor());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println("\nALLE SCHÜLER DER HTL STP:\n");
		for(Schueler s : htlstp.getSchueler()) {
			System.out.println(s.getSchulstufe()+s.getKlassenbezeichnung()+" Nr."+s.getKatalognummer()+" "+s.getName());
		}
		
		System.out.println("\nALLE LEHRER DER HTL STP:\n");
		for(Lehrer l : htlstp.getLehrer()) {
			System.out.println(l.getName()+" ("+l.getKuerzel()+")");
		}
	}
	
	public static String jaNein(boolean truefalse) {return truefalse ? "ja" : "nein";}

}
