package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferInt;

public class Lighting {
	
	private BufferedImage lightingImage;
	//private int [] pixels;
	private int [] xPos;
	private int [] yPos;
	private int [] radius;
	
	public boolean reDraw = true;
	
	public Lighting (){
		int mapWidth =  Map.b.load.chunkWidth *  Map.b.load.mapWidth;
		int mapHeight =  Map.b.load.chunkHeight *  Map.b.load.mapHeight;
		int blockWidth = (int) (16 * Map.b.load.mapScale);
		int blockHeight = (int) (16 *  Map.b.load.mapScale);
		
		lightingImage = new BufferedImage (blockWidth* mapWidth, blockHeight * mapHeight, BufferedImage.TYPE_INT_ARGB);
		//pixels = ((DataBufferInt) lightingImage.getRaster().getDataBuffer()).getData();
		xPos = new int[2];
		yPos = new int[2];
		radius = new int[2];
		
		xPos[0] = 100;
		yPos[0] = 100;
		radius [0] = 400;
		
	}
	
	public void update(int delta){
		
	}
	
	public void draw(Graphics2D g2){
		
		int xOff = Camera.getX(), yOff = Camera.getY();
		
		if (reDraw) {
			Graphics g =  lightingImage.getGraphics();
			
			xPos[0] = (int) Screen.p.getX();
			yPos[0] = (int) Screen.p.getY();
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, lightingImage.getWidth(), lightingImage.getHeight());
			
			for(int i = 0; i < xPos.length-1;i++){
				setLigthingPoint(xPos[i], yPos[i], radius[i], g);
			}
			
			
			reDraw = true;
		}
		
		
		g2.drawImage(lightingImage, 0 + xOff, 0 + yOff, lightingImage.getWidth(), lightingImage.getHeight(), null);
		
		//Create buffered Image and use clear rect to mark everything but the mark area black add then a custom circle to create lighting
	}
	
	public void setLigthingPoint(int x, int y, int radius, Graphics g){
		
		new ImageImport();
		
		for(int a = 0; a < radius*2;a++){
			for(int b = 0; b < radius*2;b++){
				if(x- radius + a > 0 &&  y - radius + b > 0)lightingImage.setRGB(x- radius + a, y - radius + b, 0xFFFFFF);
			}
		}
		g.drawImage(ImageImport.lightTest, x- radius,y- radius,radius*2,radius*2, null);
//		
//		for(int a = 0; a < radius; a++){
//			for(int b = 0 + a; b < radius - a;b++){
//				lightingImage.setRGB(x + a, y + b, 0xFFFFFF);
//				lightingImage.setRGB(x - a, y + b, 0xFFFFFF);
//			}
//			
//			
			
			
		//}
		
	}

}
