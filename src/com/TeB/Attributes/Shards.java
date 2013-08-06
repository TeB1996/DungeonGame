package com.TeB.Attributes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shards extends Attributes{
	
	public Shards(){
		name = "Shards";
		
		try {
			AttributeImage = ImageIO.read(new File("attributes/shards.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
