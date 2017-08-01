package com.thiendinh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thiendinh.model.Bee;
import com.thiendinh.model.Droper;
import com.thiendinh.model.DroppingCollision;
import com.thiendinh.model.Flower;
import com.thiendinh.model.Honey;
import com.thiendinh.model.Ship;
import com.thiendinh.model.Ship1;
import com.thiendinh.model.Ship2;
import com.thiendinh.sound.OneTimeSound_cdjv;
import com.thiendinh.view.PlayGamePanel;
import com.thiendinh.view.PlayGameView;

public class MainCtrlRunGame implements Runnable {

	private PlayGamePanel gamepanel;
	private Ship ship;
	private Droper bee;
	private Droper honey, flower;
	private int speed = 90;
	private List<Droper> beeList, honeyList, flowerList;
	private int numBee, numHoney = 99, numFlower = 7;
	private boolean flagRun = true, flagStop = false;
	private DroppingCollision droppingCollision;
	private CtrlNotification ctrlNotification;
	private PlayGameView view;
	private CtrlStop ctrlStop;

	public MainCtrlRunGame(PlayGameView view, PlayGamePanel gamepanel, int level, byte type) {
		this.view = view;
		this.gamepanel = gamepanel;

		if (type == 1) {
			ship = new Ship1(level);
		} else
			ship = new Ship2(level);
		ctrlNotification = new CtrlNotification(gamepanel, ship);
		ctrlStop = new CtrlStop(ship);
		numBee = createBee(level);
		beeList = new ArrayList<Droper>();
		honeyList = new ArrayList<Droper>();
		flowerList = new ArrayList<Droper>();

		for (int i = 0; i < numBee; i++) {
			// beeList.add(new Bee(new Random().nextInt(420) + 10, new
			// Random().nextInt(90) - 30));
			beeList.add(new Bee(new Random().nextInt(420) + 10, 50 - 7 * i));
		}

		for (int i = 0; i < numHoney; i++) {
			honeyList.add(new Honey(new Random().nextInt(425), new Random().nextInt(6999) - 7000));
		}

		for (int i = 0; i < numFlower; i++) {
			flowerList.add(new Flower(new Random().nextInt(425), new Random().nextInt(6900) - 7000));
		}
	}

	private int createBee(int n) {
		return 2 * n;
	}

	@Override
	public void run() {
		
		
		ship.dataChanged();
		while (!flagStop) {
			if (!ship.isFlagPause()) {
				setFlagRun(true);
			}
			while (flagRun) {
				if (ship.isFlagPause()) {
					setFlagRun(false);
				} else if (ship.isFlagDead()) {
					setFlagStop(true);
				} else {

					// next level
					if (beeList.size() <= 0) {
						OneTimeSound_cdjv nextsound = new OneTimeSound_cdjv("src/sound/next.wav");
						nextsound.start();
						ctrlNotification.increaseLevel();
						ctrlStop.setDead();
						System.out.println("next level");
					}
					
					// if collision occur
					droppingCollision = new DroppingCollision(ship);
					if (droppingCollision != null) {
						int collisionIndex = droppingCollision.isCollision((ArrayList<Droper>) flowerList);
						if (collisionIndex != -1) {
							OneTimeSound_cdjv powerupsound = new OneTimeSound_cdjv("src/sound/powerup.wav");
							powerupsound.start();
							ctrlNotification.increaseRetrieve();
							droppingCollision.droppingCollisionOccur((ArrayList<Droper>) flowerList, collisionIndex);
						}

						collisionIndex = droppingCollision.isCollision((ArrayList<Droper>) honeyList);
						if (collisionIndex != -1) {
							OneTimeSound_cdjv eatSound = new OneTimeSound_cdjv("src/sound/get.wav");
							eatSound.start();
							ctrlNotification.increaseHoney();
							droppingCollision.droppingCollisionOccur((ArrayList<Droper>) honeyList, collisionIndex);
						}

						collisionIndex = droppingCollision.isCollision((ArrayList<Droper>) beeList);
						if (collisionIndex != -1) {
							int retreive = ctrlNotification.getRetreive();
							if (retreive <= 0) {
								gamepanel.adLost(true);
								droppingCollision.lose();
								System.out.println("game over");
							} else {
								ctrlNotification.decreaseRetreive();
							}
						}
					}
					
					// remove element out of date in drop down list
					for (int i = 0; i < beeList.size(); i++) {
						if (beeList.get(i).getY() > view.getH()) {
							beeList.remove(i);
						}
					}
					for (int i = 0; i < honeyList.size(); i++) {
						if (honeyList.get(i).getY() > view.getH()) {
							honeyList.remove(i);
						}
					}
					for (int i = 0; i < flowerList.size(); i++) {
						if (flowerList.get(i).getY() > view.getH()) {
							flowerList.remove(i);
						}
					}

					// move behavior
					for (int i = 0; i < beeList.size(); i++) {
						beeList.get(i).move();
					}
					for (int i = 0; i < honeyList.size(); i++) {
						honeyList.get(i).move();
					}
					for (int i = 0; i < flowerList.size(); i++) {
						flowerList.get(i).move();
					}

					gamepanel.repaint();
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						System.out.println("main ctrl run game occur error!");
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("main ctrl run game occur error!");
				e.printStackTrace();
			}
		}
	}

	public Ship getShip() {
		return ship;
	}

	public Bee getBee() {
		return (Bee) this.bee;
	}

	public Droper getGoldCoin() {
		return this.honey;
	}

	public void setBee(Bee bee2) {
		this.bee = bee2;
	}

	public Droper getFlower() {
		return flower;
	}

	public List<Droper> getBeeList() {
		return beeList;
	}

	public List<Droper> getHoneyList() {
		return honeyList;
	}

	public List<Droper> getFlowerList() {
		return flowerList;
	}

	public boolean isFlagRun() {
		return flagRun;
	}

	public void setFlagRun(boolean flag) {
		this.flagRun = flag;
	}

	public boolean isFlagStop() {
		return flagStop;
	}

	public void setFlagStop(boolean flagStop) {
		this.flagStop = flagStop;
	}

	public CtrlNotification getCtrNotification() {
		return ctrlNotification;
	}

}
