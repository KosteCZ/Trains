package cz.koscak.jan.game.trains.model;

public class Terrain {

	private TerrainType type;

	public Terrain(TerrainType type) {
		super();
		this.type = type;
	}

	public TerrainType getType() {
		return type;
	}

	public void setType(TerrainType type) {
		this.type = type;
	}
	
}
