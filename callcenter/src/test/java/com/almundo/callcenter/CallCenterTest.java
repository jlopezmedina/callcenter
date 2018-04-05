package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.almundo.callcenter.model.CallingUser;
import com.almundo.callcenter.service.CallCenterController;
import com.almundo.callcenter.service.CallingUserController;
import com.almundo.callcenter.service.Dispatcher;

/**
 * Unit test for simple App.
 */
public class CallCenterTest{
	
	
	private CallCenterController callCenterController;
	private Dispatcher dispatcher;
	private CallingUserController callingUserController = null;
       
    @Before
	public void setUp() throws Exception {
    	
    	dispatcher = new Dispatcher();
    	callingUserController = new CallingUserController(this.getCallingUser());
		callingUserController.deleteCallingUserList(0);
    }
    
   /**
    * En esta prueba se valida:
    * 1 - Que pasa con una llamada cuando entran mas de 10 llamadas concurrentes
    * 
    * @throws InterruptedException
    */
    @Test
    public void testCallCenter10Customers() throws InterruptedException
    {
    	callCenterController = new CallCenterController(4);
    	
    	while(!callingUserController.getCallingUserList().isEmpty()){
    		
			if(callingUserController.getCallingUserList().get(0) != null){
	    		dispatcher.dispatchCall(callCenterController, callingUserController.getCallingUserList().get(0), callingUserController);
	    		callingUserController.deleteCallingUserList(0);
	    		
				TimeUnit.SECONDS.sleep(1);
    		}
			
		}
    	
    	dispatcher.endDispatchCall(callCenterController);
    }
    
    /**
     * En esta prueba se valida:
     * 1 - Que sucede cuando no hay un empleado libre
     * 2 - Que pasa con una llamada cuando entran mas de 10 llamadas concurrentes
     * 
     * @throws InterruptedException
     */
     @Test
     public void testCallCenter4Customers() throws InterruptedException
     {
     	callCenterController = new CallCenterController(4);
     	
     	while(!callingUserController.getCallingUserList().isEmpty()){
     		
 			if(callingUserController.getCallingUserList().get(0) != null){
 	    		dispatcher.dispatchCall(callCenterController, callingUserController.getCallingUserList().get(0), callingUserController);
 	    		callingUserController.deleteCallingUserList(0);
 	    		
 				TimeUnit.SECONDS.sleep(1);
     		}
 			
 		}
     	
     	dispatcher.endDispatchCall(callCenterController);
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
    	CallingUser c7 = new CallingUser("Camila");
    	callingUserList.add(c7);
    	CallingUser c8 = new CallingUser("Alex");
    	callingUserList.add(c8);
    	CallingUser c9 = new CallingUser("Fabian");
    	callingUserList.add(c9);
    	CallingUser c10 = new CallingUser("Victor");
    	callingUserList.add(c10);
    	
    	return callingUserList;
    }
}
