package source;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * This starts with a pop up dialog asking if you want to create a new character and 
 * if they do it pulls up the new character window.
 * 
 * @author Devon Adair
 *
 */
public class Application {
	
	public static final int FIRST_VERSION_NUMBER = 1;
	public static final int SECOND_VERSION_NUMBER = 1;
	public static final int THIRD_VERSION_NUMBER = 0;
	public static final String VERSION = FIRST_VERSION_NUMBER + "." + 
										SECOND_VERSION_NUMBER + "." +
										THIRD_VERSION_NUMBER;
	
//	public static final int FIRST_BOOK_NUMBER = 1;
//	public static final int SECOND_BOOK_NUMBER = 0;
//	public static final int THIRD_BOOK_NUMBER = 0;
	
	public static final String AUTHOR  = "Devon Adair";
	private static final String CONTACT = "If you need to report a bug or want to request a feature"
										+ " please send an email to: adairdg@rose-hulman.edu. \nIn the "
										+ "email include a description of the bug or feature. \nInclude"
										+ " screenshots if possible.\nThanks from your friendly neighbor"
										+ "hood programmer";

	private static final String TITLE = "Re-Evolution: NRT Redacted © Official "
											+ "Character Creation App v" + VERSION
											+ " By - " + AUTHOR;
	
	private static final String UPDATE_HISTORY = "Version " + VERSION + " changes: \n\n"
												+ "1. Interfacing mod score fixed.\n"
												+ "2. Added a dice roller in the tools tab.\n"
												+ "3. Added auto updating by clicking the check for updates.\n"
												+ "4. Added clickable spells to navigate to grimore website. ctrl + right click\n";
	private JFrame frame;
	
	private MainWindow mainWindow;
	private FileIO fileManager;
	
	private Character player;
	private CharacterWindow newCharacterWindow;
	private SpellWindow spellFrame;
	private DiceRoller diceRollerFrame;

	/**
	 * Create the application and decide if to create a new character or not.
	 */
	public Application() {
		// TODO create method for creating frame
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 1547, 1027);
		this.frame.setTitle(TITLE);
//		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO FIX DUP
		this.frame.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to close?","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
//					spellFrame.closeWindow();
//					diceRollerFrame.closeWindow();
					frame.dispose();
				}
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) { 
				
			}
			
		});
		
		this.mainWindow = null;
		
