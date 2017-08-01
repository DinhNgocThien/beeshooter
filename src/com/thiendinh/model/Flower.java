package com.thiendinh.model;


public class Flower extends Droper{

	private DroperMoveBehavior droperMoveBehavior;
	public Flower(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		droperMoveBehavior = new DroperFreeMove();
		droperMoveBehavior.move(this);
	}

}
