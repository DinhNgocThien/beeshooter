package com.thiendinh.model;

public class MoveByKey implements MoveBehavior{

	@Override
	public void move(Ship ship, byte direction, int min, int max) {
		if ((!(ship.getX() <min) && (direction == LEFT))) {
			ship.setX(ship.getX() - MOUSE_SPACE);
		}else if ((!(ship.getX() > max) && (direction == RIGHT))) {
			ship.setX(ship.getX() + MOUSE_SPACE);
		}
	}

}
