package com.TeB.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.TeB.Blocks.Block;
import com.TeB.DungeonGame.Load;

public class Enemy1 {
	
	private int x = 30, y = 30;
	private int width = 14, height = 28;


	
	private int direction = 0, speed = 2, j = 0;
	private boolean run = false;
	private boolean jump = false, onPlatform = false, running = false, right = false, left = false;
	private Random rand = new Random();
	
	public Enemy1(int direction){
		this.direction = direction;
	}
	
	public void update(int delta, int id){
		if(!run){
			x = 100;
			y = 290;
			run = true;
		}
		if (!running) speed = 2;
		int p1 = (((int) x + width) / 16 - 1) + (((y + 7) / 16 + 1) * 62 - 61);
		int p2 = (((int) x - 1) / 16 - 1) + (((y + 7) / 16 + 1) * 62 - 61);

		if (jump) {
			if (Block.getBackgroundBlock(Load.Block[(((int) x + 3) / 16 - 1) + (((y - 1) / 16 + 1) * 62 - 61)]) && Block.getBackgroundBlock(Load.Block[(((int) x + width - 3) / 16 - 1) + (((y - 1) / 16 + 1) * 62 - 61)])) y -= 2 * delta;
			j += delta;
			speed = 1;
			if (j > 20) {
				jump = false;
				j = 0;
			}
		}

		if (p1 > 0 && p1 < 3000) {
			if (Block.getBackgroundBlock(Load.Block[(((int) x + 3) / 16 - 1) + (((y + height) / 16 + 1) * 62 - 61)]) && Block.getBackgroundBlock(Load.Block[(((int) x + width - 3) / 16 - 1) + (((y + height) / 16 + 1) * 62 - 61)]) && !jump && delta < 30) {
				y += 2 * delta;
				onPlatform = false;
			} else onPlatform = true;
		} else y += 3;

		if (running) speed = speed + 1;

		if(direction == 2)right = true;
		if(direction == 4)left = true;
		if (p1 > 0 && p2 > 0 && delta < 20) {
			if (right) if (Block.getBackgroundBlock(Load.Block[p1]) && Block.getBackgroundBlock(Load.Block[p1 + 62])) x += speed * delta;
			if (left) if (Block.getBackgroundBlock(Load.Block[p2]) && Block.getBackgroundBlock(Load.Block[p2 + 62])) x -= speed * delta;

		}


		speed = 2;
		 
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
	
	public boolean checkHitbox(int x1, int y1, int width1, int height1){
		if(x1 > x && x1 < x + width){
			return true;
		}
		System.out.println("HIT");
		return false;
		
	}

}
