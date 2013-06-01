package com.TeB.DungeonGame;

import java.awt.Graphics;

import com.TeB.Blocks.Block;

public class Player {

	private static int width = 14, height = 28;
	private static int x = 6, y = 8, j = 0, speed = 2;

	public static int itemsInInventory[] = {306, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static boolean onPlatform = false;

	private keyListener kl = new keyListener();

	public Player() {

	}
	@SuppressWarnings("static-access")
	public void update(int delta) {
		
		int p1 = (((int) x + width) / 16 - 1) + (((y + 7) / 16 + 1) * 62 - 61);
		int p2 = (((int) x - 1) / 16 - 1) + (((y + 7) / 16 + 1) * 62 - 61);

		if (!kl.running) speed = 2;

		if (kl.jump) {
			if (Block.getBackgroundBlock(Load.Block[(((int) x + 3) / 16 - 1) + (((y - 1) / 16 + 1) * 62 - 61)]) && Block.getBackgroundBlock(Load.Block[(((int) x + width - 3) / 16 - 1) + (((y - 1) / 16 + 1) * 62 - 61)])) y -= 2 * delta;
			j += delta;
			speed = 1;
			if (j > 20) {
				kl.jump = false;
				j = 0;
			}
		}

		if (p1 > 0 && p1 < 3000) {
			if (Block.getBackgroundBlock(Load.Block[(((int) x + 3) / 16 - 1) + (((y + height) / 16 + 1) * 62 - 61)]) && Block.getBackgroundBlock(Load.Block[(((int) x + width - 3) / 16 - 1) + (((y + height) / 16 + 1) * 62 - 61)]) && !kl.jump && delta < 30) {
				y += 2 * delta;
				onPlatform = false;
			} else onPlatform = true;
		} else y += 3;

		if (kl.running) speed = speed + 1;


		if (p1 > 0 && p2 > 0) {
			if (kl.right) if (Block.getBackgroundBlock(Load.Block[p1]) && Block.getBackgroundBlock(Load.Block[p1 + 62])) x += speed * delta;
			if (kl.left) if (Block.getBackgroundBlock(Load.Block[p2]) && Block.getBackgroundBlock(Load.Block[p2 + 62])) x -= speed * delta;

		}

		if (delta > 1) System.out.println("Delta: " + delta);

		speed = 2;

	}
	public void draw(Graphics g) {
		g.drawImage(ImageImport.player, x, y, width, height, null);
	}

	public static boolean getWithinProximity(int px, int py) {

		// System.out.println("PY: " + py + " Y: " + y + " py - y: " + (py -
		// y));
		// System.out.println("PX: " + px + " X: " + x + " px - x: " + (px -
		// x));
		if (px - x > -64 && px - x < 64 && py - y < 96 && py - y > -16) return true;

		return false;
	}

}
