package com.easportz.tictactoe;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * Att läsa in antal rader och kolumner från terminalen.
		 * Game game = new Game(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		   game.start();
		 */
		
		
		Game game = new Game(3, 3);
		game.start();
		
		

	}

}
