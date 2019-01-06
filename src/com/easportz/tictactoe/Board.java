package com.easportz.tictactoe;

import com.easportz.tictactoe.exceptions.BlockTakenException;

// Board representerar brädet.
public class Board implements Drawable{
	
	// brädet implemeteras som en tvådimensionell array.
	public Block[][] blocks;
	
	// brädet konstrukteras i konstruktören.
	public Board(int row, int col) {
		blocks = new Block[row][col];
		for (int i = 0 ; i < row ; ++i)
			for(int j = 0 ; j < col ; ++j)
				blocks[i][j] = new Block();	
	}
    
	
	public void markBlock(int row, int column, Player current) throws ArrayIndexOutOfBoundsException, BlockTakenException{
		
    	if (blocks[row][column].isEmpty())
    		blocks[row][column].setMarker(current);
    	else
    		throw new BlockTakenException();
	}
	
	// den här metoden ritar brädet i terminalen.
    public void draw() {
    	// TODO Auto-generated method stub
    			for (int i = 0 ; i <= 2 ; ++i) {
    				for(int j = 0 ; j <= 2 ; ++j) {
    					blocks[i][j].draw();
    					
    				}
    				System.out.println();
    			}
    }
    
    // gör det möjligt för andra metoder i andra klasser att komma åt brädet.
    public Block getBlock(int row, int col) {
		return blocks[row][col];
	}
	
}
