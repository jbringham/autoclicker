package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/** Menu Constructor.
 * 
 * @author Raleigh Martin
 * @date May 10, 2020
 */

public class Menu {
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu edit;
	private JMenu settings;
	
	
	public Menu() {
		
		menuBar = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		settings = new JMenu("Settings");
			
		
		
	}


	/**
	 * @return the menuBar
	 */
	public JMenuBar getMenuBar() {
		return menuBar;
	}


	/**
	 * @return the file
	 */
	public JMenu getFile() {
		return file;
	}


	/**
	 * @return the edit
	 */
	public JMenu getEdit() {
		return edit;
	}


	/**
	 * @return the settings
	 */
	public JMenu getSettings() {
		return settings;
	}

}
