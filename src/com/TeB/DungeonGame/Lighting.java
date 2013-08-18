package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Lighting {
	
	private BufferedImage lightingImage;
	private int [] pixels;
	private int [] xPos;
	private int [] yPos;
	
	public boolean reDraw = true;
	
	public Lighting (){
		int mapWidth =  Map.b.load.chunkWidth *  Map.b.load.mapWidth;
		int mapHeight =  Map.b.load.chunkHeight *  Map.b.load.mapHeight;
		int blockWidth = (int) (16 * Map.b.load.mapScale);
		int blockHeight = (int) (16 *  Map.b.load.mapScale);
		
		lightingImage = new BufferedImage (blockWidth* mapWidth, blockHeight * mapHeight, BufferedImage.TYPE_INT_ARGB);
		pixels = ((DataBufferInt) lightingImage.getRaster().getDataBuffer()).getData();
		xPos = new int[2];
		yPos = new int[2];
		
		xPos[0] = 1;
		yPos[0] = 1;
		
	}
	
	public void update(int delta){
		
	}
	
	public void draw(Graphics2D g2){
		
		int xOff = Camera.getX(), yOff = Camera.getY();
		
		if (reDraw) {
			Graphics g =  lightingImage.getGraphics();
			g.setColor(Color.BLACK);
			g.fillRect(20, 20, lightingImage.getWidth(), lightingImage.getHeight());
			
			for(int i = 0; i < xPos.length-1;i++){
				System.out.println(i);
				// Use g.copyArea() to create the holes int the black abyss
				for(int a = 0; a < pixels.length-1;a++){
					pixels[a] = 255255255;
				}
			}
			System.out.println(lightingImage.getWidth());
			
			
			reDraw = false;
		}
		
		
		g2.drawImage(lightingImage, 0 + xOff, 0 + yOff, lightingImage.getWidth(), lightingImage.getHeight(), null);
		
		//Create buffered Image and use clear rect to mark everything but the mark area black add then a custom circle to create lighting
	}

}
