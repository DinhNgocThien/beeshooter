package com.thiendinh.controller;

import com.thiendinh.view.PlayGameView;

public class CtrlStartNewGame implements CtrlStart{

	PlayGameView playGameView;
	private byte type;
	private int level;

	public CtrlStartNewGame(byte type, int level) {
		this.type = type;
		this.level = level;
	}

	public void selected() {
		playGameView = new PlayGameView(type, level);
	}
	
}
