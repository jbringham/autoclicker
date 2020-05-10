package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import gui.Borders;

/** Constructor for the panels.
 * 
 * @author Raleigh Martin
 * @date May 10, 2020
 */
public class Panel {
	
	private JPanel borderPanel;
	private JPanel mainPanel;
	private JPanel topButtonPanel;
	private JPanel bottomButtonPanel;
	
	private Borders border;
	
	public Panel() {
		
		border = new Borders();
		
		borderPanel = new JPanel(new BorderLayout());
		mainPanel = new JPanel( new BorderLayout());
		topButtonPanel = new JPanel( new FlowLayout());
		bottomButtonPanel = new JPanel( new FlowLayout());
		
		borderPanel.setBorder(border.getSpacer());
		
		
	}

	/**
	 * @return the borderPanel
	 */
	public JPanel getBorderPanel() {
		return borderPanel;
	}

	/**
	 * @return the mainPanel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * @return the topButtonPanel
	 */
	public JPanel getTopButtonPanel() {
		return topButtonPanel;
	}

	/**
	 * @return the bottomButtonPanel
	 */
	public JPanel getBottomButtonPanel() {
		return bottomButtonPanel;
	}

}
