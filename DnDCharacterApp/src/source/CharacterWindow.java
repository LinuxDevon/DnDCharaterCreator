package source;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This window is used to create a new character. It pulls up text 
 * boxes to fill out for the initial character creation. It instantiates 
 * the character object and return the character when closed.
 * 
 * @author Devon Adair
 *
 * CHANGE LIST:
 * 
 * TODO add custom focus traversal - http://docs.oracle.com/javase/tutorial/uiswing/misc/focus.html
 */
public class CharacterWindow{
	
	public static final ArrayList<String> skillLabelList = 
						new ArrayList<String>(Arrays.asList(
								"Acrobatics (DEX)", " Animal Handling (WIS)",
								"Athletics (STR)", " Deception (CHA)",
								"History (INT)", "Insight (WIS)", "Intimidation (CHA)",
								"Investigation (INT)", "Mechanics (INF)", "Medicine (WIS)",
								"Nature (INT)", "Perception (WIS)", "Performance (CHA)",
								"Persuasion (CHA)", "Programming (INF)", "Religion (INT)",
								"Sleight of Hand (DEX)", "Stealth (DEX)", "Survival (WIS)",
								"Vehicle Handling (INF)"));
	public static final ArrayList<String> savingThrowList = 
						new ArrayList<String>(Arrays.asList(
								"strength", "dexterity", "constitution", "intelligence",
								"wisdom","interfacing","charaisma"));

	private JPanel contentPanel;
	private JPanel buttonPane;
	
	private JLabel lblTotalPoints;
	
	private JDialog window;
	
	private ArrayList<JLabel> scrLabelList;	// TODO maybe find a better way to store these and recover them
	private ArrayList<JLabel> modLabelList;
	private HashMap<String, Integer> radioButtonsList;
	private HashMap<String, JTextField> labelMap;
	private Character player;
	private Application application;
	
	private boolean newCharacter;
	
	
	// Variables to load when loading character to edit.

	public CharacterWindow(Application application, Character playerToMake){
		
		this.contentPanel = new JPanel();
		this.scrLabelList = new ArrayList<>();
		this.modLabelList = new ArrayList<>();
		this.labelMap = new HashMap<>();
		if (playerToMake == null){
			this.newCharacter = true;
			this.player = new Character();
		}else {
			this.newCharacter = false;
			this.player = playerToMake;
		}

		this.application = application;
		
		this.radioButtonsList = new HashMap<>();
		
		init();
		
	}
	
	private void init(){
		InitWindow();

		createButtons();
		createLabels();
		createTextFields();
		createRadioLayout(skillLabelList, 8);
		createRadioLayout(savingThrowList, 6);
		
	}
	
