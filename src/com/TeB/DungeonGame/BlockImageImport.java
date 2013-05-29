package com.TeB.DungeonGame;

import java.awt.*;
import javax.swing.*;

public class BlockImageImport {

	public Image brick;
	public Image stone;
	public Image grass;
	public Image dirt;
	public Image air;
	public Image tnt;
	public Image obsidian;
	public Image sign;
	public Image chest;

	public Image l1;
	public Image l2;
	public Image l3;
	public Image l4;
	public Image l5;

	public BlockImageImport() {

		brick = new ImageIcon("res/brick.png").getImage();
		stone = new ImageIcon("res/stone.png").getImage();
		grass = new ImageIcon("res/grass.png").getImage();
		dirt = new ImageIcon("res/dirt.png").getImage();
		air = new ImageIcon("res/air.png").getImage();
		tnt = new ImageIcon("res/tnt.png").getImage();
		obsidian = new ImageIcon("res/obsidian.png").getImage();
		sign = new ImageIcon("res/sign.png").getImage();
		chest = new ImageIcon("res/chest.png").getImage();

		l1 = new ImageIcon("res/light_level_1.png").getImage();
		l2 = new ImageIcon("res/light_level_2.png").getImage();
		l3 = new ImageIcon("res/light_level_3.png").getImage();
		l4 = new ImageIcon("res/light_level_4.png").getImage();
		l5 = new ImageIcon("res/light_level_5.png").getImage();
	}

}
