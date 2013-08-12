package com.TeB.DungeonGame;

public class Camera {

	private static int x = 0;
	private static int y = 0;

	private int pX = 0, pY = 0;
	private String focus = "PLAYER";
	private int mainWidth = Main.width / 2 - 24,
			mainHeight = Main.height / 2 - 46;

	public Camera() {

	}

	public void update(int delta) {
		int pXtemp = (int) Player.getX();
		int pYtemp = (int) Player.getY();
		int mapWidth = (int) (-Load.chunkWidth * Load.mapWidth
				* (Load.mapScale * 16) + Main.width);
		int mapHeight = (int) (-Load.chunkHeight * Load.mapHeight
				* (Load.mapScale * 16) + Main.height);

		if (focus.equalsIgnoreCase("PLAYER")) {
			if (x >= mapWidth && pXtemp >= mainWidth && pX != pXtemp) {
				int addX = pX - pXtemp;
				x += addX;
				pX = pXtemp;
			} else {
				pX = pXtemp;
			}
			if (y >= mapHeight && pYtemp >= mainHeight && pY != pYtemp) {
				int addY = pY - pYtemp;
				y += addY;
				pY = pYtemp;
			} else {
				pY = pYtemp;
			}
		}
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

}
