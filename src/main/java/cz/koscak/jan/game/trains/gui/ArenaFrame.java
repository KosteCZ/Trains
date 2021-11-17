package cz.koscak.jan.game.trains.gui;

import javax.swing.JFrame;

import cz.koscak.jan.game.trains.core.Game;
import cz.koscak.jan.game.trains.model.Arena;

@SuppressWarnings("serial")
public class ArenaFrame extends JFrame {

	public ArenaFrame(Game game) {

		super("Trains game");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(new ArenaPanel(game, Arena.ARENA_WIDTH + 100, Arena.ARENA_HEIGHT + 100));
		this.pack();
		
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);

		// System.out.println("Frame created.");

	}
	
}
