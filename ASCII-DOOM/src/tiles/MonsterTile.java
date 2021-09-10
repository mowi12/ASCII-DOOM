package tiles;

import game.Position;

/**
 * Public class MonsterTile.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class MonsterTile extends GameTile {
	private Position positionOnField; 						//position on the gamefield
	private int lifePoints = (int)(Math.random() * 100); 	//lifepoints of the monster this tile is representing
	
	/**
	 * Public Constructor.
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public MonsterTile(int x, int y) {
		positionOnField = new Position(x, y);
	}
	
	@Override
	public String toString() {
		return "M";
	}
	
	/**
	 * Getter and Setter methods.
	 */
	public int getXCoordinate() { return positionOnField.getXCoordinate(); }
	public int getYCoordinate() { return positionOnField.getYCoordinate(); }
	public int getLifePoints() {return lifePoints; }
	public void setLifePoints(int lifePoints) { this.lifePoints = lifePoints; }
}
