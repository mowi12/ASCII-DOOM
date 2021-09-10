package tiles;

import game.Position;

/**
 * Public class WallTile.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class WallTile extends GameTile {
	private Position positionOnField;	//position on the gamefield

	/**
	 * Public Constructor.
	 *  
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public WallTile(int x, int y) {
		setPositionOnField(new Position(x, y));
	}
	
	@Override
	public String toString() {
		return "#";
	}
	
	/**
	 * Getter and Setter methods.
	 * @return
	 */
	public Position getPositionOnField() { return positionOnField; }
	public void setPositionOnField(Position positionOnField) { this.positionOnField = positionOnField; }
}
