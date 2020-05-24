package com.kata.game.tictactoe;

public enum Mark {
	EMPTY("-"), CROSS("X"), NOUGHT("O");

	private String label;	
	
	private Mark(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

}
