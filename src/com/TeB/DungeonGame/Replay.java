package com.TeB.DungeonGame;

public class Replay {
	
	private keyListener kl;
	
	public Replay(){
		kl = new keyListener();
	}
	
	public void update(int delta){
		
		if(keyListener.startReplay && keyListener.replayNumber > keyListener.replayUpdateNumber){
			kl.keyPressed(keyListener.replay[keyListener.replayUpdateNumber]);
			keyListener.replayUpdateNumber += 1;
			System.out.println(keyListener.replayNumber);
			System.out.println("Helloooo");
		}
		
	}

}
