package com.TeB.DungeonGame;

import com.TeB.Blocks.Block;

public class Explosion implements Runnable {

	private Thread tnt = new Thread(this);
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
			if(Block.getResistands(Load.Block[position + 60 + i]) < 5)Load.Block[position + 60 + i] = 0;
			if(Block.getResistands(Load.Block[position - 60 - i]) < 5)Load.Block[position - 60 - i] = 0;
			
		}
		for (int i = 0; i < 3; i++) {
			if(Block.getResistands(Load.Block[position + 123 + i]) < 5)Load.Block[position + 123 + i] = 0;
			if(Block.getResistands(Load.Block[position - 123 - i]) < 5)Load.Block[position - 123 - i] = 0;
		}
		for (int i = 0; i < 5; i++) {
			if(Block.getResistands(Load.Block[position - 2 + i]) < 5)Load.Block[position - 2 + i] = 0;

		}


	}
}
