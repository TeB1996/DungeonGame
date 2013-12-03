package com.TeB.Characters;

import java.awt.Image;

import com.TeB.DungeonGame.Map;

public class Characters {
	
	protected Image CharacterImage;
	protected int width, height;
	protected double health;
	
	public Characters (){
		
	}
	
	public Image getCharacterImage(){
		return CharacterImage;
	}
	
	public int getWidth(){
		return (int) (width*Map.b.load.mapScale);
	}
	
	public int getHeight(){
		System.out.println(Map.b.load.mapScale + " " + height  + " " + (int)(height*Map.b.load.mapScale));
		return (int) (height*Map.b.load.mapScale);
	}
	
	public double getHealth(){
		
		return health;
	}

}
