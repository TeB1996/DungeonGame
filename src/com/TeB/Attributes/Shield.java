package com.TeB.Attributes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shield extends Attributes{
	
	public Shield(){
		name = "Shield";
		
		try {
			AttributeImage = ImageIO.read(new File("attributes/shield.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
