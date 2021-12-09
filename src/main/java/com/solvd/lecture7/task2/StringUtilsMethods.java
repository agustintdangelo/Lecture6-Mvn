package com.solvd.lecture7.task2;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsMethods {
	private final static Logger LOG = Logger.getLogger(StringUtilsMethods.class.getName());

	public static void main(String[] args) {
		String empty = "";
		String capitalize = "this is a capitalize example.";
		String digits = "Java 8. Java 9. Java 10. Java 11. Java 12";
		String space = StringUtils.SPACE;
		String chop = "Hello!";

		LOG.log(Level.INFO, "Java" + space + "is great.");
		LOG.log(Level.INFO, "Is empty?" + StringUtils.isEmpty(empty));
		LOG.log(Level.INFO, StringUtils.capitalize(capitalize));
		LOG.log(Level.INFO, StringUtils.getDigits(digits));
		LOG.log(Level.INFO, StringUtils.chop(chop));

	}
}
