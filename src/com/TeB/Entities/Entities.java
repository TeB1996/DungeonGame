package com.TeB.Entities;

import java.awt.Graphics;
import java.util.Arrays;

import com.TeB.DungeonGame.Load;

public class Entities {

	public static Bullet[] bullet = new Bullet[100];
	public static boolean[] bulletActivated = new boolean[100];
	public static Enemy1[] ent = new Enemy1[10];
	public static boolean[] entActivated = new boolean[10];
	public static int bulletAmount = -1;
	public static int mobCount = 3;
	private int mapLength = Load.mapWidth;

	public Entities() {
		Arrays.fill(bulletActivated, false);
		Arrays.fill(entActivated, true);

		for (int i = 0; i < ent.length; i++) {
			ent[i] = new Enemy1(2);
		}
	}

	public void update(int delta) {
		if (bulletAmount >= 0) {
			for (int i = 0; i < 99; i++) {
				if (bulletActivated[i]) bullet[i].update(delta, i, mapLength);
			}
		}

		for (int i = 0; i < mobCount; i++) {
			if (entActivated[i]) ent[i].update(delta, i, mapLength);
		}

	}

	public void draw(Graphics g) {
		if (bulletAmount >= 0) {
			for (int i = 0; i < 99; i++) {
				if (bulletActivated[i]) bullet[i].draw(g);
			}
		}
		for (int i = 0; i < mobCount; i++) {
			if (entActivated[i]) ent[i].draw(g);
		}
	}

	public static void resetBulletId(int Id) {
		// System.out.println("Reseting: " + Id + " bulletAmount: " + bulletAmount);
		bulletAmount--;
		bulletActivated[Id] = false;
	}

	public static void fireBullet(int direction) {
		if (bulletAmount < 99) {
			bulletAmount++;
			bullet[bulletAmount] = new Bullet(direction);
			bulletActivated[bulletAmount] = true;
		}
	}

	public static boolean bulletHit(int x, int y, int width, int height) {
		for (int i = 0; i < mobCount; i++) {
			if (entActivated[i]) ent[i].checkHitbox(x, y, width, height);
		}
		return false;
	}

}
