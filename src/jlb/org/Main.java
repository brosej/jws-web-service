package jlb.org;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.xml.ws.Endpoint;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;



public class Main {

	public static void main(String[] args) throws IOException, LifecycleException, ServletException {
		Integer port = 8101;
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(port);
		
		Endpoint.publish("http://localhost:9999/ws/hello", new WSClass());
		System.out.println("Tomcat correrá en el puerto: " + port);
		Context ctxt = null;
		Connector connector = tomcat.getConnector();
		connector.setURIEncoding("UTF-8");
		try {
			 ctxt = tomcat.addWebapp("/", System.getProperty("user.dir") + "\\"+"webClient");

			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Tomcat.addServlet(ctxt, "Serv2", new Serv2());
		ctxt.addServletMappingDecoded("/test", "Serv2");
		
		
		
	   tomcat.start();
	   tomcat.getServer().await();
	   
    }

}
