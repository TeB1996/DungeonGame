package com.TeB.DungeonGame;

import java.awt.Color;
import java.awt.Graphics2D;

import com.TeB.Characters.Characters;

public class Health {
	
	public double health;
	private double healthBarWidth, healthBarHeight;
	
	public Health(Characters character){
		
		health = 100*character.getHealth();
	}
	
	public double getHealt(){
		return health;
	}
	public void setHealth(double change){
		health = change;
	}
	public void addHealth(double change){
		health += change;
	}
	
	public void draw(Graphics2D g){
		System.out.println(100/(health/100));
		healthBarWidth = 100/health*100*Screen.hud.hudScale;
		healthBarHeight = 30*Screen.hud.hudScale;
		
		
		g.setColor(Color.RED);
		g.fillRect(10, 10, (int) healthBarWidth, (int)healthBarHeight);
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, (int) 100, (int)healthBarHeight);
		
	}

}
