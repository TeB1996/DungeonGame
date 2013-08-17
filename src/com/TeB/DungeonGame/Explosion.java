package com.TeB.DungeonGame;

import com.TeB.Blocks.Block;

public class Explosion implements Runnable {

	private Thread tnt = new Thread(this);
	private int mapLength =  Map.b.load.mapWidth;
	private int position;

	private boolean s = false;

	@SuppressWarnings("deprecation")
	public Explosion(int position) {
		this.position = position;
		if (s) {
			s = false;
			tnt.stop();
		}
		s = true;
		tnt.start();

	}

	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		for (int i = 0; i < 5; i++) {
			if(Block.getResistands(Map.b.load.getBlock(position + (62*mapLength)-2 + i)) < 6)Map.b.load.setBlockValue(0,position + (62*mapLength)-2 + i);
			if(Block.getResistands(Map.b.load.getBlock(position - (62*mapLength)-2 + i)) < 6)Map.b.load.setBlockValue(0,position - (62*mapLength)-2 + i);
		}
		for (int i = 0; i < 3; i++) {
			if(Block.getResistands(Map.b.load.getBlock(position + (124*mapLength)-1 + i)) < 6)Map.b.load.setBlockValue(0,position + (124*mapLength)-1 + i);
			if(Block.getResistands(Map.b.load.getBlock(position - (124*mapLength)-1 + i) ) < 6)Map.b.load.setBlockValue(0,position - (124*mapLength)-1 + i);
		}
		for (int i = 0; i < 5; i++) {
			if(Block.getResistands(Map.b.load.getBlock(position - 2 + i)) < 6)Map.b.load.setBlockValue(0,position - 2 + i);
		}


	}
}
