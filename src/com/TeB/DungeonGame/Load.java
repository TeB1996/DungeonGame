package com.TeB.DungeonGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load {

	public static int Block[];
	public static String Sign[] = new String[100];
	public static int SignBlock[] = {0};
	public static int mapLength = 2;
	public static boolean mapUpdate = false;

	public Load(String map) {

		Block = new int[61 * 48 * mapLength + 1];

		try {
			Scanner s = new Scanner(new File(map));

			for (int g1 = 0; g1 <= 61 * 48 * mapLength; g1++) {
				Block[g1] = s.nextInt();
				System.out.println(g1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Scanner s = new Scanner(new File(map + "Signs"));
			boolean writeDown = false;

			String sentence = "";

			while (s.hasNext()) {
				String i = s.next();

				if (i.equalsIgnoreCase("[")) {
					writeDown = true;
					i = s.next();
				}
				if (i.equalsIgnoreCase("]")) {
					if (SignBlock.length - 1 >= 0) Sign[SignBlock.length - 1] = sentence;
					else Sign[0] = sentence;

					if (SignBlock.length - 1 >= 0) SignBlock[SignBlock.length - 1] = s.nextInt();
					else SignBlock[0] = s.nextInt();

					writeDown = false;
				}
				if (writeDown) {
					sentence += " " + i;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// System.out.println(SignBlock[0]);
	}

}
