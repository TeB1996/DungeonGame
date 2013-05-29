package com.TeB.DungeonGame;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public static int width = 998, height = width / 12 * 9;

	public Main() {

		Screen screen = new Screen();
		setVisible(true);
		setSize(width, height);
		setTitle("DungeonMaster");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		add(screen);
		addKeyListener(new keyListener());
		addMouseMotionListener(new mouseListener());
		addMouseListener(new mouseListener());
	}

	public static void main(String[] args) {
		new Main();

	}

}
