package com.TeB.DungeonGame;

import java.awt.*;
import javax.swing.*;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public Thread thread = new Thread(this);

	public Map m;
	public Player p;
	public HUD h;
	public keyListener kl;
	private static int delta = 1;
	private boolean running = true;

	// bug

	public Screen() {
		m = new Map();
		p = new Player();
		h = new HUD();
		kl = new keyListener();
		new ImageImport();
		thread.start();
	}

	public void paintComponent(Graphics g) {
		g.setFont(new Font("TechnoHideo.ttf", (int) (16 * Load.mapScale),
				(int) (16 * Load.mapScale)));
		m.draw((Graphics2D) g);
		p.draw((Graphics2D) g);
		h.draw((Graphics2D) g);
		// System.out.println(g.getFont());
		g.drawString("Font", 100, 100);
	}

	public void run() {
		// long oldTimeSinceStart = 0;
		// int sleepTime = 6;
		// while (true) {
		//
		// long timeSinceStart = System.nanoTime();
		// delta = (int) ((int) timeSinceStart - oldTimeSinceStart)/1000000 -
		// (sleepTime-1);
		// oldTimeSinceStart = timeSinceStart;
		// if(delta < 1)delta = 1;
		//
		// p.update(delta);
		// ent.update(delta);
		// repaint();
		//
		// try {
		// Thread.sleep(sleepTime);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }

		int frames = 0;
		double unProcessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		//double secondsPerRender = 1 / 20.0;
		int tickCount = 0;
		//boolean ticked = false;
		while (running) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unProcessedSeconds += passedTime / 1000000000.0;

			while (unProcessedSeconds > secondsPerTick) {
				unProcessedSeconds -= secondsPerTick;
				//ticked = true;
				tickCount++;

				
				if(keyListener.startReplay && keyListener.replayNumber > keyListener.replayUpdateNumber){
					kl.keyPressed(keyListener.replay[keyListener.replayUpdateNumber]);
					keyListener.replayUpdateNumber += 1;
					System.out.println(keyListener.replayNumber);
					System.out.println("Helloooo");
				}
				p.update(delta);

				if (tickCount % 60 == 0) {
					System.out.println("FPS: " + frames);
					System.out.println("TickCount: " + tickCount);
					previousTime += 1000;
					frames = 0;
					tickCount = 0;
				}
			}
			if (true) {
				repaint();
				frames++;
			}

		}

	}

}
