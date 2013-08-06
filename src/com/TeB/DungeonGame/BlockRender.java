package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class BlockRender {

	public static int mapWidth, mapHeight;
	private int blockWidth = (int) (16 * Load.mapScale),
			blockHeight = (int) (16 * Load.mapScale);
	private Image[] blockImage = new Image[10];
	private Image[] blockLighting = new Image[6];
	private ImageImport ii;

	public static int blockSize;

	public BlockRender(String map) {
		
		new Load(map);
		mapWidth = Load.chunkWidth * Load.mapWidth;
		mapHeight = Load.chunkHeight * Load.mapHeight;
		blockWidth = (int) (16 * Load.mapScale);
		blockHeight = (int) (16 * Load.mapScale);
		blockSize = (int) (16 * Load.mapScale);

		ii = new ImageImport();
		blockImage[1] = ii.grass;
		blockImage[2] = ii.dirt;
		blockImage[3] = ii.stone;
		blockImage[4] = ii.brick;
		blockImage[5] = ii.l5;
		blockImage[6] = ii.tnt;
		blockImage[7] = ii.obsidian;
		blockImage[8] = ii.sign;
		blockImage[9] = ii.chest;

		blockLighting[1] = ii.l1;
		blockLighting[2] = ii.l2;
		blockLighting[3] = ii.l3;
		blockLighting[4] = ii.l4;
		blockLighting[5] = ii.l5;

	}

	public void update(int delta) {

	}

	public void draw(Graphics2D g) {
		blockSize = (int) (16 * Load.mapScale);
		int x = blockWidth, y = blockHeight;
		int xOff = Player.getX(), yOff = Player.getY();

		blockWidth = (int) (16 * Load.mapScale);
		blockHeight = (int) (16 * Load.mapScale);
		
		g.drawImage(ii.airBg, 0,0, blockWidth*mapWidth, blockHeight*mapHeight,null);

		for (int px = 0; px < mapWidth; px++) {

			for (int py = 0; py < mapHeight; py++) {

				int id = px + py * mapWidth;

				int bId = Load.Block[id];
				int blId = Load.BlockLight[id];

				if(bId > 0)g.drawImage(blockImage[bId], x * px + xOff, y * py + yOff,
						blockWidth, blockHeight, null);
				if (blId > 0) {
					g.setColor(new Color(0, 0, 0, 50 * blId));
					g.fillRect(x * px + xOff, y * py + yOff, blockWidth,
							blockHeight);
				}

				// g.setColor(Color.BLACK);
				// g.drawRect(px * x + xOff, py * y + yOff, blockWidth,
				// blockHeight);


			}
		}

	}

}
