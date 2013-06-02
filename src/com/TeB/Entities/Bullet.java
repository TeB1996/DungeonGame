package com.TeB.Entities;

import java.awt.Color;
import java.awt.Graphics;

import com.TeB.Blocks.Block;
import com.TeB.DungeonGame.Load;
import com.TeB.DungeonGame.Main;
import com.TeB.DungeonGame.Player;

public class Bullet {

	private int x = 30, y = 30;
	private int width = 3, height = 1;
	private int direction = 0;
	private int bulletTravelLength = 0;
	private boolean run = false;
	
	public Bullet(int direction){
		this.direction = direction;
	}

	public void update(int delta, int Id) {
			if(!run){
				x = Player.getX() + Player.getWidth();
				y = Player.getY() + Player.getHeight()/2;
				run = true;
			}
			if(direction == 2)x+=3;
			if(direction == 4)x-=3;
			bulletTravelLength++;
			if(bulletTravelLength > 80&&bulletTravelLength % 20 == 0){
				y++;
			}
			if(!Block.getBackgroundBlock(Load.Block[(((int) x) / 16 - 1) + (((y-32) / 16 + 1) * 62 - 61)]) || x > Main.width){
				System.out.println("Block: " + Load.Block[(((int) x) / 16 - 1) + (((y - 32) / 16 + 1) * 62 - 61)] + " BlockId: " + ((((int) x) / 16 - 1) + (((y) / 16 + 1) * 62 - 61)));
				Entities.resetId(Id);
			}
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}

}