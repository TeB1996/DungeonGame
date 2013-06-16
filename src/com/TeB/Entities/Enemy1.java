package com.TeB.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.TeB.Blocks.Block;
import com.TeB.DungeonGame.Blocks;
import com.TeB.DungeonGame.Load;
import com.TeB.DungeonGame.Player;

public class Enemy1 {

	private double scale = Load.mapScale;
	private double xOffset = 0;
	private int x = 30, y = 30;
	private int width = (int) (14*scale), height = (int) (28*scale);

	@SuppressWarnings("unused")
	private int direction = 0, speed = 2, j = 0;
	private boolean run = false;
	@SuppressWarnings("unused")
	private boolean jump = false, onPlatform = false, running = false, right = false, left = false;
	private Random rand = new Random();
	@SuppressWarnings("unused")
	private int pw = Player.getWidth(), ph = Player.getHeight();

	public Enemy1(int direction) {
		this.direction = direction;
	}

	public void update(int delta, int id, int mapLength) {
		if (!run) {
			x = 100;
			y = 290;
			run = true;
		}
		if (!running) speed = 1 + rand.nextInt(2);
		int adjustment = (62*mapLength);
		int dadjustment = (62*mapLength - 1);
		int blockSize = Blocks.blockSize;
		double xOff = Blocks.xOff;
		int p1 = (((int) x + width) / blockSize - 1) + (((y + 7) / blockSize + 1) * adjustment  - dadjustment);
		int p2 = (((int) x - 1) / blockSize - 1) + (((y + 7) / blockSize + 1) * adjustment  - dadjustment);
		int px = Player.getX();
		int py = Player.getY();
		
		if(xOff != xOffset){
			x += xOff-xOffset;
			xOffset = xOff;
		}

		if (py == y) {
			if (x < px) {
				right = true;
				left = false;
			}
			if (x + pw > px) {
				left = true;
				right = false;
			}
		}
		if(py < y){
			
		}

		// System.out.println("PlayerY:" + py + " Enemy" + id + "Y: " + y);

		if (jump) {
			if (Block.getBackgroundBlock(Load.Block[(((int) x + 3) / blockSize - 1) + (((y - 1) / blockSize + 1) * adjustment  - dadjustment)]) && Block.getBackgroundBlock(Load.Block[(((int) x + width - 3) / blockSize - 1) + (((y - 1) / blockSize + 1) * adjustment  - dadjustment)])) y -= 2 * delta;
			j += delta;
			speed = 1;
			if (j > 20) {
				jump = false;
				j = 0;
			}
		}

		if (p1 > 0 && p1 < 3000) {
			if (Block.getBackgroundBlock(Load.Block[(((int) x + 3) / blockSize - 1) + (((y + height) / blockSize + 1) * adjustment  - dadjustment)]) && Block.getBackgroundBlock(Load.Block[(((int) x + width - 3) / blockSize - 1) + (((y + height) / blockSize + 1) * adjustment  - dadjustment)]) && !jump && delta < 30) {
				y += 2 * delta;
				onPlatform = false;
			} else onPlatform = true;
		} else y += 3;

		if (running) speed = speed + 1;

		if (p1 > 0 && p2 > 0 && delta < 20) {
			if (right) if (Block.getBackgroundBlock(Load.Block[p1]) && Block.getBackgroundBlock(Load.Block[p1 + adjustment])) x += speed * delta;
			if (left) if (Block.getBackgroundBlock(Load.Block[p2]) && Block.getBackgroundBlock(Load.Block[p2 + adjustment])) x -= speed * delta;

		}

		speed = 2;

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}

	public boolean checkHitbox(int x1, int y1, int width1, int height1) {
		if (x1 > x && x1 < x + width) { return true; }
		return false;

	}

}
