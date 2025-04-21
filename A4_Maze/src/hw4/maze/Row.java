package hw4.maze;

import java.util.ArrayList;

public class Row {

	ArrayList<Cell> cells;
	/**
	 * sets the amount of cells
	 * @param cells
	 */
	public Row(ArrayList<Cell> cells) {
		super();
		this.cells = cells;
	}

	@Override
	/**
	 * toString method
	 */
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
	/**
	 * gets the amount of cells
	 * @return
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}
	/**
	 * sets the amount of cells
	 * @param cells
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	/**
	 * finds a certain cell
	 */
	public int FindCellIndex(Cell cellToFind)
	{
		var cellsArray = cells.toArray();
		
		for(int i =0; i< cellsArray.length; i++)
		{
			if (cellsArray[i] == cellToFind)
			{
				return i;
			}
		}
		return -1;
	}
}
