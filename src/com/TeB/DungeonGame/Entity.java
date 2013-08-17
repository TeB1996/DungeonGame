package com.TeB.DungeonGame;

import java.awt.Graphics2D;
import java.awt.Image;

import com.TeB.Blocks.Block;

public class Entity {

	protected double x, y, verticalVelocity, horisontalVelocity;
	protected int width, height;
	protected int blockSize, mapWidth, maxJumpHeight, currentJumpHeight = 0;
	protected double gravityPull =  Map.b.load.mapScale;
	protected double xMovement = gravityPull;
	protected boolean onPlatform;
	protected Image sprite;
	public int[] points = new int[12];

	public Entity() {

	}

	protected void Gravity(int delta) {
		if (Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[2]])) && Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[3]]))) {
			y += gravityPull;
			onPlatform = false;
		} else {
			onPlatform = true;
		}
	}

	protected void moveRight(boolean right, int delta) {
		if (right) {
			if (Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[7]])) && Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[8]])) && Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[9]]))) {
				x += verticalVelocity;
			}

		}
	}

	protected void moveLeft(boolean left, int delta) {
		if (left) {
			if (Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[4]])) && Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[5]])) && Block.getBackgroundBlock(Block.getBlockById( Map.b.load.Block[points[6]]))) {
				x -= verticalVelocity;
			}

		}
	}
	
	protected void moveUp(boolean jump, int delta){
		if (jump) {
			currentJumpHeight++;
			if (Block.getBackgroundBlock(Block
					.getBlockById( Map.b.load.Block[points[0]]))
					&& Block.getBackgroundBlock(Block
							.getBlockById( Map.b.load.Block[points[1]])))
				y -= (horisontalVelocity*gravityPull);
			else {
				keyListener.jump = false;
				currentJumpHeight = 0;
			}
			if (currentJumpHeight > maxJumpHeight) {
				currentJumpHeight = 0;
				keyListener.jump = false;
			}
		}
		
	}
	
	protected void configureVelocity(int delta, boolean right, boolean left){

		if (!right && !left && verticalVelocity > xMovement) {
			verticalVelocity -= .02 * xMovement;
		} else if (verticalVelocity < xMovement * 2) {
			verticalVelocity += .01 * xMovement;
		}

	}

	protected void checkMovement(int delta, boolean right, boolean left, boolean jump) {
		moveRight(right, delta);
		moveLeft(left, delta);
		moveUp(jump, delta);
		configureVelocity(delta, right, left);
	}
	
	protected void setHitBox(int delta){

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


	public void draw(Graphics2D g) {

	}

}
