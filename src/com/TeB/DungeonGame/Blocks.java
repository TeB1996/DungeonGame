package com.TeB.DungeonGame;

import java.awt.*;

@SuppressWarnings("serial")
public class Blocks extends Rectangle {

	public Load l;
	public Save s;

	public static boolean isTrue = true;
	public boolean starting = false;
	public String xmap = "";
	public static int xOff = 0;

	public static boolean update = true;

	public Blocks(String map) {

		l = new Load(map);
	}

	public void draw(Graphics g) {
		int width = 16, height = width;
		int x = width, y = width;
		int mapLength = Load.mapLength;
		ImageImport ii = new ImageImport();

		if (update) {
			for (int py = 0; py <= 44; py++) {

				for (int px = 0; px <= 61; px++) {

					int id = px + xOff + (py * 62 * Load.mapLength);

					if ((id <= 2808 * mapLength)) {
						g.setColor(Color.CYAN);
						if (Load.Block[id] == 0 || Load.Block[id] == 8) g.fillRect(x * px, y * py, width, height);
						g.setColor(Color.BLACK);
						if (Load.Block[id] == 5) g.fillRect(x * px + xOff, y * py, width, height);
						if (Load.Block[id] == 1) g.drawImage(ii.grass, x * px + xOff, y * py, width, height, null);
						if (Load.Block[id] == 2) g.drawImage(ii.dirt, x * px + xOff, y * py, width, height, null);
						if (Load.Block[id] == 3) g.drawImage(ii.stone, x * px + xOff, y * py, width, height, null);
						if (Load.Block[id] == 4) g.drawImage(ii.brick, x * px + xOff, y * py, width, height, null);
						if (Load.Block[id] == 6) g.drawImage(ii.tnt, x * px + xOff, y * py, width, height, null);
						if (Load.Block[id] == 7) g.drawImage(ii.obsidian, x * px + xOff, y * py, width, height, null);
						if (Load.Block[id] == 8) g.drawImage(ii.sign, x * px + xOff, y * py, width, height, null);
						if (Load.Block[id] == 9) g.drawImage(ii.chest, x * px + xOff, y * py, width, height, null);
					}

					// g.setColor(Color.BLUE);
					// g.drawRect(x * px, y * py, width, height);

				}

			}
			update = true;
		}
	}

}
