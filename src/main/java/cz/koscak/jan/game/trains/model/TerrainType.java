package cz.koscak.jan.game.trains.model;

import java.awt.Color;

public enum TerrainType {

	DIRT(new Color(102, 51, 0)),
	GRASS(new Color(0, 204, 0)),
	SAND(new Color(255, 255, 100)),
	ICE(new Color(200, 225, 255)),
	WATER(new Color(51, 204, 255)),
	ROCK(new Color(130, 130, 130)),
	SEAWEED(new Color(0, 150, 60));
	
	private final Color color;
	
	private TerrainType(Color color){
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
}
