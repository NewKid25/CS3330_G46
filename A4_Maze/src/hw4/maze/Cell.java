package hw4.maze;

public class Cell {

	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	

	public Cell()
	{
		
	}
	/**
	 * creates a cell in a grid
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		super();
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}
	
	@Override
	/**
	 * toString for cell object
	 */
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}

	/**
	 * gets the cell to the right side of the current cell
	 * @return
	 */
	public CellComponents getLeft() {
		return left;
	}
	/**
	 * checks the left side of a cell to a wall, the agent, or exit
	 * @param left
	 */
	public void setLeft(CellComponents left) {
		if(left == null)
		{
			this.left = CellComponents.WALL;
		}
		else
		{			
			this.left = left;
		}
	}
	/**
	 * gets the cell to the right side of the current cell
	 * @return
	 */
	public CellComponents getRight() {
		return right;
	}
	/**
	 * sets the cell to the right a wall, agent, or exit
	 * @param right
	 */
	public void setRight(CellComponents right) {
		if(right == null)
		{
			this.right = CellComponents.WALL;
		}
		else
		{			
			this.right = right;
		}
	}
	/**
	 * returns what cell is above the current cell
	 * @return
	 */
	public CellComponents getUp() {
		return up;
	}
	/**
	 * sets the cell above the current cell to wall, agent, or exit
	 * @param up
	 */
	public void setUp(CellComponents up) {
		if(up == null)
		{
			this.up = CellComponents.WALL;
		}
		else
		{			
			this.up = up;
		}
	}
	/**
	 * gets the cell from below the current cell
	 * @return
	 */
	public CellComponents getDown() {
		return down;
	}
	/**
	 * sets the cell below the current cell to wall, exit, or agent
	 * @param down
	 */
	public void setDown(CellComponents down) {
		if(down == null)
		{
			this.down = CellComponents.WALL;
		}
		else
		{			
			this.down = down;
		}
	}
	/**
	 * checks to see if the current cell has at least one wall
	 * @return
	 */
	public boolean containsAtLeastOneWall()
	{
		if(left==CellComponents.WALL || right == CellComponents.WALL || up == CellComponents.WALL || down == CellComponents.WALL)
		{
			return true;
		}
		else
		{
			return false;			
		}
	}
}
