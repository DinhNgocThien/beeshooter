package com.thiendinh.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.thiendinh.model.Ship;

public class ScorePanel extends JPanel implements Observer {

	private JLabel label, lRetrieve, lHoney, lScore, lLevel;
	private int score, honey, retrieve, level;
	private Ship ship;

	@Override
	public void update(Observable obs, Object arg1) {
		if (obs instanceof Ship) {
			ship = (Ship) obs;
			this.retrieve = ship.getRetrieve();
			this.honey = ship.getHoney();
			this.score = ship.getScore();
			this.level = ship.getLevel();
			reset();
		}

	}

	public ScorePanel(PlayGameView view, int level0) {
		this.level=level0;
		this.ship = view.getPlayGamePanel().getShip();
		setBounds(510, 160, 150, 200);
		setBackground(new Color(99, 52, 65));
		setLayout(null);

		label = new JLabel("Level");
		label.setBounds(30, 10, 75, 23);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(label);

		lLevel = new JLabel(this.level + "");
		lLevel.setBounds(100, 10, 50, 23);
		lLevel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(lLevel);

		label = new JLabel("Retrieve");
		label.setBounds(30, 35, 130, 23);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(label);

		lRetrieve = new JLabel(this.retrieve + "");
		lRetrieve.setBounds(40, 60, 100, 23);
		lRetrieve.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(lRetrieve);

		label = new JLabel("Honey");
		label.setBounds(30, 85, 130, 23);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(label);

		lHoney = new JLabel(this.honey + "");
		lHoney.setBounds(40, 110, 100, 23);
		lHoney.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(lHoney);

		label = new JLabel("Score");
		label.setBounds(30, 135, 130, 23);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(label);

		lScore = new JLabel(this.score + "");
		lScore.setBounds(40, 160, 100, 23);
		lScore.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		add(lScore);
	}

	public void reset() {
		lRetrieve.setText(this.retrieve + "");
		lHoney.setText(this.honey + "");
		lScore.setText(this.score + "");
		lLevel.setText(this.level + "");
	}

}
