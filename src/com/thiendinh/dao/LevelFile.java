package com.thiendinh.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LevelFile {
	private File file;

	public LevelFile() {
		file = new File("src/data/level.txt");
	}

	public void write(int level) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(level + "");
		} catch (IOException e) {
			System.out.println("no thing to write!");
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException ignore) {
				}
		}
	}

	public int read() {
		try {
			Scanner scanner = new Scanner(file);
			String rep = scanner.nextLine();
			return Integer.parseInt(rep);
		} catch (Exception e) {
			System.out.println("new game!");
		}
		return 1;
	}
}
