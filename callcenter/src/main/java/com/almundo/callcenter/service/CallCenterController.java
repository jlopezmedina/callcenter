package com.almundo.callcenter.service;

import java.util.ArrayList;
import java.util.List;

import com.almundo.callcenter.model.Director;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.Operator;
import com.almundo.callcenter.model.Supervisor;

public class CallCenterController {

	private List<Employee> employeeList;
	
	Integer amount = 10;
	
	public CallCenterController(Integer amount) {
		super();
		if(amount == 10){
			this.employeeList = getCallCenter10Employees();
		}else{
			this.employeeList = getCallCenter4Employees();
		}
	}


	private List<Employee> getCallCenter10Employees(){
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Employee e1 = new Operator(false);
		employeeList.add(e1);
		Employee e2 = new Supervisor(false);
		employeeList.add(e2);
		Employee e3 = new Operator(false);
		employeeList.add(e3);
		Employee e4 = new Director(false);
		employeeList.add(e4);
		Employee e5 = new Director(false);
		employeeList.add(e5);
		Employee e6 = new Operator(false);
		employeeList.add(e6);
		Employee e7 = new Supervisor(false);
		employeeList.add(e7);
		Employee e8 = new Director(false);
		employeeList.add(e8);
		Employee e9 = new Supervisor(false);
		employeeList.add(e9);
		
		return employeeList;
	}
	
	private List<Employee> getCallCenter4Employees(){
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Employee e1 = new Operator(false);
		employeeList.add(e1);
		Employee e2 = new Supervisor(false);
		employeeList.add(e2);
		Employee e3 = new Operator(false);
		employeeList.add(e3);
		Employee e4 = new Director(false);
		employeeList.add(e4);
		
		return employeeList;
	}


	public List<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
