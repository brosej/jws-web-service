package jlb.org;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WSMethods{
	 
	@WebMethod String getHelloWorldAsString(String name);
	@WebMethod void setOption(String param);
	@WebMethod String sendOption(String option);
	@WebMethod String communicate(String queryparam);
	

}

