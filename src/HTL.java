import java.time.LocalDate;

public class HTL {
	
	public static void main(String[] args) {
		
		Schule htlstp = new Schule("HTBLuVA St. Pölten", (long) 212411);
		htlstp.addAbteilung("Elektronik und Technische Informatik", "EL");
		System.out.println(htlstp.abteilungen);
		
		
		//Abteilung Elektronik = htlstp.addAbteilung("Elektronik","EL");
		//Person Adrian = new Person(1234, "Adrian", "Blanda", LocalDate.of(2000, 03, 11), "b.a@g.com", new Adresse("MusterOrt","Muster-Straße",24,3032));
		
		
		for(Schueler i : htlstp.getSchueler()) {
			System.out.println(i.getVorname());
		}
		//System.out.println(Adrian.getAlter());
	}
}
