package com.easportz.tictactoe;


/* Den här enumerationen representerar en spelare. 
 * Det är bara två möjliga spelare i det här spelet.
 * 
 * 
 */
public enum Player {
	player1('X'), player2('O');
	
	private char status;
	
	private Player(char status) {
		this.status = status;
	}

	public char getStatus() {
		return status;
	}
	
}

