package com.thiendinh.model;

import java.util.List;

public class ShootCollision {
	private ShootBehavior shootBehavior;
	private Ship ship;
	private byte type;
	private List<Droper> beeList;

	public ShootCollision(ShootBehavior shootBehavior, Ship ship, byte type, List<Droper> beeList) {
		this.shootBehavior = shootBehavior;
		this.ship = ship;
		this.type = type;
		this.beeList = beeList;
	}

	public void shootCollisionOccur(int index) {
//		shootBehavior.drawShootOnTarget(g, explosion, beeList.get(index).getX() - 30, beeList.get(index).getY() - 30,	io);
		
		beeList.remove(index);
	}

	public int isCollision() {
		for (int i = 0; i < beeList.size(); i++) {
			if (type == 1) {
				if ((ship.getX() < beeList.get(i).getX() + 10) && (beeList.get(i).getX() - 30 < ship.getX())&&(beeList.get(i).getY() > 0) && (beeList.get(i).getY() < 400)) {
						return i;
				}
			} else if (type == 2) {
				if ((shootBehavior.getY1() + 22 < beeList.get(i).getY() + 50)
						&& (beeList.get(i).getY() - 10 < shootBehavior.getY1() + 22))
					return i;
			}
		}
		return -1;
	}

}