//		this.frame.setBackground(Color.RED);
		
		// Decide if they want a new character or not. 
		// 0 = yes, 1 = no
		int choice = JOptionPane.showConfirmDialog(null, 
							"Do you want to create a new character?\n\n"
							+ "Created By " + AUTHOR + "Re-Evolution: NRT Redacted © 2017" , "New Character?", 
							JOptionPane.YES_NO_OPTION);
		if(choice == 0){
			initMenu();
			intializeNewCharacter();
		}else{
			this.player = new Character();
			initialize(this.player);
		}
		
	}
	
	public void initializeCharacter(Character player, JFrame frame){
		this.frame = frame;
		this.frame.setBounds(100, 100, 1547, 1027);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.frame.setTitle(TITLE);
		
		this.mainWindow = new MainWindow(frame, player);
		this.player = player;
		
		initMenu();
		
		this.fileManager = new FileIO(this.player, frame, this);
		this.frame.setVisible(true);
		
		this.spellFrame = new SpellWindow(this.player, this.frame);
		
		this.fileManager.fileChecker();
		this.fileManager.saveTemp();
		
		this.frame.setLocationRelativeTo(null); // center the window in the middle of the screen
		
	}

	/**
	 * Initialize the frame if there is no new character.
	 */
	public void initialize(Character player) {
		
		Character character = player;
		this.player = player;
		this.mainWindow = new MainWindow(this.frame, character);
		
		initMenu();
		
		this.fileManager = new FileIO(character, this.frame, this);
		this.frame.setVisible(true);
		this.frame.setTitle(TITLE);
		
		this.spellFrame = new SpellWindow(character,this.frame);
		this.diceRollerFrame = new DiceRoller(this.frame);
		
		this.fileManager.fileChecker();
		this.fileManager.saveTemp();
		
		this.frame.setLocationRelativeTo(null); // center the window in the middle of the screen
	}

	/**
	 * Create a new character pop up window.
	 */
	private void intializeNewCharacter() {
		this.newCharacterWindow = new CharacterWindow(this, this.player);
	}

	/**
	 * This starts the menu bar. 
	 */
	private void initMenu(){
		/////////////////////////////////////////////////////////////////////////
		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		this.frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem save = new JMenuItem("Save");
		mnFile.add(save);
		
		save.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saving");
				fileManager.save();
		}});
		
		JMenuItem saveAs = new JMenuItem("Save As");
		mnFile.add(saveAs);
		
		saveAs.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saving");
				fileManager.saveAs();
		}});
		
		JMenuItem load = new JMenuItem("Load");
		mnFile.add(load);
		
		load.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n Loading");
				fileManager.load();
				frame.addWindowListener(new WindowListener(){

					@Override
					public void windowActivated(WindowEvent arg0) {
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to close?","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							fileManager.saveTemp();
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//							spellFrame.closeWindow();
//							diceRollerFrame.closeWindow();
							frame.dispose();
						}
						
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {

					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
						
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
						
					}

					@Override
					public void windowOpened(WindowEvent arg0) { 
						
					}
					
				});
				
			
		}});
		
		JMenuItem newChar = new JMenuItem("New Character");
		mnFile.add(newChar);
		
		newChar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(frame, "Did you remeber to save your character?","Confirm", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
					return;
				}
				
				player = new Character();
				intializeNewCharacter();
				frame.dispose();
				frame = new JFrame();
				
				frame.setBounds(100, 100, 1547, 1027);
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.addWindowListener(new WindowListener(){ // TODO turn into class

					@Override
					public void windowActivated(WindowEvent arg0) {
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to close?","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//							spellFrame.closeWindow();
//							diceRollerFrame.closeWindow();
							frame.dispose();
						}
						
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {

					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
						
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
						
					}

					@Override
					public void windowOpened(WindowEvent arg0) { 
						
					}
					
				});
				
			}});
		
		JMenuItem mnEditCharacter = new JMenuItem("Edit Character");
		mnFile.add(mnEditCharacter);
		
		Application app = this;
		
		// TODO fix the issue of the frame not updating when done modifiying
		mnEditCharacter.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				newCharacterWindow = new CharacterWindow(app, player);
				frame.dispose();
				frame = new JFrame();
				
				frame.setBounds(100, 100, 1547, 1027);
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.addWindowListener(new WindowListener(){

					@Override
					public void windowActivated(WindowEvent arg0) {
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to close?","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							spellFrame.closeWindow();
							diceRollerFrame.closeWindow();
							frame.dispose();
						}
						
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {

					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
						
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
						
					}

					@Override
					public void windowOpened(WindowEvent arg0) { 
						
					}
					
				});
				
			}});
		
		JMenu mnReference = new JMenu("Reference");
		menuBar.add(mnReference);
		
		JMenuItem spellBook = new JMenuItem("Spell Book Website");
		mnReference.add(spellBook);
		
		JMenuItem dndBook = new JMenuItem("D&D 5E Base Handbook");
		mnReference.add(dndBook);
		
		JMenuItem playerHandGuide = new JMenuItem("Re-Evolution Player Handbook");
		mnReference.add(playerHandGuide);
		
		JMenuItem characterSheet = new JMenuItem("Reference Page");
		mnReference.add(characterSheet);
		
		characterSheet.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// checks to see if computer has pdf viewer
				if (Desktop.isDesktopSupported()) {
					try {
						File myFile = new File("References/Reference Page.pdf");
						Desktop.getDesktop().open(myFile);
					} catch (IOException ex) {
						// no application registered for PDFs
						
					}
				}
		
		}});
		
		// Adds the spell book git hub website
		spellBook.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try { 
				Desktop.getDesktop().browse(new URL("http://thebombzen.github.io/grimoire/").toURI());
			} catch (Exception e) {
				e.printStackTrace();
			}	
		
		}});
		
		dndBook.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String filePath = null;
			if (Desktop.isDesktopSupported()) {
				try {
					File myFile = new File("References/DnD 5e Player's Handbook.pdf");
					filePath = myFile.getAbsolutePath();
					Desktop.getDesktop().open(myFile);
				} catch (IOException ex) {
					System.out.println(ex);
				} catch (IllegalArgumentException x){
					JOptionPane.showConfirmDialog(null, "File " + filePath + " not found!", "Warning", JOptionPane.OK_CANCEL_OPTION);
				}
			}	
		
		}});
		
		playerHandGuide.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (Desktop.isDesktopSupported()) {
				try {
					File myFile = new File("References/Re-Evolution Players Handbook.pdf");
					Desktop.getDesktop().open(myFile);
				} catch (IOException ex) {
					// no application registered for PDFs
				}
			}
		
		}});
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem spellWindowSettings = new JMenuItem("Spell Window Settings");
		mnSettings.add(spellWindowSettings);
		
		spellWindowSettings.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
