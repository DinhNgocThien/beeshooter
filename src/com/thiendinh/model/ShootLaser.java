package com.thiendinh.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class ShootLaser extends ShootBehavior {

	@Override
	public void drawShoot(Graphics g, int target) {
		g.setColor(Color.red);
		g.drawLine(x1 + 37, y1, x2 + 37, target);
	}

	@Override
	public void drawShootOnTarget(Graphics g, Image explosion, int i, int j, ImageObserver io) {
		g.drawImage(explosion, i, j, io);
	}

}
