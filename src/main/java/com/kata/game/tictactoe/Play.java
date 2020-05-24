package com.kata.game.tictactoe;

import static java.util.logging.Level.INFO;

import java.util.logging.Logger;

public class Play {	
	
	private Board board;
	private static final int BOARD_SIZE = 3;
	private static final Logger LOGGER = Logger.getLogger(Play.class.getName());

	void initialize() {
		board = new Board();
		board.initialize(BOARD_SIZE);
	}
	
	boolean updateBoard(int rowSelected, int columnSelected, Mark player) {		
		if(rowSelected > BOARD_SIZE || columnSelected > BOARD_SIZE || columnSelected <= 0 || rowSelected <= 0) {
			LOGGER.log(INFO, "Please enter valid input between 1 and {0}", BOARD_SIZE);
			return false;
		}
		if(!board.update(rowSelected, columnSelected, player)) {
			LOGGER.log(INFO, "Position is already marked, please choose other position !!!");
			return false;
		}
		return true;
	}
	
	boolean hasResult() {
		return false;
	}
	
	public Board getBoard() {
		return board;
	}
	
}
