package com.TeB.DungeonGame;

import java.awt.*;

@SuppressWarnings("serial")
public class Blocks extends Rectangle {

	public Load l;
	public Save s;

	public static boolean isTrue = true;
	public boolean starting = false;
	public String xmap = "";
	
	public static boolean update = true;

	public Blocks(String map) {

		l = new Load(map);
	}

	public void draw(Graphics g) {
		int width = 16, height = width;
		int x = width, y = width;
		BlockImageImport ii = new BlockImageImport();
		
		if (update) {
			for (int py = 0; py <= 44; py++) {

				for (int px = 0; px <= 61; px++) {

					g.setColor(Color.CYAN);
					int id = px + (py * 62);
					
					if (id <= 2808) if (Load.Block[id] == 0 || Load.Block[id] == 8 ) g.fillRect(x * px, y * py, width, height);
					if (id <= 2808) if (Load.Block[id] == 1) g.drawImage(ii.grass, x * px, y * py, width, height, null);
					if (id <= 2808) if (Load.Block[id] == 2) g.drawImage(ii.dirt, x * px, y * py, width, height, null);
					if (id <= 2808) if (Load.Block[id] == 3) g.drawImage(ii.stone, x * px, y * py, width, height, null);
					if (id <= 2808) if (Load.Block[id] == 4) g.drawImage(ii.brick, x * px, y * py, width, height, null);
					g.setColor(Color.BLACK);
					if (id <= 2808) if (Load.Block[id] == 5) g.fillRect(x * px, y * py, width, height);
					if (id <= 2808) if (Load.Block[id] == 6) g.drawImage(ii.tnt, x * px, y * py, width, height, null);
					if (id <= 2808) if (Load.Block[id] == 7) g.drawImage(ii.obsidian, x * px, y * py, width, height, null);
					if (id <= 2808) if (Load.Block[id] == 8) g.drawImage(ii.sign, x * px, y * py, width, height, null);
					if (id <= 2808) if (Load.Block[id] == 9) g.drawImage(ii.chest, x * px, y * py, width, height, null);
					
					//g.setColor(Color.BLUE);
					//g.drawRect(x * px, y * py, width, height);
					
				}

			}
			update = true;
		}
	}

}
