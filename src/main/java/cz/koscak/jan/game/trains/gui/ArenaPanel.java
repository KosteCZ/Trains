package cz.koscak.jan.game.trains.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cz.koscak.jan.game.trains.core.Game;
import cz.koscak.jan.game.trains.model.Arena;

@SuppressWarnings("serial")
public class ArenaPanel extends JPanel implements MouseMotionListener {

	private static final String BUTTON_PAUSE_NEW_GAME = "New game";
	private static final String BUTTON_PAUSE_START = "Start";
	private static final String BUTTON_PAUSE_PAUSE = "Pause";
	
	public final int WIDTH;
	public final int HEIGHT;
		
	private Game game;
	private JLabel labelRoundText;
	private JLabel labelTrainsText;
	private JLabel labelBlueAliveText;
	private JLabel labelRedAliveText;
	private JLabel labelBlueAliveNumber;
	private JLabel labelRedAliveNumber;
//	private JLabel blueAILabel;
//	private JLabel redAILabel;
//	private JComboBox<String> blueAIComboBox;
//	private JComboBox<String> redAIComboBox;
	private JButton buttonPause;
	
	public ArenaPanel(Game game, int width, int height) {
		
		this.game = game;
		
		WIDTH = width;
		HEIGHT = height;
		
		addMouseMotionListener(this);
		
		this.setLayout(null);

		//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setDoubleBuffered(true);
		
		createPauseButton();
		
		createLabel();
		
//		createBlueAISelection();
//		createRedAISelection();
		
		Images.loadIamges();
		
	}

    private void createLabel() {
    	
    	labelRoundText = new JLabel("Round: " + 0);
    	labelRoundText.setForeground(Color.BLACK);
    	//labelRoundText.setBounds(10, 10, 100, 30);
    	labelRoundText.setBounds(50, 10, 100, 10);
    	labelRoundText.setHorizontalAlignment(JLabel.LEFT);
    	labelRoundText.setVerticalAlignment(JLabel.CENTER);
    	add(labelRoundText);
    	
    	labelTrainsText = new JLabel("Trains: " + 0);
    	labelTrainsText.setForeground(Color.BLACK);
    	//labelTrainsText.setBounds(10, 10, 100, 30);
    	labelTrainsText.setBounds(WIDTH - 110, 10, 100, 10);
    	labelTrainsText.setHorizontalAlignment(JLabel.LEFT);
    	labelTrainsText.setVerticalAlignment(JLabel.CENTER);
    	add(labelTrainsText);
    	
    	labelBlueAliveText = new JLabel("BLUE alive: ");
    	labelBlueAliveText.setForeground(Color.BLUE);
    	//labelBlueAliveText.setBounds(10, 10, 100, 30);
    	labelBlueAliveText.setBounds(10, 20, 100, 30);
    	labelBlueAliveText.setHorizontalAlignment(JLabel.LEFT);
    	labelBlueAliveText.setVerticalAlignment(JLabel.CENTER);
    	//add(labelBlueAliveText);
		
    	labelBlueAliveNumber = new JLabel("BLUE alive: " + 5);
    	labelBlueAliveNumber.setForeground(Color.BLUE);
    	//labelBlueAliveNumber.setBounds(10, 10, 100, 30);
    	labelBlueAliveNumber.setBounds(10 + 200, 20, 20, 30);
    	labelBlueAliveNumber.setHorizontalAlignment(JLabel.RIGHT);
    	labelBlueAliveNumber.setVerticalAlignment(JLabel.CENTER);
    	//add(labelBlueAliveNumber);
		
    	labelRedAliveText = new JLabel("RED alive: ");
    	labelRedAliveText.setForeground(Color.RED);
    	//labelRedAliveText.setBounds(WIDTH - 110, 10, 100, 30);
    	labelRedAliveText.setBounds(WIDTH - 110 - 123, 20, 100, 30);
    	labelRedAliveText.setHorizontalAlignment(JLabel.LEFT);
    	labelRedAliveText.setVerticalAlignment(JLabel.CENTER);
    	//add(labelRedAliveText);
		
    	labelRedAliveNumber = new JLabel("RED alive: " + 5);
    	labelRedAliveNumber.setForeground(Color.RED);
    	//labelRedAliveNumber.setBounds(WIDTH - 110, 10, 100, 30);
    	labelRedAliveNumber.setBounds(WIDTH - 110, 20, 100, 30);
    	labelRedAliveNumber.setHorizontalAlignment(JLabel.RIGHT);
    	labelRedAliveNumber.setVerticalAlignment(JLabel.CENTER);
    	//add(labelRedAliveNumber);
		
	}

	public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);       

        //g.drawString("This is my custom Panel!", 10, 20);
		//g.drawOval(0, 0, 4, 4);
        
        paintArena(g);
        
		//game.paint(g);
		
