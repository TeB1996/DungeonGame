package com.TeB.Attributes;

import java.awt.Graphics2D;
//import java.awt.Image;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import com.TeB.Blocks.Block;
//import com.TeB.DungeonGame.Camera;
//import com.TeB.DungeonGame.Load;
//import com.TeB.DungeonGame.Map;
//import com.TeB.DungeonGame.Screen;
//import com.TeB.DungeonGame.keyListener;

public class JumpBoost extends Attributes {

//	private Image jumpShard;
//
//	private int dx, dy, px, py, width = (int) (16 * Map.b.load.mapScale),
//			height = (int) (32 * Map.b.load.mapScale);
//	private double riseAmount = 0.0;
//	private boolean activated = false;

	public JumpBoost() {
//		name = "JumpBoost";
//
//		try {
//			AttributeImage = ImageIO.read(new File("attributes/jumpboost.png"));
//			jumpShard = ImageIO.read(new File("random/jumpshard.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void update(int delta) {
//		if (!activated
//				&& !Block.getBackgroundBlock(Block
//						.getBlockById(Load.Block[Screen.p.points[2]]))
//				&& !Block.getBackgroundBlock(Block
//						.getBlockById(Load.Block[Screen.p.points[3]]))) {
//			px = (int) Screen.p.getX();
//			py = (int) Screen.p.getY();
//			activated = true;
//		} else if (!activated) {
//			Screen.p.attributeActivated[0] = false;
//			Screen.p.attributes[0] = new JumpBoost();
//		} else if (activated) {
//
//			int pgX = (int) Screen.p.getX();
//
//			if (px != pgX) {
//				dx += pgX - px;
//				px = pgX;
//			}
//
//			int pgY = (int) Screen.p.getY();
//
//			if (py != pgY) {
//				dy += pgY - py;
//				py = pgY;
//			}
//
//			if (riseAmount < height) {
//				riseAmount += 1;
//				if(riseAmount != 0 && riseAmount != 63)Screen.p.addY((int)Load.mapScale + 1);
//			}
//			if (keyListener.jump && riseAmount == height) {
//				Screen.p.attributeActivated[0] = false;
//				Screen.p.attributes[0] = new JumpBoost();
//			} else if (!keyListener.jump && riseAmount == height) {
//				Screen.p.addY((int)Load.mapScale);
//			}
//		
//
//		}

	}

	public void draw(Graphics2D g) {
//		if (!activated
//				&& !Block.getBackgroundBlock(Block
//						.getBlockById(Load.Block[Screen.p.points[2]]))
//				&& !Block.getBackgroundBlock(Block
//						.getBlockById(Load.Block[Screen.p.points[3]]))) {
//			dx = Camera.getX();
//			dy = (int) (Camera.getY() - 3.5 * Load.mapScale);
//			activated = true;
//		}
//		g.drawImage(jumpShard.getScaledInstance(width, (int) (1 + riseAmount), 0),
//				dx, (int) (dy + height - riseAmount), width, (int) riseAmount, null);

	}

}
