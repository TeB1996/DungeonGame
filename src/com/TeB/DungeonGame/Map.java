package com.TeB.DungeonGame;

import java.awt.*;

import com.TeB.Characters.Crystalith;

public class Map {

	private BlockRender b;
	public static boolean playerHasRun = false;

	public static String MapInUse = "Map1";

	public Map() {
		b = new BlockRender(MapInUse);
	}

	public void draw(Graphics2D g) {
		b.draw(g);
	}

	public void changeMap(String newMap) {
		new Save(MapInUse);
		new Load (newMap);
		MapInUse = newMap;
		b = new BlockRender(MapInUse);
		new Player(new Crystalith());
	}

	public String getMap() {
		return MapInUse;
	}
}
