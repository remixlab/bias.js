/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package main.simplecallback;

import processing.core.PApplet;
import processing.eventjs.JsEventHandler;
import remixlab.bias.core.InputHandler;


// TODO: Auto-generated Javadoc
/**
 * The Class ActionDrivenCallback.
 */
public class SimpleCallback {
	
	
	/** The p. */
	private PApplet p;
    
    /** The w. */
    int w = 600;
    
    /** The h. */
    int h = 600;
    
    /** The agent. */
    MouseAgent agent;
    
    InputHandler inputHandler;
    Ellipse [] ellipses;
    
    
    /**
     * Instantiates a new action driven callback.
     */
    public SimpleCallback(){}
    
    /**
     * Instantiates a new action driven callback.
     *
     * @param p the p
     */
    public SimpleCallback(PApplet p){
    	this.p = p;
    	this.p.setJsEventHandler(new JsEventHandler());
    }
    
    /**
     * Setup.
     */
    public void setup() {
            p.size(w, h);
            inputHandler = new InputHandler();
            ellipses = new Ellipse[50];
            agent = new MouseAgent(inputHandler, "my_mouse");
            p.addMouseAgent ("mouseEvent", agent);            
            
            for (int i = 0; i < ellipses.length; i++)
              ellipses[i] = new Ellipse(agent,p);
    }

    /**
     * Draw.
     */
    public void draw() {
    	  p.background(255);
    	  for (int i = 0; i < ellipses.length; i++) {
    	    if ( ellipses[i].grabsInput(agent) )
    	      ellipses[i].draw(p.color(255, 0, 0));
    	    else
    	      ellipses[i].draw();
    	  }
    	  inputHandler.handle();
    }
   

	
}
