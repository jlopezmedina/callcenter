package com.almundo.callcenter.model;

public class Operator implements Employee {

	public final Integer priority = 1;
	public final String type = "Operator";
	public boolean busy;
	
	public Operator(boolean busy) {
		super();
		this.busy = busy;
	}

	public void answerCall() {

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
