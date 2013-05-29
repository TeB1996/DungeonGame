package com.TeB.Blocks;

public class Air extends Block{
	
	static int resistands = 0;
	static boolean backgroundBlock = true;
	
	public static boolean backgroundBlock(){
		return backgroundBlock;
	}
	
	public static int getResistands(){
		return resistands;
	}

}