	/**
	 * Creates the JDialog window and sets some base settings.
	 */
	private void InitWindow() {
		this.window = new JDialog();
		this.window.setTitle("Character Create");
		this.window.setVisible(true);
		
		this.window.setBounds(100, 100, 928, 648);
		this.window.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.window.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(new MigLayout("", "[][][][][][25px:n][][25px:n][100px:n]", "[][][][][][][][][][][][][][][][][][][][][][][][][]"));

		this.buttonPane = new JPanel();
		this.buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.window.getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		this.window.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				if(JOptionPane.showConfirmDialog(window, "Are you sure you want to close?","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.dispose();
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
	}
	
	/**
	 * Make the labels for the pane.
	 */
	private void createLabels(){
		
		JLabel lblStartingMoney = new JLabel("Starting Money:");
		this.contentPanel.add(lblStartingMoney, "cell 0 2,alignx trailing");
		
		JLabel lblClass = new JLabel("Class:");
		this.contentPanel.add(lblClass, "cell 0 3,alignx trailing");

		JLabel lblRank = new JLabel("Rank:");
		this.contentPanel.add(lblRank, "cell 0 4,alignx trailing");
		
		JLabel lblSpecies = new JLabel("Species:");
		this.contentPanel.add(lblSpecies, "cell 0 5,alignx trailing");
		
		JLabel lblMutLvl = new JLabel("MUT LVL / HUM Variant:");
		this.contentPanel.add(lblMutLvl, "cell 0 6,alignx trailing");
		
		JLabel lblCharacterName = new JLabel("Character Name:");
		this.contentPanel.add(lblCharacterName, "cell 0 0,alignx trailing");
		
		JLabel lblStartingxp = new JLabel("StartingXP:");
		this.contentPanel.add(lblStartingxp, "cell 0 1,alignx trailing");

		JLabel lblAgentNumber = new JLabel("Agent Number:");
		this.contentPanel.add(lblAgentNumber, "cell 0 7,alignx trailing");
		
		JLabel labelSpacer1 = new JLabel("---------------------------");
		this.contentPanel.add(labelSpacer1, "cell 0 8");

		JLabel labelSpacer2 = new JLabel("-----------------------------------");
		this.contentPanel.add(labelSpacer2, "cell 1 8");

		JLabel lblAbilityScore = new JLabel("Ability Scores");
		this.contentPanel.add(lblAbilityScore, "cell 0 9,alignx center");
		
		JLabel lblModifier = new JLabel("Modifier");
		this.contentPanel.add(lblModifier, "cell 2 9,alignx center");

		JLabel lblStrength = new JLabel("Strength:");
		this.contentPanel.add(lblStrength, "cell 0 10,alignx trailing");
		
		JLabel lblStrscr = new JLabel(this.player.getData(Character.STRABILITY));
		this.contentPanel.add(lblStrscr, "cell 1 10");
		scrLabelList.add(lblStrscr);
		
		JLabel lblStrmod = new JLabel(this.player.getData(Character.STRMOD));
		this.contentPanel.add(lblStrmod, "cell 2 10,alignx center");
		modLabelList.add(lblStrmod);

		JLabel lblDexterity = new JLabel("Dexterity:");
		this.contentPanel.add(lblDexterity, "cell 0 11,alignx trailing");
		
		JLabel lblDexscr = new JLabel(this.player.getData(Character.DEXABILITY));
		this.contentPanel.add(lblDexscr, "cell 1 11");
		scrLabelList.add(lblDexscr);
		
		JLabel lblDexmod = new JLabel(this.player.getData(Character.DEXMOD));
		this.contentPanel.add(lblDexmod, "cell 2 11,alignx center");
		modLabelList.add(lblDexmod);

		JLabel lblConsitution = new JLabel("Consitution:");
		this.contentPanel.add(lblConsitution, "cell 0 12,alignx trailing");
		
		JLabel lblConscr = new JLabel(this.player.getData(Character.CONABILITY));
		this.contentPanel.add(lblConscr, "cell 1 12");
		scrLabelList.add(lblConscr);
		
		JLabel lblConmod = new JLabel(this.player.getData(Character.CONMOD));
		this.contentPanel.add(lblConmod, "cell 2 12,alignx center");
		modLabelList.add(lblConmod);

		JLabel lblIntelligence = new JLabel("Intelligence:");
		this.contentPanel.add(lblIntelligence, "cell 0 13,alignx trailing");
		
		JLabel lblIntscr = new JLabel(this.player.getData(Character.INTELABILITY));
		this.contentPanel.add(lblIntscr, "cell 1 13");
		
		scrLabelList.add(lblIntscr);
		
		JLabel lblIntmod = new JLabel(this.player.getData(Character.INTELMOD));
		this.contentPanel.add(lblIntmod, "cell 2 13,alignx center");
		modLabelList.add(lblIntmod);

		JLabel lblWisdom = new JLabel("Wisdom:");
		this.contentPanel.add(lblWisdom, "cell 0 14,alignx trailing");
		
		JLabel lblWisscr = new JLabel(this.player.getData(Character.WISABILITY));
		this.contentPanel.add(lblWisscr, "cell 1 14");
		scrLabelList.add(lblWisscr);
		
		JLabel lblWismod = new JLabel(this.player.getData(Character.WISMOD));
		this.contentPanel.add(lblWismod, "cell 2 14,alignx center");
		modLabelList.add(lblWismod);
		
		JLabel lblInterfacing = new JLabel("Interfacing:");
		this.contentPanel.add(lblInterfacing, "cell 0 15,alignx trailing");
		
		JLabel lblInterscr = new JLabel(this.player.getData(Character.INTERABILITY));
		this.contentPanel.add(lblInterscr, "cell 1 15");
		scrLabelList.add(lblInterscr);
		
		JLabel lblIntmod_1 = new JLabel(this.player.getData(Character.INTERMOD));
		this.contentPanel.add(lblIntmod_1, "cell 2 15,alignx center");
		modLabelList.add(lblIntmod_1);
		
		JLabel lblCharisma = new JLabel("Charisma:");
		this.contentPanel.add(lblCharisma, "cell 0 16,alignx trailing");
		
		JLabel lblChrscr = new JLabel(this.player.getData(Character.CHAABILITY));
		this.contentPanel.add(lblChrscr, "cell 1 16");
		scrLabelList.add(lblChrscr);
		
		JLabel lblChamod = new JLabel(this.player.getData(Character.CHAMOD));
		this.contentPanel.add(lblChamod, "cell 2 16,alignx center");
		modLabelList.add(lblChamod);
		
		lblTotalPoints = new JLabel("31");
		this.contentPanel.add(lblTotalPoints, "cell 1 17");

		JLabel lblTotalRemaining = new JLabel("Total Remaining:");
		this.contentPanel.add(lblTotalRemaining, "cell 0 17,alignx trailing");
	}

	/**
	 *  Make the buttons.
	 */
	private void createButtons(){
		JButton okButton = new JButton("OK");
		this.buttonPane.add(okButton);
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO save the choices and pop up the skills window.
				createMainWindow();
				
			}});

