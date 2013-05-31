package com.TeB.Blocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.TeB.DungeonGame.Map;

public class Chest extends Block {

	public static int openChest[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	static boolean backgroundBlock = true;
	static boolean hasClickUse = true;

	public static boolean backgroundBlock() {
		return backgroundBlock;
	}

	public static boolean hasClickUse() {
		return hasClickUse;
	}

	public static void ClickUse(int BlockId) {
		chestAt(BlockId);
		// System.out.println(openChest[0]);
	}

	public static void chestAt(int BlockId) {
		try {
			Scanner s = new Scanner(new File(Map.MapInUse + "Chests"));
			boolean writeDownChest = false;

			int item = 0;

			while (s.hasNext()) {
				int next = s.nextInt();
				
				if (next == BlockId) {
					if (writeDownChest) {
						writeDownChest = false;
						item = 0;
						break;
					}
					if (!writeDownChest && item == 0) {
						writeDownChest = true;
						if (s.hasNext())
							next = s.nextInt();
					}
				}
				if (writeDownChest) {
					System.out.println(next);
					openChest[item] = next/10;
					item++;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
