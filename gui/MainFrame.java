package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import gui.Buttons;
import gui.Display;
import gui.Menu;
import gui.Panel;



/** 
 * 
 * @author Raleigh Martin
 * @date May 10, 2020
 */
public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Buttons button;
	private Display display;
	private Menu menu;
	private Panel panel;
	
	public MainFrame() {
		
		
		button = new Buttons();
		display = new Display();
		menu = new Menu();
		panel = new Panel();
	
//***************************Instantiations**************************
		
		button = new Buttons();
		display = new Display();
		menu = new Menu();
		panel = new Panel();
		
//**************************Additions for Panels*********************
		
		panel.getBorderPanel().add(panel.getMainPanel(), "Center");
		panel.getMainPanel().add(panel.getTopButtonPanel(), "North");
		panel.getMainPanel().add(panel.getBottomButtonPanel(), "South");
		panel.getMainPanel().add(display.getDisplay(), "Center");
		
//*************************Additions for Buttons*********************
		
		panel.getTopButtonPanel().add(button.getAdd());
		panel.getTopButtonPanel().add(button.getActionType());
		panel.getTopButtonPanel().add(button.getRecord());
		
		panel.getBottomButtonPanel().add(button.getPlay());
		panel.getBottomButtonPanel().add(button.getTimes());
		
//*************************Additions for Menu************************
		
		menu.getMenuBar().add(menu.getFile());
		menu.getMenuBar().add(menu.getEdit());
		menu.getMenuBar().add(menu.getSettings());
		
		
		
		this.setContentPane(panel.getBorderPanel());
		this.setTitle("Thicc RAM Boi");
		this.setLocationRelativeTo(null);
		this.setSize(400, 500);
		this.setVisible(true);
		this.setJMenuBar(menu.getMenuBar());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}
}
