package com.thiendinh.view;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	static Image background;
	static ImageIcon ii;
	static int w, h;
	private URL url;

	public HomePanel(int w, int h) {
		HomePanel.w = w;
		HomePanel.h = h;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		url = Home.class.getResource("/Images/shooterAdvertise.jpg");
		ii = new ImageIcon(url);
		background = ii.getImage();
		if (background != null) {
			g.drawImage(background, 0, 0, w, h, this);
		}

	}

}
