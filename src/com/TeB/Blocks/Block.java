package com.TeB.Blocks;

import com.TeB.DungeonGame.Load;

public class Block {

	static int resistands = 1;
	static boolean backgroundBlock = false;
	static boolean hasClickUse = false;
	static boolean blockHasPlaceUse = false;

	public static int getResistands() {
		return resistands;
	}

	public static boolean backgroundBlock() {
		return backgroundBlock;
	}

	public static boolean hasClickUse() {
		return hasClickUse;
	}

	public static boolean blockHasPlaceUse() {
		return blockHasPlaceUse;
	}
	public static void placeUs(int BlockPlacementId){
		
	}

	public static boolean getBackgroundBlock(int Block) {

		if (Block == 0) return Air.backgroundBlock();
		if (Block == 1) return Grass.backgroundBlock();
		if (Block == 2) return Dirt.backgroundBlock();
		if (Block == 3) return Stone.backgroundBlock();
		if (Block == 4) return Brick.backgroundBlock();
		if (Block == 5) return Black.backgroundBlock();
		if (Block == 6) return Tnt.backgroundBlock();
		if (Block == 7) return Obsidian.backgroundBlock();
		if (Block == 8) return Sign.backgroundBlock();
		if (Block == 9) return Chest.backgroundBlock();

		System.out.println("Here! GBB= " + Block);

		return false;

	}

	public static int getResistands(int Block) {

		if (Block == 0) return Air.getResistands();
		if (Block == 1) return Grass.getResistands();
		if (Block == 2) return Dirt.getResistands();
		if (Block == 3) return Stone.getResistands();
		if (Block == 4) return Brick.getResistands();
		if (Block == 5) return Black.getResistands();
		if (Block == 6) return Tnt.getResistands();
		if (Block == 7) return Obsidian.getResistands();
		if (Block == 8) return Sign.getResistands();
		if (Block == 9) return Chest.getResistands();
		System.out.println("Here! GR = " + Block);
		return 0;

	}

	public static boolean hasClickUse(int Block) {

		if (Block == 0) return Air.hasClickUse();
		if (Block == 1) return Grass.hasClickUse();
		if (Block == 2) return Dirt.hasClickUse();
		if (Block == 3) return Stone.hasClickUse();
		if (Block == 4) return Brick.hasClickUse();
		if (Block == 5) return Black.hasClickUse();
		if (Block == 6) return Tnt.hasClickUse();
		if (Block == 7) return Obsidian.hasClickUse();
		if (Block == 8) return Sign.hasClickUse();
		if (Block == 9) return Chest.hasClickUse();

		System.out.println("Here! HCU = " + Block);
		return false;

	}

	public static boolean blockHasPlaceUse(int Block) {

		if (Block == 0) return Air.blockHasPlaceUse();
		if (Block == 1) return Grass.blockHasPlaceUse();
		if (Block == 2) return Dirt.blockHasPlaceUse();
		if (Block == 3) return Stone.blockHasPlaceUse();
		if (Block == 4) return Brick.blockHasPlaceUse();
		if (Block == 5) return Black.blockHasPlaceUse();
		if (Block == 6) return Tnt.blockHasPlaceUse();
		if (Block == 7) return Obsidian.blockHasPlaceUse();
		if (Block == 8) return Sign.blockHasPlaceUse();
		if (Block == 9) return Chest.blockHasPlaceUse();

		System.out.println("Here! BHPU= " + Block);
		return false;

	}

	public static void activateClickUse(int BlockId, int Block) {
		if (Block == 8) Sign.ClickUse(BlockId);
		if (Block == 9) Chest.ClickUse(BlockId);
	}

	public static void place(int BlockPlacementId, int newBlock) {


		if (blockHasPlaceUse(newBlock)) {
			runPlaceUse(BlockPlacementId , newBlock);
			Load.Block[BlockPlacementId] = newBlock;
		}
		else{
			Load.Block[BlockPlacementId] = newBlock;
		}

	}
	
	public static void runPlaceUse(int BlockPlacementId, int Block){
		if(Block == 6)Tnt.placeUs(BlockPlacementId);
		
	}

}
