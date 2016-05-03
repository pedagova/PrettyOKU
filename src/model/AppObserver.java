package model;

import dataAccessObjectDesingPattern.Dao;

public interface AppObserver {
	
	void onAppStart();
	void opAppEnd();
	void onUserLogIn();
	void onUserLogOut();
	void onBddUpdate(String comand, Dao act);
	void onBddRequest(String comand, String id);
}
