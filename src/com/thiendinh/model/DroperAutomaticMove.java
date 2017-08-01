package com.thiendinh.model;

import java.util.Random;

public class DroperAutomaticMove implements DroperMoveBehavior {

	@Override
	public void move(Droper droper) {
		int d = new Random().nextInt(135) - 70;
		if ((droper.getY() < 0||(droper.getY() > 270))) {
			droper.setY(droper.getY() + d);
		} else {
			int newX = droper.getX() + d;
			if (newX > 0 && newX < 400) {
				droper.setX(newX);
			}
			d = new Random().nextInt(20) - 7;
			droper.setY(droper.getY() + d);
		}
	}

}
