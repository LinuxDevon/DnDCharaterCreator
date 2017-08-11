package source;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This program was built in eclipse using Window Builder for the GUI. The program is a DnD app that lets you create characters to save and automate them.
 *  
 * @author Devon Adair
 *
 */
public class Main {

	private static JFrame topFrame;
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(topFrame, "Critcal Error");
				}
			}
		});

	}

}
