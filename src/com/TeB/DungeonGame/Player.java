package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics;

import com.TeB.Blocks.Block;

public class Player {

	private static int width = 14, height = 28;
	private static int x = 6, y = 8, j = 0, speed = 2;

	public static int itemInMainInventory = 3;
	public static int itemsInInventory[] = {306,0,0,0,0,0,0,0,0,0};
	public static boolean onPlatform = false;
	public static int position = (((int) x) / 16) + (((y + height + 4 - 16) / 16 + 1) * 62 - 61);

	private keyListener kl = new keyListener();

	public Player() {

	}
	@SuppressWarnings("static-access")
	public void update(int delta) {

		if (!kl.running) speed = 2;

		if (kl.jump) {
			y -= 2 * delta;
			j++;
			speed = 1;
			if (j > 20) {
				kl.jump = false;
				j = 0;
			}
		}

		if (((x + 1) / 16 - 1) + ((y / 16 + 1) * 59 - 61) >= 0) {
			if (Block.getBackgroundBlock(Load.Block[(((int) x + 3) / 16 - 1) + (((y + height + 4) / 16 + 1) * 62 - 61)]) && Block.getBackgroundBlock(Load.Block[(((int) x + width) / 16 - 1) + (((y + height + 4) / 16 + 1) * 62 - 61)]) && !kl.jump) {
				y += 3 * delta;
				speed = 4;
				onPlatform = false;
			} else onPlatform = true;
		} else y += 3;

		if (kl.running) speed = speed + 1;
		if ((((int) x) / 16) + (((y + height + 4 - 16) / 16 + 1) * 62 - 61) > 0 && (((int) x) / 16) + (((y + height / 2 + 4 - 16) / 16 + 1) * 62 - 61) > 0) {
			if (kl.right) if (Block.getBackgroundBlock(Load.Block[(((int) x) / 16) + (((y + height + 4 - 16) / 16 + 1) * 62 - 61)]) && Block.getBackgroundBlock(Load.Block[(((int) x) / 16) + (((y + height / 2 + 4 - 16) / 16 + 1) * 62 - 61)])) x += speed * delta;
			if (kl.left) if (Block.getBackgroundBlock(Load.Block[(((int) x) / 16) + (((y + height + 4 - 16) / 16 + 1) * 62 - 61) - 1]) && Block.getBackgroundBlock(Load.Block[(((int) x) / 16) + (((y + height / 2 + 4 - 16) / 16 + 1) * 62 - 61) - 1])) x -= speed * delta;

		}
		if (delta > 1) System.out.println("Delta: " + delta);
		speed = 2;
		position = (((int) x) / 16) + (((y + height + 4 - 16) / 16 + 1) * 62 - 61);
		itemInMainInventory = itemsInInventory[0];

	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x + 2, y + 4, width, height);
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
