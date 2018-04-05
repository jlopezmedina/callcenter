package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.almundo.callcenter.model.CallingUser;
import com.almundo.callcenter.service.CallCenterController;
import com.almundo.callcenter.service.CallingUserController;
import com.almundo.callcenter.service.Dispatcher;

public class CallCenter 
{
    public static void main( String[] args )
    {
    	CallCenter callCenter = new CallCenter();
    	Dispatcher dispatcher = new Dispatcher();   
    	CallCenterController callCenterController = new CallCenterController(10);
    	CallingUserController callingUserController = null;
    	
    	try {
    		
    		callingUserController = new CallingUserController(callCenter.getCallingUser());
    		
    		while(!callingUserController.getCallingUserList().isEmpty()){
	    		
    			if(callingUserController.getCallingUserList().get(0) != null){
		    		dispatcher.dispatchCall(callCenterController, callingUserController.getCallingUserList().get(0), callingUserController);
		    		callingUserController.deleteCallingUserList(0);
		    		
					TimeUnit.SECONDS.sleep(1);
	    		}
    			
    		}
    		
    		dispatcher.endDispatchCall(callCenterController);
    		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public List<CallingUser> getCallingUser(){
    	List<CallingUser> callingUserList = new ArrayList<>();
    	
    	CallingUser c1 = new CallingUser("Joseph");
    	callingUserList.add(c1);
    	CallingUser c2 = new CallingUser("Arturo");
    	callingUserList.add(c2);
    	CallingUser c3 = new CallingUser("Lisseth");
    	callingUserList.add(c3);
    	CallingUser c4 = new CallingUser("Oscar");
    	callingUserList.add(c4);
    	CallingUser c5 = new CallingUser("Wilson");
    	callingUserList.add(c5);
    	CallingUser c6 = new CallingUser("Andrea");
    	callingUserList.add(c6);
    	
    	return callingUserList;
    }
}
