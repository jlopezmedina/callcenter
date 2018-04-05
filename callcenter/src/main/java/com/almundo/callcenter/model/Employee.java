package com.almundo.callcenter.model;

public interface Employee {

	public void answerCall();
		
	public String getType();
	
	public Integer getPriority();
	
	public boolean isBusy();
	
	public void setBusy(boolean busy);
}
