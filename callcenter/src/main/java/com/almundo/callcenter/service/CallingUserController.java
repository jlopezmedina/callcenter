package com.almundo.callcenter.service;

import java.util.List;

import com.almundo.callcenter.model.CallingUser;

public class CallingUserController {

	List<CallingUser> callingUserList;

	public CallingUserController(List<CallingUser> callingUserList) {
		super();
		this.callingUserList = callingUserList;
	}

	public List<CallingUser> getCallingUserList() {
		return callingUserList;
	}

	public void addCallingUserList(CallingUser callingUser) {
		this.callingUserList.add(callingUser);
	}
	
	public void deleteCallingUserList(int position) {
		this.callingUserList.remove(position);
	}
	
	public CallingUser getCallingUser() {
		CallingUser callingUser = null;
		
		if(!this.callingUserList.isEmpty()){
			callingUser = this.callingUserList.get(0);
		}
	return callingUser;
	}
}
