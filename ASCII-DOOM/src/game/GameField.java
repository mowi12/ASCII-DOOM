package game;

import tiles.ChestTile;
import tiles.EmptyTile;
import tiles.ExitTile;
import tiles.GameTile;
import tiles.MonsterTile;
import tiles.NotATile;
import tiles.Player;
import tiles.WallTile;

/**
 * Public class GameField.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class GameField {
	private GameTile[][] level;
	public int levelWidth;
	public int levelHeight;
	
	/**
	 * Public constructor.
	 * 
	 * @param s string version of the level
	 * @param levelWidth width of the level
	 * @param levelHeight height of the level
	 */
	public GameField(String s, int levelWidth, int levelHeight) {
		this.levelWidth = levelWidth;
		this.levelHeight = levelHeight;
		this.level = StringToGameTiles(s);
	}
	
	@Override
	public String toString() {
		String field = "";
		
		for(int i = 0; i < levelHeight; i++) {
			for(int j = 0; j < levelWidth; j++) {
				field += level[i][j].toString();
			}
			//field += "\n";
		}
		return field;
	}
	
	/**
	 * Method for constructing the gameField.
	 * 
	 * @param s string version of the gamefield
	 * @return
	 */
	private GameTile[][] StringToGameTiles(String s) {
		GameTile[][] gameTiles = new GameTile[levelHeight][levelWidth];
		for(int i = 0; i < levelHeight; i++) {
			for(int j = 0; j < levelWidth; j++) {
				if(s.charAt((i * levelWidth) + (j)) == ' ') {
					gameTiles[i][j] = new EmptyTile(i, j);
				} else if(s.charAt((i * levelWidth) + j) == '#') {
					gameTiles[i][j] = new WallTile(i, j);
				} else if(s.charAt((i * levelWidth) + j) == 'E') {
					gameTiles[i][j] = new ExitTile(i, j);
				} else if(s.charAt((i * levelWidth) + j) == 'M') {
					gameTiles[i][j] = new MonsterTile(i, j);
				} else if(s.charAt((i * levelWidth) + j) == 'C') {
					gameTiles[i][j] = new ChestTile(i, j);
				}
			}
		}
		return gameTiles;
	}
	
	/**
	 * Getter and Setter methods.
	 */
	public void setTileAtCoordinate(int x, int y, GameTile tile) { level[y][x] = tile; }
	
	public GameTile getTileOnCoordinate(int x, int y) {
		if((x >= levelWidth) || (y >= levelHeight)) {
			return (new NotATile());
		}
		return level[y][x];
	}
	
	public String getTileOnCoordinateString(int x, int y) {
		if((x >= levelWidth) || (y >= levelHeight)) {
			return "?";
		} else {
			return level[y][x].toString();
		}
	}
	
	public Position getChestPosition(Player player) {
		if(player.isNearChest) {
			Position chestPosition;
			
			for(int i = -1; i < 2; i++) {
				for(int j = -1; j < 2; j++) {
					if(this.getTileOnCoordinateString(player.getXCoordinate() + i, player.getYCoordinate() + j) == "C") {
						chestPosition = new Position(player.getXCoordinate() + i, player.getYCoordinate() + j);
						return chestPosition;
					}
				}
			}
			
			System.out.println("Should not reach here!");
			return new Position(-1, -1); //should not reach here !
		} else {
			return new Position(-1, -1);
		}
	}

	public Position getMonsterPosition(Player player) {
		if(player.isNearMonster) {
			Position monsterPosition;
			
			for(int i = -1; i < 2; i++) {
				for(int j = -1; j < 2; j++) {
					if(this.getTileOnCoordinateString(player.getXCoordinate() + i, player.getYCoordinate() + j) == "M") {
						monsterPosition = new Position(player.getXCoordinate() + i, player.getYCoordinate() + j);
						return monsterPosition;
					}
				}
			}
			
			System.out.println("Should not reach here!");
			return new Position(-1, -1); //should not reach here !
		} else {
			System.out.println("No monster near");
			return new Position(-1, -1);
		}
	}
}
