/**
 * 
 */
package main;

import java.awt.Desktop;
import java.net.*;

import javax.swing.*;

/**
 * @author robo
 *
 */
@SuppressWarnings("unused")
public class Main {
	
	static String robosane = "http://robosane.tk/";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		openWebpage(robosane);
	}
	
	// Thanks to 'Vulcan' from Stackoverflow
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static void openWebpage(String url) {
	    try {
	        try {
				openWebpage(new URL(url).toURI());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}

}
