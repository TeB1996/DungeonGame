package com.TeB.Characters;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Crystalith extends Characters{
	
	public Crystalith(){
		
		try {
			CharacterImage = ImageIO.read(new File("Chars/player.png"));
			width = 12;
			height = 28;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
