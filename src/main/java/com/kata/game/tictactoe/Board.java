package com.kata.game.tictactoe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {

	private int boardSize;
	private List<Cell> cells;
	private int rowSelected;
	private int columnSelected;
	private Mark currentPlayer;

	public void initialize(int boardSize) {
		this.cells = new ArrayList<>(boardSize * boardSize);
		IntStream.rangeClosed(1, boardSize).forEach(
				row -> IntStream.rangeClosed(1, boardSize).forEach(column -> cells.add(new Cell(row, column))));
		this.clean();
	}

	void clean() {
		cells.stream().forEach(Cell::clear);
	}

	public boolean update(int rowSelected, int columnSelected, Mark mark) {		
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
		Predicate<Cell> leftToRightDiagonalMatch = cell -> cell.getRow() + cell.getColumn() == boardSize + 1;
		Predicate<Cell> rightToLeftDiagonalMatch = cell -> cell.getRow() == cell.getColumn();

		Stream<Predicate<Cell>> predicates = Stream.of(rowMatch, columnMatch, leftToRightDiagonalMatch, rightToLeftDiagonalMatch);
		Iterator<Predicate<Cell>> iterator = predicates.iterator();
		while (iterator.hasNext()) {
			boolean hasWon = cells.stream().filter(iterator.next()).allMatch(e -> e.getMark() == currentPlayer);
			if (hasWon) {
				return true;
			}
		}
		return false;
	}

	public boolean hasAllPositionsMarked() {
		return cells.stream().noneMatch(cell -> Mark.EMPTY == cell.getMark());
	}
	
	public List<Cell> getCells() {
		return cells;
	}
}
