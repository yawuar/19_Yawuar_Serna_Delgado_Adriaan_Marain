package org.kdg.personeel;

public class Factuur implements Betaalbaar {
	float factuurBedrag = 100f;
	int factuurNR = 0;

	public Factuur(int factuurNR, float factuurBedrag) {
		this.factuurNR = factuurNR;
		this.factuurBedrag = factuurBedrag;
	}

	public void betaal() {
		System.out.println("Betaal het factuur van " + factuurBedrag);
	}
}