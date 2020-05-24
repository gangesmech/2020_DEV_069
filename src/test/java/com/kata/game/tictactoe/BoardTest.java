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
	
}
