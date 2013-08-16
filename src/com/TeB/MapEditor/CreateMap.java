package com.TeB.MapEditor;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class CreateMap {
	
	public CreateMap(){
		
	}
	
	public void makeFiles(String mapName, int mapWidth, int mapHeight, int mapScale, int spawnBlockX, int spawnBlockY ){
		
		int a = 0;
		
		try {
			Formatter f = new Formatter("maps/" + mapName + "/" + mapName);

			for (int i = 0; i < 62*mapWidth*44*mapHeight; i++) {
				a++;
				if (a != 1) f.format("%s", " ");
				if (a == 62*mapWidth) {
					a = 0;
					f.format("%s", 0);
					f.format("\n", "");
				} else {
					f.format("%s", 0);
				}
			}
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
