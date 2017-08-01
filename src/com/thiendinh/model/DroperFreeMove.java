package com.thiendinh.model;

import java.util.Random;

public class DroperFreeMove implements DroperMoveBehavior {

	@Override
	public void move(Droper droper) {
		droper.setY(droper.getY()+new Random().nextInt(10)+10);
	}

}
