package com.kata.game.tictactoe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {

	private List<Cell> cells;
	private static final int BOARD_SIZE = 3;
	private int rowSelected;
	private int columnSelected;
	private Mark currentPlayer;

	public void initialize() {
		this.cells = new ArrayList<>(BOARD_SIZE * BOARD_SIZE);
		IntStream.rangeClosed(1, BOARD_SIZE).forEach(
				row -> IntStream.rangeClosed(1, BOARD_SIZE).forEach(column -> cells.add(new Cell(row, column))));
		this.clean();
	}

	void clean() {
		cells.stream().forEach(Cell::clear);
	}

	public boolean update(int rowSelected, int columnSelected, Mark mark) {
		if (cells == null || cells.isEmpty()) {
			this.initialize();			
		}
		Optional<Cell> optionalCell = cells.stream().filter(e -> e.getColumn() == columnSelected && e.getRow() == rowSelected)
				.findFirst();
		if (optionalCell.isPresent()) {
			Cell cellToUpdate = optionalCell.get(); 
			if (Mark.EMPTY != cellToUpdate.getMark()) {
				return false;
			}
			cellToUpdate.setMark(mark);
			this.rowSelected = rowSelected;
			this.columnSelected = columnSelected;
			this.currentPlayer = mark;
			return true;
		}
		return false;
	}

	public boolean hasWon() {
		Predicate<Cell> rowMatch = cell -> cell.getRow() == rowSelected;
		Predicate<Cell> columnMatch = cell -> cell.getColumn() == columnSelected;
		Stream<Predicate<Cell>> predicates = Stream.of(rowMatch, columnMatch);
		Iterator<Predicate<Cell>> iterator = predicates.iterator();
		while (iterator.hasNext()) {
			boolean hasWon = cells.stream().filter(iterator.next()).allMatch(e -> e.getMark() == currentPlayer);
			if (hasWon) {
				return true;
			}
		}
		return false;
	}

	
}
