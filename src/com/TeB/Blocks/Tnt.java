package com.TeB.Blocks;

import com.TeB.DungeonGame.Explosion;

public class Tnt extends Block{
	
	
	static boolean blockHasPlaceUse = true;
	static boolean backgroundBlock = true;
	static boolean i = false;
	
	
	public static void placeUs(int BlockPlacementId){
		new Explosion(BlockPlacementId);
	}
	
	public static boolean blockHasPlaceUse() {
		return blockHasPlaceUse;
	}
	public static boolean backgroundBlock(){
		return backgroundBlock;
	}
	
	
	


}


