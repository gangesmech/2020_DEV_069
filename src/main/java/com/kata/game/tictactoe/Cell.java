package com.kata.game.tictactoe;

public class Cell{
	
	private Mark mark;
	
	private int row;
	
	private int column;
		
	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void clear(){
		mark = Mark.EMPTY;
	}
	
	public Mark getMark() {
		return mark;
	}
	
	public void setMark(Mark mark) {
		this.mark = mark;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}	
}
