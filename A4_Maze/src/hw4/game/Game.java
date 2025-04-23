package hw4.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import hw4.maze.*;
import hw4.player.*;

public class Game {

	private Grid grid;

	/**
	 * constructor that sets the grid
	 * @param grid
	 */
	public Game(Grid grid) {
		super();
		this.grid = grid;
	}
	/**
	 * sets the grid size to a random size
	 * @param gridSize
	 */
	public Game(int gridSize)
	{
		this.grid = createRandomGrid(gridSize);
	}
	
	/**
	 * returns the grid
	 * @return
	 */
	public Grid getGrid() {
		return grid;
	}
	
	/**
	 * sets the grid
	 * @param grid = random grid
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}


	@Override
	/**
	 * toString function for grid
	 */
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
	
	/**
	 * This method moves the player in the grid, checking if the player would hit a wall
	 * @param movement
	 * @param player
	 * @return
	 */
	public boolean play(Movement movement, Player player)
	{
		if(movement == null || player == null)
		{
			 return false;
		}
		
		Row playerCurrentRow = player.getCurrentRow();
		Cell playerCurrentCell = player.getCurrentCell();

		int changeX =0, changeY = 0;
		switch(movement)
		{
			case Movement.UP:
				if(playerCurrentCell.getUp() == CellComponents.WALL)
				{
					return false;
				}
	
				changeY = -1;
				break;
			case Movement.DOWN:
				if(playerCurrentCell.getDown() == CellComponents.WALL)
				{
					return false;
				}
				changeY = 1;
				break;
			case Movement.LEFT:
				if(playerCurrentCell.getLeft() == CellComponents.WALL)
				{
					return false;
				}
				changeX = -1;
				break;
			case Movement.RIGHT:
				if(playerCurrentCell.getRight() == CellComponents.WALL)
				{
					return false;
				}
				changeX = 1;
				break;
		}
		//if broke out of the switch then the player is allowed to move
		//Grid (x,y) positions start at (0,0) in the top left corner and (max X,max Y) in the bottom right corner
		
		Row playerNewRow;
		Cell playerNewCell;
		try {
			int playerPosY = grid.FindRowIndex(playerCurrentRow);	
			
			int playerPosX = playerCurrentRow.FindCellIndex(playerCurrentCell);
			
			playerNewRow = grid.getRows().get(playerPosY+changeY);
			playerNewCell = playerNewRow.getCells().get(playerPosX+changeX);
		}
		catch(IndexOutOfBoundsException e) //player could try to move outside the bounds of the grid 
		{
			if(playerCurrentCell.getLeft() == CellComponents.EXIT && movement == Movement.LEFT) //check if player found exit
			{
				return true;
			}
			else
			{
				return false;				
			}
		}
			
		player.setCurrentRow(playerNewRow);
		player.setCurrentCell(playerNewCell);
		return true;
		
	}
	/**
	 * creates a random grid using gridSize
	 * @param gridSize
	 * @return
	 */
	public Grid createRandomGrid(int gridSize)
	{
		if(gridSize < 3 || gridSize > 7)
		{
			return null;
		}
		var cells = new Cell[gridSize][gridSize];
		var rand = new Random();

		var rowList = new ArrayList<Row>();
		for(int i =0; i<gridSize; i++) //i is the y coordinate in this grid
		{
		
			var cellList = new ArrayList<Cell>();
			for(int j=0; j<gridSize; j++) //j is the x coordinate
			{
			
				var currentCell = new Cell(); //in this grid coordinates go (y,x) 
				
				if(j == 0) //this is the leftmost cell
				{
					currentCell.setLeft(CellComponents.WALL);
				}
				else
				{
					//this left equals the right from the cell to the left for consistency
					currentCell.setLeft(cells[i][j-1].getRight());
				}
				
				if(j== gridSize) //this is the rightmost cell
				{
					currentCell.setRight(CellComponents.WALL);
				}
				else
				{
					var isWallProb = rand.nextDouble();
					if(isWallProb < .2) //walls should spawn about 20% of the time
					{
						currentCell.setRight(CellComponents.WALL);
					}
					else
					{
						currentCell.setRight(CellComponents.APERTURE);
					}
				}
				
				if(i==0) //this is in the top most row
				{
					currentCell.setUp(CellComponents.WALL);
				}
				else
				{
					//this up equals the down from the cell above it for consistency
					currentCell.setUp(cells[i-1][j].getDown()); 
				}
				
				if(i==gridSize) //this is the bottom most cell
				{
					currentCell.setDown(CellComponents.WALL);
				}
				else
				{
					var isWallProb = rand.nextDouble();
					if(isWallProb<0.15)//probability for a wall is 15%
					{
						currentCell.setDown(CellComponents.WALL);
					}
					else
					{
						currentCell.setDown(CellComponents.APERTURE);
					}
				}				
				
				
				if(!currentCell.containsAtLeastOneWall()) //check if cell is all apertures, which is illegal
				{
					currentCell.setRight(CellComponents.WALL);
				}
				cells[i][j] = currentCell;
				cellList.add(currentCell);
			}
			rowList.add(new Row(cellList));
		}
		
		//pick a row and set leftmost cell in that row to have the one exit
		int rowToHaveExit = rand.nextInt(gridSize);
		rowList.get(rowToHaveExit).getCells().get(0).setLeft(CellComponents.EXIT);
		//making double sure that exit does not have walls on all sides
		rowList.get(rowToHaveExit).getCells().get(0).setRight(CellComponents.APERTURE);
		rowList.get(rowToHaveExit).getCells().get(1).setLeft(CellComponents.APERTURE);
	
		var grid = new Grid(rowList);
		return grid;
	}
	
	
	public Player initPlayerInValidPosition(int maxDistanceFromExit) 
	{
		var rows = grid.getRows();
		Player player = null;
		for(var row : rows)
		{
			var leftMostCellInRow = row.getCells().get(0);
			if(leftMostCellInRow.containsExit())
			{
				player = new Player(row, leftMostCellInRow);
			}
		}
		
		//randomly try move away from the exit a maxDistanceFromExit number of times
		//this way we guarantee that the exit is reachable from where the player starts
		var rand = new Random();
		for(int i =0; i<maxDistanceFromExit; i++)
		{
			var directionToTry =rand.nextInt(3);
			switch (directionToTry)
			{
				//never move left because that would put player closer to exit
				case 0:
					play(Movement.UP, player);
				case 1:
					play(Movement.RIGHT, player);
				case 2:
					play(Movement.DOWN, player);
			}
		}
		
		//dont want to start player on exit, make sure they move (one direction must be open
		if(player.getCurrentCell().containsExit()) 
		{
			play(Movement.UP, player);
			play(Movement.RIGHT, player);
			if(player.getCurrentCell().containsExit()) //dont move down if player not on exit (up then down could cancel out)
			{
				play(Movement.DOWN, player);
			}
		}
		return player;
		
		
	}

	
	
}
