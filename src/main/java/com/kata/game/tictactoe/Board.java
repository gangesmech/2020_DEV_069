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
	private Cell cellSelected;

	public void initialize(int boardSize) {
		this.boardSize = boardSize;
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
			cellSelected = optionalCell.get(); 
			if (Mark.EMPTY != cellSelected.getMark()) {
				return false;
			}
			cellSelected.setMark(mark);
			return true;
		}
		return false;
	}

	public boolean hasWon() {
		Predicate<Cell> rowMatch = cell -> cell.getRow() == cellSelected.getRow();
		Predicate<Cell> columnMatch = cell -> cell.getColumn() == cellSelected.getColumn();
		Predicate<Cell> leftToRightDiagonalMatch = cell -> cell.getRow() + cell.getColumn() == boardSize + 1;
		Predicate<Cell> rightToLeftDiagonalMatch = cell -> cell.getRow() == cell.getColumn();

		Stream<Predicate<Cell>> predicates = Stream.of(rowMatch, columnMatch, leftToRightDiagonalMatch, rightToLeftDiagonalMatch);
		Iterator<Predicate<Cell>> iterator = predicates.iterator();
		while (iterator.hasNext()) {
			boolean hasWon = cells.stream().filter(iterator.next()).allMatch(e -> e.getMark() == cellSelected.getMark());
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
	
	public Cell getCellSelected() {
		return cellSelected;
	}
}
