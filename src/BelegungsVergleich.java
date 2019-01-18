import java.util.Comparator;

public class BelegungsVergleich implements Comparator<Belegung> {

	@Override
	public int compare(Belegung b1, Belegung b2) {
//		System.out.println("B1 : " + b1.getUnterrichtsFach().getName()+" einheit:"+ b1.getUnterrichtsEinheit());
//		System.out.println("B2 : " + b2.getUnterrichtsFach().getName()+" einheit:"+ b2.getUnterrichtsEinheit());
//		System.out.println(" dadurch: "+Integer.valueOf(b1.getUnterrichtsEinheit()).compareTo(Integer.valueOf(b2.getUnterrichtsEinheit())));
//		return Integer.valueOf(b1.getUnterrichtsEinheit()).compareTo(Integer.valueOf(b2.getUnterrichtsEinheit()));
		return 1;
	}
}
