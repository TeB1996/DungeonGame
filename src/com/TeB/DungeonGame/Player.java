package com.TeB.DungeonGame;

import java.awt.Graphics2D;
import com.TeB.Attributes.*;
import com.TeB.Characters.Characters;

public class Player extends Entity {

	private double zSize;
	public Attributes[] attributes = new Attributes[10];
	public boolean[] attributeActivated = new boolean[10];

	public Player(Characters character) {
		sprite = character.getCharacterImage();
		zSize =  Map.b.load.mapScale;
		width = (int) (character.getWidth());
		height = (int) (character.getHeight());
		blockSize = (int) (16 * zSize);
		mapWidth =  Map.b.load.chunkWidth *  Map.b.load.mapWidth;
		maxJumpHeight = (int) (blockSize * 2 / zSize);
		y = 0;
		x = 0;
		horisontalVelocity = zSize;

		attributes[0] = new JumpBoost();
		attributes[1] = new Shards();
		attributes[2] = new Dig();
		attributes[3] = new Shield();

		int spawnBlockX = Map.b.load.spawnBlockX;
		int spawnBlockY =  Map.b.load.spawnBlockY;

		if (spawnBlockX * Map.b.blockSize < Main.width / 2) {
			x = spawnBlockX * Map.b.blockSize;
		}
		if (spawnBlockY * Map.b.blockSize < Main.height / 2) {
			y = spawnBlockY * Map.b.blockSize + 1;
		}

		for (int i = 0; i < attributeActivated.length - 1; i++)
			attributeActivated[i] = false;

	}

	public void update(int delta) {
		setHitBox(delta);
		Gravity(delta);
		checkMovement(delta, keyListener.right, keyListener.left, keyListener.jump);

		for (int i = 0; i < attributeActivated.length - 1; i++)
			if (attributeActivated[i]) attributes[i].update(delta);

	}

	public void draw(Graphics2D g) {
		// g.rotate(90.0);
		g.drawImage(sprite, (int) (x + Camera.getX()), (int) (y + Camera.getY()), width, height, null);
		g.drawRect((int) (x + Camera.getX()), (int) (y + Camera.getY()), width, height);

		for (int i = 0; i < attributeActivated.length - 1; i++)
			if (attributeActivated[i]) attributes[i].draw(g);
	}

	public boolean getWithinProximity(int px, int py) {
		if (px - x > -64 * zSize && px - x < 64 * zSize && py - y < 96 * zSize && py - y > -16 * zSize) return true;

		return false;
	}

	public void changeMap(Characters character) {
		sprite = character.getCharacterImage();
		zSize =  Map.b.load.mapScale;
		width = (int) (character.getWidth());
		height = (int) (character.getHeight());
		blockSize = (int) (16 * zSize);
		mapWidth =  Map.b.load.chunkWidth *  Map.b.load.mapWidth;
		maxJumpHeight = (int) (blockSize * 2 / zSize);
		y = 0;
		x = 0;

		attributes[0] = new JumpBoost();
		attributes[1] = new Shards();
		attributes[2] = new Dig();
		attributes[3] = new Shield();

		int spawnBlockX =  Map.b.load.spawnBlockX;
		int spawnBlockY =  Map.b.load.spawnBlockY;

		if (spawnBlockX * Map.b.blockSize < Main.width / 2) {
			x = spawnBlockX * Map.b.blockSize;
		}
		if (spawnBlockY * Map.b.blockSize < Main.height / 2) {
			y = spawnBlockY * Map.b.blockSize + 1;
		}

		for (int i = 0; i < attributeActivated.length - 1; i++)
			attributeActivated[i] = false;

	}
}
