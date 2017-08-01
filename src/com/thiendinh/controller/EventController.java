package com.thiendinh.controller;

import java.awt.Point;

import com.thiendinh.model.MoveBehavior;
import com.thiendinh.model.MoveByKey;
import com.thiendinh.model.Ship;
import com.thiendinh.model.ShootBehavior;
import com.thiendinh.model.ShootBoom;
import com.thiendinh.model.ShootLaser;

public class EventController {

	// private Ship ship;
	private MoveBehavior moveBehavior;
	private ShootBehavior shootBehavior;

	//move
	public void turn(Ship ship, byte direction) {
		moveBehavior = new MoveByKey();
		moveBehavior.move(ship, direction, -19, 430);
	}

	// shoot conference type
	public void fireBoom(Ship ship, boolean isShooting) {
		shootBehavior = new ShootBoom();
		shootBehavior.shoot(new Point(ship.getX(), ship.getY()), new Point(ship.getX(), 0), isShooting);
	}

	public void fireLaser(Ship ship, boolean isShooting) {
		shootBehavior = new ShootLaser();
		shootBehavior.shoot(new Point(ship.getX(), ship.getY()), new Point(ship.getX(), 0), isShooting);
	}

	public ShootBehavior getShootBehavior() {
		return shootBehavior;
	}

}
