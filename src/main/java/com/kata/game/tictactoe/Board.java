package com.kata.game.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Board {

	private List<Cell> cells;
	private static final int BOARD_SIZE = 3;

	public void initialize() {
		this.cells = new ArrayList<>(BOARD_SIZE * BOARD_SIZE);
		IntStream.rangeClosed(1, BOARD_SIZE).forEach(
				row -> IntStream.rangeClosed(1, BOARD_SIZE).forEach(column -> cells.add(new Cell(row, column))));
	}

	void clean() {
		cells.stream().forEach(Cell::clear);
	}

	public boolean update(int rowSelected, int columnSelected, Mark mark) {
		if (cells == null || cells.isEmpty()) {
			this.initialize();
			this.clean();
		}
		Optional<Cell> optionalCell = cells.stream().filter(e -> e.getColumn() == columnSelected && e.getRow() == rowSelected)
				.findFirst();
		if (optionalCell.isPresent()) {
			Cell cellToUpdate = optionalCell.get(); 
			if (Mark.EMPTY != cellToUpdate.getMark()) {
				return false;
			}
			cellToUpdate.setMark(mark);
			return true;
		}
		return false;
	}

}
