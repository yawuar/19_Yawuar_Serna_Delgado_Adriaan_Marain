package org.kdg.personeel;

public class PartTimeWerknemer extends Werknemer {

	int urenGewerkt;

	public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGw) {
		super(voornaam, achternaam, wNummer, salaris); // verplicht op 1ste lijn.
		urenGewerkt = urenGw;
	}

	public void salarisVerhogen(int percentage) {
		if(percentage > 5) {
			System.err.println("Fout: PartTime werknemers kunnen slechts 5% opslag krijgen");
		} else {
			super.salarisVerhogen(percentage);
		}
	}
}