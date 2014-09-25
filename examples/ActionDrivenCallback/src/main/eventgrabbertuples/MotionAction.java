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


import remixlab.bias.core.Action;



// TODO: Auto-generated Javadoc
/**
 * The Enum MotionAction.
 */
public enum MotionAction implements Action<GlobalAction> {
	  CHANGE_POSITION(GlobalAction.CHANGE_POSITION), 
	  CHANGE_SHAPE(GlobalAction.CHANGE_SHAPE);

	  @Override
	  public GlobalAction referenceAction() {
	    return act;
	  }

	  @Override
	  public String description() {
	    return "A simple motion action";
	  }

	  @Override
	  public int dofs() {
	    return 2;
	  }

	  GlobalAction act;

	  MotionAction(GlobalAction a) {
	    act = a;
	  }
	}
