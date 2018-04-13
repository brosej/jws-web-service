package jlb.org;

import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import java.net.URL;

public class HTTPRequest {
	

	
	String charset = "UTF-8";
	
	public String GET(String url, String param) throws Exception {
	
    String responseBody = null;
    String query_param = URLEncoder.encode(param , charset); 
	    
	
	URLConnection connection = new URL(url + "?" + "q=" + query_param).openConnection();
	connection.setRequestProperty("Accept-Charset", charset);
	InputStream response = connection.getInputStream();
	
	System.out.println(query_param);
	try (Scanner scanner = new Scanner(response)) {
	    responseBody = scanner.useDelimiter("\\A").next();
	    System.out.println(responseBody);
	    
	    
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return responseBody;
	}

}
