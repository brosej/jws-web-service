package jlb.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;



@WebServlet("/Serv2")

public class Serv2 extends HttpServlet{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


public Serv2() {
		
        // TODO Auto-generated constructor stub
    }

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.addHeader("Access-Control-Allow-Origin", "*");
        setAccessControlHeaders(response);   		
        String option = null;
        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://org.jlb/", "WSClassService");
        Service service = Service.create(url, qname);
        WSMethods wsm = service.getPort(WSMethods.class);
        option = wsm.sendOption(option);				
		PrintWriter out = response.getWriter();
		response.setContentType("text/event-stream, charset=UTF-8");
		out.print("data:"+ option + "\n\n");
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
  private void setAccessControlHeaders(HttpServletResponse response) {
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Credentials", "true");
      response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
      response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
      //filterChain.doFilter(servletRequest, servletResponse);
  }
}
