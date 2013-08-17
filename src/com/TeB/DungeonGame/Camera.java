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
		int pXtemp = (int) Screen.p.getX();
		int pYtemp = (int) Screen.p.getY();
		int mapWidth = (int) (- Map.b.load.chunkWidth *  Map.b.load.mapWidth
				* ( Map.b.load.mapScale * 16) + Main.width);
		int mapHeight = (int) (- Map.b.load.chunkHeight *  Map.b.load.mapHeight
				* ( Map.b.load.mapScale * 16) + Main.height);

		if (focus.equalsIgnoreCase("PLAYER")) {
			if (pXtemp >= mainWidth && pX != pXtemp) {
				if (x >= mapWidth) {
					int addX = pX - pXtemp;
					x += addX;
					pX = pXtemp;
				}
				if (x <= mapWidth) {
					int addX = pX - pXtemp;
					if (addX > 0 && x < mainWidth && x > mainWidth + 10)
						x += addX;
					pX = pXtemp;
				}
			} else {
				// if(!(x >= mapWidth))System.out.println("first");
				// if( !(pXtemp >= mainWidth))System.out.println("second");
				// if(!(pX != pXtemp))System.out.println("third");

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
