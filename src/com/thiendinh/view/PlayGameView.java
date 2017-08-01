package com.thiendinh.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.thiendinh.controller.ButtonCtrl;
import com.thiendinh.model.Ship;

public class PlayGameView implements ActionListener, KeyListener {

	private JFrame frame;
	private static Ship ship;
	private JButton btnPause, btnPlay;
	private PlayGamePanel playGamePanel;
	private JPanel panel, scorePanel;
	private final byte LEFT = 1, RIGHT = 2;
	private JLabel usingShip;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private int w = 666, h = 460;
	private byte type;
	private int level;
	private ButtonCtrl buttonCtrl;
	private URL url;

	public PlayGameView(byte type, int level) {
		this.type = type;
		this.level = level;
		buttonCtrl = new ButtonCtrl();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Bee Shootting");
		frame.setBounds(100, 100, w, h + 23);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setLocation(350, 50);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.setResizable(false);

		panel = new JPanel();
		panel.setBackground(new Color(99, 52, 32));
		panel.setBounds(0, 0, w, h);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		// Create the menu bar.
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		//
		// Build the first menu.
		menu = new JMenu("Game");
		menuBar.add(menu);
		//
		// a group of JMenuItems
		menuItem = new JMenuItem("New Game", KeyEvent.VK_N);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				newGame();
			}
		});
		menu.add(menuItem);
		//
		menuItem = new JMenuItem("Exit", KeyEvent.VK_E);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		menu.add(menuItem);

		if (type == 1) {
			playGamePanel = new PlayGamePanel(this, level, (byte) 1);
		} else
			playGamePanel = new PlayGamePanel(this, level, (byte) 2);

		playGamePanel.setBackground(Color.BLACK);
		playGamePanel.setBounds(0, 0, 500, h);
		playGamePanel.setLayout(null);
		panel.add(playGamePanel);

		usingShip = new JLabel("");
		url = Home.class.getResource("/Images/HunterShip.png");
		usingShip.setIcon(new ImageIcon(url));

		if (type == 2) {
			url = Home.class.getResource("/Images/AngelShip.png");
			usingShip.setIcon(new ImageIcon(url));
		}
		usingShip.setBounds(510, 25, 150, 123);
		panel.add(usingShip);

		scorePanel = new ScorePanel(this, level);
		panel.add(scorePanel);
		ship = playGamePanel.getShip();
		ship.addObserver((Observer) scorePanel);

		btnPause = new JButton("Pause");
		btnPause.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnPause.setBackground(Color.orange);
		btnPause.setBounds(540, 370, 100, 23);
		btnPause.addActionListener(this);
		panel.add(btnPause);

		btnPlay = new JButton("Play");
		btnPlay.setBounds(540, 405, 100, 23);
		btnPlay.setBackground(Color.CYAN);
		btnPlay.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnPlay.setEnabled(false);
		btnPlay.addActionListener(this);
		panel.add(btnPlay);

	}
	
	private void newGame() {
		new Home();
		this.getPlayGamePanel().getMainCtrlRunGame().setFlagRun(false);
		this.getFrame().setVisible(false);
	}

	public PlayGamePanel getPlayGamePanel() {
		return playGamePanel;
	}

	public JButton getBtnPause() {
		return btnPause;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.shooting(false);
			ship.moving(LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.shooting(false);
			ship.moving(RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			playGamePanel.getShip().shooting(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			playGamePanel.getShip().shooting(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		buttonCtrl.buttonSelected(this, a);
	}

	public Component getFrame() {
		return this.frame;
	}

	public byte getType() {
		return type;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void setEnabledBtnPause(boolean b) {
		this.btnPause.setEnabled(b);
	}

	public void setEnabledBtnPlay(boolean b) {
		this.btnPlay.setEnabled(b);
	}

}
