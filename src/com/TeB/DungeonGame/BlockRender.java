package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BlockRender {

	public int mapWidth;
	public int mapHeight;;
	public boolean reDraw = true;
	private int blockWidth , blockHeight;
	private BufferedImage mapImage;
	private Image[] blockImage = new Image[10];
	private Image[] blockLighting = new Image[6];
	private ImageImport ii;
	
	public Load load;

	public int blockSize;

	public BlockRender(String map) {

		load = new Load(map);
		mapWidth = load.chunkWidth * load.mapWidth;
		mapHeight = load.chunkHeight * load.mapHeight;
		blockWidth = (int) (16 * load.mapScale);
		blockHeight = (int) (16 * load.mapScale);
		blockSize = (int) (16 * load.mapScale);
		
		mapImage = new BufferedImage (blockWidth* mapWidth, blockHeight * mapHeight, BufferedImage.TYPE_INT_ARGB);
		System.out.println(mapImage.getWidth());
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

	public void draw(Graphics2D g2) {
		int xOff = Camera.getX(), yOff = Camera.getY();
		
		if (reDraw) {
			Graphics2D g = (Graphics2D) mapImage.getGraphics();
			blockSize = (int) (16 * load.mapScale);
			int x = blockWidth, y = blockHeight;

			blockWidth = (int) (16 * load.mapScale);
			blockHeight = (int) (16 * load.mapScale);

			g.drawImage(ii.airBg, 0, 0, blockWidth * mapWidth, blockHeight * mapHeight, null);

			for (int px = 0; px < mapWidth; px++) {

				for (int py = 0; py < mapHeight; py++) {

					int id = px + py * mapWidth;

					int bId = load.Block[id];
					int blId = load.BlockLight[id];

					if (bId > 0) g.drawImage(blockImage[bId], x * px, y * py, blockWidth, blockHeight, null);
					if (blId > 0) {
						g.setColor(new Color(0, 0, 0, 50 * blId));
						g.fillRect(x * px, y * py, blockWidth, blockHeight);
					}

					// g.setColor(Color.BLACK);
					// g.drawRect(px * x + xOff, py * y + yOff, blockWidth,
					// blockHeight);

				}
			}
			reDraw = false;
		}
		
		g2.drawImage(mapImage, 0 + xOff, 0 + yOff, blockWidth* mapWidth, blockHeight * mapHeight,null);

	}

}
