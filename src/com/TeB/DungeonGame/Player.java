package com.TeB.DungeonGame;

import java.awt.Graphics2D;
import java.awt.Image;

import com.TeB.Attributes.*;
import com.TeB.Blocks.Block;
import com.TeB.Characters.Characters;

public class Player extends Entity {

	public boolean onPlatform = false;
	private double zSize;

	public int[] points = new int[12];
	private keyListener kl = new keyListener();
	private Image playerSprite;

	public Attributes[] attributes = new Attributes[10];
	public boolean[] attributeActivated = new boolean[10];

	public Player(Characters character) {
		playerSprite = character.getCharacterImage();
		zSize = Load.mapScale;
		width = (int) (character.getWidth());
		height = (int) (character.getHeight());
		blockSize = (int) (16 * zSize);
		mapWidth = Load.chunkWidth * Load.mapWidth;
		maxJumpHeight = (int) (blockSize * 2 / zSize);
		y = 0;
		x = 0;
		horisontalVelocity = zSize;

		attributes[0] = new JumpBoost();
		attributes[1] = new Shards();
		attributes[2] = new Dig();
		attributes[3] = new Shield();

		int spawnBlockX = Load.spawnBlockX;
		int spawnBlockY = Load.spawnBlockY;

		if (spawnBlockX * BlockRender.blockSize < Main.width / 2) {
			x = spawnBlockX * BlockRender.blockSize;
		}
		if (spawnBlockY * BlockRender.blockSize < Main.height / 2) {
			y = spawnBlockY * BlockRender.blockSize + 1;
		}

		for (int i = 0; i < attributeActivated.length - 1; i++)
			attributeActivated[i] = false;

	}

	@SuppressWarnings("static-access")
	public void update(int delta) {

		int cX = (int) x;
		int cY = (int) y;

		points[0] = (int) ((+2 + cX) / blockSize) + (int) ((cY) / blockSize)
				* mapWidth;
		points[1] = (int) ((width - 2 + cX) / blockSize)
				+ (int) ((cY) / blockSize) * mapWidth;
		points[2] = (int) ((2 + cX) / blockSize)
				+ (int) ((cY + height + 1) / blockSize) * mapWidth;
		points[3] = (int) ((width - 2 + cX) / blockSize)
				+ (int) ((cY + height + 1) / blockSize) * mapWidth;
		points[4] = (int) ((cX - 1) / blockSize) + (int) ((1 + cY) / blockSize)
				* mapWidth;
		points[5] = (int) ((cX - 1) / blockSize)
				+ (int) ((height / 2 + cY) / blockSize) * mapWidth;
		points[6] = (int) ((cX - 1) / blockSize)
				+ (int) ((height + cY) / blockSize) * mapWidth;
		points[7] = (int) ((cX + 1 + width) / blockSize)
				+ (int) ((cY + 1) / blockSize) * mapWidth;
		points[8] = (int) ((cX + 1 + width) / blockSize)
				+ (int) ((height / 2 + cY) / blockSize) * mapWidth;
		points[9] = (int) ((cX + 1 + width) / blockSize)
				+ (int) ((height + cY) / blockSize) * mapWidth;
		points[10] = (int) ((width / 2 + cX) / blockSize)
				+ (int) ((cY + height + 1) / blockSize) * mapWidth;

		if (Block.getBackgroundBlock(Block.getBlockById(Load.Block[points[2]]))
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[3]]))) {
			y += zSize;
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
				y -= (horisontalVelocity*zSize);
			else {
				kl.jump = false;
				currentJumpHeight = 0;
			}
			if (currentJumpHeight > maxJumpHeight) {
				currentJumpHeight = 0;
				kl.jump = false;
			}
		}

		if (kl.left
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[4]]))
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[5]]))
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[6]]))) {
			x -= verticalVelocity;
		}

		if (kl.right
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[7]]))
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[8]]))
				&& Block.getBackgroundBlock(Block
						.getBlockById(Load.Block[points[9]]))) {
			x += verticalVelocity;
		}

		if (!kl.right && !kl.left && verticalVelocity > zSize) {
			verticalVelocity -= .02 * zSize;
		} else if (verticalVelocity < zSize * 2) {
			verticalVelocity += .01 * zSize;
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
		g.drawImage(playerSprite, (int) (x + Camera.getX()),
				(int) (y + Camera.getY()), width, height, null);
		g.drawRect((int) (x + Camera.getX()), (int) (y + Camera.getY()), width,
				height);

		for (int i = 0; i < attributeActivated.length - 1; i++)
			if (attributeActivated[i])
				attributes[i].draw(g);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void addX(int x) {
		this.x += x;
	}

	public void addY(int y) {
		this.y += y;
	}

	public boolean getWithinProximity(int px, int py) {
		if (px - x > -64 * zSize && px - x < 64 * zSize && py - y < 96 * zSize
				&& py - y > -16 * zSize)
			return true;

		return false;
	}

	public void changeMap(Characters character) {
		playerSprite = character.getCharacterImage();
		zSize = Load.mapScale;
		width = (int) (character.getWidth());
		height = (int) (character.getHeight());
		blockSize = (int) (16 * zSize);
		mapWidth = Load.chunkWidth * Load.mapWidth;
		maxJumpHeight = (int) (blockSize * 2 / zSize);
		y = 0;
		x = 0;

		attributes[0] = new JumpBoost();
		attributes[1] = new Shards();
		attributes[2] = new Dig();
		attributes[3] = new Shield();

		int spawnBlockX = Load.spawnBlockX;
		int spawnBlockY = Load.spawnBlockY;

		if (spawnBlockX * BlockRender.blockSize < Main.width / 2) {
			x = spawnBlockX * BlockRender.blockSize;
		}
		if (spawnBlockY * BlockRender.blockSize < Main.height / 2) {
			y = spawnBlockY * BlockRender.blockSize + 1;
		}

		for (int i = 0; i < attributeActivated.length - 1; i++)
			attributeActivated[i] = false;

	}
}
