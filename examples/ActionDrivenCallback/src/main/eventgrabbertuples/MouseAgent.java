/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package main.eventgrabbertuples;

import com.gwtent.reflection.client.Reflectable;

import processing.core.PApplet;
import processing.eventjs.JsMouseEvent;
import remixlab.bias.agent.*;
import remixlab.bias.agent.profile.*;
import remixlab.bias.core.EventGrabberTuple;
import remixlab.bias.core.Grabber;
import remixlab.bias.core.InputHandler;
import remixlab.bias.event.*;



// TODO: Auto-generated Javadoc
/**
 * The Class MouseAgent.
 */
@Reflectable
public class MouseAgent extends ActionMotionAgent<MotionProfile<MotionAction>, ClickProfile<ClickAction>> {
	  DOF2Event event, prevEvent;
	  
      Grabber[] ellipses = null;
	  public MouseAgent(InputHandler scn, String n, Grabber[] ellipses) {
	    super(new MotionProfile<MotionAction>(), 
	          new ClickProfile<ClickAction>(), scn, n);
	    
	    this.ellipses = ellipses;
	    //default bindings
	    clickProfile().setBinding(PApplet.LEFT, 1, ClickAction.CHANGE_COLOR);
	    clickProfile().setBinding(DOF2Event.META, PApplet.RIGHT, 1, ClickAction.CHANGE_STROKE_WEIGHT);
	    clickProfile().setBinding((DOF2Event.META | DOF2Event.SHIFT), PApplet.RIGHT, 1, ClickAction.CHANGE_STROKE_WEIGHT);
	    profile().setBinding(PApplet.LEFT, MotionAction.CHANGE_POSITION);
	    profile().setBinding(DOF2Event.SHIFT, PApplet.LEFT, MotionAction.CHANGE_SHAPE);
	    profile().setBinding(DOF2Event.META, PApplet.RIGHT, MotionAction.CHANGE_SHAPE);
	  }
	  
	  
	  
	  public void mouseEvent(JsMouseEvent e) {      
		    if ( e.getAction() == JsMouseEvent.MOVE ) {
		      event = new DOF2Event(prevEvent, e.getX(), e.getY(), e.getModifiers(), e.getButton());
		      updateTrackedGrabber(event);
		      prevEvent = event.get();
		    }
		    if ( e.getAction() == JsMouseEvent.DRAG ) {
		      event = new DOF2Event(prevEvent, e.getX(), e.getY(), e.getModifiers(), e.getButton());

			if(event.isControlDown())
		        inputHandler().enqueueEventTuple(new EventGrabberTuple(event, MotionAction.CHANGE_POSITION, ellipses[20]));
		      else
		        handle(event);
		      prevEvent = event.get();
		    }
		    if ( e.getAction() == JsMouseEvent.CLICK ) {
		      handle(new ClickEvent(e.getX(), e.getY(), e.getModifiers(), e.getButton(), e.getCount()));
		    }
		  }
	}
