package com.TeB.Blocks;

import com.TeB.DungeonGame.Map;

public class Sign extends Block{
	
	static boolean backgroundBlock = true;
	static boolean hasClickUse = true;
	
	public boolean backgroundBlock(){
		return backgroundBlock;
	}
	
	public boolean hasClickUse(){
		return hasClickUse;
	}
	
	
	public void ClickUse(int BlockId){
		
		for(int i= 0; i < Map.b.load.SignBlock.length;i++){
			if(Map.b.load.SignBlock[i] == BlockId){
				System.out.println(Map.b.load.Sign[i]);
			}
			
		}
		

	}


}
