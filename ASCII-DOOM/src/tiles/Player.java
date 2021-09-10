package tiles;

import exceptions.IllegalPlayerPositionException;
import game.Fight;
import game.GameField;
import game.Position;

/**
 * public class Player.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class Player extends GameTile {
	private Position positionOnField;	//position on the gamefield
	private int lifePoints = 100;		//lifepoints of the player
	
	//Checks
	public boolean isOnExitTile = false;
	public boolean isNearMonster = false;
	public boolean isNearChest = false;
	
	/**
	 * Public Constructor.
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public Player(int x, int y) {
		//starting Coordinates have to be on the gamefield
		if((x < 0) || (y < 0)) {
			try {
				throw new IllegalPlayerPositionException();
			} catch(IllegalPlayerPositionException e) {
				System.out.println("Illegal Player Position!");
				System.out.println("(Reset to (0,0)");
				positionOnField = new Position(0, 0);
			}
		} else {
			positionOnField = new Position(x, y);
		}
	}
	
	@Override
	public String toString() {
		return "@";
	}
	
	/**
	 * Method to move one field left.
	 * 
	 * @param gameField current gamefield
	 */
	public void moveLeft(GameField gameField) { 
		//the Tile the Player is going to walk on has to be a legal Tile
		if(checkCollision(gameField, positionOnField.getXCoordinate() - 1, positionOnField.getYCoordinate())) {
			try {
				throw new IllegalPlayerPositionException();
			} catch(IllegalPlayerPositionException e) {
				System.out.println("Illegal Player Position!");
				System.out.println("Player is not going to move!");
			}
		} else {
			positionOnField.setXCoordinate(positionOnField.getXCoordinate() - 1);
		}
		
		//do all Checks for next the Move
		checkExit(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearChest(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearMonster(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
	}
	
	/**
	 * Method to move one field right.
	 * 
	 * @param gameField current gamefield
	 */
	public void moveRight(GameField gameField) {
		//the Tile the Player is going to walk on has to be a legal Tile
		if(checkCollision(gameField, positionOnField.getXCoordinate() + 1, positionOnField.getYCoordinate())) {
			try {
				throw new IllegalPlayerPositionException();
			} catch(IllegalPlayerPositionException e) {
				System.out.println("Illegal Player Position!");
				System.out.println("Player is not going to move!");
			}
		} else {
			positionOnField.setXCoordinate(positionOnField.getXCoordinate() + 1);
		}
		
		//do all Checks for next the Move
		checkExit(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearChest(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearMonster(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
	}
	
	/**
	 * Method to move one field up.
	 * 
	 * @param gameField current gamefield
	 */
	public void moveUp(GameField gameField) {
		//the Tile the Player is going to walk on has to be a legal Tile
		if(checkCollision(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate() - 1)) {
			try {
				throw new IllegalPlayerPositionException();
			} catch(IllegalPlayerPositionException e) {
				System.out.println("Illegal Player Position!");
				System.out.println("Player is not going to move!");
			}
		} else {
			positionOnField.setYCoordinate(positionOnField.getYCoordinate() - 1);
		}
		
		//do all Checks for next the Move
		checkExit(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearChest(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearMonster(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
	}
	
	/**
	 * Method to move one field down.
	 * 
	 * @param gameField current gamefield
	 */
	public void moveDown(GameField gameField) {
		//the Tile the Player is going to walk on has to be a legal Tile
		if(checkCollision(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate() + 1)) {
			try {
				throw new IllegalPlayerPositionException();
			} catch(IllegalPlayerPositionException e) {
				System.out.println("Illegal Player Position!");
				System.out.println("Player is not going to move!");
			}
		} else {
			positionOnField.setYCoordinate(positionOnField.getYCoordinate() + 1);
		}
		
		//do all Checks for next the Move
		checkExit(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearChest(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearMonster(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
	}
	
	/**
	 * Method for printing current Position in the console.
	 */
	public void printPosition() {
		System.out.println("(" + positionOnField.getXCoordinate() + ", " + positionOnField.getYCoordinate() + ")");
	}
	
	//method for checking collisions with walls or if the Player is walking off Bounds
	/**
	 * Method for checking collisions with walls or if the player is walking off bounds.
	 * 
	 * @param gameField current gamefield
	 * @param x x-coordinate of the player
	 * @param y y-coordinate of the player
	 * @return
	 */
	private boolean checkCollision(GameField gameField, int x, int y) {
		if((gameField.getTileOnCoordinateString(x, y) == "#") ||
		   (gameField.getTileOnCoordinateString(x, y) == "?") ||
		   (x == gameField.levelWidth) ||
		   (y == gameField.levelHeight)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method for checking if player is on the exittile.
	 * 
	 * @param gameField current gamefield
	 * @param x x-coordinate of the player
	 * @param y y-coordinate of the player
	 */
	private void checkExit(GameField gameField, int x, int y) {
		if(gameField.getTileOnCoordinateString(x, y) == "E") {
			isOnExitTile = true;
		} else {
			isOnExitTile = false;
		}
	}
	
	/**
	 * Method for checking if player is near a chest.
	 * 
	 * @param gameField current gamefield
	 * @param x x-coordinate of the player
	 * @param y y-coordinate of the player
	 */
	private void checkNearChest(GameField gameField, int x, int y) {
		if((gameField.getTileOnCoordinateString(x - 1, y - 1) == "C") ||
		   (gameField.getTileOnCoordinateString(x    , y - 1) == "C") ||
		   (gameField.getTileOnCoordinateString(x + 1, y - 1) == "C") ||
		   (gameField.getTileOnCoordinateString(x - 1, y    ) == "C") ||
		   (gameField.getTileOnCoordinateString(x    , y    ) == "C") ||
		   (gameField.getTileOnCoordinateString(x + 1, y    ) == "C") ||
		   (gameField.getTileOnCoordinateString(x - 1, y + 1) == "C") ||
		   (gameField.getTileOnCoordinateString(x    , y + 1) == "C") ||
		   (gameField.getTileOnCoordinateString(x + 1, y + 1) == "C")) {
			isNearChest = true;
		} else {
			isNearChest = false;
		}
	}
	
	/**
	 * Method for checking if player is near a monster.
	 * 
	 * @param gameField current gamefield
	 * @param x x-coordinate of the player
	 * @param y y-coordinate of the player
	 */
	private void checkNearMonster(GameField gameField, int x, int y) {
		if((gameField.getTileOnCoordinateString(x - 1, y - 1) == "M") ||
		   (gameField.getTileOnCoordinateString(x    , y - 1) == "M") ||
		   (gameField.getTileOnCoordinateString(x + 1, y - 1) == "M") ||
		   (gameField.getTileOnCoordinateString(x - 1, y    ) == "M") ||
		   (gameField.getTileOnCoordinateString(x    , y    ) == "M") ||
		   (gameField.getTileOnCoordinateString(x + 1, y    ) == "M") ||
		   (gameField.getTileOnCoordinateString(x - 1, y + 1) == "M") ||
		   (gameField.getTileOnCoordinateString(x    , y + 1) == "M") ||
		   (gameField.getTileOnCoordinateString(x + 1, y + 1) == "M")) {
			isNearMonster = true;
			System.out.println("HUHU");
		} else {
			isNearMonster = false;
		}
	}
	
	/**
	 * Method for opening a near Chest.
	 * 
	 * @param gameField current gamefield
	 */
	public void openChest(GameField gameField) {
		//only open a Chest if Player is near a Chest
		if(isNearChest) {
			//get the Coordinates of the Chest
			int xChestCoordinate = gameField.getChestPosition(this).getXCoordinate();
			int yChestCoordinate = gameField.getChestPosition(this).getYCoordinate();
			//replace Chest Tile with an Empty Tile
			gameField.setTileAtCoordinate(xChestCoordinate, yChestCoordinate, new EmptyTile(xChestCoordinate, yChestCoordinate));
		
			//TODO: Add Items
			System.out.println("You found a new Item!");
		
			isNearChest = false;
		} else {
			System.out.println("There is no Chest near you!");
		}
		
		//do Checks
		checkNearChest(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
		checkNearMonster(gameField, positionOnField.getXCoordinate(), positionOnField.getYCoordinate());
	}
	
	/**
	 * Method for starting a fight with a near monster.
	 * 
	 * @param gameField current gamefield
	 */
	public void fight(GameField gameField) {
		//only start a Fight if Player is near a Monster
		if(isNearMonster) {
			//get the Coordinates of the Monster
			int xMonsterCoordinate = gameField.getMonsterPosition(this).getXCoordinate();
			int yMonsterCoordinate = gameField.getMonsterPosition(this).getYCoordinate();
			//start a new Fight
			Fight fight = new Fight();
			fight.startFight(gameField, this, (MonsterTile)gameField.getTileOnCoordinate(xMonsterCoordinate, yMonsterCoordinate));
			//showing Lifepoints of the Monster (Debugging)
			System.out.println(((MonsterTile)gameField.getTileOnCoordinate(xMonsterCoordinate, yMonsterCoordinate)).getLifePoints());
			
			//replace Monster Tile with an Empty Tile if Fight was won
			if(fight.isFightWon()) {
				gameField.setTileAtCoordinate(xMonsterCoordinate, yMonsterCoordinate, new EmptyTile(xMonsterCoordinate, yMonsterCoordinate));
			}
		}
		
		isNearMonster = false;
	}
	
	/**
	 * Method for blocking the next attack.
	 * 
	 * @param gameField current gamefield
	 */
	public void block(GameField gameField) {
		//TODO: implement Blocking (implement Fight mechanic fist)
	}
	
	/**
	 * Getter and Setter methods.
	 */
	public int getXCoordinate() { return positionOnField.getXCoordinate(); }
	public int getYCoordinate() { return positionOnField.getYCoordinate(); }
	public int getLifePoints() { return lifePoints; }
	public void setLifePoints(int lifePoints) { this.lifePoints = lifePoints; }
}
