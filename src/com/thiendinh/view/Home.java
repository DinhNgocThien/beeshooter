package com.thiendinh.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.thiendinh.controller.CtrlStart;
import com.thiendinh.controller.CtrlStartContinue;
import com.thiendinh.controller.CtrlStartNewGame;
import com.thiendinh.model.Ship;
import com.thiendinh.sound.EndlessSound_cdjv;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home {
	int w = 666, h = 460;
	private JFrame frame;
	// ControllerMenu ctrMenu;
	JButton btnContinue, btnPlay, btnHunterShip, btnAngelShip;
	JTextArea tHunter, tAngel;
	public static byte style = 0;
	public static Ship ship;
	private byte type = 1;
	private int level = 1;
	private URL url;
	private ImageIcon icon;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Home();
					EndlessSound_cdjv sound = new EndlessSound_cdjv("src/sound/background.wav");
					sound.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame("Bee Shootting");
		frame.setBounds(100, 100, w, h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setLocation(350, 50);
		frame.setResizable(false);

		JPanel panel = new HomePanel(w, h);
		panel.setBounds(0, 0, w, h);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		// choose ship style 1
		tHunter = new JTextArea("Hunter Ship");
		tHunter.setBounds(30, 355, 100, 17);
		tHunter.setBackground(new Color(99, 75, 64));
		panel.add(tHunter);
		url = Home.class.getResource("/Images/HunterShip.png");
		icon = new ImageIcon(url);
		btnHunterShip = new JButton("Hunter Ship", icon);
		btnHunterShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerforme(e);
				type = 1;
			}
		});
		btnHunterShip.setBounds(30, 280, 100, 100);
		btnHunterShip.setContentAreaFilled(false);
		btnHunterShip.setBorderPainted(false);
		panel.add(btnHunterShip);

		// choose ship style 2
		tAngel = new JTextArea("Angel Ship");
		tAngel.setBackground(Color.PINK);
		tAngel.setBounds(150, 355, 100, 17);
		tAngel.setBackground(new Color(84, 75, 99));
		panel.add(tAngel);
		url = Home.class.getResource("/Images/AngelShip.png");
		icon = new ImageIcon(url);
		btnAngelShip = new JButton("Angel Ship", icon);
		btnAngelShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerforme(e);
				type = 2;
			}
		});
		btnAngelShip.setBounds(150, 280, 100, 100);
		btnAngelShip.setContentAreaFilled(false);
		btnAngelShip.setBorderPainted(false);
		panel.add(btnAngelShip);

		// continue game
		btnContinue = new JButton();
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (style != 0) {
					jButtonActionPerforme(e);
					frame.setVisible(false);
				}
			}
		});
		url = Home.class.getResource("/Images/continue.png");
		icon = new ImageIcon(url);
		btnContinue.setIcon(icon);
		btnContinue.setBounds(345, 330, 100, 65);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setBorderPainted(false);
		panel.add(btnContinue);

		// play game
		btnPlay = new JButton();
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (style != 0) {
					jButtonActionPerforme(e);
					frame.setVisible(false);
				}
			}
		});
		url = Home.class.getResource("/Images/play.png");
		icon = new ImageIcon(url);
		btnPlay.setIcon(icon);
		btnPlay.setBounds(450, 330, 65, 65);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		panel.add(btnPlay);

	}

	public void jButtonActionPerforme(ActionEvent e) {
		if (e.getSource() == btnPlay) {
			CtrlStart ctrl = new CtrlStartNewGame(type, level);
			ctrl.selected();
		}
		if (e.getSource() == btnContinue) {
			CtrlStart ctrl = new CtrlStartContinue(type);
			ctrl.selected();
		}
		if (e.getSource() == btnHunterShip) {
			style = 1;
			tHunter.setBackground(Color.blue);
			tAngel.setBackground(new Color(84, 75, 99));
			System.out.println("hunter");
		}
		if (e.getSource() == btnAngelShip) {
			style = 2;
			tHunter.setBackground(new Color(99, 75, 64));
			tAngel.setBackground(Color.blue);
			System.out.println("angel");
		}
	}
}
