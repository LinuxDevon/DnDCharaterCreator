package source;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JLabel;

/**
 * This is the main window of the application. A lot of it is labels and layout. It creates the dialog window which is the new character window if the user
 * selects yes then the this main page pops up. 
 * 
 * @author Devon Adair
 *
 * Changes eventually:
 * 
 * TODO add comments
 * TODO make either maps or arraylist of data so it makes the code look nicer
 * TODO general code cleanup
 * TODO add in save and load features
 * TODO fix the catch so they don't eat the exception
 * 
 * BUGS:
 * TODO find the radio bug error and fix it.
 */

public class ApplicationGUI {
	
	public static final String VERSION = "Beta 1.0";

	private JFrame frame;
	private Character player = null;
	private NewCharacterWindow dialog;
	private FileIO fileManager;							// Saving and loading
	private HashMap<JLabel, JRadioButton> buttonMap;	// Map used to change value of label based on button selected
	private ArrayList<Integer> lvlExp;		 			// contains the list of xp amounts for each level
	private SpellWindow spellFrame;
	private boolean newCharacter; 						// used for edit and new character

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ApplicationGUI() {
		this.lvlExp 		= new ArrayList<>();
		this.buttonMap 		= new HashMap<>();
		this.newCharacter 	= true;
		this.spellFrame 	= new SpellWindow(this.player);
		
//		this.player = new Character("", 0, null); // used this to be able to use the Window GUI builder to design
		
		// Set up the levels for the level list
		lvlExp.addAll(Arrays.asList(0,300,900,2700,6500,14000,23000,34000,48000,
									64000,85000,100000,120000,140000,165000,195000,
									225000,265000,305000,355000));
		
		initializeOptionPanel(); 
	}
	
	/**
	 * Creates a pop up that asks if a they want to make a new character and if so it brings up 
	 * the character create window to enter information.
	 */
	
	public void initializeOptionPanel(){
		
		int xpAmount;
		HashMap<String, String> data = new HashMap<>();
		if(!this.newCharacter){ // TODO figure out why this is here
			dialog = new NewCharacterWindow(this.frame, this.player, this, this.newCharacter);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setAutoRequestFocus(true);
			dialog.setAlwaysOnTop(true);
			return;
		}
		if (JOptionPane.showConfirmDialog(null, "Do you want to create a new character?", "New Character?",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			dialog = new NewCharacterWindow(this.frame, this.player, this, this.newCharacter);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setAutoRequestFocus(true);
			dialog.setAlwaysOnTop(true);
			
		} else {
			// creates default blank character
			// TODO add template
			xpAmount = 0;
			data.put("strengthAbility", "8");
			data.put("dexterityAbility","8");
			data.put("constitutionAbility", "8");
			data.put("intelligenceAbility", "8");
			data.put("wisdomAbility", "8");
			data.put("interfacingAbility", "8");
			data.put("charismaAbility", "8");
			
			data.put("strengthMod", "-1");
			data.put("dexterityMod", "-1");
			data.put("consititutionMod", "-1");
			data.put("intelligenceMod","-1");
			data.put("wisdomMod", "-1");
			data.put("interfacingMod", "-1");
			data.put("charismaMod", "-1");
			
			data.put("name", "");
			data.put("money", "");
			data.put("class", "");
			data.put("rank", "");
			data.put("species", "");
			data.put("variant", "");
			data.put("agentNumber","");	
//			Character player = new Character(characterName, xpAmount, abilityScores, "", "", "", "", "", "");
			Character player = new Character(xpAmount, data);
			this.player = player;
			initialize(player);
			
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @param player2 - the Character to add to the GUI
	 */
	public void initialize(Character player2) {
		
		// init the player
		this.player = player2;	

		// frame to hold everything
		frame = new JFrame();

		frame.setBounds(100, 100, 1547, 1027);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// MENU
		initMenu();

		LabelCreator labels = new LabelCreator(this.lvlExp, this.buttonMap, this.player, this.frame);
	      
		frame.setVisible(true);
		
		fileManager = new FileIO(this.frame, this);

		if(!this.newCharacter){
			
			HashMap<String, Integer> tempButtonMap = this.player.getButtonMap();
			ArrayList<String> labelNames = new ArrayList<>();
			ArrayList<Integer> buttonOn = new ArrayList<>();
			
			for(String label: tempButtonMap.keySet()){
				labelNames.add(label);
				buttonOn.add(tempButtonMap.get(label));
			}
			System.out.println(buttonMap.size());
			for(JLabel key: this.buttonMap.keySet()){
				key.setText(labelNames.get(0));
				labelNames.remove(0);
				if(buttonOn.get(0) == 1){
					this.buttonMap.get(key).setSelected(true);
				}else{
					this.buttonMap.get(key).setSelected(false);
				}
				buttonOn.remove(0);
			}
		}
		this.newCharacter = false;	
		
	}
	
	/**
	 * This starts the menu bar. 
	 */
	public void initMenu(){
		
		
		/////////////////////////////////////////////////////////////////////////
		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem save = new JMenuItem("Save");
		mnFile.add(save);
		
		save.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saving");
	
				player.setButtonMap(buttonMap);							// trying to save to the xml. need to move into config file
				String fileName = "";
				fileManager.saveCharacter(fileName, player, spellFrame);// remove spell frame from here

		
		}});
		
		JMenuItem load = new JMenuItem("Load");
		mnFile.add(load);
		
		load.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Loading");
				fileManager.loadCharacter();
			
		}});
		
		JMenuItem newChar = new JMenuItem("New Character");
		mnFile.add(newChar);
		
		newChar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				newCharacter = true;
				initializeOptionPanel();
				frame.dispose();
				
			}});
		
		JMenuItem mnEditCharacter = new JMenuItem("Edit Character");
		mnFile.add(mnEditCharacter);
		
		// TODO fix the issue of the frame not updating when done modifiying
		mnEditCharacter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				newCharacter = false;
				initializeOptionPanel();
//				frame.dispose();
				
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
			if (Desktop.isDesktopSupported()) {
				try {
					File myFile = new File("References/DnD 5e Player's Handbook.pdf");
					Desktop.getDesktop().open(myFile);
				} catch (IOException ex) {
					// no application registered for PDFs
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
		
		JMenuItem version = new JMenuItem("version");
		mnUpdate.add(version);
		
		version.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, VERSION);
		
		}});
		JMenu mnSpells = new JMenu("Spells Window");
		menuBar.add(mnSpells);
		
		JMenuItem spellWindow = new JMenuItem("spells");
		mnSpells.add(spellWindow);
		
		spellWindow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				spellFrame.getFrame().setVisible(true);
				
			}});
	}
}

