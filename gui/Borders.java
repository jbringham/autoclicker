package gui;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/** Constructor for the borders on Panels.
 * 
 * @author Raleigh Martin
 * @date May 10, 2020
 */

public class Borders {
	
	Border spacer;
	
	public Borders() {
		
		spacer = BorderFactory.createEmptyBorder( 5, 5, 5, 5 );
		
	}

	/**
	 * @return the spacer
	 */
	public Border getSpacer() {
		return spacer;
	}

}
