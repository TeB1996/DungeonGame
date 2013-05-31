package com.TeB.DungeonGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.TeB.Blocks.Block;
import com.TeB.Items.Items;

public class mouseListener implements MouseListener , MouseMotionListener{
	
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
		int BlockId = (((int) x) / 16 - 1) + (((y + 4 - 32) / 16 + 1) * 62 - 61);
		if(e.getButton() == MouseEvent.BUTTON3){
			if (Player.getWithinProximity(x, y)) {
				if (Block.hasClickUse(Load.Block[BlockId])) {
					Block.activateClickUse(BlockId, Load.Block[BlockId]);
					//System.out.println(BlockId);
					return;
				}
				if(Block.getResistands(Load.Block[BlockId]) == 0){
					if(Items.isBlock(Player.itemInMainInventory)){
						Block.place(BlockId, Player.itemInMainInventory-300);
					}
					System.out.println(Items.isBlock(Player.itemInMainInventory));
				}
			}
			
			
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
