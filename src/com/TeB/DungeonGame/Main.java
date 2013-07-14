package com.TeB.DungeonGame;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public static int width = 998, height = width / 12 * 9;
	public static boolean running = false;
	public Main() {
		if (!running) {
			init();
			running = true;
		}
	}

	public static void main(String[] args) {
		new Main();
	}
	public void init(){

		Screen screen = new Screen();
		setVisible(true);
		setSize(width, height);
		setTitle("Dungeon indev 0.1");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		add(screen);
		addKeyListener(new keyListener());
		addMouseMotionListener(new mouseListener());
		addMouseListener(new mouseListener());
		
		addComponentListener(new ComponentListener(){  
		        // This method is called after the component's size changes
		        public void componentResized(ComponentEvent evt) {
		            Component c = (Component)evt.getSource();
		    
		            // Get new size
		            width  = c.getWidth();
		            height = c.getHeight();
		        }

				@Override
				public void componentHidden(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void componentMoved(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void componentShown(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
		});
	}
}
