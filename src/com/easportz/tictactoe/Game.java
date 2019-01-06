package com.easportz.tictactoe;

import java.util.*;

import com.easportz.tictactoe.exceptions.BlockTakenException;

public class Game {
	private Board board;
	private Player turn = Player.player1;
	
	public Game(int row, int col) {
		board = new Board(row, col);
	}
	
	// start innehåller en loop som forsätts tills slutet av spelet. 
	public void start() {
		init();
		boolean shouldIStop = false;
		while(!shouldIStop) {	  
		  getInput(); // steg 1
		  changeTurn(); // steg 2
		  board.draw(); // steg 3
		  GameResult result = checkForWinner(); // steg 4
		  switch(result) {
		  	case playerOneWins: // i switch ska inte namnet på enum skrivas.
		  		System.out.println("Player One Wins!");
		  		shouldIStop = true;
		  		break;
		  	case playerTwoWins:
		  		System.out.println("Player Two Wins!");
		  		shouldIStop = true;
		  		break;
		  	case draw:
		  		System.out.println("It's a draw!!");
		  		shouldIStop = true;
		  		break;
		  	
		  }
		}
		
	}
	
	// GameResult används för att returnera flera olika resultat.
	private GameResult checkForWinner() {
		
		for (int i = 0; i < 3 ; i++ ) {
			boolean mayContinue = true;
			for (int j = 0 ; mayContinue && j < 2 ; j++) {
				if (!board.getBlock(i, j).equals(board.getBlock(i , j + 1))) {
					mayContinue = false;
				}
			}
			
			if (mayContinue) {
				if(board.getBlock(i, 0).getMarker().getStatus() == 'X')
					return GameResult.playerOneWins; // Vi förutsätter att spelare 1 använder X för att markera rutorna.
				else {
					return GameResult.playerTwoWins;
				}
			}
				
			
		}
		
		// kollar vidare vertikallt och diagonallt för att hitt en vinnare
		// om det blir ingen vinnare då spelet är oavgjort eller inte slut än.
		// För att bestämma om spelet är slut eller oavgjort då ska man kolla
		// om det finns nån tom ruta kvar eller inte. Om det finns ingen tom ruta
		// då spelet är slut.
		
		/*
		 * 
		 * Resten av logiken för att hitta en vinnare.
		 */
		
		
		for (int i = 0; i < 3 ; i++ ) {
			for (int j = 0 ; j < 3 ; j++) {
				if (board.getBlock(i, j).isEmpty()) {		
					return GameResult.noWinYet; // Returnerar resultatet så fort en tom ruta hittas.
				}
			}
			
		}
		
		// Om exekveringen når den här raden då betyder det att ingen ruta har varit tom. 
		return GameResult.draw;
		
		
	}
	
	
	// changeTurn anrops varje gång för att byta turen. 
	private void changeTurn() {
		if (turn == Player.player1) {
			  turn = Player.player2;
		  }else {
			  turn = Player.player1;
		  }
	}
	
	// init innehåller all kod som ska köras i början av exekveringen. 
	public void init() {
		System.out.println("Welcome to EASportz Tic Tac Toe. 2018.");
		System.out.println("======================================");
	}
	
	// den här metoden är ansvarig för att läsa in användarens inmatnignar. 
	public void getInput() {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			try {
			   System.out.print("Enter row: ");
			   int row = input.nextInt();
			   System.out.print("Enter column: ");
			   int column = input.nextInt();
			   board.markBlock(row, column, turn);
			   flag = false;
			}
			catch(InputMismatchException ex) {
				System.out.println("Wrong type! Try again!");
				input.nextLine();
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("Invalid indexes!");
			}
			catch(BlockTakenException ex) {
				System.out.println("Block taken, try again!");
			}
		}	
	}
	
	
}
