package game;

/**
 * Public class Position.
 * 
 * @author Moritz Wieland
 * @version 1.0
 * @date 29.04.2021
 */
public class Position {
	//coordinates
	private int xCoordinate;
	private int yCoordinate;

	/**
	 * Public Constructor.
	 */
	public Position() {
		xCoordinate = 0;
		yCoordinate = 0;
	}
	
	/**
	 * Public Constructor.
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public Position(int x, int y) {
		xCoordinate = x;
		yCoordinate = y;
	}
	
	@Override
	public boolean equals(Object other) {
		if((this.getClass() == other.getClass()) && 
		   (this.xCoordinate == ((Position)other).xCoordinate) &&
           (this.yCoordinate == ((Position)other).yCoordinate)) {
				return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Getter and Setter methods.
	 */
	public int getXCoordinate() { return xCoordinate; }
	public int getYCoordinate() { return yCoordinate; }
	public void setXCoordinate(int x) { xCoordinate = x; }
	public void setYCoordinate(int y) { yCoordinate = y; }
}
