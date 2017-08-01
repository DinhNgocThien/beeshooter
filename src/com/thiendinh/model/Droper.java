package com.thiendinh.model;

public abstract class Droper {
	private int x, y;
	public Droper(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public abstract void move();
	
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x=x;
	}
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y=y;
	}


}
