package com.TeB.DungeonGame;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import com.TeB.Characters.*;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public Thread thread = new Thread(this);

	public static Map map;
	public Replay replay;
	public static Player p;
	public static Lighting light;
	public HUD h;
	public Camera c;
	public keyListener kl;
	private static int delta = 1;
	private boolean running = true;

	// bug

	public Screen() {
		map = new Map();
		replay = new Replay();
		p = new Player(new Crystalith());
		light = new Lighting();
		h = new HUD();
		kl = new keyListener();
		c = new Camera();
		setSize(Main.width, Main.height);
		new ImageImport();
		thread.start();
	}

	public void paintComponent(Graphics g) {
		BufferedImage image = new BufferedImage(Main.width, Main.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		map.draw(g2);
		p.draw(g2);
		light.draw(g2);
		h.draw(g2);
		g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
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
			boolean ticked = false;
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unProcessedSeconds += passedTime / 1000000000.0;

			while (unProcessedSeconds > secondsPerTick) {
				unProcessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;

				replay.update(delta);
				p.update(delta);
				c.update(delta);

				if (tickCount % 60 == 0) {
					System.out.println("FPS: " + frames);
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
