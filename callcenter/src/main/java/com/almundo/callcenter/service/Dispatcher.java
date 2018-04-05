package com.almundo.callcenter.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.CallingUser;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.util.Constants;

public class Dispatcher {
	
	private ExecutorService executor;
	private EmployeeController employeeController;
	private Logger logger = LogManager.getLogger("Dispatcher");
	
	/**
	 * Se crean las llamadas para los empleados disponibles
	 * Si no hay empleados disponibles para atender al cliente
	 * La llamada se encola para ser atendida luego.
	 */
	public void dispatchCall(CallCenterController callCenterController, CallingUser callingUser, CallingUserController callingUserController){
		
		employeeController = new EmployeeController(callCenterController.getEmployeeList());
		
		executor = Executors.newFixedThreadPool(Constants.MAX_CALL);
		Employee availableEmployee = employeeController.getAvailableEmployee();
		
		if(availableEmployee != null){
			
			Runnable call = new Call(availableEmployee, callingUser);
			executor.execute(call);
		}else{
			logger.info("No employee available to the client: " + callingUser.getName());
			callingUserController.addCallingUserList(callingUser);
		}
	}
	
	public void endDispatchCall(CallCenterController callCenterController) throws InterruptedException{
		executor.shutdown();
		executor.awaitTermination(11, TimeUnit.SECONDS);

	}
}