//				ServerSettingsWindow serverWindow = new ServerSettingsWindow(frame);
				
			}});
		
//		JMenuItem serverSettings = new JMenuItem("Server Settings");
//		mnSettings.add(serverSettings);
//		
//		mnSettings.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ServerSettingsWindow serverWindow = new ServerSettingsWindow(frame);
//				
//			}});
	
		
		JMenu mnUpdate = new JMenu("Update");
		menuBar.add(mnUpdate);
		
		JMenuItem version = new JMenuItem("Version");
		mnUpdate.add(version);
		
		version.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, Application.VERSION + "\n" + Application.AUTHOR);
		
		}});
		
		JMenuItem bugContact = new JMenuItem("Bug/Feature Contact");
		mnUpdate.add(bugContact);
		
		bugContact.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, Application.CONTACT);
				
			}});
		
		JMenuItem manualUpdate = new JMenuItem("Manual Update");
		mnUpdate.add(manualUpdate);
		
		manualUpdate.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				fileManager.manualUpdate();
		
		}});
		
		JMenuItem updateHistory = new JMenuItem("Update History");
		mnUpdate.add(updateHistory);
		
		updateHistory.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, Application.UPDATE_HISTORY);
		
		}});
		
		JMenuItem checkUpdate = new JMenuItem("Check for Updates");
		mnUpdate.add(checkUpdate);
		
		checkUpdate.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				fileManager.update();
		
		}});
		
		
		JMenu mnSpells = new JMenu("Spells Window");
		menuBar.add(mnSpells);
		
		JMenuItem spellWindow = new JMenuItem("Spells");
		mnSpells.add(spellWindow);
		
		spellWindow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				spellFrame.display();
				
			}});
		
		JMenu mnTool = new JMenu("Tools");
		menuBar.add(mnTool);
		
		JMenuItem calculatorApp = new JMenuItem("Calc App");
		mnTool.add(calculatorApp);
		
		calculatorApp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("calc");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		
		JMenuItem diceWindow = new JMenuItem("Dice Roller");
		mnTool.add(diceWindow);
		
		diceWindow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				diceRollerFrame.display();
				
			}});
		
		JMenu mnDonate = new JMenu("Donate");
		menuBar.add(mnDonate);
		
		JMenuItem donatePaypalButton = new JMenuItem("Donate via Paypal");
		mnDonate.add(donatePaypalButton);
		
		donatePaypalButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.paypal.me/DevonAdair").toURI());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Can't open window.");
				}	
				
			}});
		
		JMenuItem donateVenmoButton = new JMenuItem("Donate via Venmo (no fee)");
		mnDonate.add(donateVenmoButton);
		
		donateVenmoButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.venmo.com/Devon-Adair").toURI());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Can't open window.");
				}	
				
			}});

	}
	
}
