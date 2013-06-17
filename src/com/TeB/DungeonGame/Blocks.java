package com.TeB.DungeonGame;

import java.awt.*;

@SuppressWarnings("serial")
public class Blocks extends Rectangle {

	public Load l;
	public Save s;

	public static boolean isTrue = true;
	public boolean starting = false;
	public static int blockSize = 16;
	public int xOffset = 0;
	private static int sXOffset = 0;
	public String xmap = "";
	public static float xOff = 0;

	public static boolean update = true;

	public Blocks(String map) {

		l = new Load(map);
	}

	public void draw(Graphics g) {
		int width = (int) (16*Load.mapScale), height = width;
		int x = width, y = width;
		blockSize = (int) (16*Load.mapScale);
		int mapLength = Load.mapLength;
		ImageImport ii = new ImageImport();

		if (xOffset % 15 <= 0.01) {
			// System.out.println(xOff*10);
			xOffset = 0;
		}
		if (xOff > 0.01) {
			xOffset = (int) ((xOff - (int) xOff) * 16);
			xOffset = -xOffset;
		}

		if (update) {
			for (int py = 0; py <= (int)44/Load.mapScale + 1; py++) {

				for (int px = 0; px <= (int)61/Load.mapScale + 1; px++) {

					int id = px + (int) xOff + (py * 62 * Load.mapLength);

					if ((id <= 2808 * mapLength)) {
						int bId = Load.Block[id];
						g.setColor(Color.CYAN);
						if (bId == 0 || bId == 8) g.fillRect(x * px + xOffset, y * py, width, height);
						g.setColor(Color.BLACK);
						if (bId == 5) g.fillRect(x * px + xOffset, y * py, width, height);
						if (bId == 1) g.drawImage(ii.grass, x * px + xOffset, y * py, width, height, null);
						if (bId == 2) g.drawImage(ii.dirt, x * px + xOffset, y * py, width, height, null);
						if (bId == 3) g.drawImage(ii.stone, x * px + xOffset, y * py, width, height, null);
						if (bId == 4) g.drawImage(ii.brick, x * px + xOffset, y * py, width, height, null);
						if (bId == 6) g.drawImage(ii.tnt, x * px + xOffset, y * py, width, height, null);
						if (bId == 7) g.drawImage(ii.obsidian, x * px + xOffset, y * py, width, height, null);
						if (bId == 8) g.drawImage(ii.sign, x * px + xOffset, y * py, width, height, null);
						if (bId == 9) g.drawImage(ii.chest, x * px + xOffset, y * py, width, height, null);
					}

					// g.setColor(Color.BLUE);
					// g.drawRect(x * px, y * py, width, height);
					// g.setColor(Color.BLACK);
					// g.drawString("" + px + xOff + (py * 62 * Load.mapLength),
					// x * px, y * py);

				}

			}
			update = true;
			sXOffset = xOffset;
		}
	}

	public static int getXOffset() {
		return sXOffset;
	}

}
