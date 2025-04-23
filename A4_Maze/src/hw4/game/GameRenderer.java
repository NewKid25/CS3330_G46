package hw4.game;

import hw4.player.Player;

public class GameRenderer {
	/**
	 * This function prints the grid of the game for the player to
	 * see where they are at and where the walls and exit is
	 * @param game
	 * @param player
	 */
	public void printGame(Game game, Player player)
	{
		var grid = game.getGrid();
		var rows = grid.getRows();
		int gridSize = rows.size();
//		String[] gridLines = new String[gridSize];
		
		int playerPosY = grid.FindRowIndex(player.getCurrentRow());	
		
		int playerPosX = player.getCurrentRow().FindCellIndex(player.getCurrentCell());
		
		for(int i =0; i<gridSize; i++) 
		{
			String gridLine =""; //print out a row as one string
			var cells = rows.get(i).getCells();
			for(int j=0; j<gridSize; j++)
			{
				if (i == playerPosY && j == playerPosX)
				{
					gridLine = gridLine+"A ";
				}
				else if(cells.get(j).containsExit())
				{
					gridLine = gridLine+"E ";
				}
				else
				{
					gridLine = gridLine+"S ";
				}
			}
			System.out.println(gridLine);
		}
		
	}
}
