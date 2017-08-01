package com.thiendinh.controller;

import com.thiendinh.model.Ship;

public class CtrlStop {
	Ship ship;

	public CtrlStop(Ship ship){
		this.ship=ship;
	}
	
	public void setPause(){
		ship.setFlagPause(true);
	}
	public void setPlay(){
		ship.setFlagPause(false);
	}
	public void setDead(){
		ship.setFlagDead(true);
	}
}
