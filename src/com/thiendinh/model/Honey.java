package com.thiendinh.model;


public class Honey extends Droper{

	DroperMoveBehavior droperMoveBehavior;

	public Honey(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		droperMoveBehavior = new DroperFreeMove();
		droperMoveBehavior.move(this);
	}

}
