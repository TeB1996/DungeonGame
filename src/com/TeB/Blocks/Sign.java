package com.TeB.Blocks;

import com.TeB.DungeonGame.Load;

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
		
		for(int i= 0; i < Load.SignBlock.length;i++){
			if(Load.SignBlock[i] == BlockId){
				System.out.println(Load.Sign[i]);
			}
			
		}
		

	}


}