//		updateFighterAlives();
		
		updateRoundLabel();
		updateTrainsLabel();
		
		printTexts(g);
		
//		checkGameStateAndHandleComboboxes();
		
	}

/*	private void checkGameStateAndHandleComboboxes() {
		if (game.isEnd()) {
			enableAIComboboxes(true);
		} else {
			enableAIComboboxes(false);
		}
		
	}
*/
	private void updateRoundLabel() {
		labelRoundText.setText("Round: " + game.getRound());
	}
	
	private void updateTrainsLabel() {
//		labelTrainsText.setText("Trains: " + game.getListOfAnimals().size());
	}
	
/*
	private void updateFighterAlives() {
		
		labelBlueAliveNumber.setText("" + game.getListOfTeams().get(0).getPlayersAliveCount());
		labelRedAliveNumber.setText("" + game.getListOfTeams().get(1).getPlayersAliveCount());
		
	}
*/
	private void printTexts(Graphics g) {
		
		if (game.isEnd() && !game.isBeforeFirstGame()) {
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Dialog", Font.BOLD, 16));
			g.drawString("END", (WIDTH / 2) - 15, (HEIGHT / 2) - 10);
			
//			enableAIComboboxes(true);
			buttonPause.setText(BUTTON_PAUSE_NEW_GAME);
			
		}
		
	}

	private void paintArena(Graphics g) {

		//g.drawRect(Arena.ARENA_X, Arena.ARENA_Y, Arena.ARENA_WIDTH + 1, Arena.ARENA_HEIGHT + 1);
		
		for (int i = 0; i <= 25; i++) {
			g.drawLine(Arena.ARENA_X, Arena.ARENA_Y + (i * 20), Arena.ARENA_X + Arena.ARENA_WIDTH, Arena.ARENA_Y + (i * 20));
		}
		for (int i = 0; i <= 40; i++) {
			g.drawLine(Arena.ARENA_X + (i * 20), Arena.ARENA_Y, Arena.ARENA_X + (i * 20),  Arena.ARENA_Y + Arena.ARENA_HEIGHT);			
		}
		
		/*try {
			BufferedImage img = ImageIO.read(new File("src/main/resources/images/rails.png"));
			g.drawImage(img, Arena.ARENA_X + 1, Arena.ARENA_Y + 1, 19, 19, null);
		} catch (IOException e) {
			System.err.println(e);
		}*/
		g.drawImage(Images.railsLeftRight, Arena.ARENA_X + 1, Arena.ARENA_Y + 1, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1, 19, 19, null);
		
		g.drawImage(Images.railsCurveBottomRight, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1, 19, 19, null);
		g.drawImage(Images.railsCurveRightUp, Arena.ARENA_X + 1 + 60, Arena.ARENA_Y + 1, 19, 19, null);
		g.drawImage(Images.railsCurveLeftBottom, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 20, 19, 19, null);
		g.drawImage(Images.railsCurveUpLeft, Arena.ARENA_X + 1 + 60, Arena.ARENA_Y + 1 + 20, 19, 19, null);
		
		g.drawImage(Images.railsCross, Arena.ARENA_X + 1 + 80, Arena.ARENA_Y + 1, 19, 19, null);
		
		g.drawImage(Images.railsJunctionBottomToTopRight, Arena.ARENA_X + 1 + 100, Arena.ARENA_Y + 1, 19, 19, null);
		
		g.drawImage(Images.railsJunctionBottomTopRight, Arena.ARENA_X + 1 + 120, Arena.ARENA_Y + 1, 19, 19, null);
		
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 +  40, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 +  60, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 +  80, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 + 100, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 + 120, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 + 140, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 + 160, 19, 19, null);
		g.drawImage(Images.train1Locomotive, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y +  1 +  60, 19, 19, null);
		g.drawImage(Images.train1Coach, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 +  80, 19, 19, null);
		g.drawImage(Images.train1Coach, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 + 100, 19, 19, null);
		g.drawImage(Images.train1Truck, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 + 120, 19, 19, null);
		g.drawImage(Images.train1Truck, Arena.ARENA_X + 1 + 0, Arena.ARENA_Y + 1 + 140, 19, 19, null);
		
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 +  40, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 +  60, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 +  80, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 + 100, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 + 120, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 + 140, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 + 160, 19, 19, null);
		g.drawImage(Images.train2Locomotive, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y +  1 +  60, 19, 19, null);
		g.drawImage(Images.train2Coach, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 +  80, 19, 19, null);
		g.drawImage(Images.train2Coach, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 + 100, 19, 19, null);
		g.drawImage(Images.train2Truck, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 + 120, 19, 19, null);
		g.drawImage(Images.train2Truck, Arena.ARENA_X + 1 + 20, Arena.ARENA_Y + 1 + 140, 19, 19, null);
		
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 +  40, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 +  60, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 +  80, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 100, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 120, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 140, 19, 19, null);
		g.drawImage(Images.railsUpDown, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 160, 19, 19, null);
		g.drawImage(Images.train3Locomotive, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y +  1 +  60, 19, 19, null);
		g.drawImage(Images.train3Coach, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 +  80, 19, 19, null);
		g.drawImage(Images.train3Coach, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 100, 19, 19, null);
		g.drawImage(Images.train3Truck, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 120, 19, 19, null);
		g.drawImage(Images.train3Truck, Arena.ARENA_X + 1 + 40, Arena.ARENA_Y + 1 + 140, 19, 19, null);
		
	}
	
	private void createPauseButton() {
		
		buttonPause = new JButton(BUTTON_PAUSE_NEW_GAME);
		buttonPause.setBounds(WIDTH / 2 - 50, 10, 100, 30);
		
		buttonPause.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				boolean pausing = game.tooglePaused();
				if (pausing) {
					game.setEnd(false);
					buttonPause.setText(BUTTON_PAUSE_START);
				} else {
					game.setBeforeFirstGameToFalse();
					buttonPause.setText(BUTTON_PAUSE_PAUSE);
					/*if (game.isEnd() && !game.isBeforeFirstGame()) {
					game.setEnd(false);
					game.startNewGame();
					}*/
				}
			}

		});
		
		add(buttonPause);
		
	}
	
	/*
	private void enableAIComboboxes(boolean enable) {
		blueAIComboBox.setEnabled(enable);
		redAIComboBox.setEnabled(enable);
	}
	*/
	
	/*
	private void createBlueAISelection() {
		
		blueAILabel = new JLabel("BLUE AI: ", JLabel.LEFT);
		blueAILabel.setForeground(Color.BLUE);
    	blueAILabel.setBounds(10, 5 + 5, 80, 10);   	
		add(blueAILabel);
		
		
		
		blueAIComboBox = new JComboBox<String>(AI_NAMES);
		//blueAIComboBox.setSelectedIndex(0);
		blueAIComboBox.setSelectedIndex(8);
		
		blueAIComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				
				int selectedAI = blueAIComboBox.getSelectedIndex();
				
				try {
					@SuppressWarnings("unchecked")
					Class<Inteligence> blueAI = (Class<Inteligence>) Class.forName("cz.koscak.jan.ai." + AI_NAMES[selectedAI]);
					System.out.println("BLUE AI: " + blueAI.getName());
					Inteligence inteligence = blueAI.newInstance();
					game.setInteligenceForTeam(0, inteligence);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		blueAIComboBox.setBounds(80, 5, 150, 20);

		add(blueAIComboBox);
		
	}
	
	private void createRedAISelection() {
		
		redAILabel = new JLabel("RED AI: ", JLabel.RIGHT);
		redAILabel.setForeground(Color.RED);
		redAILabel.setBounds(WIDTH - 270, 5 + 5, 80, 10);   	
		add(redAILabel);
		
		
		
		redAIComboBox = new JComboBox<String>(AI_NAMES);
		//redAIComboBox.setSelectedIndex(0);
		redAIComboBox.setSelectedIndex(8);
		
		redAIComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				
				int selectedAI = redAIComboBox.getSelectedIndex();
				
				try {
					@SuppressWarnings("unchecked")
					Class<Inteligence> redAI = (Class<Inteligence>) Class.forName("cz.koscak.jan.ai." + AI_NAMES[selectedAI]);
					System.out.println("RED AI: " + redAI.getName());
					Inteligence inteligence = redAI.newInstance();
					game.setInteligenceForTeam(1, inteligence);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		redAIComboBox.setBounds(WIDTH - 160, 5, 150, 20);

		add(redAIComboBox);
		
	}*/
	
	public void mouseMoved(MouseEvent e) {
		
/*		for (ListIterator<Animal> iterator = game.getListOfAnimals().listIterator(); iterator.hasNext();) {
			Animal animal = iterator.next();
			if ((animal.getX() == (e.getX() - Arena.ARENA_X)) && (animal.getY() == (e.getY() - Arena.ARENA_Y))) {
				System.out.println("Animal: " + animal);
			}

		}*/
		/*System.out.println("Mouse moved: " + (e.getX() - Arena.ARENA_X) + ", " + (e.getY() - Arena.ARENA_Y));
		System.out.println("Animal 0:    " + game.getListOfAnimals().get(0).getX() + ", " + game.getListOfAnimals().get(0).getY());
		System.out.println();*/
		/*
		for (ListIterator<Plant> iterator = game.getListOfPlants().listIterator(); iterator.hasNext();) {
			Plant plant = iterator.next();
			if ((plant.getX() == (e.getX() - Arena.ARENA_X)) && (plant.getY() == (e.getY() - Arena.ARENA_Y))) {
				System.out.println("Plant:  " + plant);
			}

		}*/

	}

	public void mouseDragged(MouseEvent e) {
	}
}