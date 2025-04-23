package hw4;

import java.util.ArrayList;
import java.util.Scanner;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;
import hw4.game.*;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game(5);
		var grid = game.getGrid();
		var player = new Player(grid.getRows().get(2), 
				grid.getRows().get(2).getCells().get(2));
		var renderer = new GameRenderer();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tears, Dispear, and Debugging (TDD)");
		System.out.println("The goal of this game is to get the agent out of the maze");
		System.out.println("Instructions: type up, down, right, or left to move the agent");
		
		while(true) {
			renderer.printGame(game, player);
			System.out.print("Would you like to go up, down, left, or right? ");
			String movement = scanner.nextLine().toLowerCase();
			if(movement.equals("up")) {
				game.play(Movement.UP, player);
				if(player.getCurrentCell().containsExit() == true)
				{
					break; //player exits the maze
				}
			} else if(movement.equals("down")) {
				game.play(Movement.DOWN, player);
				if(player.getCurrentCell().containsExit() == true)
				{
					break; //player exits the maze
				}
			} else if(movement.equals("right")) {
				game.play(Movement.RIGHT, player);
				if(player.getCurrentCell().containsExit() == true)
				{
					break; //player exits the maze
				}
			} else if(movement.equals("left")) {
				game.play(Movement.LEFT, player);
				if(player.getCurrentCell().containsExit() == true)
				{
					break; //player exits the maze
				}
			}
			else {
				System.out.println("Bad input, please try again");
			}
			
		}
		renderer.printGame(game, player);
		System.out.println("\nCongratulations!!! You successfully found your way out of the maze!");
		
	}
}
