package tiles;

import game.Position;

/**
 * Public class ChestTile
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class ChestTile extends GameTile {
	private Position positionOnField;	//position on the gamefield
	
	/**
	 * Public Constructor.
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public ChestTile(int x, int y) {
		setPositionOnField(new Position(x, y));
	}
	
	@Override
	public String toString() {
		return "C";
	}
	
	/**
	 * Getter and Setter methods.
	 */
	public Position getPositionOnField() { return positionOnField; }
	public void setPositionOnField(Position positionOnField) { this.positionOnField = positionOnField; }
}
