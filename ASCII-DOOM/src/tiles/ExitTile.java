package tiles;

import game.Position;

/**
 * Public class ExitTile.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class ExitTile extends GameTile {
	private Position positionOnField;	//position on the gamefield
	
	/**
	 * Public Constructor.
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public ExitTile(int x, int y) {
		//TODO
	}

	@Override
	public String toString() {
		return "E";
	}

	/**
	 * Getter and Setter methods.
	 */
	public Position getPositionOnField() { return positionOnField; }
	public void setPositionOnField(Position positionOnField) { this.positionOnField = positionOnField; }
}
