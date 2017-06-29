package source;

import java.awt.EventQueue;

import javax.swing.JLabel;

/**
 * This program was built in eclipse using Window Builder for the GUI. The program is a DnD app that lets you create characters to save and automate them.
 *  
 * @author Devon Adair
 *
 */
public class Main {

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationGUI window = new ApplicationGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
