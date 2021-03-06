package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.TeB.Characters.Crystalith;

public class HUD {

	private Image sB;

	public boolean saveIcon = false;
	public Health h;
	public double hudScale = 1.0;

	public HUD() {
		sB = new ImageIcon("res/saveButton.png").getImage();
		hudScale = 1.0;
		h = new Health(new Crystalith());
	}

	public void draw(Graphics2D g) {

		if (saveIcon) g.drawImage(sB, Main.width - 100, Main.height - 100, 36, 38, null);
		g.setColor(new Color(0,0,0,200));
		g.fillRect(Main.width - 70, Main.height - 100, 50, 50);
		g.fillRect(Main.width - 70, Main.height - 170, 50, 50);
		g.fillRect(Main.width - 70, Main.height - 240, 50, 50);
		
		g.drawImage(Screen.p.attributes[0].getAttributeImage(), Main.width - 70, Main.height - 240, 50, 50,null);
		g.drawImage(Screen.p.attributes[1].getAttributeImage(), Main.width - 70, Main.height - 170, 50, 50,null);
		g.drawImage(Screen.p.attributes[2].getAttributeImage(), Main.width - 70, Main.height - 100, 50, 50,null);
		//System.out.println(Player.attributes[2].getAttributeImage());
		
		h.draw(g);
	}
}
