package processing.eventjs;


import remixlab.bias.core.BogusEvent;

import com.google.gwt.core.client.JavaScriptObject;

public class JsKeyEvent extends JsEvent {

	
	  static public final int PRESS = 1;
	  static public final int RELEASE = 2;
	  static public final int TYPE = 3;

	  char key;
	  int keyCode;

	  
	  public JsKeyEvent(JavaScriptObject event, JavaScriptObject canvas) {
		  
		  
			super(event);
			this.canvas = canvas;
			processAction();
			setNewModifiers();
		}
		
		
		public native char getKey() /*-{
		
			var event = this.@processing.eventjs.JsEvent::getJsEvent();
			
			  if (event.which == null) {
			    return String.fromCharCode(event.keyCode) // IE
			  } else if (event.which!=0 && event.charCode!=0) {
			    return String.fromCharCode(event.which)   // the rest
			  } else {
			    return null // special key
			  }
			


		}-*/;
		
		

		
		
		public native int getCharCode() /*-{
			
			var event = this.@processing.eventjs.JsEvent::getJsEvent();
			return event.charCode;

		}-*/;
		

		public native int getKeyCode() /*-{
		
			var event = this.@processing.eventjs.JsEvent::getJsEvent();
		
			  if (event.which == null) {
			    return event.keyCode // IE
			  } else if (event.which!=0 && event.charCode!=0) {
			    return event.which   // the rest
			  } else {
			    return -1 // special key
			  }

			
		
		}-*/;		
		

		@Override
		public JsKeyEvent get() {
			// TODO Auto-generated method stub
			 return new JsKeyEvent(this.event, this.canvas);
		}


		@Override
		protected void processAction() {
			// TODO Auto-generated method stub
			
		    if(getType().equals("keydown"))
		    	 setAction( JsKeyEvent.TYPE);				
//		    if(getType().equals("keydown"))
//		    	 setAction( JsKeyEvent.PRESS);	    
		    if(getType().equals("keyup"))
		    	 setAction( JsKeyEvent.RELEASE);		    
			
		}
		
	 	private void setNewModifiers() {


			 if(this.isShiftDown())		 
				 modifiers ^= BogusEvent.SHIFT ;		 
			 if(this.isControlDown())		 
				 modifiers ^= BogusEvent.CTRL ;		 		 
			 if(this.isAltDown())		 
				 modifiers ^= BogusEvent.ALT ;
			 if(this.isMetaDown())		 
				 modifiers ^= BogusEvent.META ;
			 

	       }
	  
	
	
}
