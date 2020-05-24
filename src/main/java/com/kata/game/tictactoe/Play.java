package com.kata.game.tictactoe;

import static java.util.logging.Level.INFO;

import java.util.Scanner;
import java.util.logging.Logger;

public class Play {	
	
	private Board board;
	private static final int BOARD_SIZE = 3;	
	private static Scanner scanner = new Scanner(System.in);
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
		if(board.hasWon()) {
			LOGGER.log(INFO, "Player {0} has won the game !!! ", board.getCellSelected().getMark().getLabel());
			return true;
		}
		if(board.hasAllPositionsMarked()) {
			LOGGER.log(INFO, "The game is draw !!!");
			return true;
		}
		return false;
	}
	
	void display() {
		StringBuilder stringBuilder = new StringBuilder("\n");
		board.getCells().stream().forEach(cell -> {
			stringBuilder.append(cell.getMark().getLabel());
			if (BOARD_SIZE == cell.getColumn()) {
				stringBuilder.append("\n");
			} else {
				stringBuilder.append(" | ");
			}
		});
		LOGGER.log(INFO, "{0}", stringBuilder);
	}
	
	
	void userInput(Mark player) {
		do {
			 LOGGER.log(INFO, "Player {0}, please choose the position [row(1-{1}) column(1-{1})]: ", new Object[]{player.getLabel(), BOARD_SIZE});	             
	    } while(!updateBoard(scanner.nextInt(), scanner.nextInt(), player));
	}
		
	public static void main(String[] args) {
		 Play play = new Play();
		 play.initialize();
		 Mark player = Mark.CROSS;
		 do {
			 play.userInput(player);
			 player = (Mark.CROSS == play.getBoard().getCellSelected().getMark()) ? Mark.NOUGHT : Mark.CROSS;
			 play.display();
		} while(!play.hasResult());	
	}
	
	public Board getBoard() {
		return board;
	}
	
}
