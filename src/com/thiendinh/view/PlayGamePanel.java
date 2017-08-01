package com.thiendinh.view;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.thiendinh.controller.CtrlNotification;
import com.thiendinh.controller.MainCtrlRunGame;
import com.thiendinh.model.Droper;
import com.thiendinh.model.Ship;
import com.thiendinh.model.ShootBehavior;
import com.thiendinh.model.ShootCollision;
import com.thiendinh.sound.OneTimeSound_cdjv;

public class PlayGamePanel extends JPanel {

	private PlayGameView view;
	private MainCtrlRunGame mainCtrlRunGame;
	private Ship ship;
	private Thread th;
	private ImageIcon icon;
	private Image shiper, beer1, beer2, beer3, honeyer, flowerr, explosion, gameOver;
	private byte type;
	private ShootBehavior shootBehavior;
	private ShootCollision shootCollision;
	private List<Droper> beeList, honeyList, flowerList;
	private CtrlNotification ctrlNotification;
	private URL url;
	private boolean adLost = false;

	public PlayGamePanel(PlayGameView view, int level, byte type) {
		this.view = view;
		this.type = type;
		mainCtrlRunGame = new MainCtrlRunGame(view, this, level, type);
		this.ship = mainCtrlRunGame.getShip();
		ctrlNotification = mainCtrlRunGame.getCtrNotification();
		this.beeList = mainCtrlRunGame.getBeeList();
		this.honeyList = mainCtrlRunGame.getHoneyList();
		this.flowerList = mainCtrlRunGame.getFlowerList();

		loadImage();
		th = new Thread(mainCtrlRunGame);
		th.start();
	}

	private void loadImage() {
		url = Home.class.getResource("/Images/flower.jpg");
		icon = new ImageIcon(url);
		flowerr = icon.getImage();

		url = Home.class.getResource("/Images/honey.png");
		icon = new ImageIcon(url);
		honeyer = icon.getImage();

		url = Home.class.getResource("/Images/huntershiper.png");
		icon = new ImageIcon(url);
		shiper = icon.getImage();
		if (type == 2) {
			url = Home.class.getResource("/Images/angelshiper.png");
			icon = new ImageIcon(url);
			shiper = icon.getImage();
		}

		url = Home.class.getResource("/Images/explosion.png");
		icon = new ImageIcon(url);
		explosion = icon.getImage();

		url = Home.class.getResource("/Images/beer1.png");
		icon = new ImageIcon(url);
		beer1 = icon.getImage();
		url = Home.class.getResource("/Images/beer2.png");
		icon = new ImageIcon(url);
		beer2 = icon.getImage();
		url = Home.class.getResource("/Images/beer3.png");
		icon = new ImageIcon(url);
		beer3 = icon.getImage();

		url = Home.class.getResource("/Images/gameOver.jpg");
		icon = new ImageIcon(url);
		gameOver = icon.getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// if lost
		OneTimeSound_cdjv lostsound = new OneTimeSound_cdjv("src/sound/gameover.wav");
		if (adLost) {
			lostsound.start();
			g.drawImage(gameOver, -40, 50, this);
			adLostPane();
			adLost(false);
		}

		// draw image of list flower
		for (int i = 0; i < flowerList.size(); i++) {
			g.drawImage(flowerr, flowerList.get(i).getX(), flowerList.get(i).getY(), this);
		}

		// draw image of list honey
		for (int i = 0; i < honeyList.size(); i++) {
			g.drawImage(honeyer, honeyList.get(i).getX(), honeyList.get(i).getY(), this);
		}

		// if shoot draw here
		shootBehavior = ship.getEventController().getShootBehavior();
		OneTimeSound_cdjv shotSound = new OneTimeSound_cdjv("src/sound/shot.wav");
		OneTimeSound_cdjv explosionSound = new OneTimeSound_cdjv("src/sound/explosion.wav");
		if ((shootBehavior != null) && shootBehavior.isShooting()) {
			shootCollision = new ShootCollision(shootBehavior, ship, type, beeList);
			int index = shootCollision.isCollision();
			shotSound.start();
			if (shootCollision.isCollision() != -1) {
				explosionSound.start();
				ctrlNotification.increaseScore();
				shootBehavior.drawShoot(g, beeList.get(index).getY() + 40);
				shootBehavior.drawShootOnTarget(g, explosion, beeList.get(index).getX() - 30,
						beeList.get(index).getY() - 30, this);
				shootCollision.shootCollisionOccur(shootCollision.isCollision());
			} else {
				shootBehavior.drawShoot(g, -50);
			}
		}

		// draw ship
		g.drawImage(shiper, ship.getX(), ship.getY(), this);

		// draw image of list bee with multi type
		for (int i = 0; i < beeList.size(); i++) {
			switch ((i % 3)) {
			case 1:
				g.drawImage(beer2, beeList.get(i).getX(), beeList.get(i).getY(), this);
				break;
			case 2:
				g.drawImage(beer3, beeList.get(i).getX(), beeList.get(i).getY(), this);
				break;
			default:
				g.drawImage(beer1, beeList.get(i).getX(), beeList.get(i).getY(), this);
				break;
			}
		}

	}

	public Thread getThread() {
		return th;
	}

	public void setThread(MainCtrlRunGame ctrlRunGame) {
		mainCtrlRunGame = ctrlRunGame;
	}

	public Ship getShip() {
		return ship;
	}

	public MainCtrlRunGame getMainCtrlRunGame() {
		return mainCtrlRunGame;
	}

	public byte getType() {
		return type;
	}

	public PlayGameView getView() {
		return view;
	}

	public void adLost(boolean l) {
		adLost = l;
	}

	private void adLostPane() {
		JPanel endpane = new LostPanel(view, this, type, ctrlNotification.getLevel());
		this.add(endpane);
	}

}
