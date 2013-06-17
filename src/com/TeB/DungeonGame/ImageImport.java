package com.TeB.DungeonGame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageImport {

	public BufferedImage brick;
	public Image stone;
	public Image grass;
	public Image dirt;
	public Image air;
	public Image tnt;
	public Image obsidian;
	public Image sign;
	public Image chest;
	public static Image player;

	public Image l1;
	public Image l2;
	public Image l3;
	public Image l4;
	public Image l5;

	public ImageImport() {

		try {
			brick =  ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/brick.png"));
		stone = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/stone.png"));
		grass = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/grass.png"));
		dirt = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/dirt.png"));
		air = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/air.png"));
		tnt = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/tnt.png"));
		obsidian = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/obsidian.png"));
		sign = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/sign.png"));
		chest = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/chest.png"));
		player = ImageIO.read(new File("C:/Users/tombal/Desktop/Nettside/NewTemplate/Applet/res/player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l1 = new ImageIcon("res/light_level_1.png").getImage();
		l2 = new ImageIcon("res/light_level_2.png").getImage();
		l3 = new ImageIcon("res/light_level_3.png").getImage();
		l4 = new ImageIcon("res/light_level_4.png").getImage();
		l5 = new ImageIcon("res/light_level_5.png").getImage();
	}

}
