package com.kata.game.tictactoe;

public class Play {	
	
	private Board board;
	
	void initialize() {
		board = new Board();
		board.initialize();
	}
	
	boolean updateBoard(int rowSelected, int columnSelected, Mark player) {		
		return false;
	}
	
	public Board getBoard() {
		return board;
	}
	
}
