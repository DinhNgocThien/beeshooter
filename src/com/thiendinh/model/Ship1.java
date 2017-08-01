package com.thiendinh.model;

public class Ship1 extends Ship {

	public Ship1(int level) {
		super(level);
	}

	@Override
	public void shooting(boolean isShooting) {
		eventController.fireLaser(this, isShooting);
	}

}
