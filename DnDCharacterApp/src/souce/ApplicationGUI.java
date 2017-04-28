package souce;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ApplicationGUI {

	private JFrame frame;
	private Character player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationGUI window = new ApplicationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationGUI() {
		initialize();
	}
	
	/**
	 * 
	 */
	
	public void initializeOptionPanel(JFrame frame){
		String characterName = null;
		int xpAmount = 0;
		
		if (JOptionPane.showConfirmDialog(null, "Do you want to create a new character?", "New Character?",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			
			// Add some try in case mistype the input!!!!
			//
			//
			characterName = JOptionPane.showInputDialog(frame,
	                "What is your name?", null);
			xpAmount = Integer.parseInt(JOptionPane.showInputDialog(frame,
	                "How much XP do you start with?", null));
		} else {
		    // no option
		}
		Character player = new Character(characterName, xpAmount);
		this.player = player;
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		initializeOptionPanel(frame);
		
		frame.setBounds(100, 100, 892, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(0);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setHgap(0);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.add(panel_1);
		
		JLabel labelCharacterName = new JLabel("Character Name: ");
		panel_1.add(labelCharacterName);
		
		JLabel labelCharacterNameVariable = new JLabel(player.getName());
		panel_1.add(labelCharacterNameVariable);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(75);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.add(panel_2);
		
		JProgressBar progressBar = new JProgressBar();
		
		panel_2.add(progressBar);
		
		JLabel lblXp = new JLabel("XP");
		lblXp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXp.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblXp);
		
		
		
	}

}
