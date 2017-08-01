package com.thiendinh.model;

import java.util.Observable;

import com.thiendinh.controller.EventController;

public abstract class Ship extends Observable {

	private int x;
	private int y;
	private int retrieve, honey, score, level ;

	private boolean flagDead, flagPause;
	EventController eventController;

	public Ship(int level) {
		this.x = 250;
		this.y = 400;
		retrieve = 0;
		honey = 0;
		score = 0;
		this.level=level;
		eventController = new EventController();
	}

	public void dataChanged() {
		setChanged();
		notifyObservers();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		System.out.println(level+"in setLevel in Ship");
		this.level = level;
		dataChanged();
	}

	public void setRetrieve(int retrieve) {
		this.retrieve = retrieve;
		dataChanged();
	}

	public void eatHoney(int honey) {
		this.honey = honey;
		dataChanged();
	}

	public void setScore(int score) {
		this.score = score;
		dataChanged();
	}

	public int getRetrieve() {
		return retrieve;
	}

	public int getHoney() {
		return honey;
	}

	public int getScore() {
		return score;
	}

	public void moving(byte direction) {
		eventController.turn(this, direction);
	}

	public abstract void shooting(boolean isShooting);

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public EventController getEventController() {
		return eventController;
	}

	public boolean isFlagDead() {
		return flagDead;
	}

	public void setFlagDead(boolean flagDead) {
		this.flagDead = flagDead;
	}

	public boolean isFlagPause() {
		return flagPause;
	}

	public void setFlagPause(boolean flagPause) {
		this.flagPause = flagPause;
	}

}
