/**
 * 
 */
package processing.core;






import com.google.gwt.core.client.JavaScriptObject;





/**
 * @author cesar
 *
 */
public class PApplet extends ProcessingJS {
	
	
	public  PApplet (){}
	public  PApplet (JavaScriptObject ctx)
	{
		super(ctx);
		g = new PGraphics3D(ctx);
	}
	

	public PGraphics g;
	
	private IJsEventHandler handler;
	
	public void setJsEventHandler(IJsEventHandler handler)
	{
		this.handler = handler;
		
	}
	
	public  void addMouseAgent( String methodName, Object agent) {
		 
		 if(handler != null)			 
			 handler.addMouseAgent(getCanvas(), agent, methodName);

 	}
	 
	 public  void addKeyAgent( String methodName, Object agent) {
		 
		
		 if(handler != null)		 
			 handler.addKeyAgent(getCanvas(), agent, methodName);

 	}	
	
	
						
}
