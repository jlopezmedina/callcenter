package com.almundo.callcenter.model;

import java.time.LocalDateTime;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.almundo.callcenter.util.Constants;

public class Call implements Runnable{
	
	private Logger logger = LogManager.getLogger("Call");
	private Employee employee;
	private CallingUser callingUser;
	
	public Call(Employee employee, CallingUser callingUser) {
		super();
		this.employee = employee;
		this.callingUser = callingUser;
	}
	/**
	 * Se crean los hilos necesarios para atender a los Clientes, cada vez que un Empleado
	 * Atiende a un Cliente, se marca como ocupado hasta que termina la llamada. 
	 */
	public void run() {

		Random random = new Random(System.currentTimeMillis());
		int callTime = (random.nextInt(Constants.MAX_CALL_DURATION - Constants.MIN_CALL_DURATION) + Constants.MIN_CALL_DURATION ) * 1000;
		
		try {
			logger.info("Start Calling " + this.employee.getType() + " at: " + LocalDateTime.now() + " With Customer: " + callingUser.getName());
			this.employee.setBusy(true);
			
			Thread.sleep(callTime);
			
			this.employee.setBusy(false);
			logger.info("End Calling " + this.employee.getType() + " at: " + LocalDateTime.now() + " > Total: " + callTime/1000 + " Seconds" + " With Customer: " + callingUser.getName());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public CallingUser getCallingUser() {
		return callingUser;
	}

	public void setCallingUser(CallingUser callingUser) {
		this.callingUser = callingUser;
	}

}
