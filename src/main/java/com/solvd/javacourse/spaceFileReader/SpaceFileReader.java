package com.solvd.javacourse.spaceFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SpaceFileReader {
	private final static Logger LOG = Logger.getLogger(SpaceFileReader.class.getName());
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("StarWarsIntro.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				LOG.log(Level.INFO, line);
//				System.out.println(line);
			}
		}
	}
}
