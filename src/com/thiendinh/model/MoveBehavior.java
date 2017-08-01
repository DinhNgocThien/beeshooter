package com.thiendinh.model;


public interface MoveBehavior {
	final static int MOUSE_SPACE = 10;
	final static  byte LEFT = 1, RIGHT = 2, NO_TURN=0;

	public abstract void move(Ship ship, byte direction, int min, int max);

}
