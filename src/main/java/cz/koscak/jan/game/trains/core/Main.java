package cz.koscak.jan.game.trains.core;

import cz.koscak.jan.game.trains.gui.ArenaFrame;

public class Main {
	
	//private static ArenaFrame arenaFrame;

	public static void main(String[] args) {

		Game game = new Game();
		
		ArenaFrame arenaFrame = new ArenaFrame(game);
				
		//arenaFrame.paint(graphics);
		//arenaFrame.repaint();

		int round = 0;
		
		while(true) {
			
			if (!game.isPaused()) {
			
				round++;
				game.doActions(round);
				arenaFrame.repaint();
				
				if (round % 1000 == 0) {
					System.out.println("Round: " + round);
				}
				
			}
			
			try {
				//System.out.println("Timer tick...");
				Thread.sleep(50);
				//Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}		

	}

}
