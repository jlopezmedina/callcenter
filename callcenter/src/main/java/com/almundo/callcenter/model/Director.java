package com.almundo.callcenter.model;

public class Director implements Employee {

	public final Integer priority = 3;
	public final String type = "Director";
	public boolean busy;
	
	public Director(boolean busy) {
		super();
		this.busy = busy;
	}
	
	public void answerCall() {
		// TODO Auto-generated method stub

	}
	
	public String getType() {
		return this.type;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

}
