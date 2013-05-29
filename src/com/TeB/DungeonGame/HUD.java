package com.TeB.DungeonGame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HUD {

	private Image sB;

	public static boolean saveIcon = false;

	public HUD() {
		sB = new ImageIcon("res/saveButton.png").getImage();

	}

	public void draw(Graphics g) {

		if (saveIcon) g.drawImage(sB, Main.width - 100, Main.height - 100, 36, 38, null);

	}
}
