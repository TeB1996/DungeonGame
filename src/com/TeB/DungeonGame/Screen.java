package com.TeB.DungeonGame;

import java.awt.*;

import javax.swing.*;

import com.TeB.Entities.Entities;

@SuppressWarnings("serial")
public class Screen extends JPanel implements Runnable {

	public Thread thread = new Thread(this);

	public static int myWidth, myHeight;

	public Map m;
	public Player p = new Player();;
	public HUD h = new HUD();
	public Entities ent;
	private static int delta = 1;
	private boolean running = true;
	//bug
	
	public Screen() {
		ent = new Entities();
		m = new Map();
		thread.start();
	}

	public void paintComponent(Graphics g) {

		
		
		m.draw(g);
		p.draw(g);
		ent.draw(g);
		h.draw(g);
	}

	public void run() {
//		long oldTimeSinceStart = 0;
//		int sleepTime = 6;
//		while (true) {
//			
//			long timeSinceStart =  System.nanoTime();
//		    delta =  (int) ((int) timeSinceStart - oldTimeSinceStart)/1000000 - (sleepTime-1);
//		     oldTimeSinceStart = timeSinceStart;
//		     if(delta < 1)delta = 1;
//
//			p.update(delta);
//			ent.update(delta);
//			repaint();
//			
//			try {
//				Thread.sleep(sleepTime);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		int frames = 0;
		double unProcessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;
		while (running) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unProcessedSeconds += passedTime / 1000000000.0;

			while (unProcessedSeconds > secondsPerTick) {
				unProcessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;
				p.update(delta);
				ent.update(delta);
				if (tickCount % 60 == 0) {
					System.out.println(frames + " FPS");
					System.out.println("TickCount: " + tickCount);
					previousTime += 1000;
					frames = 0;
					tickCount = 0;
				}
			}
			if (ticked) {
				repaint();
				frames++;
			}
		}

	}

}
