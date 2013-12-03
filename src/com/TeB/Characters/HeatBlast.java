package com.TeB.Characters;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HeatBlast extends Characters{
	
	public HeatBlast(){
		try {
			CharacterImage = ImageIO.read(new File("Chars/heatblast.png"));
			width = 6;
			height = 32;
			health = 1;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
