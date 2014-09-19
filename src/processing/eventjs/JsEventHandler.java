package processing.eventjs;

import com.google.gwt.core.client.JavaScriptObject;

import processing.core.IJsEventHandler;

public class JsEventHandler implements  IJsEventHandler{
	
	
		
	
		public JsEventHandler ()
		{
			init();
			
		}
		
		public native void init() /*-{
			
	
			$wnd.isMousePressed = false;

			$doc.body.onmousedown = function() { 
			    $wnd.isMousePressed = true;

			}
			$doc.body.onmouseup = function() {
			    $wnd.isMousePressed = false;

			}
	    	
	  	}-*/;	
		
		
		public native  Boolean isMousePressed() /*-{
				

				if (typeof $wnd.isMousePressed  != 'undefined')				
	    			return $wnd.isMousePressed ;
	    		else
	    			return false;
	    	
	    	
	  	}-*/;	

		

		@Override
		public native void addMouseAgent(JavaScriptObject canvas, Object agent, String methodName)/*-{
		
		
		var eventHandler = function(event) {
						
			var type = event.type;
			
			

		
			var isMousePressed  =  false;
			
				if (typeof $wnd.isMousePressed  != 'undefined')				
	    			isMousePressed = $wnd.isMousePressed ;			
			
		
			

	
			// new JsMouseEvent with the native event
			var JsMouseEvent = 
			@processing.eventjs.JsMouseEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Z)
			(event,canvas, isMousePressed);			
			
			
			//pass to the agent the JsMouseEvent to run
		//	@processing.eventjs.Reflect::ExecuteEvent(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;) 
			//(agent,methodName, JsMouseEvent);
			@processing.eventjs.Reflect::ExecuteEvent(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)
			(agent,methodName, JsMouseEvent);
		//	console.log(methodName);
	
																    
		}
		
		
		//listeners
		canvas.addEventListener('mousemove',eventHandler,false);		
		canvas.addEventListener('click',eventHandler,false);	
		canvas.addEventListener('ondblclick',eventHandler,false);				
		canvas.addEventListener('mousedown',eventHandler,false);				
		canvas.addEventListener('mouseup',eventHandler,false);				
		canvas.addEventListener('mouseout',eventHandler,false);	
		canvas.addEventListener('mouseover',eventHandler,false);	
		// IE9, Chrome, Safari, Opera
		canvas.addEventListener("mousewheel", eventHandler, false);
		// Firefox
		canvas.addEventListener("DOMMouseScroll", eventHandler, false);		
		
	
	}-*/;

		@Override
		public native void addKeyAgent(JavaScriptObject canvas, Object agent, String methodName)/*-{
		
		
		
		var eventHandler = function(event) {
					
			var type = event.type;
			
			// new JsMouseEvent with the native event
			var JsKeyEvent = 
			@processing.eventjs.JsKeyEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)
			(event,canvas);	
			
			
			@processing.eventjs.Reflect::ExecuteEvent(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)
			(agent,methodName, JsKeyEvent);
		
		
		}
		
		//listeners
		canvas.addEventListener('keydown',eventHandler,false);		
		canvas.addEventListener('keyup',eventHandler,false);	
	
	}-*/;




}
