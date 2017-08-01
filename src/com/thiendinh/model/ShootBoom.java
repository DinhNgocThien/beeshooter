package com.thiendinh.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;

public class ShootBoom extends ShootBehavior {

	@Override
	public void drawShoot(Graphics g, int target) {
		g.setColor(Color.yellow);

		this.y1 = new Random().nextInt(400);
		g.fillOval(this.x1 + 15, y1, 45, 45);
		g.drawLine(0, y1 + 22, 500, y1 + 22);
	}

	@Override
	public void drawShootOnTarget(Graphics g, Image explosion, int i, int j, ImageObserver io) {
		g.drawImage(explosion, i, j, io);
	}

}
