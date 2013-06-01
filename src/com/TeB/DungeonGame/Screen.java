package com.TeB.DungeonGame;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Screen extends JPanel implements Runnable {

	public Thread thread = new Thread(this);

	public static int myWidth, myHeight;

	public static Map m;
	public static Player p = new Player();;
	public static HUD h = new HUD();
	private static int delta;
	//bug
	
	public Screen() {
		m = new Map();
		thread.start();
	}

	public void paintComponent(Graphics g) {

		

		m.draw(g);
		p.draw(g);
		h.draw(g);
	}

	public void run() {
		long oldTimeSinceStart = 0;
		int sleepTime = 6;
		while (true) {
			
			long timeSinceStart =  System.nanoTime();
		    delta =  (int) ((int) timeSinceStart - oldTimeSinceStart)/1000000 - (sleepTime-1);
		     oldTimeSinceStart = timeSinceStart;
		     if(delta < 1)delta = 1;

			p.update(delta);
			repaint();
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
