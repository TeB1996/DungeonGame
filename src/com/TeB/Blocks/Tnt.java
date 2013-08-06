package com.TeB.Blocks;

import com.TeB.DungeonGame.Explosion;
import com.TeB.DungeonGame.Load;

public class Tnt extends Block{
	
	
	static boolean blockHasPlaceUse = true;
	static boolean backgroundBlock = true;
	static boolean i = false;
	
	
	public  void placeUs(int BlockPlacementId){
		Load.Block[BlockPlacementId] = 6;
		new Explosion(BlockPlacementId);
	}
	
	public  boolean blockHasPlaceUse() {
		return blockHasPlaceUse;
	}
	public  boolean backgroundBlock(){
		return backgroundBlock;
	}
	
	
	


}