		JButton cancelButton = new JButton("Cancel");
		this.buttonPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO decide weather to close of load default player
				
				window.dispose();
//				player = new Character();		// Load default character
				
			}});
		
		///////////////////////////////////////////////////////////////////////////
		// BUTTONS
		//////////////////////////////////////////////////////////////////////////
		
		// UP BUTTONS
		for(int i = 0; i < 7; i++){
			JButton btnUp_i = new JButton("up");
			int index = i;
			
			btnUp_i.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO finish this and make it a seperate listener for add and subtract
					// to remove duplicate code.
					JLabel label = scrLabelList.get(index);
					int labelNumber = Integer.parseInt(label.getText());
					if(labelNumber < 0 ){  // Check so that way the player can't go to far with the buttons
						label.setText("0");
						return;
					}else if(labelNumber > 40){
						label.setText("40");
						return;
					}
					label.setText("" + (labelNumber + 1));
					labelNumber = Integer.parseInt(label.getText());
					modLabelList.get(index).setText("" + modifierCalc(labelNumber));
					lblTotalPoints.setText("" + (Integer.parseInt(lblTotalPoints.getText()) - 1));
					
				}});
			this.contentPanel.add(btnUp_i, "cell 3 " + (i + 10));
		}
		
		// DOWN BUTTONS
		for(int i = 0; i < 7; i++){
			JButton btnUp_i = new JButton("down");
			int index = i;
			btnUp_i.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO finish this and make it a seperate listener for add and subtract
					// to remove duplicate code.
					JLabel label = scrLabelList.get(index);
					int labelNumber = Integer.parseInt(label.getText());
					if(labelNumber < 0 ){	// Check so that way the player can't go to far with the buttons
						label.setText("0");
						return;
					}else if(labelNumber > 40){
						label.setText("40");
						return;
					}
					label.setText("" + (labelNumber - 1));
					labelNumber = Integer.parseInt(label.getText());
					modLabelList.get(index).setText("" + modifierCalc(labelNumber));
					lblTotalPoints.setText("" + (Integer.parseInt(lblTotalPoints.getText()) + 1));
				}});
			this.contentPanel.add(btnUp_i, "cell 4 " + (i + 10));
		}
		
	}

	/**
	 * Create text fields and adds to the panel.
	 * 
	 */
	private void createTextFields(){
		
		JTextField txtCharacterinput = new JTextField(this.player.getData(Character.NAME));
		this.contentPanel.add(txtCharacterinput, "cell 1 0,growx");
		this.labelMap.put("nameText", txtCharacterinput);
		
		// TODO decide weather to check if xp is a valid number here
		JTextField txtStartingXP = new JTextField(this.player.getData(Character.XP));
		this.contentPanel.add(txtStartingXP, "cell 1 1,growx");
		this.labelMap.put("xpText", txtStartingXP);
		
		JTextField txtMoney = new JTextField(this.player.getData(Character.MONEY));
		this.contentPanel.add(txtMoney, "cell 1 2,growx");
		txtMoney.setColumns(10);
		this.labelMap.put("moneyText", txtMoney);
		
		JTextField txtClass = new JTextField(this.player.getData(Character.CLASS));
		this.contentPanel.add(txtClass, "cell 1 3,growx");
		txtClass.setColumns(10);
		this.labelMap.put("classText", txtClass);
		
		JTextField txtRank = new JTextField(this.player.getData(Character.RANK));
		this.contentPanel.add(txtRank, "cell 1 4,growx");
		txtRank.setColumns(10);
		this.labelMap.put("rankText", txtRank);
		
		JTextField txtSpecies = new JTextField(this.player.getData(Character.SPECIES));
		this.contentPanel.add(txtSpecies, "cell 1 5,growx");
		txtSpecies.setColumns(10);
		this.labelMap.put("speciesText", txtSpecies);
				
		JTextField txtVariant = new JTextField(this.player.getData(Character.VARIANT));
		this.contentPanel.add(txtVariant, "cell 1 6,growx");
		txtVariant.setColumns(10);
		this.labelMap.put("variantText", txtVariant);
		
		JTextField txtAgentnum = new JTextField(this.player.getData(Character.AGENTNUM));
		this.contentPanel.add(txtAgentnum, "cell 1 7,growx");
		txtAgentnum.setColumns(10);
		this.labelMap.put("agentNumberText", txtAgentnum);
		
//		this.fieldList.addAll(Arrays.asList(txtCharacterinput, txtStartingXP, txtMoney, txtClass, txtRank, txtSpecies, txtVariant, txtAgentnum));
	}
	
	/**
	 * Creates the layout based on the given list of strings. It makes the
	 * Radio buttons associate with the appropriate label.
	 * 
	 */
	private void createRadioLayout(ArrayList<String> list, int startingCell){
		int index = 0;
		
		for(String labelName: list){
			JRadioButton radioButton = new JRadioButton();
			this.contentPanel.add(radioButton, "cell " + startingCell + " " + index);
			if(this.player.getRadioButton(labelName) == 1){
				radioButton.setSelected(true);
			} else {
				radioButton.setSelected(false);
			}
			
			JLabel label = new JLabel(labelName);
			this.contentPanel.add(label, "cell " + startingCell + " " + index);
			index++;
			
			radioButton.addActionListener(new RadioListener(radioButton, labelName, this.radioButtonsList));
			
			this.radioButtonsList.put(labelName, this.player.getRadioButton(labelName));
		}
	}

	/**
	 * Used to calculate what the modifier score is according to the ability score.
	 * 
	 * @param parseInt - ability score as an integer
	 * @return - the string of for the modifier score
	 */
	private String modifierCalc(int parseInt) {
		double abilityMod;
		abilityMod = Math.floor((((double) parseInt -10)/2));
		return String.valueOf((int) abilityMod);
	}
	
	/**
	 * Asks the user if they want to close the window or not.
	 */
	private int closeWindow(){
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to quit?","Verify",JOptionPane.YES_NO_OPTION);
		return dialogResult;
	}
	
	/**
	 * Starts the main gui with the correct information.
	 */
	private void createMainWindow(){
		HashMap<String, String> data = new HashMap<>();
		HashMap<String, Boolean> deathSaves = new HashMap<>();
		
		//TODO change these to the public static variables of character
		data.put("strengthAbility", scrLabelList.get(0).getText());
		data.put("dexterityAbility", scrLabelList.get(1).getText());
		data.put("constitutionAbility", scrLabelList.get(2).getText());
		data.put("intelligenceAbility", scrLabelList.get(3).getText());
		data.put("wisdomAbility", scrLabelList.get(4).getText());
		data.put("interfacingAbility", scrLabelList.get(5).getText());
		data.put("charismaAbility", scrLabelList.get(6).getText());
		
		data.put("strengthMod", modLabelList.get(0).getText());
		data.put("dexterityMod", modLabelList.get(1).getText());
		data.put("constitutionMod", modLabelList.get(2).getText());
		data.put("intelligenceMod", modLabelList.get(3).getText());
		data.put("wisdomMod", modLabelList.get(4).getText());
		data.put("interfacingMod", modLabelList.get(5).getText());
		data.put("charismaMod", modLabelList.get(6).getText());
		
		data.put("name", this.labelMap.get("nameText").getText());
		data.put("money", this.labelMap.get("moneyText").getText());
		data.put("class", this.labelMap.get("classText").getText());
		data.put("rank", this.labelMap.get("rankText").getText());
		data.put("species", this.labelMap.get("speciesText").getText());
		data.put("variant", this.labelMap.get("variantText").getText());
		data.put("agentNumber", this.labelMap.get("agentNumberText").getText());
		data.put("xp", this.labelMap.get("xpText").getText());
		if(this.newCharacter){
			data.put("speed", "");
			data.put("ac", "");
			data.put("inspiration", "");
			data.put("proficiency", "");
			
			data.put(Character.TITLE1, "Changeable Title");
			data.put(Character.TITLE2, "Changeable Title");
			data.put(Character.TEXTAREA1, "");
			data.put(Character.TEXTAREA2, "");
			data.put(Character.TEXTAREA3, "");
			
			data.put(Character.CURHITPNTS, "");
			data.put(Character.MAXHITPNTS, "");
			data.put(Character.CURSTAMPNTS, "");
			data.put(Character.MAXSTAMPNTS, "");
			data.put(Character.SPELLCASTING, "");
			data.put(Character.ABLATTMOD, "");
			data.put(Character.ABLSAVEDC, "");
			data.put(Character.LEVEL, "");
			
			for(int i = 0; i < 3; i++){
				String labelSuccess = "success" + (i + 1);
				String labelFailure = "failure" + (i + 1);
				deathSaves.put(labelFailure, false);
				deathSaves.put(labelSuccess, false);
			}
			this.player = new Character(data, this.radioButtonsList, deathSaves, 0);
		}	
		
		this.player.edit(data, this.radioButtonsList);
		
		this.application.initialize(this.player);
		this.window.dispose();
		
	}
	
//	public Character getPlayer(){
//		return this.player;
//	}

}