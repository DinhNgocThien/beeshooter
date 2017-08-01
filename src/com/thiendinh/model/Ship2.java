package com.thiendinh.model;

public class Ship2 extends Ship {

	public Ship2(int level) {
		super(level);
	}

	@Override
	public void shooting(boolean isShooting) {
		eventController.fireBoom(this, isShooting);
	}
}