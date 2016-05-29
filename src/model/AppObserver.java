package model;

import java.util.List;

import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;


public interface AppObserver {
	
	void opAppEnd();
	void opAppStart(List<ItemVO> actList);
	void OnUserLogOut();
	void OnLoginRight(UserVO u);
	void OnLoginFail(UserVO u);
	void OnListAct(List<ItemVO> l);
}
