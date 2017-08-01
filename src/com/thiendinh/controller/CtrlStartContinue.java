package com.thiendinh.controller;

import com.thiendinh.dao.LevelFile;
import com.thiendinh.view.PlayGameView;

public class CtrlStartContinue implements CtrlStart{

	PlayGameView playGameView;
	private byte type;
	private int level;
	private LevelFile levelFile;

	public CtrlStartContinue(byte type) {
		this.type = type;
		levelFile= new LevelFile();
		level=levelFile.read();
	}

	public void selected() {
		playGameView = new PlayGameView(type, level);
	}
	
}
