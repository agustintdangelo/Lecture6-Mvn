package com.solvd.javacourse.enums;

public enum EnumLeaders {
	DARTH_VADER("Darth Vader", "No… I am your Father…"), DARTH_SIDIOUS("Darth Sidious", "Infinite power!!!"),
	DARTH_MAUL("Darth Maul", "..."), KYLO_REN("Kylo Ren", "I've Given Everything To You...To The Dark Side."),
	LUKE_SKYWALKER("Luke Skywalker", "I Want To Learn The Ways Of The Force..."),
	YODA("Yoda",
			"Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering."),
	OBI_WAN_KENOBI("Obi Wan Kenobi",
			"The truth is often what we make of it; you heard what you wanted to hear, believed what you wanted to believe.");

	private String name;
	private String phrase;

	EnumLeaders(String name, String phrase) {
		this.name = name;
		this.phrase = phrase;
	}

	public String getName() {
		return name;
	}

	public String getPhrase() {
		return phrase;
	}

	public String printPhrase() {
		return getName() + ": " + getPhrase();
	}
}
