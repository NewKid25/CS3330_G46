package hw4;

import java.util.ArrayList;
import java.util.Scanner;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Player;
import hw4.game.*;

public class Main {

	public static void main(String[] args) {
		
//		Cell cell00 = new Cell(CellComponents.EXIT, CellComponents.APERTURE,
//				CellComponents.WALL, CellComponents.APERTURE);
//		
//		Cell cell01 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
//				CellComponents.WALL, CellComponents.APERTURE);
//		
//		Cell cell02 = new Cell(CellComponents.WALL, CellComponents.WALL,
//				CellComponents.WALL, CellComponents.APERTURE);
//		
//		Cell cell10 = new Cell(CellComponents.WALL, CellComponents.WALL,
//				CellComponents.APERTURE, CellComponents.APERTURE);
//		
//		Cell cell11 = new Cell(CellComponents.WALL, CellComponents.APERTURE,
//				CellComponents.APERTURE, CellComponents.APERTURE);
//		
//		Cell cell12 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
//				CellComponents.APERTURE, CellComponents.APERTURE);
//		
//		Cell cell20 = new Cell(CellComponents.WALL, CellComponents.WALL,
//				CellComponents.APERTURE, CellComponents.WALL);
//		
//		Cell cell21 = new Cell(CellComponents.WALL, CellComponents.WALL,
//				CellComponents.APERTURE, CellComponents.WALL);
//		
//		Cell cell22 = new Cell(CellComponents.WALL, CellComponents.WALL,
//				CellComponents.APERTURE, CellComponents.WALL);
//		
//		
//		ArrayList<Cell> cells = new ArrayList<Cell>();
//		cells.add(0, cell00);
//		cells.add(1, cell01);
//		cells.add(2, cell02);
//		Row row0 = new Row(cells);
//		
//		cells = new ArrayList<Cell>();
//		cells.add(0, cell10);
//		cells.add(1, cell11);
//		cells.add(2, cell12);
//		Row row1 = new Row(cells);
//		
//		cells = new ArrayList<Cell>();
//		cells.add(0, cell20);
//		cells.add(1, cell21);
//		cells.add(2, cell22);
//		Row row2 = new Row(cells);
//		
//		ArrayList<Row> rows = new ArrayList<Row>();
//		rows.add(0, row0);
//		rows.add(1, row1);
//		rows.add(2, row2);
//		var rowList = new ArrayList<Row>();
//		rowList = rows;
//		var grid = new Grid(rows);
//		
//		var game = new Game(grid);
//		
//			System.out.println(game.getGrid().FindRowIndex(row0));
//			System.out.println(row0.FindCellIndex(cell21));
//		
//
//
		
		Game game = new Game(5);
		var grid = game.getGrid();
		var player = new Player(grid.getRows().get(2), 
				grid.getRows().get(2).getCells().get(2));
		var renderer = new GameRenderer();
//		renderer.printGame(game, player);
		Scanner scanner = new Scanner(System.in);
		Cell cells = new Cell();
		
		while(cells.containsExit() == false) {
			renderer.printGame(game, player);
			System.out.print("Up, Down, left, or right? ");
			String movement = scanner.nextLine();
			
			if(movement == "up" || movement == "Up") {
				player.setCurrentCell(player.getCurrentCell().getUp());
			} else if(movement == "down" || movement == "Down") {
				player.setCurrentCell(player.getCurrentCell().getDown());
			} else if(movement == "right" || movement == "Right") {
				player.setCurrentCell(player.getCurrentCell().getRight());
			} else if(movement == "right" || movement == "Right") {
				player.setCurrentCell(player.getCurrentCell().getRight());
			}
				else {
					System.out.println("Try again");
				}
			
		}
	}
}
