package com.TeB.DungeonGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.TeB.MapEditor.CreateMap;

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
			if(Screen.p.onPlatform)jump = true;
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
			Screen.p.attributeActivated[0] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Screen.p.attributeActivated[1] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Screen.p.attributeActivated[1] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Screen.p.attributeActivated[2] = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_F1){
			CreateMap cm = new CreateMap();
			
			cm.openOptionsMenu();
			cm.makeFiles("map5", 5, 5, 1.5, 4, 4);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_F2){
			Screen.hud.h.addHealth(-10);
			System.out.println(Screen.hud.h.getHealt());
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
