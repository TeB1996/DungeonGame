package com.TeB.DungeonGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load {

	public  int Block[];
	public  int BlockLight[];
	public  String Sign[] = new String[100];
	public  int SignBlock[] = {0};
	public  int mapWidth = 1;
	public  int mapHeight = 1;
	public  double mapScale = 1;
	public  int spawnBlockX = 4;
	public  int spawnBlockY = 4;
	public  int chunkWidth = 998/16, chunkHeight = ((998/12)*9)/16;
	public  boolean mapUpdate = false;
	public  String mapBG = "air";

	public Load(String map) {
		try {
			Scanner s = new Scanner(new File("maps/" + map + "/" + map + "Info"));
			
			mapWidth = s.nextInt();
			mapHeight = s.nextInt();
			mapScale = s.nextDouble();
			spawnBlockX = s.nextInt();
			spawnBlockY = s.nextInt();
			
			s = new Scanner(new File("maps/" + map + "/" + map));
			
			Block = new int[chunkWidth * chunkHeight * mapWidth * mapHeight + 1];

			for (int g1 = 0; g1 <= chunkWidth* chunkHeight * mapWidth* mapHeight; g1++) 
				Block[g1] = s.nextInt();
			
			s = new Scanner(new File("maps/" + map + "/" + map + "Light"));
			
			BlockLight = new int[chunkWidth * chunkHeight * mapWidth * mapHeight + 1];

			for (int g1 = 0; g1 <= chunkWidth* chunkHeight * mapWidth* mapHeight; g1++) 
				BlockLight[g1] = 0;
				//BlockLight[g1] = s.nextInt();
			

			s = new Scanner(new File("maps/" + map + "/" + map + "Signs"));
			boolean writeDown = false;

			String sentence = "";

			while (s.hasNext()) {
				String i = s.next();

				if (i.equalsIgnoreCase("[")) {
					writeDown = true;
					i = s.next();
				}
				if (i.equalsIgnoreCase("]")) {
					if (SignBlock.length - 1 >= 0) Sign[SignBlock.length - 1] = sentence;
					else Sign[0] = sentence;

					if (SignBlock.length - 1 >= 0) SignBlock[SignBlock.length - 1] = s.nextInt();
					else SignBlock[0] = s.nextInt();

					writeDown = false;
				}
				if (writeDown) {
					sentence += " " + i;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// System.out.println(SignBlock[0]);
	}
	
	public void setBlockValue(int newBlock, int position){
		Block[position] = newBlock;
		Map.b.reDraw = true;
	}
	
	public com.TeB.Blocks.Block getBlock(int position){
		return com.TeB.Blocks.Block.getBlockById(Block[position]);
	}

}
