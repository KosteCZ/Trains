package cz.koscak.jan.game.trains.model;

import java.awt.Graphics;

public interface Entity {
	
	public int getID();
	public int getX();
	public int getY();
	public void paint(Graphics g);
	
}
