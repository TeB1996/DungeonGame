package com.TeB.DungeonGame;

import java.awt.Graphics2D;
import java.awt.Image;

import com.TeB.Attributes.*;
import com.TeB.Blocks.Block;

public class Player {

	public static boolean onPlatform = false;
	private static int x, y, width, height;
	private static int dx = Main.width / 2 - width / 2;
	private static int dy = Main.height / 2 - height / 2;
	private int blockSize, mapWidth, maxJumpHeight,
			currentJumpHeight = 0;
	private static double zSize;

	public static int[] points = new int[12];
	private Image characterImage = ImageImport.player;
	private keyListener kl = new keyListener();

	public static Attributes[] attributes = new Attributes[10];
	public static boolean[] attributeActivated = new boolean[10];

	public Player() {
		new ImageImport();
		zSize = Load.mapScale;
		characterImage = ImageImport.player;
		dx = Main.width / 2 - width / 2;
		dy = Main.height / 2 - height / 2;
		y = 0;
		x = 0;
		characterImage = ImageImport.player;

		attributes[0] = new JumpBoost();
		attributes[1] = new Shards();
		attributes[2] = new Dig();
		attributes[3] = new Shield();

		int spawnBlockX = Load.spawnBlockX;
		int spawnBlockY = Load.spawnBlockY;

		if (spawnBlockX * BlockRender.blockSize < Main.width / 2) {
			dx = spawnBlockX * BlockRender.blockSize;
		}
		if (spawnBlockY * BlockRender.blockSize < Main.height / 2) {
			dy = spawnBlockY * BlockRender.blockSize + 1;
		}

		for (int i = 0; i < attributeActivated.length - 1; i++)
			attributeActivated[i] = false;

	}

	@SuppressWarnings("static-access")
	public void update(int delta) {

		blockSize = (int) (16 * zSize);
		mapWidth = Load.chunkWidth * Load.mapWidth;
		maxJumpHeight = (int) (blockSize * 2 / zSize);
		width = (int) (12 * zSize);
		height = (int) (28 * zSize);

		points[0] = (int) ((-x + 2 + dx) / blockSize)
				+ (int) ((-y + dy) / blockSize) * mapWidth;
		points[1] = (int) ((-x + width - 2 + dx) / blockSize)
				+ (int) ((-y + dy) / blockSize) * mapWidth;
		points[2] = (int) ((-x + 2 + dx) / blockSize)
				+ (int) ((-y + dy + height + 1) / blockSize) * mapWidth;
		points[3] = (int) ((-x + width - 2 + dx) / blockSize)
				+ (int) ((-y + dy + height + 1) / blockSize) * mapWidth;
		points[4] = (int) ((-x + dx - 1) / blockSize)
				+ (int) ((-y + dy) / blockSize) * mapWidth;
		points[5] = (int) ((-x + dx - 1) / blockSize)
				+ (int) ((-y + height / 2 + dy) / blockSize) * mapWidth;
		points[6] = (int) ((-x + dx - 1) / blockSize)
				+ (int) ((-y + height + dy) / blockSize) * mapWidth;
		points[7] = (int) ((-x + dx + 1 + width) / blockSize)
				+ (int) ((-y + dy) / blockSize) * mapWidth;
		points[8] = (int) ((-x + dx + 1 + width) / blockSize)
				+ (int) ((-y + +height / 2 + dy) / blockSize) * mapWidth;
		points[9] = (int) ((-x + dx + 1 + width) / blockSize)
				+ (int) ((-y + +height + dy) / blockSize) * mapWidth;
		points[10] = (int) ((-x + width / 2 + dx) / blockSize)
				+ (int) ((-y + dy + height + 1) / blockSize) * mapWidth;

		if (Block.getBackgroundBlock(Block.getBlockById(Load.Block[points[2]]))
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[3]]))) {
			if (!kl.jump)
				if (y > -blockSize * mapWidth + Main.height * zSize
						+ Main.height / (zSize + zSize / 2) - 16 / zSize * 1.5
						&& dy > Main.height / 2 - height)
					y -= zSize;
				else
					dy += zSize;
			onPlatform = false;

		} else {
			onPlatform = true;
		}

		if (kl.jump) {
			currentJumpHeight++;
			if (Block.getBackgroundBlock(Block
					.getBlockById(Load.Block[points[0]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[1]])))
				if (y < 0 && dy < Main.height / 2 - height)
					y += zSize;
				else
					dy -= zSize;
			else {
				kl.jump = false;
				currentJumpHeight = 0;
			}
			if (currentJumpHeight > maxJumpHeight) {
				currentJumpHeight = 0;
				kl.jump = false;
			}
		}

		if (x < 0 && !(dx > Main.width / 2 - width / 2)) {
			if (kl.left
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[4]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[5]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[6]])))
				x += zSize;
		} else {
			if (kl.left
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[4]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[5]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[6]])) && dx > 0)
				dx -= zSize;
		}
		if (x > -blockSize * mapWidth + Main.width - width / 2
				&& !(dx < Main.width / 2 - width / 2)) {
			if (kl.right
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[7]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[8]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[9]])))
				x -= zSize;
		} else {
			if (kl.right
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[7]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[8]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById(Load.Block[points[9]]))
					&& dx < Main.width - width - width / 2)
				dx += zSize;
		}

		for (int i = 0; i < attributeActivated.length - 1; i++)
			if (attributeActivated[i])
				attributes[i].update(delta);

		// System.out.println("bID: " + points[1] + " x: " + ((-x + width +
		// dx)/blockSize) + " y: " + (((y - height)/blockSize) * mapWidth) +
		// " dy: " + y);

	}

	public void draw(Graphics2D g) {
		// g.rotate(90.0);
		g.drawImage(characterImage, dx, dy, width, height, null);
		g.drawRect(dx, dy, width, height);

		for (int i = 0; i < attributeActivated.length - 1; i++)
			if (attributeActivated[i])
				attributes[i].draw(g);
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static int getDrawX() {
		return dx;
	}

	public static int getDrawY() {
		return dy;
	}

	public static void setX(int x) {
		Player.x = x;
	}

	public static void setY(int y) {
		Player.y = y;
	}

	public static void addX(int x) {
		Player.x += x;
	}

	public static void addY(int y) {
		if (Player.y < 0)
			Player.y += y;
		else
			Player.dy -= y;
	}

	public static boolean getWithinProximity(int px, int py) {
		if (px - x > -64 * zSize && px - x < 64 * zSize && py - y < 96 * zSize
				&& py - y > -16 * zSize)
			return true;

		return false;
	}
}
