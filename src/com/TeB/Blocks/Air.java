package com.TeB.Blocks;

public class Air extends Block{
	
	static int resistands = 0;
	static boolean backgroundBlock = true;
	
	public boolean backgroundBlock(){
		return backgroundBlock;
	}
	
	public  int getResistands(){
		return resistands;
	}

}
