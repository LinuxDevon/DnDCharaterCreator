package source;

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
	
	public static final String VERSION = "OFFICIAL 1.0";
	public static final String AUTHOR  = "Devon Adair";
	private static final String CONTACT = "If you need to report a bug or want to request a feature"
										+ " please send an email to: adairdg@rose-hulman.edu. In the "
										+ "email include a description of the bug or feature. Include"
										+ " screenshots if possible. Thanks from your friendly neighbor"
										+ "hood programmer";

	private JFrame frame;
	
	private MainWindow mainWindow;
	private FileIO fileManager;
	
	private Character player;
	private CharacterWindow newCharacterWindow;
	private SpellWindow spellFrame;

	/**
	 * Create the application and decide if to create a new character or not.
	 */
	public Application() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 1547, 1027);
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
		
		// Decide if they want a new character or not. 
		// 0 = yes, 1 = no
		int choice = JOptionPane.showConfirmDialog(null, 
							"Do you want to create a new character?", "New Character?", 
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
		
		this.mainWindow = new MainWindow(frame, player);
		this.player = player;
		
		initMenu();
		
		this.fileManager = new FileIO(this.player, frame, this);
		this.frame.setVisible(true);
		
		this.spellFrame = new SpellWindow(this.player);
		
		this.fileManager.saveTemp();
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
		
		this.spellFrame = new SpellWindow(character);
		
		this.fileManager.saveTemp();
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
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JMenuItem dndBook = new JMenuItem("Player Manual");
		mnReference.add(dndBook);
		
		JMenuItem playerHandGuide = new JMenuItem("Re-evolution Manual");
		mnReference.add(playerHandGuide);
		
		JMenuItem characterSheet = new JMenuItem("Character Sheet");
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
					File myFile = new File("References/Re-Evolution Players Handbook (1st Edition) v1.2.1.pdf");
					Desktop.getDesktop().open(myFile);
				} catch (IOException ex) {
					// no application registered for PDFs
				}
			}
		
		}});
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
	
		
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
		
		JMenu mnSpells = new JMenu("Spells Window");
		menuBar.add(mnSpells);
		
		JMenuItem spellWindow = new JMenuItem("spells");
		mnSpells.add(spellWindow);
		
		spellWindow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				spellFrame.display();
				
			}});
	}

}
