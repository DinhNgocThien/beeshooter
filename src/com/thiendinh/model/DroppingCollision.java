package com.thiendinh.model;

import java.util.ArrayList;

import com.thiendinh.controller.CtrlStop;

public class DroppingCollision {

	private Ship ship;

	public DroppingCollision(Ship ship) {
		this.ship = ship;
	}

	public void droppingCollisionOccur(ArrayList<Droper> list, int index) {
		list.remove(index);
	}

	public int isCollision(ArrayList<Droper> droperList) {
		for (int i = 0; i < droperList.size(); i++) {
			if ((ship.getX() < droperList.get(i).getX() + 10) && (droperList.get(i).getX() - 60 < ship.getX())) {
				if ((ship.getY() < droperList.get(i).getY() + 10) && (droperList.get(i).getY() - 10 < ship.getY())) {
						return i;
				}
			}
		}
		return -1;
	}

	public void lose() {
		CtrlStop ctrlStop = new CtrlStop(ship);
		ctrlStop.setDead();
	}

}
