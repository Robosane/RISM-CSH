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
import java.net.UnknownHostException;
import java.util.concurrent.*;

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
	        System.out.println("Generic IOException.");
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
