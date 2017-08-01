package com.thiendinh.model;

public class Bee extends Droper{
	private DroperMoveBehavior droperMoveBehavior;

	public Bee(int x, int y) {
		super(x, y);
	}


	@Override
	public void move() {
		droperMoveBehavior = new DroperAutomaticMove();
		droperMoveBehavior.move(this);
	}
}
