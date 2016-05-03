package controller;

import dataAccessObjectDesingPattern.UsserDao;

public class Controler {
	private class User extends UsserDao{
		public String id, pass; 
		@Override
		public void update(){
			
		}
	};
	private User user = new User();
	
	void changePass(){
		
	}
	
	public String getPass(){
		return user.pass;	
	}
	
}
