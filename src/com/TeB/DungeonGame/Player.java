package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics;

import com.TeB.Blocks.Block;

public class Player {

	private static int width = 14, height = 28;
	private static int x = 6, y = 8, j = 0, speed = 2;

	public static int itemsInInventory[] = { 306, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static boolean onPlatform = false;

	private static int position[] = new int[18];

	private keyListener kl = new keyListener();
	private int mapLength = Load.mapWidth;
	private static double scale = Load.mapScale;
	private double previousBlock = 0;

	public Player() {
		width = (int) (14 * Load.mapScale);
		height = (int) (28 * Load.mapScale);
	}

	@SuppressWarnings("static-access")
	public void update(int delta) {
		double xMovement = 0;
		double xOffset = Blocks.xOff;

		if (Load.mapUpdate) {
			mapLength = Load.mapWidth;
		}
		int adjustment = (62 * mapLength);
		int dadjustment = (62 * mapLength - 1);
		int blockSize = Blocks.blockSize;
		int blockXOffset = Blocks.getXOffset();

		for (int i = 0; i < 3; i++)
			position[i] = Load.Block[(int) ((((x - (int)blockXOffset
					+ (int) (4 * scale * i) + 1)
					/ blockSize - 1) + (int) xOffset) + (((y) / blockSize + 1)
					* adjustment - dadjustment))];
		for (int i = 3; i < 6; i++)
			position[i] = Load.Block[(int) ((((x - (int) blockXOffset
					+ (int) (7 * scale * (i - 3)))
					/ blockSize - 1) + (int) xOffset) + (((y + height)
					/ blockSize + 1)
					* adjustment - dadjustment))];
		for (int i = 6; i < 12; i++)
			position[i] = Load.Block[(int) ((((x - (int)blockXOffset) / blockSize - 1) + (int) xOffset) + (((y
					+ (int) (4 * scale * (i - 6)) + 1)
					/ blockSize + 1)
					* adjustment - dadjustment))];
		for (int i = 12; i < 18; i++)
			position[i] = Load.Block[(int) ((((x - (int)blockXOffset + width)
					/ blockSize - 1) + (int) xOffset) + (((y
					+ (int) (4 * scale * (i - 12)) + 1)
					/ blockSize + 1)
					* adjustment - dadjustment))];

		if (!kl.running)
			speed = 2;

		if (kl.jump) {

			boolean doJump = true;

			for (int i = 0; i < 3; i++) {
				if (!Block.getBackgroundBlock(position[i]))
					doJump = false;
			}

			if (doJump)
				y -= 2 * delta;

			j += delta;
			if (j > 30) {
				kl.jump = false;
				j = 0;
			}
		}

		if (!kl.jump) {

			for (int i = 0; i < 3; i++)
				if (Block.getBackgroundBlock(position[3])
						&& Block.getBackgroundBlock(position[4])
						&& Block.getBackgroundBlock(position[5])) {
					y += 1 * scale * delta;
					onPlatform = false;
				} else
					onPlatform = true;

		}

		if (kl.running)
			speed = speed + 1;

		if (kl.right) {
			boolean goRight = true;

			for (int i = 12; i < 18; i++)
				if (!Block.getBackgroundBlock(position[i])) {
					goRight = false;
				}
			if (goRight) {
				x += speed * delta;
				xMovement = (double) (speed * delta) / 10;
			}
		}
		if (kl.left) {
			boolean goLeft = true;

			for (int i = 6; i < 12; i++)
				if (!Block.getBackgroundBlock(position[i])) {
					goLeft = false;
				}
			if (goLeft) {
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
		// Load.Block[(int) previousBlock] = 0;
		// Load.Block[(int) ((((x + blockXOffset + width)
		// / blockSize - 1) + xOffset) + (((y + (int)(4 * scale * (12 - 12)) +
		// 1)
		// / blockSize + 1)
		// * adjustment - dadjustment))] = 6;
		// previousBlock = (int) ((((x + blockXOffset + width)
		// / blockSize - 1) + xOffset) + (((y + (int)(4 *scale * (12 - 12)) + 1)
		// / blockSize + 1)
		// * adjustment - dadjustment));
		// System.out.println(((y + (4 *scale * (12 - 12))) + 1));
		// System.out.println(y);
	}

	public void draw(Graphics g) {
		g.drawImage(ImageImport.player, x, y, width, height, null);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
	}

	public static boolean getWithinProximity(int px, int py) {

		// System.out.println("PY: " + py + " Y: " + y + " py - y: " + (py -
		// y));
		// System.out.println("PX: " + px + " X: " + x + " px - x: " + (px -
		// x));
		if (px - x > -64 * scale && px - x < 64 * scale && py - y < 96 * scale
				&& py - y > -16 * scale)
			return true;

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
