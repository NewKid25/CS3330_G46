package hw4.player;

import hw4.maze.*;

public class Player {

	private Cell currentCell;
	private Row currentRow;
	/**
	 * creates a player with position
	 * @param currentRow
	 * @param currentCell
	 */
	public Player(Row currentRow, Cell currentCell) {
		super();
		this.currentCell = currentCell;
		this.currentRow = currentRow;
	}
	/**
	 * returns current position
	 * @return
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}
	/**
	 * sets current position
	 * @param currentCell
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	/**
	 * gets the current row the player is on
	 * @return
	 */
	public Row getCurrentRow() {
		return currentRow;
	}
	/**
	 * sets the current 
	 * @param currentRow the player is on
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}
	
	@Override
	/**
	 * toString method
	 */
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	} 
	
	
}
