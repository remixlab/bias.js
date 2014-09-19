package processing.eventjs;

import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.TypeOracle;

public class Reflect {
	
	/**
	 * calls the method by reflection.
	 *
	 * @param agt the anonymous agent to call the event with reflection
	 * @param methodName the method name
	 * @param param the JsMouseEvent
	 */
	public static  void ExecuteEvent(Object agt, String methodName , Object param)
	{
				
		    ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(agt.getClass());		    
		    classType.invoke(agt,methodName, param);		    			
	}
	
	
	
	/**
	 * calls the method by reflection.
	 *
	 * @param agt the anonymous agent to call the event with reflection
	 * @param methodName the method name

	 */
	public static  void ExecuteEvent(Object agt, String methodName )
	{
				
		    ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(agt.getClass());		    
		    classType.invoke(agt,methodName);		    			
	}
	

}
