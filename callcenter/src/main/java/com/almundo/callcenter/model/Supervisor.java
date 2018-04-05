package com.almundo.callcenter.model;

public class Supervisor implements Employee {
	
	public final Integer priority = 2;
	public final String type = "Supervisor";
	public boolean busy;
	
	public Supervisor(boolean busy) {
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
