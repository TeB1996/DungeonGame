package com.TeB.DungeonGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.TeB.Entities.Entities;

public class keyListener implements KeyListener {

	public static boolean right = false, left = false, jump = false, place = false, running = false, use = false;

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_D) {
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			if(Player.onPlatform)jump = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_P) {
			place = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			Map m = new Map();

			m.changeMap("Map2");
			System.out.println("Changing");
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			new Save(Map.MapInUse);
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			running = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			use = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Entities.fireBullet(4);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Entities.fireBullet(2);
		}

	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_D) {
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			place = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			running = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			use = false;
		}

	}

	public void keyTyped(KeyEvent e) {

	}

}
