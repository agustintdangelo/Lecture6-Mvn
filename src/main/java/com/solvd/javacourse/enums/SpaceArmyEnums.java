package com.solvd.javacourse.enums;

public enum SpaceArmyEnums {
	EMPIRE("Sith"), ALLIANCE("Jedi");

	String leaders;

	SpaceArmyEnums(String string) {
		// TODO Auto-generated constructor stub
		this.leaders = string;
	}

	public String getLeaders() {
		return "The leaders are: " + leaders;
	}

}
