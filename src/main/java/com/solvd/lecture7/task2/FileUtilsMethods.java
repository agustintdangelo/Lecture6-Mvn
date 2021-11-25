package com.solvd.lecture7.task2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtilsMethods {
	public static void main(String[] args) throws IOException {
		// Creating a file and deleting it.
		File trashFile = new File("files/trashile");
		File aliveFile = new File("files/survivourFile");
		String data = "This is the file that survives.";
		byte[] bytes2 = data.getBytes();

		FileUtils.touch(trashFile);
		FileUtils.touch(aliveFile);
		FileUtils.writeByteArrayToFile(aliveFile, bytes2);
		FileUtils.forceDelete(trashFile);

		// copying file
		File copyOfFile = new File("files/copy");
		FileUtils.copyFile(aliveFile, copyOfFile, false);
	}

}
