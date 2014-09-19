package main.client;

import com.gwtent.reflection.client.Reflectable;

import processing.eventjs.JsMouseEvent;
import remixlab.bias.core.Agent;
import remixlab.bias.core.InputHandler;
import remixlab.bias.event.DOF2Event;

@Reflectable
public class SimpleMouseAgent extends Agent {
	  DOF2Event event;

	  public SimpleMouseAgent(InputHandler scn, String n) {
	    super(scn, n);
	  }

	  public void mouseEvent(JsMouseEvent e) {
	    event = new DOF2Event(e.getX(), e.getY());
	    if ( e.getAction() == JsMouseEvent.MOVE )
	      updateTrackedGrabber(event);
	    if ( e.getAction() == JsMouseEvent.DRAG )
	      handle(event);
	  }
	}
