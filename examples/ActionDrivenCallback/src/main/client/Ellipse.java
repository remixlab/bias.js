package main.client;

import processing.core.*;
import remixlab.bias.core.*;
import remixlab.bias.event.*;

public class Ellipse extends GrabberObject {
	
	
    /** The w. */
    int w = 600;
    
    /** The h. */
    int h = 600;
	
	/** The p. */
	private PApplet p;	
	
	  public float radiusX, radiusY;
	  public PVector center;
	  public int colour;
	  public int contourColour;
	  public int sWeight;
	  
	  
	  public Ellipse(Agent agent, PApplet p) {
		    this.p = p;
		    agent.addInPool(this);
		    setColor();
		    setPosition();
		    sWeight = 4;
		    contourColour = p.color(0, 0, 0);
		  }

//	  public Ellipse(Agent agent) {
//	    agent.addInPool(this);
//	    setColor();
//	    setPosition();
//	    sWeight = 4;
//	    contourColour = p.color(0, 0, 0);
//	  }

	  public Ellipse(Agent agent, PVector c, float r) {
	    agent.addInPool(this);
	    radiusX = r;
	    radiusY = r;
	    center = c;    
	    setColor();
	    sWeight = 4;
	  }

	  public void setColor() {
	    setColor(p.color(p.random(0, 255), p.random(0, 255), (int) p.random(0, 255), p.random(100, 200)));
	  }

	  public void setColor(int myC) {
	    colour = myC;
	  }

	  public void setPosition(float x, float y) {
	    setPositionAndRadii(new PVector(x, y), radiusX, radiusY);
	  }

	  public void setPositionAndRadii(PVector p, float rx, float ry) {
	    center = p;
	    radiusX = rx;
	    radiusY = ry;
	  }

	  public void setPosition() {
	    float maxRadius = 50;
	    float low = maxRadius;
	    float highX = w - maxRadius;
	    float highY = h - maxRadius;
	    float r = p.random(20, maxRadius);
	    setPositionAndRadii(new PVector(p.random(low, highX), p.random(low, highY)), r, r);
	  }

	  public void draw() {
	    draw(colour);
	  }

	  public void draw(int c) {
		  p.pushStyle();
		  p.stroke(contourColour);
		  p.strokeWeight(sWeight);
		  p.fill(c);
		  p.ellipse(center.x, center.y, 2*radiusX, 2*radiusY);
		  p.popStyle();
	  }

	  @Override
	  public boolean checkIfGrabsInput(BogusEvent event) {
	    if (event instanceof DOF2Event) {
	      float x = ((DOF2Event)event).x();
	      float y = ((DOF2Event)event).y();
	      return(PApplet.pow((x - center.x), 2)/PApplet.pow(radiusX, 2) + PApplet.pow((y - center.y), 2)/PApplet.pow(radiusY, 2) <= 1);
	    }      
	    return false;
	  }

	  @Override
	  public void performInteraction(BogusEvent event) {
		  
		    setColor();
		    setPosition();
		  
		  /*
	    if (((BogusEvent)event).action() != null) {
	      switch ((GlobalAction) ((BogusEvent)event).action().referenceAction()) {
	        case CHANGE_COLOR:
	        contourColour = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255));
	        break;
	      case CHANGE_STROKE_WEIGHT:
	        if (event.isShiftDown()) {          
	          if (sWeight > 1)
	            sWeight--;
	        }
	        else      
	          sWeight++;    
	        break;
	      case CHANGE_POSITION:
	        setPosition( ((DOF2Event)event).x(), ((DOF2Event)event).y() );
	        break;
	        case CHANGE_SHAPE:
	        radiusX += ((DOF2Event)event).dx();
	        radiusY += ((DOF2Event)event).dy();
	        break;
	      }
	    }*/
	  }
	}
