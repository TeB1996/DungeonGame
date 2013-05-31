package com.TeB.Items;

public class Tnt extends Items{
	
	private static boolean isBlock= true;
	private int id = 306;
	
	public int itemId(){
		return id;
	}
	
	public static boolean isBlock (){
		return isBlock;
	}
	

}
