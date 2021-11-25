package com.solvd.lecture7;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.solvd.lecture7.task2.StringUtilsMethods;

public class task1 {
	private final static Logger LOG = Logger.getLogger(StringUtilsMethods.class.getName());

	public static void main(String[] args) throws IOException {
		File file = new File("src/main/resources/java.txt");
		String words = FileUtils.readFileToString(file, "UTF-8");

		// I remove the last sentence so when i run again the program it doesn't write
		// the same thing over and over again.
		// I don't know if it's the best way to do this, but it is what I thought.
		words = StringUtils.remove(words, "The total of unique words is: 197");

		// I eliminate the white spaces of /n, and write the file again.
		words = StringUtils.trim(words);
		byte[] bytes = words.getBytes();
		FileUtils.writeByteArrayToFile(file, bytes);

		// I put all characters in uppercase so everything is generalized, and delete
		// every character that is numeric or isn't a character.
		String wordsModified = StringUtils.upperCase(words);
		wordsModified = wordsModified.replaceAll("[^A-Za-z]", " ");
		String[] wordsList = StringUtils.split(wordsModified, " ");

		// I called a collection of Set to add unique values to the collection.
		Set<String> uniqueValues = new HashSet<String>();
		for (int i = 0; wordsList.length > i; i++) {
			uniqueValues.add(wordsList[i]);
		}

		// finally i print the quantity of unique words and write it in the file.
		int numberUniqueWords = uniqueValues.size();
		LOG.log(Level.INFO, "The total of unique words is: " + numberUniqueWords);
		LOG.log(Level.INFO, "The total of words is: " + wordsList.length);
		String introduction = "\nThe total of unique words is: ";
		String fullFileString = words + introduction + numberUniqueWords;

		byte[] bytes2 = fullFileString.getBytes();
		FileUtils.writeByteArrayToFile(file, bytes2);
	}

}
