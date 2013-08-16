package com.TeB.Attributes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.TeB.Blocks.Block;
import com.TeB.DungeonGame.BlockRender;
import com.TeB.DungeonGame.Load;
import com.TeB.DungeonGame.Screen;

public class Dig extends Attributes{
	
	public Dig(){
		name = "Dig";
		
		try {
			AttributeImage = ImageIO.read(new File("attributes/dig.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int delta){
		System.out.println("Digging");
		int mapWidth = BlockRender.mapWidth;
		
		if(Block.getResistands(Block.getBlockById(Load.Block[Screen.p.points[2]])) < 6)Load.Block[Screen.p.points[2]] = 0;
		if(Block.getResistands(Block.getBlockById(Load.Block[Screen.p.points[3]])) < 6)Load.Block[Screen.p.points[3]] = 0;

		if(Block.getResistands(Block.getBlockById(Load.Block[Screen.p.points[2] + mapWidth])) < 6)Load.Block[Screen.p.points[2] + mapWidth] = 0;
		if(Block.getResistands(Block.getBlockById(Load.Block[Screen.p.points[3] + mapWidth])) < 6)Load.Block[Screen.p.points[3] + mapWidth] = 0;
		
		//Load.Block[Screen.p.points[2] + mapWidth*2] = 0;
		//Load.Block[Screen.p.points[3] + mapWidth*2] = 0;
		
		Screen.p.attributeActivated[2] = false;

	}

}
