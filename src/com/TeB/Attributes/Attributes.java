package com.TeB.Attributes;

import java.awt.Graphics2D;
import java.awt.Image;

public class Attributes {
	
	protected Image AttributeImage;
	protected String name = "This is not the correct name";
	
	public Attributes(){
		
	}
	
	public String getName(){
		return name;
	}
	
	public Image getAttributeImage(){
		
		return AttributeImage;
	}
	
	public Image getAttributeImage(Attributes attribute){
		return attribute.getAttributeImage();
	}
	
	public void draw(Graphics2D g){
		g.drawRect(100, 100,100,100);
	}
	
	public void update(int delta){
		
	}

}
