package com.TeB.Blocks;

public class Block {

	private static final Block Air = new Air();
	private static final Block Grass = new Grass();
	private static final Block Dirt = new Dirt();
	private static final Block Stone = new Stone();
	private static final Block Brick = new Brick();
	private static final Block Black = new Black();
	private static final Block Tnt = new Tnt();
	private static final Block Obsidian = new Obsidian();
	private static final Block Sign = new Sign();
	private static final Block Chest = new Chest();
	
	 int resistands = 5;
	 boolean backgroundBlock = false;
	 boolean hasClickUse = false;
	 boolean blockHasPlaceUse = false;
	
	public static Block getBlockById(int Id){
		if (Id == 0) return Air;
		if (Id == 1) return Grass;
		if (Id == 2) return Dirt;
		if (Id == 3) return Stone;
		if (Id == 4) return Brick;
		if (Id == 5) return Black;
		if (Id == 6) return Tnt;
		if (Id == 7) return Obsidian;
		if (Id == 8) return Sign;
		if (Id == 9) return Chest;
		
		return Air;
	}

	public int getResistands() {
		return resistands;
	}

	public boolean backgroundBlock() {
		return backgroundBlock;
	}

	public boolean hasClickUse() {
		return hasClickUse;
	}

	public boolean blockHasPlaceUse() {
		return blockHasPlaceUse;
	}
	public void placeUs(int BlockPlacementId){
		
	}

	public static boolean getBackgroundBlock(Block block) {

		return block.backgroundBlock();
		

	}

	public static int getResistands(Block block) {

		return block.getResistands();
	}

	public static boolean hasClickUse(Block block) {

		return block.hasClickUse();
	}

	public static boolean blockHasPlaceUse(Block block) {

		return block.blockHasPlaceUse();
	}

	public static void activateClickUse(Block block, int BlockId) {
		block.ClickUse(BlockId);
		
	}

	public static void place(int BlockPlacementId, Block newBlock) {


		if (blockHasPlaceUse(newBlock)) {
			runPlaceUse(BlockPlacementId , newBlock);
		}else{
			
		}


	}
	
	public static void runPlaceUse(int BlockPlacementId, Block block){
		block.placeUs(BlockPlacementId);
		
	}
	
	public void ClickUse(int BlockId){
		
	}

}
