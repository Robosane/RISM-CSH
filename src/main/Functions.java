package main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.prefs.Preferences;

public class Functions {
	
	// Use the Robosane class to store user data.
	static Preferences prefs = Preferences.userNodeForPackage(main.Robosane.class);
	
	final static String USE_HTTPS = "use_https";

	// Non-used default method to catch args.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Who in the world would call the main()?");
	}
	
	// Return HTTP or HTTPS from the user preferences.
	private static String getProtocol() {
		if (!prefs.getBoolean(USE_HTTPS, false)) {
			return "http://";
		} else if (prefs.getBoolean(USE_HTTPS, false)) {
			return "https://";
		} else {
			return null;
		}
	}
	
	// Set the user preference for HTTPS or not.
	public static void setHTTPS(boolean HTTPS) {
		prefs.putBoolean(USE_HTTPS, HTTPS);
	}
	
	// Return a boolean for wether HTTPS is enabled.
	public static boolean getHTTPS() {
		return prefs.getBoolean(USE_HTTPS, false);
	}
	
	// Convert a webpage from string to URI and open it.
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
	// Open a URI in the default browser.
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
	// Check to see if a server accepts a socket connection.
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
