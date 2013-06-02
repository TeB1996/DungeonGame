package com.TeB.Entities;

import java.awt.Graphics;

public class Entities {
	
	public static Bullet [] bullet  = new Bullet[100];
	public static boolean [] bulletActivated = new boolean[100]; 
	public static int bulletAmount = -1;
	
	public Entities(){
		for(int i = 0; i < 100;i++){
			bulletActivated[i] = false;
		}
	}
	
	public void update(int delta){
		if(bulletAmount >= 0){
			for(int i = 0; i < 99;i++){
				if(bulletActivated[i])bullet[i].update(delta, bulletAmount);
			}
		}
		
	}
	
	public void draw(Graphics g){
		if(bulletAmount >= 0){
			for(int i = 0; i < 99;i++){
				if(bulletActivated[i])bullet[i].draw(g);
			}
		}
	}
	
	public static void resetId(int Id){
		System.out.println("Reseting: " + Id +" bulletAmount: " + bulletAmount);
		bulletAmount--;
		bullet[Id] = null;
		bulletActivated[Id] = false;
	}
	
	public static void fireBullet(int direction){
		if(bulletAmount < 99){
			bulletAmount++;
			bullet[bulletAmount] = new Bullet(direction);
			bulletActivated[bulletAmount] = true;
		}
	}
	
	
	
}
