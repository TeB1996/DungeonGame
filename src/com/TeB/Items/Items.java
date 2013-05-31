package com.TeB.Items;

import java.lang.reflect.InvocationTargetException;

public class Items {
	
	public static String itemName [] = new String [100];
	private static Class items [] = {null,null,null,null,null,Tnt.class};
	private static boolean isBlock= false;
	
	public static boolean isBlock (){
		return isBlock;
	}
	@SuppressWarnings("unchecked")
	public static boolean isBlock (int ItemId){
		
			try {
				return (Boolean) items[ItemId- 301].getMethod("isBlock", null).invoke(null, null);
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
