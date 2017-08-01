package com.thiendinh.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.thiendinh.controller.CtrlStartNewGame;

public class NextPanel extends JPanel {
	JLabel label;
	Button btn;

	public NextPanel(PlayGamePanel parent, byte type, int level) {
		setBounds(150, 150, 200, 75);
		setBackground(Color.yellow);
		setLayout(null);

		label = new JLabel("You win!");
		label.setBounds(50, 5, 130, 23);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		add(label);

		btn = new Button("More challenge");
		btn.setBounds(30, 45, 130, 23);
		add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.getView().getFrame().setVisible(false);
				CtrlStartNewGame ctrl = new CtrlStartNewGame(type, level);
				ctrl.selected();
			}
		});
	}

}
