package hw4.player;

import hw4.maze.*;

public class Player {

	private Cell currentCell;
	private Row currentRow;
	
	public Player(Row currentRow, Cell currentCell) {
		super();
		this.currentCell = currentCell;
		this.currentRow = currentRow;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	public Row getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}
	
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	} 
	
	
}
