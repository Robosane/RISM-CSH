/**
 * 
 */
package main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.*;
import java.util.prefs.*;

/**
 * @author robo
 *
 */
@SuppressWarnings("unused")
public class Functions {
	
	// Use the Robosane class to store user data.
	static Preferences prefs = Preferences.userNodeForPackage(main.Robosane.class);
	
	final static String USE_HTTPS = "use_https";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	private static void setHTTPS(boolean HTTPS) {
		prefs.putBoolean(USE_HTTPS, HTTPS);
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
	
	// Doesn't Work like I want it to...                  
	/*
	public static boolean hostAvailabilityCheck2(String SERVER_ADDRESS, int TCP_SERVER_PORT) { 
	    Socket s = new Socket(SERVER_ADDRESS, TCP_SERVER_PORT);
	    boolean available = true; 
	    try {               
	        if (s.isConnected()) {
	        	s.close();    
	        }
	    } catch (UnknownHostException e) { 
	        available = false;
	        s = null;
	    } catch (IOException e) { 
	        available = false;
	        s = null;
	    } catch (NullPointerException e) {
	        available = false;
	        s=null;
	    }
	    return available;   
	} 
	*/
	
	// Keeps returning false positives for some reason
	/*
	public static boolean hostAvailableTimeoutCheck(final String SERVER_ADDRESS, final int TCP_SERVER_PORT) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Callable<Object> task = new Callable<Object>() {
		   public Object call() {
		      return hostAvailabilityCheck(SERVER_ADDRESS, TCP_SERVER_PORT);
		   }
		};
		Future<Object> future = executor.submit(task);
		try {
		   Object result = future.get(5, TimeUnit.SECONDS);
		   return (result) != null;
		} catch (TimeoutException ex) {
		   // handle the timeout
			return(false);
		} catch (InterruptedException e) {
		   // handle the interrupts
			return(false);
		} catch (ExecutionException e) {
		   // handle other exceptions
			return(false);
		} finally {
		   future.cancel(true); // may or may not desire this
		}
	}
	*/

}
