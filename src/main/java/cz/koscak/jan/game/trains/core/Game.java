package cz.koscak.jan.game.trains.core;

import java.awt.Graphics;

import cz.koscak.jan.game.trains.model.Arena;
import cz.koscak.jan.game.trains.model.Rails;

public class Game {
	
	public static final int BULLET_SPEED = 4;
	private Rails[][] map = new Rails[40][25];
//	private List<Animal> listOfAnimals = new ArrayList<Animal>();
//	private List<Plant> listOfPlants = new ArrayList<Plant>();
	private boolean paused = true;
	private boolean end = false;
	private boolean beforeFirstGame = true;
	private int round = 0;
	
	public Game() {
		
		initGame();
		
	}

	public void startNewGame() {
		
//		listOfAnimals = new ArrayList<Animal>();
//		listOfPlants = new ArrayList<Plant>();
		initGame();
		
	}
		
	public void initGame() {
		
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				// Empty
				map[x][y] = null;
				
				/*// Up Down
				if (x  > 130  && x <= 170  && y  > 320 && y <= 360) {
					map[x][y] = new Rails(RailsType.UPDOWN);
				}*/
			}
		}
		
		// add list of trains ?
/*		listOfAnimals.add(new Animal(50, 50));
		listOfAnimals.add(new Rabbit(150, 70));
		listOfAnimals.add(new Fish(550, 350));
		listOfAnimals.add(new Penguin(150, 350));
		listOfAnimals.add(new Fish(150, 340));
		
		listOfPlants.add(new Cactus(550, 70));
		listOfPlants.add(new DesertGrass(650, 70));
		listOfPlants.add(new SeeWeed(570, 350));*/
		
	}
	
	public void setBeforeFirstGameToFalse() {
		beforeFirstGame = false;
	}
	
	public boolean isBeforeFirstGame() {
		return beforeFirstGame;
	}
	
/*	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}

	public List<Plant> getListOfPlants() {
		return listOfPlants;
	}*/

	public void paint(Graphics graphics) {
		
		printMap(graphics);
		
/*		for (Animal animal : listOfAnimals) {
			animal.paint(graphics);
		}
		
		for (Plant plant : listOfPlants) {
			plant.paint(graphics);
		}*/
		
	}

	private void printMap(Graphics graphics) {
		
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				//graphics.setColor(map[x][y].getType().getColor());
				graphics.drawLine(Arena.ARENA_X + x, Arena.ARENA_Y + y, Arena.ARENA_X + x, Arena.ARENA_Y + y);
			}
		}
		
	}

	public void doActions(int round) {
		
		this.round = round;
		
/*		for (ListIterator<Animal> iterator = listOfAnimals.listIterator(); iterator.hasNext();) {
			Animal animal = iterator.next();
			animal.doAction(iterator, round, map);
		}
		
		if (listOfAnimals.size() == 0) {
			end = true;
			paused = true;
		}

		for (ListIterator<Plant> iterator = listOfPlants.listIterator(); iterator.hasNext();) {
			Plant plant = iterator.next();
			plant.doAction(iterator, round, map);
		}

		doRandomTerrationExpansion();
*/		
	}
	
/*	private void doRandomTerrationExpansion() {
		
		for (int i = 0; i < 1000; i++) {		
			
			int randomX = (int) Math.floor(Math.random() * map.length);
			int randomY = (int) Math.floor(Math.random() * map[0].length);
			TerrainType terrainType = map[randomX][randomY].getType();
			
			if (terrainType != TerrainType.DIRT && terrainType != TerrainType.ROCK) {
				
				//randomX = randomX + (int) ((Math.floor(Math.random() * 9)) - 4);
				//randomY = randomY + (int) ((Math.floor(Math.random() * 9)) - 4);
				randomX = randomX + (int) ((Math.floor(Math.random() * 3)) - 1);
				randomY = randomY + (int) ((Math.floor(Math.random() * 3)) - 1);
				if (randomX < 0 || randomX >= map.length || randomY < 0 || randomY >= map[0].length) {
					continue;
				}
				if (map[randomX][randomY].getType() != TerrainType.ROCK) {
					map[randomX][randomY].setType(terrainType);
				}
				
			}
			
		}
	}*/
	
	// Inspiration for animal grass eating
	/*private void doRandomDirtExpansion() {
		
		for (int i = 0; i < 100; i++) {		
			int randomX = (int) Math.floor(Math.random() * map.length);
			int randomY = (int) Math.floor(Math.random() * map[0].length);
			map[randomX][randomY].setType(TerrainType.DIRT);
		}
	}*/

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
	
	public boolean tooglePaused() {
		paused = !paused;
//		System.out.println("Toogle paused: " + paused);
		return paused;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public boolean isEnd() {
		return end;
	}

	public int getRound() {
		return round;
	}
	
}
