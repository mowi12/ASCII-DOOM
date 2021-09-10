package game;

import java.util.Scanner;

import tiles.Player;

/**
 * Public class World.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class World {
	private Scanner scan = new Scanner(System.in);
	
	//Variables for saving all important Components
	private GameField gameField;
	private String canvas = "";
	private Player player1;
	
	/**
	 * Public constructor.
	 */
	public World() {
		//create a Gamefield
		gameField = new GameField("################################" + //1
								  "#             #                #" + //2
								  "# ## ######## # ###### #####   #" + //3						
								  "#    ######## #      # #####   #" + //4
								  "#### ##    ##   #### #     #####" + //5
								  "#### ## ## ######### ##### #####" + //6
								  "#    ## ## ##      #     # #   #" + //7
								  "# ##### ##### ## ####### #   # #" + //8
								  "#   ###       ##    #### ##### #" + //9
								  "# #     ######### ###### ###   #" + //10
								  "# ###########   # #   ## ### ###" + //11
								  "#             M # ### ## #    ##" + //12
								  "## ####### ##   #     ## # ## ##" + //13
								  "## ####### #### ##### ## # #   #" + //14
								  "##      ##   ## ##       # # M #" + //15
								  "#######  #   ## ######## # #   #" + //16
								  "######## # C ## ##    ## # # C #" + //17
								  "# C #### ###### ## ## ##########" + //18
								  "#           M      ##          E" + //19
								  "################################",  //20
								  32, 20); //String, Width, Height
		//create a Player at Position
		player1 = new Player(5, 18); //29, 2
		//draw the Gamefield for the first time
		draw();
		
		//start game
		run();
	}
	
	/**
	 * Method for running the game.
	 */
	private void run() {
		char input = ' ';
		//loop while input != 'p' (Pause)
		while(input != 'p') {
			//player is not near a Monster
			if(!player1.isNearMonster) {
				System.out.print("What do you want to do: ");
				input = scan.next().charAt(0);
				System.out.println("");
			
				switch(input) {
				case 'a':
					player1.moveLeft(gameField);
					break;
				case 'd':
					player1.moveRight(gameField);
					break;
				case 'w':
					player1.moveUp(gameField);
					break;
				case 's':
					player1.moveDown(gameField);
					break;
				case 'o':
					player1.openChest(gameField);
					break;
				}
				draw();
			
				if(player1.isOnExitTile) {
					input = 'p';
					System.out.println("You've reached the Exit!");
				}
			//Player is near a Monster (can't walk, has to fight)
			} else {
				System.out.print("What do you want to do: ");
				input = scan.next().charAt(0);
				System.out.println("");
			
				switch(input) {
				case 'f':
					player1.fight(gameField);
					break;
				case 'b':
					player1.block(gameField);
					break;
				case 'o':
					player1.openChest(gameField);
					break;
				}
				draw();
			}
		}
	}
	
	/**
	 * Method for drawing the canvas (in the console)
	 */
	private void draw() {
		//get the full Gamefield as a String
		canvas = gameField.toString();
		System.out.println("");
		System.out.println("--------------------------------");
		
		String canvasPrint = "";
		
		//go through all Coordinates to place Player (as a Smybol) into the Gamefield
		for(int i = 0; i < gameField.levelHeight; i++) {
			for(int j = 0; j < gameField.levelWidth; j++) {
				int index = (i * gameField.levelWidth) + j;
				
				if(index == player1.getYCoordinate() * gameField.levelWidth + player1.getXCoordinate()) {
					canvasPrint += player1.toString();
				} else {
					canvasPrint += canvas.charAt((i * gameField.levelWidth) + j);
				}
			}
			canvasPrint += "\n";
		}		
		
		//print Gamefield, Playerposition
		System.out.println(canvasPrint);
		System.out.print("Playerposition: ");
		player1.printPosition();
		System.out.println("");
	}
}
