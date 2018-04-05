package com.almundo.callcenter.service;

import java.util.List;

import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.util.Constants;

public class EmployeeController {
	
	List<Employee> employeeList;
	
	public EmployeeController(List<Employee> employeeList) {
		super();
		this.employeeList = employeeList;
	}



	public Employee getAvailableEmployee(){
		
		boolean found = false;
		
		Employee employee = null;
		
		for(int i=0;i<employeeList.size();i++){
			if(!employeeList.get(i).isBusy() && employeeList.get(i).getPriority() == Constants.PRIORITY_OPERATOR){
				employee = employeeList.get(i);
				found = true;
				break;
			}
		}
		if(!found){
			for(int i=0;i<employeeList.size();i++){
				if(!employeeList.get(i).isBusy() && employeeList.get(i).getPriority() == Constants.PRIORITY_SUPERVISOR){
					employee = employeeList.get(i);
					found = true;
					break;
				}
			}
		}
		
		if(!found){
			for(int i=0;i<employeeList.size();i++){
				if(!employeeList.get(i).isBusy() && employeeList.get(i).getPriority() == Constants.PRIORITY_DIRECTOR){
					employee = employeeList.get(i);
					found = true;
					break;
				}
			}
		}
		return employee;
	}
}
