/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package main.actiondrivencallback;


import remixlab.bias.core.Action;



// TODO: Auto-generated Javadoc
/**
 * The Enum ClickAction.
 */
public enum ClickAction implements Action<GlobalAction> {
	  CHANGE_COLOR(GlobalAction.CHANGE_COLOR), 
	  CHANGE_STROKE_WEIGHT(GlobalAction.CHANGE_STROKE_WEIGHT);

	  @Override
	  public GlobalAction referenceAction() {
	    return act;
	  }

	  @Override
	  public String description() {
	    return "A simple click action";
	  }

	  @Override
	  public int dofs() {
	    return 0;
	  }

	  GlobalAction act;

	  ClickAction(GlobalAction a) {
	    act = a;
	  }
	}
