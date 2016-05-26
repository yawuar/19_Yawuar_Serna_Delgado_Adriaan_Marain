import org.kdg.personeel.*;

public class LesKlassen {
	public static void main(String args[]) {
		Werknemer ruben = new Werknemer("Ruben", "de Swaef", 1, 20.0f);
		Werknemer alex = new Werknemer("Alex", "vanderbist", 2, (25.0f) * 1.1f);
		Werknemer yawuar = new Werknemer("Yawuar", "Serna Delgado", 3, 35.0f);
		Werknemer heline = new Werknemer("Heline", "Janssens", 4, 45.0f);

		ruben.salarisVerhogen(10);
		alex.salarisVerhogen(10);
		System.out.println(ruben.salaris);
		System.out.println(alex.salaris);
		System.out.println("Aantal Werknemers = " + ruben.aantalWerknemers);

		PartTimeWerknemer gert = new PartTimeWerknemer("Gert", "Verhulst", 5, 15.0f, 10);
		PartTimeWerknemer joshje = new PartTimeWerknemer("Joshje", "de Hollander", 6, 10.0f, 15);

		joshje.salarisVerhogen(10);

		StudentWerknemer stu = new StudentWerknemer("Ruben", "De Swaef", 7, 6.5f, 2);
		System.out.println("Het RSZ percentage van Gert is = " + ruben.getRSZ() + "%");

		Factuur factuur1 = new Factuur(1250, 2750.99f);
		Betaalbaar[] betdingen = new Betaalbaar[2];
		betdingen[0] = ruben;
		betdingen[1] = factuur1;

		for(int i = 0; i < 2; i++) {
			betdingen[i].betaal();
		}

		ruben.betaal();
	}
}