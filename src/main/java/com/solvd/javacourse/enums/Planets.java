package com.solvd.javacourse.enums;

import java.util.function.BiFunction;

public enum Planets {
	TATOOINE(0), ENDOR(10000), HOTH(25115214), CORRUSCANT(105648952);

	int km;

	private Planets(int km) {
		this.km = km;
	}

	BiFunction<Integer, Integer, Integer> distanceBetweenPlanets = (kilometres, kilometres2) -> Math
			.abs(kilometres - kilometres2);

	public int distanceBetweenPlanetHome(int km2) {
		int distance = distanceBetweenPlanets.apply(this.km, km2);
		return distance;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

}
