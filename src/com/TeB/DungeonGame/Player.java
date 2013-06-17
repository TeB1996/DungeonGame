package com.TeB.DungeonGame;

import java.awt.Graphics;

import com.TeB.Blocks.Block;

public class Player {

	private static int width = 14, height = 28;
	private static int x = 6, y = 8, j = 0, speed = 2;

	public static int itemsInInventory[] = {306, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static boolean onPlatform = false;

	private keyListener kl = new keyListener();
	private int mapLength = Load.mapLength;
	private static double scale = Load.mapScale;

	public Player() {
		width = (int) (14 * Load.mapScale);
		height = (int) (28 * Load.mapScale);
	}
	@SuppressWarnings("static-access")
	public void update(int delta) {
		double xMovement = 0;
		double xOffset = Blocks.xOff;

		if (Load.mapUpdate) {
			mapLength = Load.mapLength;
		}
		int adjustment = (62 * mapLength);
		int dadjustment = (62 * mapLength - 1);
		int blockSize = Blocks.blockSize;

		int p1 = ((((int) x - Blocks.getXOffset() + width) / blockSize - 1) + (int) xOffset) + (((y + height/4) / blockSize + 1) * adjustment - dadjustment);
		int p2 = ((((int) x - Blocks.getXOffset() ) / blockSize - 1) + (int) xOffset) + (((y + height/4) / blockSize + 1) * adjustment - dadjustment);

		if (!kl.running) speed = 2;

		if (kl.jump) {
			if (Block.getBackgroundBlock(Load.Block[((((int) x ) / blockSize - 1) + (int) xOffset) + (((y - 1) / blockSize + 1) * adjustment - dadjustment)]) 
					&& Block.getBackgroundBlock(Load.Block[((((int) x + width) / blockSize - 1) + (int) xOffset) + (((y - 1) / blockSize + 1) * adjustment - dadjustment)])) 
						y -= 2 * delta;
			
			j += delta;
			if (j > 30) {
				kl.jump = false;
				j = 0;
			}
		}

		if (p1 > 0) {
			if (Block.getBackgroundBlock(Load.Block[((((int) x + 4) / blockSize - 1) + (int) xOffset) + (((y + height) / blockSize + 1) * adjustment - dadjustment)]) && Block.getBackgroundBlock(Load.Block[((((int) x + width - 4) / blockSize - 1) + (int) xOffset) + (((y + height) / blockSize + 1) * adjustment - dadjustment)]) && !kl.jump && delta < 30) {
				y += 3 * delta;
				onPlatform = false;
			} else onPlatform = true;
		} else y += 3;

		if (kl.running) speed = speed + 1;

		if (p1 > 0 && p2 > 0) {
			if (kl.right) if (Block.getBackgroundBlock(Load.Block[p1]) && Block.getBackgroundBlock(Load.Block[p1 + adjustment])) {
				
				x += speed * delta;
				xMovement = (double) (speed * delta) / 10;
			}
			if (kl.left) if (Block.getBackgroundBlock(Load.Block[p2]) && Block.getBackgroundBlock(Load.Block[p2 + adjustment])) {
				
				x -= speed * delta;
				xMovement = (double) (speed * delta) / 10;
			}

		}
		if (xMovement > 0.0 && kl.right) {
			// System.out.println("x: " + x + " width/2: " + Main.width / 2 +
			// " xOffSet: " + xOffset);
			if (x > Main.width / 2 && x < Main.width / 2 + 10 && xOffset < 62.5) {
				x -= speed * delta;
				Blocks.xOff += xMovement;
			}
			xMovement = 0;
		}
		if (xMovement > 0.0 && kl.left) {
			// System.out.println("x: " + x + " width/2: " + Main.width / 2 +
			// " xOffSet: " + xOffset);
			if (x > Main.width / 2 - 10 && x < Main.width / 2 && xOffset > 0) {
				x += speed * delta;
				Blocks.xOff -= xMovement;
			}
			xMovement = 0;
		}
		// if (delta > 1) System.out.println("Delta: " + delta);

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
		if (px - x > -64*scale && px - x < 64*scale && py - y < 96*scale && py - y > -16*scale) return true;

		return false;
	}

	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}
	public static int getWidth() {
		return width;
	}
	public static int getHeight() {
		return height;
	}

}
