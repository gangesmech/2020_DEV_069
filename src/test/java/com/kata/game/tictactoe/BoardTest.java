package com.kata.game.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	private Board board;
	
	@Before
	public void initialize() {
		board = new Board();
	}
	
	@Test
    public void updateIfValidPosition(){
        assertEquals(true, board.update(1, 1, Mark.CROSS));
    }
	
	@Test
    public void noUpdateIfPositionAlreadyMarked(){
		board.update(1, 1, Mark.CROSS);
        assertEquals(false, board.update(1, 1, Mark.NOUGHT));
    }
	
	@Test
    public void playerCrossWonByRowMatch(){
		board.update(1, 2, Mark.CROSS);
        assertEquals(true, board.hasWon());
    }
		
	@Test
    public void playerNoughtWonByRowMatch(){
		board.update(1, 3, Mark.NOUGHT);
        assertEquals(true, board.hasWon());
    }
}
