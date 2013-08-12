package com.TeB.DungeonGame;

public class Replay {
	
	private keyListener kl;
	
	public static int [] buttonsDown = new int [100000];
	public static int [] buttonsUp = new int [100000];
	
	
	public Replay(){
		kl = new keyListener();
	}
	
	public void update(int delta){
		
		if(!keyListener.right && !keyListener.left && !keyListener.jump){
			
		}
		
		if(keyListener.startReplay && keyListener.replayNumber > keyListener.replayUpdateNumber){
			kl.keyPressed(keyListener.replay[keyListener.replayUpdateNumber]);
			keyListener.replayUpdateNumber += 1;
			System.out.println(keyListener.replayNumber);
			System.out.println("Helloooo");
		}
		
	}

}
