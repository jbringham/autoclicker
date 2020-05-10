package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

/** Constructor for all the buttons.
 * 
 * @author Raleigh Martin
 * @date May 10, 2020
 */

public class Buttons {
	
	private JButton add;
	private JComboBox<String> actionType;
	private JButton record;
	private JButton play;
	private JSpinner times;
	
	public Buttons() {
		
		add = new JButton("Add");
		actionType = new JComboBox<String>();
		record = new JButton("Record");
		play = new JButton("Play");
		times = new JSpinner();
		
		actionType.addItem("");
		actionType.addItem("Download");
		actionType.addItem("Moar");
		actionType.addItem("RAM");
		
	}

	/**
	 * @return the addButton
	 */
	public JButton getAdd() {
		return add;
	}

	/**
	 * @return the actionType
	 */
	public JComboBox<String> getActionType() {
		return actionType;
	}

	/**
	 * @return the record
	 */
	public JButton getRecord() {
		return record;
	}

	/**
	 * @return the play
	 */
	public JButton getPlay() {
		return play;
	}

	/**
	 * @return the times
	 */
	public JSpinner getTimes() {
		return times;
	}

}
