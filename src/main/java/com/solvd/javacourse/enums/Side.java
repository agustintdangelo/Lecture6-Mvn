package com.solvd.javacourse.enums;

public enum Side {
	EMPIRE("Evil"), ALLIANCE("Good");

	private String goodOrEvil;

	private Side(String goodOrEvil) {
		// TODO Auto-generated constructor stub
		this.goodOrEvil = goodOrEvil;
	}

	public String getGoodOrEvil() {
		return goodOrEvil;
	}

}
