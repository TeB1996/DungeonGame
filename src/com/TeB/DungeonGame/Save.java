package com.TeB.DungeonGame;

import java.io.FileNotFoundException;
import java.util.*;

public class Save implements Runnable {

	private Thread IconLoop = new Thread(this);

	public Save(String map) {

		int a = 0;

		IconLoop.start();

		try {
			Formatter f = new Formatter(map);

			for (int i = 0; i < Load.Block.length; i++) {
				a++;
				if (a != 1) f.format("%s", " ");
				if (a == 62*Load.mapLength) {
					a = 0;
					f.format("%s", Load.Block[i]);
					f.format("\n", "");
				} else {
					f.format("%s", Load.Block[i]);
				}
			}
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Saved");

	}

	public void run() {


		for (int i = 0; i <= 2; i++) {
			HUD.saveIcon = true;
			try {
				Thread.sleep(1000);
				HUD.saveIcon = false;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
