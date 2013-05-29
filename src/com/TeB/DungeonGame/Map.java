package com.TeB.DungeonGame;

import java.awt.*;

public class Map {

	private Blocks b;

	public static String MapInUse = "Map1";

	public Map() {
		b = new Blocks(MapInUse);
	}

	public void draw(Graphics g) {

		b.draw(g);

	}

	public void changeMap(String newMap) {
		new Save(MapInUse);
		MapInUse = newMap;
		b = new Blocks(MapInUse);
	}

	public String getMap() {
		return MapInUse;
	}
}
