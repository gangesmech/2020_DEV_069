package com.kata.game.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	private Board board;
	
	@Before
	public void initialize() {
		board = new Board();
		board.initialize();
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
		
		board.update(1, 1, Mark.CROSS);
		board.update(1, 2, Mark.CROSS);
		board.update(1, 3, Mark.CROSS);
		
        assertEquals(true, board.hasWon());
    }
		
	@Test
    public void playerNoughtWonByRowMatch(){
		
		board.update(2, 1, Mark.NOUGHT);
		board.update(2, 2, Mark.NOUGHT);
		board.update(2, 3, Mark.NOUGHT);
		
        assertEquals(true, board.hasWon());
    }
	
	@Test
    public void playerCrossWonByColumnMatch(){
		
		board.update(1, 1, Mark.CROSS);
		board.update(2, 1, Mark.CROSS);
		board.update(3, 1, Mark.CROSS);
		
        assertEquals(true, board.hasWon());
    }
		
	@Test
    public void playerNoughtWonByColumnMatch(){
		
		board.update(1, 2, Mark.NOUGHT);
		board.update(2, 2, Mark.NOUGHT);
		board.update(3, 2, Mark.NOUGHT);
		
        assertEquals(true, board.hasWon());
    }
	
	@Test
    public void playerCrossWonByLeftToRightDiagonalMatch(){
		
		board.update(3, 1, Mark.CROSS);
		board.update(2, 2, Mark.CROSS);
		board.update(1, 3, Mark.CROSS);
		
        assertEquals(true, board.hasWon());
    }
		
	@Test
    public void playerNoughtWonByLeftToRightDiagonalMatch(){
		
		board.update(3, 1, Mark.NOUGHT);
		board.update(2, 2, Mark.NOUGHT);
		board.update(1, 3, Mark.NOUGHT);
		
        assertEquals(true, board.hasWon());
    }
	
	@Test
    public void playerCrossWonByRightToLeftDiagonalMatch(){
		
		board.update(3, 3, Mark.CROSS);
		board.update(2, 2, Mark.CROSS);
		board.update(1, 1, Mark.CROSS);
		
        assertEquals(true, board.hasWon());
    }
		
	@Test
    public void playerNoughtWonByRightToLeftDiagonalMatch(){
		
		board.update(3, 3, Mark.NOUGHT);
		board.update(2, 2, Mark.NOUGHT);
		board.update(1, 1, Mark.NOUGHT);
		
        assertEquals(true, board.hasWon());
    }
	
	@Test
    public void allPositionsMarked(){		
		
		board.getCells().forEach(e -> e.setMark(Mark.CROSS));
		
        assertEquals(true, board.hasAllPositionsMarked());
    }
	
	@Test
    public void allPositionsMarkedExceptOne(){		
		
		board.getCells().forEach(e -> e.setMark(Mark.CROSS));	
		board.update(1, 1, Mark.EMPTY);
		
        assertEquals(false, board.hasAllPositionsMarked());
    }
	
}
