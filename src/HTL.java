import java.time.LocalDate;

public class HTL {
	
	// Neue Schule anlegen
	public static Schule htlstp = new Schule("HTL St. Pölten", (long) 212411, "Höhere Technische Bundeslehr- und Versuchsanstalt");
	
	public static void main(String[] args) {
//		main1();
		mainFunction();
	}
	
	public static void alteTestFunktion() {
		
		// Abteilungen hinzufügen
		htlstp.addAbteilung("Elektronik", 		"EL");
		htlstp.addAbteilung("Informatik", 		"IF");
		
		//'Schwebende' Lehrer erstellen
		System.out.println("\nLehrer erstellen:");
		Lehrer Kern    = new Lehrer("Gunter","Kern",   LocalDate.of(1989, 12, 1), 2123, "g.kerni@hotmail.com", new Adresse("Hupfing", "Minimal Musterstr.", 12, 1234));
		Lehrer Mueller = new Lehrer("Anton","Mueller", LocalDate.of(1979, 2, 21), 2343, "h.muello@hotmail.de", new Adresse("Hintertupf", "Ing. Jansestr.", 122, 1154));
		Lehrer Muehler = new Lehrer("Anton","Muehler", LocalDate.of(1978, 2, 21), 2393, "h.muelli@hotmail.at", new Adresse("Musterstar", "Mag. Jansestr.", 412, 1554));
		
		// Den Lehrern Fächer hinzufügen
		System.out.println("\nLehrern Fächer geben:");
		Kern.addFach(Fach.DEUTSCH);
		Mueller.addFach(Fach.DEUTSCH);
		Mueller.addFach(Fach.HWE);
		Muehler.addFach(Fach.MATHE);
		Muehler.addFach(Fach.FSST);

		//'Schwebende' Klasse mit StammRaum erstellen
		System.out.println("\nKlassen erstellen:");
		Klasse FBHELS = new Klasse(5,"BHELS", Kern, new Raum("WT102", 2, Raumtyp.KLASSENZIMMER));
		Klasse VBHELS = new Klasse(4,"BHELS", Mueller, new Raum("WT422", 14, Raumtyp.KLASSENZIMMER));
		
		// Klassen einer Abteilung hinzufügen
		System.out.println("\nKlassen einer Abteilung hinzufügen:");
		try {
			htlstp.getAbteilung("EL").addKlasse(FBHELS);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.getAbteilung("EL").addKlasse(VBHELS);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Lehrer zu einer Abteilung hinzufügen
		System.out.println("\nLehrer einer Abteilung der htlstp hinzufügen: (generiert einzigartige Kürzel)");
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
		
		// Für alle Fächer genügend Räume bauen
		System.out.println("Lehrer lassen für ihre Fächer Räume bauen:");
		htlstp.addRaeume(Raum.generateRaeume(htlstp.getLehrer()));
		
		
		//'Schwebende'Schüler erstellen
		System.out.println("\nSchüler erstellen:");
		Schueler Agnes    = new Schueler("Agnes", "Thalhammer", LocalDate.of(1999, 11, 01), 3030, "hundert.tausend@eins.at", new Adresse ("Grosszehl", "Ausservollbach", 23, 3024));
		Schueler Baldrian = new Schueler("Baldrian", "Burger", 	LocalDate.of(2008, 11, 01), 3030, "agnes.thalhammer@gmail.at", new Adresse ("Mistelbach", "Ausservollbach", 23, 3024));
		Schueler Clemens  = new Schueler("Clemens", "Annanas", 	LocalDate.of(1991, 12, 29), 3030, "hundert.tausend@eins.at", new Adresse ("Laa a.d. Traisen", "Ausservollbach", 23, 3024));
		
		Schueler Adrian   = new Schueler("Adrian", "Blanda", 	LocalDate.of(1999, 11, 01), 3030, "agnes.thalhammer@gmail.at", new Adresse ("Maierhofen", "Ausservollbach", 23, 3024));
		Schueler Bungur   = new Schueler("Bungur", "Hollunder", LocalDate.of(2001, 01, 01), 3030, "hundert.tausend@eins.at", new Adresse ("Gundelkofen", "Ausservollbach", 23, 3024));
		Schueler Zoe      = new Schueler("Zoe", "Azunder", 		LocalDate.of(2003, 02, 19), 3030, "agnes.thalhammer@htlstp.at", new Adresse ("Warschau", "Ausservollbach", 23, 3024));
		
		System.out.println("\nSchüler einer Klasse hinzufügen:");
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
		
		FBHELS.setKlassensprecher();
		
		try {
			System.out.println("Klassensprecher der 5BHELS ist: "+FBHELS.getKlassensprecher().getVorname());
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		FBHELS.setKlassensprecher();

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
			htlstp.getAbteilung("EL").setAbteilungsvorstand(Kern);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			htlstp.getAbteilung("EL").setAbteilungsvorstand(Mueller);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.getAbteilung("IF").setAbteilungsvorstand(Mueller);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("Abteilungsvorstand der EL: "+htlstp.getAbteilung("EL").getAbteilungsvorstand().getName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
		Lehrer AVIF = htlstp.getAbteilung("IF").getAbteilungsvorstand();
//			System.out.println("Abteilungsvorstand der IF: "+AVIF.getName()+", "+AVIF.getKuerzel()+", "+AVIF.getEmail()+", SVNR: "+AVIF.getSvnr()+", Alter: "+AVIF.getAlter());
		System.out.println("AV der IF: "+AVIF.toString());
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
		
		System.out.println("\nALLE LEHRER DER HTL STP MIT ALLEN DETAILS:\n");
		for(Lehrer l : htlstp.getLehrer()) {
			System.out.println(l.toString());
		}
		
		// Fächer, Stundenplan 'n' similar stuff
		System.out.println("\nFÄCHER - / - STUNDENPLÄNE:\n");
		try {
			for (Fach f : FBHELS.getFaecher()) {
				System.out.println("Fach: "+f.getName()+" Stundenzahl: "+f.getWochenstunden()+" Raum: "+f.getRaumanforderung());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Einer Klasse ein Fach hinzufügen (trägt die Klasse auch beim Fach ein):");
		
		FBHELS.addFach(Fach.MATHE);
		FBHELS.addFach(Fach.DEUTSCH);
		FBHELS.addFach(Fach.FSST);
		FBHELS.addFach(Fach.HWE);
		
		try {
			System.out.println("\n\nStundenplan 5BHELS:");
			FBHELS.exportStundenplan();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for(Raum r : htlstp.getRaeume()) {
			try {
				System.out.println("\n\nRaumplan für "+r.getRaumtyp().name().toLowerCase()+" ("+r.getRaumNummer()+"):");
				r.exportBelegung();
			} catch (Exception e) {
				System.out.println("Raum: "+e);
			}
		}
		
		for(Lehrer l : htlstp.getLehrer()) {
			try {
				System.out.println("\n\nStundenplan für "+l.getName()+":");
				l.exportStundenplan();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
	}
	
	public static void mainFunction() {
		
		// ABTEILUNGEN
		// hinzufügen
		System.out.println("\n\nAbteilungen hinzufügen:\n");
		
		htlstp.addAbteilung("Elektronik", 		"EL");
		htlstp.addAbteilung("Informatik", 		"IF");
		htlstp.addAbteilung("Maschinenbau", 	"MB");
		htlstp.addAbteilung("Elektrotechnik", 	"ET");
		htlstp.addAbteilung("Wirtschaft", 		"WI");
		
		
		// LEHRER
		// erstellen
		System.out.println("\n\nLehrer erstellen:\n");
		
		Lehrer Huti   = new Lehrer("Georg","Hutflesz",   LocalDate.of(1986, 12, 1), 2123, "g.huti@hotmail.com", new Adresse("Hupfing", "Minimal Musterstr.", 12, 1234));
		Lehrer Karner = new Lehrer("Ferdinand","Karner", LocalDate.of(1989, 2, 21), 2343, "f.karni@mail.de", new Adresse("Hintertupf", "Ing. Jansestr.", 192, 1154));
		Lehrer Resch  = new Lehrer("Bernhard","Resch", 	LocalDate.of(1985, 2, 21), 2393, "b.resch@hotmail.at", new Adresse("Musterstar", "Mag. Jansestr.", 419, 1514));
		Lehrer Peham  = new Lehrer("Christoph","Peham", LocalDate.of(1985, 12, 30), 2393, "c.peha@hotmail.at", new Adresse("Musterstar", "Mag. Jansestr.", 112, 1874));
		Lehrer Michi  = new Lehrer("Michaela","Singer", LocalDate.of(1990, 2, 6), 2393, "michi_hasix26@hotmail.at", new Adresse("Musterstar", "Mag. Jansestr.", 492, 1934));
		Lehrer Weigl  = new Lehrer("Manuel","Weigl", LocalDate.of(1997, 5, 7), 0507, "manuel.weigl@htlstp.at", new Adresse("Musterstar", "Mag. Jansestr.", 800, 1554));
		
		htlstp.getAbteilung("EL").addLehrer(Huti);
		htlstp.getAbteilung("MB").addLehrer(Karner);
		htlstp.getAbteilung("EL").addLehrer(Resch);
		htlstp.getAbteilung("EL").addLehrer(Peham);
		htlstp.getAbteilung("EL").addLehrer(Michi);
		htlstp.getAbteilung("IF").addLehrer(Weigl);
		
		
		// FÄCHER
		// Lehrern hinzufügen
		System.out.println("\n\nLehrer bekommen ihre Fächer nachträglich:\n");
		Huti.addFach(Fach.PHYSIK);
		Huti.addFach(Fach.HWE);
		Karner.addFach(Fach.PHYSIK);
		Karner.addFach(Fach.WIRTSCHAFT);
		Resch.addFach(Fach.MATHE);
		Peham.addFach(Fach.FSST);
		Michi.addFach(Fach.WIRTSCHAFT);
		Michi.addFach(Fach.DEUTSCH);
		Weigl.addFach(Fach.FSST);
		Weigl.addFach(Fach.MATHE);
		
		// Für alle Fächer genügend Räume bauen
		System.out.println("Lehrer lassen für ihre Fächer Räume bauen:");
		htlstp.addRaeume(Raum.generateRaeume(htlstp.getLehrer()));
		

		// KLASSEN
		// erstellen
		System.out.println("\n\nKlassen werden erstellt:\n");
		Klasse FBHELS = new Klasse(5,"BHELS", Weigl, new Raum("WT118", 36, Raumtyp.KLASSENZIMMER));
		Klasse VBHELS = new Klasse(4,"BHELS", Peham, new Raum("WT420", 20, Raumtyp.KLASSENZIMMER));
		
		
		// KLASSEN
		// zur Abteilung hinzufügen
		htlstp.getAbteilung("EL").addKlasse(FBHELS);
		htlstp.getAbteilung("IF").addKlasse(VBHELS);
		
		
		// SCHÜLER
		// erstellen
		System.out.println("\n\nSchüler werden erstellt:\n");
		Schueler Agnes    = new Schueler("Agnes", "Thalhammer", LocalDate.of(1999, 11, 01), 3030, "hundert.tausend@eins.at", new Adresse ("Grosszehl", "Ausservollbach", 23, 3024));
		Schueler Baldrian = new Schueler("Baldrian", "Burger", 	LocalDate.of(2008, 11, 01), 3030, "agnes.thalhammer@gmail.at", new Adresse ("Mistelbach", "Ausservollbach", 23, 3024));
		Schueler Clemens  = new Schueler("Clemens", "Annanas", 	LocalDate.of(1991, 12, 29), 3030, "hundert.tausend@eins.at", new Adresse ("Laa a.d. Traisen", "Ausservollbach", 23, 3024));
		
		Schueler Adrian   = new Schueler("Adrian", "Blanda", 	LocalDate.of(1999, 11, 01), 3030, "agnes.thalhammer@gmail.at", new Adresse ("Maierhofen", "Ausservollbach", 23, 3024));
		Schueler Bungur   = new Schueler("Bungur", "Hollunder", LocalDate.of(2001, 01, 01), 3030, "hundert.tausend@eins.at", new Adresse ("Gundelkofen", "Ausservollbach", 23, 3024));
		Schueler Zoe      = new Schueler("Zoe", "Azunder", 		LocalDate.of(2003, 02, 19), 3030, "agnes.thalhammer@htlstp.at", new Adresse ("Warschau", "Ausservollbach", 23, 3024));
		
		// Schüler zur Klasse FBHELS hinzufügen
		FBHELS.addSchueler(Agnes);
		FBHELS.addSchueler(Baldrian);
		FBHELS.addSchueler(Clemens);
		
		// Schüler zur Klasse VBHELS hinzufügen
		VBHELS.addSchueler(Adrian);
		VBHELS.addSchueler(Bungur);
		VBHELS.addSchueler(Zoe);
		
		// DIREKTOR
		// der HTL St. Pölten wählen
		System.out.println("\nDIREKTOR\n\nAbfragen, Waehlen, Abfragen");
		
		try {
			htlstp.getDirektor();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.setDirektor(Karner);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Lehrer d = htlstp.getDirektor();
			System.out.println("Direktor: "+d.getName()+", "+d.getEmail());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// Abteilungsvorstand 
		//der EL wählen (geht nur, wenn es bereits einen Direktor gibt)
		System.out.println("\nABTEILUNGSVORSTAND\n\nDirektor Wählen, Lehrer einer anderen Abteilung Wählen, gültige Wahl, Abfrage");
		try {
			htlstp.getAbteilung("MB").setAbteilungsvorstand(Karner);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			htlstp.getAbteilung("EL").setAbteilungsvorstand(Weigl);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			htlstp.getAbteilung("EL").setAbteilungsvorstand(Michi);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("Abteilungsvorstand der EL: "+htlstp.getAbteilung("EL").getAbteilungsvorstand().getName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
		System.out.println("AV der IF: "+htlstp.getAbteilung("IF").getAbteilungsvorstand().toString());
		} catch (Exception e) {
			System.out.println(e);
		}
				
		
		// SCHÜLER
		// der Schule ausgeben
		System.out.println("\n\nSchüler der HTL:\n");
		for(Schueler s : htlstp.getSchueler()) {
			System.out.println(s.getName());
		}
		
		
		// FÄCHER
		// zur Klasse hinzufügen
		
		FBHELS.addFach(Fach.MATHE);
		FBHELS.addFach(Fach.DEUTSCH);
		FBHELS.addFach(Fach.WIRTSCHAFT);
		FBHELS.addFach(Fach.HWE);

		VBHELS.addFach(Fach.FSST);
		VBHELS.addFach(Fach.MATHE);
		
		// STUNDENPLÄNE
		// ausgeben (generiert im Hintergrund)
		try {
			System.out.println("\n\nStundenplan 5BHELS:");
			FBHELS.exportStundenplan();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for(Raum r : htlstp.getRaeume()) {
			try {
				System.out.println("\n\nRaumplan für "+r.getRaumtyp().name().toLowerCase()+" ("+r.getRaumNummer()+"):");
				r.exportBelegung();
			} catch (Exception e) {
				System.out.println("Raum: "+e);
			}
		}
		
		for(Lehrer l : htlstp.getLehrer()) {
			try {
				System.out.println("\n\nStundenplan für "+l.getName()+":");
				l.exportStundenplan();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static String jaNein(boolean truefalse) {
		return truefalse ? ("ja") : ("nein");
	}

}
