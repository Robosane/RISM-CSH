/**
 * 
 */
package main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.prefs.Preferences;

/**
 * @author robo
 *
 */
public class Functions {
	
	// Use the Robosane class to store user data.
	static Preferences prefs = Preferences.userNodeForPackage(main.Robosane.class);
	
	final static String USE_HTTPS = "use_https";

	// Non-used default method to catch args.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Who in the world would call the main()?");
	}
	
	private static String getProtocol() {
		if (!prefs.getBoolean(USE_HTTPS, false)) {
			return "http://";
		} else if (prefs.getBoolean(USE_HTTPS, false)) {
			return "https://";
		} else {
			return null;
		}
	}
	
	public static void setHTTPS(boolean HTTPS) {
		prefs.putBoolean(USE_HTTPS, HTTPS);
	}
	
	public static boolean getHTTPS() {
		return prefs.getBoolean(USE_HTTPS, false);
	}
	
	public static void openWebpage(String url) {
	    try {
	        URI destination = new URI((getProtocol() + url));
	        System.out.println("openWebpage() opening URI: " + destination);
			openWebpage(destination);
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
	    try (Socket s = new Socket()) {
	    	s.connect(new InetSocketAddress(SERVER_ADDRESS, TCP_SERVER_PORT), 1000);
	    	s.close();
	        return true;
	    } catch (IOException ex) {
	        System.out.println("Generic IOException.");
	        //ex.printStackTrace();
	    }
	    return false;
	}
}
