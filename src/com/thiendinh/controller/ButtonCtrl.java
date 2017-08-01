package com.thiendinh.controller;

import java.awt.event.ActionEvent;

import com.thiendinh.view.PlayGameView;

public class ButtonCtrl {

	public ButtonCtrl() {
	}
	
	public void buttonSelected(PlayGameView view, ActionEvent e) {
		if(e.getSource()==view.getBtnPause()){
			view.getPlayGamePanel().getMainCtrlRunGame().getShip().setFlagPause(true);
			view.setEnabledBtnPause(false);
			view.setEnabledBtnPlay(true);
		}
		if(e.getSource()==view.getBtnPlay()){
			view.getPlayGamePanel().getMainCtrlRunGame().getShip().setFlagPause(false);
			view.setEnabledBtnPause(true);
			view.setEnabledBtnPlay(false);
		}
	}

}
