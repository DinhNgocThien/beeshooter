package com.thiendinh.controller;

import javax.swing.JPanel;

import com.thiendinh.dao.LevelFile;
import com.thiendinh.model.Ship;
import com.thiendinh.view.NextPanel;
import com.thiendinh.view.PlayGamePanel;

public class CtrlNotification {
	private Ship ship;
	private boolean availableIncrease = true;
	private LevelFile levelFile;
	private PlayGamePanel playGamePanel;

	public CtrlNotification(PlayGamePanel playGamePanel, Ship ship) {
		this.playGamePanel = playGamePanel;
		this.ship = ship;
		levelFile = new LevelFile();
	}

	public void setLevel(int level) {
		ship.setLevel(level);
	}

	public void increaseLevel() {
		if (availableIncrease) {
			availableIncrease = false;
			levelFile.write(getLevel() + 1);
			JPanel endLevel = new NextPanel( playGamePanel, playGamePanel.getType(), getLevel() + 1);
			playGamePanel.add(endLevel);
		}
	}

	public void increaseHoney() {
		ship.eatHoney(ship.getHoney() + 1);
	}

	public void increaseRetrieve() {
		ship.setRetrieve(ship.getRetrieve() + 1);
	}

	public void increaseScore() {
		ship.setScore(ship.getScore() + 3);
	}

	public void decreaseRetreive() {
		ship.setRetrieve(ship.getRetrieve() - 1);
	}

	public int getRetreive() {
		return ship.getRetrieve();
	}

	public int getLevel() {
		return ship.getLevel();
	}

	public int getHoney(){
		return ship.getHoney();
	}
	
}
