package com.TeB.Characters;

import java.awt.Image;

import com.TeB.DungeonGame.Load;

public class Characters {
	
	protected Image CharacterImage;
	protected int width, height;
	
	public Characters (){
		
	}
	
	public Image getCharacterImage(){
		return CharacterImage;
	}
	
	public int getWidth(){
		return (int) (width*Load.mapScale);
	}
	
	public int getHeight(){
		System.out.println(Load.mapScale + " " + height  + " " + (int)(height*Load.mapScale));
		return (int) (height*Load.mapScale);
	}

}
