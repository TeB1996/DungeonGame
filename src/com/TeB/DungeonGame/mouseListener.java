package com.TeB.DungeonGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.TeB.Blocks.Block;
import com.TeB.Blocks.Tnt;

public class mouseListener implements MouseListener, MouseMotionListener {

	private static int x;
	private static int y;

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int blockSize = BlockRender.blockSize;
		int mapWidth = BlockRender.mapWidth;

		int BlockId =  ((x - 10 - Player.getX()) / blockSize)
				+ ( ((y - 30  - Player.getY()) / blockSize) * mapWidth);
		
		Block block = Block.getBlockById(Load.Block[BlockId]);
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (Block.hasClickUse(block)) {
				Block.activateClickUse(block, BlockId);
				return;
			}
			if (Block.getResistands(block) == 0) {
				Block.place(BlockId, new Tnt());

			}

			System.out.println(BlockId);

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
