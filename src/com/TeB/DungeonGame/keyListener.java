package com.TeB.DungeonGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener {

	public static boolean right = false, left = false, jump = false, place = false, running = false, use = false;

	public static boolean startReplay = false;
	
	public static KeyEvent[] replay = new KeyEvent[100000];
	
	public static int replayUpdateNumber = 1, replayNumber = 1;
	
	
	public void keyPressed(KeyEvent e) {
		
		if(!startReplay){
			replay[replayNumber] = e;
			replayNumber++;
		}
		
		//System.out.println(replay[replayNumber-1].getKeyCode());
		
		if(e.getKeyCode() == KeyEvent.VK_R){
			//Replaying last motions
			if(startReplay)startReplay = false;
			if(!startReplay)startReplay = true;
			System.out.println(startReplay);
			System.out.println(replay[replayNumber-1].getKeyChar());
			
			
		}
		
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
		if(e.getKeyCode() == KeyEvent.VK_UP){
			Player.attributeActivated[0] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Player.attributeActivated[1] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Player.attributeActivated[1] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Player.attributeActivated[2] = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		
		replay[replay.length - 1] = e;

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
