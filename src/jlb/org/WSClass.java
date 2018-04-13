package jlb.org;

import java.util.LinkedList;
import java.util.Queue;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "jlb.org.WSMethods")
public class WSClass implements WSMethods {
	
	Queue<String> messages = new LinkedList<>();
	/*while(messageIn = false) {
		option = null;
		}*/
	
	@Override			
    public String getHelloWorldAsString(String name) {
		return "hello "+name;
	}
	
	@Override 
	public String communicate(String queryparam) {
		
		HTTPRequest request = new HTTPRequest();
		String response_body = null;
		
		try {
			
	    response_body = request.GET("http://localhost:8101/test", queryparam);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response_body;
	}
	
	@Override 
	public void setOption(String param) {
		messages.add(param);
	}
	
	@Override 
	public String sendOption(String opt) {
	    opt = messages.poll();   
		return opt;
	}
	
	

}
