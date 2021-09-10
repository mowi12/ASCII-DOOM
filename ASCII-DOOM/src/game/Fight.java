package game;

import tiles.MonsterTile;
import tiles.Player;

/**
 * Public class Fight.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class Fight {
	private boolean fightWon = false; //check

	/**
	 * Public constructor.
	 */
	public Fight() {}
	
	//TODO: implemnt Fight mechanic
	public void startFight(GameField gameField, Player player, MonsterTile monster) {
		//System.out.println("Started fight!");
		draw();
		//System.out.println("Finished fight!");
		
		//if Monster dead remove MonsterTile
		//if Player dead end Game
		
		//player.isNearMonster = false;
		
		fightWon = true;
		//gameField.setTileAtCoordinate(monster.getXCoordinate(), monster.getYCoordinate(), new ChestTile(monster.getXCoordinate(), monster.getYCoordinate()));
	}
	
	//TODO
	private void draw() {
		//System.out.println("drawing!");
	}
	
	/**
	 * Getter and Setter methods.
	 */
	public boolean isFightWon() { return fightWon; }
}
