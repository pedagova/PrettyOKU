package model;

import dataAccessObjectDesingPattern.UserVO;


public interface AppObserver {
	
	void onAppStart();
	void opAppEnd();
	void onUserLogIn();
	void onUserLogOut();
	void OnUserBaseUpdate(UserVO user);
	void OnLoginRight();
	void OnLoginFail();
}
