package com.thiendinh.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;

public abstract class ShootBehavior {
	private boolean isShooting;
	Point start, end;
	protected int x1, x2, y1, y2;

	public void shoot(Point start, Point end, boolean isShooting) {
		this.start = start;
		this.end = end;
		this.x1 = start.x;
		this.y1 = start.y;
		this.x2 = end.x;
		this.y2 = end.y;
		this.isShooting= isShooting;
	}

	public abstract void drawShoot(Graphics g, int i);

	public abstract void drawShootOnTarget(Graphics g, Image explosion, int i, int y, ImageObserver io);

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public boolean isShooting() {
		return isShooting;
	}

	public void setY1(int y) {
		this.y1=y;
	}

}
