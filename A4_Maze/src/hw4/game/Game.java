package hw4.game;

import hw4.maze.*;
import hw4.player.*;

public class Game {

	private Grid grid;

	public Game(Grid grid) {
		super();
		this.grid = grid;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
	
	public boolean play(Movement movement, Player player)
	{
		if(movement == null || player == null)
		{
			 return false;
		}
		
		Row playerCurrentRow = player.getCurrentRow();
		Cell playerCurrentCell = player.getCurrentCell();
//		System.out.println(playerCurrentRow.toString());
		System.out.println(playerCurrentCell.toString());
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
	
	
	
	

	
	
}
