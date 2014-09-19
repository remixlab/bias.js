package processing.core;

import com.google.gwt.core.client.JavaScriptObject;

public interface IJsEventHandler {


	public abstract void addMouseAgent(JavaScriptObject canvas, Object agent, String methodName);
	public abstract void  addKeyAgent(JavaScriptObject canvas, Object agent, String methodName);
}
