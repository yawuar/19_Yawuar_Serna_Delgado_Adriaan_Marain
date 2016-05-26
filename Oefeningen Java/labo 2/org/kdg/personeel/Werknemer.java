package org.kdg.personeel;

public class Werknemer implements Betaalbaar{
	public String voornaam;
	public String achternaam;
	public int werknemernr;
	protected float salaris;
	private float rszpercentage = 33.0f;

	public static int aantalWerknemers;

	public Werknemer(String voornaam, String achternaam, int wNummer, float salaris) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		werknemernr = wNummer;
		this.salaris = salaris;

		aantalWerknemers++;
	}

	public void salarisVerhogen( int percentage ) {
		salaris = salaris * (1 + (percentage/100.0f));
	}

	public float getSalaris() {
		return salaris;
	}

	float getRSZ() {
		return rszpercentage;
	}

	void setRSZ(float rsz) {
		rszpercentage = rsz;
	}

	public void betaal() {
		System.out.println("Betaal " + salaris + " van " + voornaam);
	}
}