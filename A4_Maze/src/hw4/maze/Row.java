package hw4.maze;

import java.util.ArrayList;

public class Row {

	ArrayList<Cell> cells;

	public Row(ArrayList<Cell> cells) {
		super();
		this.cells = cells;
	}

	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
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
