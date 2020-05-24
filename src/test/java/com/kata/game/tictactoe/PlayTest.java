package com.kata.game.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlayTest {

	private Play play;	
	
	private Board board;

	@Before
	public void initialize() {
		play = new Play();
		play.initialize();
		board = play.getBoard();
	}
	
	@Test
    public void noUpdateIfOutOfGridPositionEntry(){
		
		assertEquals(false, play.updateBoard(10, 1, Mark.NOUGHT));
		assertEquals(false, play.updateBoard(-1, 1, Mark.NOUGHT));
	}
	
	@Test
    public void noUpdateIfPositionAlreadyMarked(){	
		
		board.update(1, 1, Mark.CROSS);
		
		assertEquals(false, play.updateBoard(1, 1, Mark.NOUGHT));
	}
	
	@Test
    public void updateIfValidEntry(){	
		
		assertEquals(true, play.updateBoard(1, 1, Mark.NOUGHT));
		
	}
}
