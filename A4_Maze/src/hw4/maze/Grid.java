package hw4.maze;

import java.util.ArrayList;

public class Grid {
	ArrayList<Row> rows;

	/**
	 * sets the rows
	 * @param rows
	 */
	public Grid(ArrayList<Row> rows) {
		super();
		this.rows = rows;
	}
	/**
	 * returns the amount of rows
	 * @return
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}
	/**
	 * sets the amount of rows
	 * @param rows
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	@Override
	/**
	 * toString method
	 */
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
	/**
	 * finds a certain row
	 * @param rowToFind
	 * @return
	 */
	public int FindRowIndex(Row rowToFind)
	{
		var rowsArray = rows.toArray();
		
		for(int i =0; i< rowsArray.length; i++)
		{
			if (rowsArray[i] == rowToFind)
			{
				return i;
			}
		}
		return -1;
	}
}
