package com.TeB.Items;

import java.lang.reflect.InvocationTargetException;

public class Items {
	
	public static String itemName [] = new String [100];
	@SuppressWarnings("rawtypes")
	private static Class items [] = {null,null,null,null,null,Tnt.class};
	private static boolean isBlock= false;
	
	public static boolean isBlock (){
		return isBlock;
	}
	@SuppressWarnings("unchecked")
	public static boolean getValue (int ItemId, String valueMethod){
		
			try {
				if(ItemId > 300)return (Boolean) items[ItemId- 301].getMethod(valueMethod, null).invoke(null, null);
				else return (Boolean) items[ItemId].getMethod(valueMethod, null).invoke(null, null);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return false;
	}

}
