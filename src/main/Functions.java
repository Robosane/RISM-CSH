/**
 * 
 */
package main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author robo
 *
 */
public class Functions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void openWebpage(String url) {
	    try {
	        try {
				openWebpage(new URL(url).toURI());
			} catch (MalformedURLException e) {
				System.err.println("Malformed URL Exception. How silly.");
				e.printStackTrace();
			}
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
	
	// Thanks to 'Vulcan' from Stackoverflow
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	        	System.err.println("Some kind of exception occured, sorry I don't know more.");
	            e.printStackTrace();
	        }
	    }
	}
	
	// Thanks to 'Stephen C' from Stackoverflow
	public static boolean hostAvailabilityCheck(String SERVER_ADDRESS, int TCP_SERVER_PORT) { 
	    try (Socket s = new Socket(SERVER_ADDRESS, TCP_SERVER_PORT)) {
	        return true;
	    } catch (IOException ex) {
	        /* ignore */
	    }
	    return false;
	}

}
