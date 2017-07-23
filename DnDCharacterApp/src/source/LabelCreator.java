package source;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;

/**
 * This object is used to make the labels on the main app frame. It creates the labels upon creating the object. Maybe change in future update
 * 
 * @author Devon Adair
 * 
 * TODO order the labels/Text Windows/ and other elements
 *
 */
public class LabelCreator implements Serializable{

	private JPanel abilityPanel;
	private HashMap<JLabel, JRadioButton> buttonMap;
	private Character player;
	private JPanel headerPanel;
	private JFrame frame;
	
	private ArrayList<Integer> lvlExp;
	
	Container myContainer;
	Component myCA[];
	private Object listner;
	
	public LabelCreator(){
		
	}
	
	
	public LabelCreator(ArrayList<Integer> lvlExp, HashMap<JLabel, JRadioButton> buttonMap, Character player, JFrame frame) {
		this.buttonMap = buttonMap;
		this.player = player;
		this.frame = frame;
		this.lvlExp = lvlExp;
		
		init();
		
		this.myContainer = this.frame.getContentPane(); // Used for writing components to text config file
		this.myCA = myContainer.getComponents();
		
	}

	public void init(){
		///////////////////////////////////////////////////////////////////////
		//	PANELS
		JPanel headerPanel = new JPanel();
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new MigLayout("", "[144px,grow][75px,grow][150px,grow][100px,grow][]", "[30px][30px][30px]"));
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new MigLayout("", "[60px][200px][][250px][100px][25px][25px][25px]", "[40px][40px][40px][40px][40px]"));
		
		JPanel abilityPanel = new JPanel();
		frame.getContentPane().add(abilityPanel, BorderLayout.WEST);
		MigLayout layout = new MigLayout("", "[65px,center][65px,center][65px,center][20px][200px][20px][175px]", "[30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][25px,center][25px,center][25px,center]");
		abilityPanel.setLayout(layout);
		
		JPanel bottomMainPanel = new JPanel();
		bottomMainPanel.setPreferredSize(new Dimension(100,250));
		frame.getContentPane().add(bottomMainPanel, BorderLayout.SOUTH);
		bottomMainPanel.setLayout(new MigLayout("", "[:10px:300px,grow,left][grow]", "[][grow]"));
		
		bottomMainPanel.add(bottomPanel, "cell 1 1,grow");
		
		// TODO find a way to clean up the code with maybe a generic function 
		// 		to make the labels.
		/////////////////////////////////////////////////////////////////////////
		// Header of the APP
		
		////////////////////////////////////////////////////////////////////////
		// 	LABELS
		///////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel_3 = new JLabel("Class: " + this.player.getData("class"));
		headerPanel.add(lblNewLabel_3, "cell 1 0,alignx center");
		
		JLabel lblRank = new JLabel("Rank: " + this.player.getData("rank"));
		headerPanel.add(lblRank, "cell 2 0,alignx center");
		
		JLabel lblXp = new JLabel("XP: ");
		headerPanel.add(lblXp, "flowx,cell 3 0,alignx center");
		
		JLabel lblMoney = new JLabel("Money: ");
		headerPanel.add(lblMoney, "flowx,cell 0 1");
		
		JLabel lblSpecies = new JLabel("Species: " + this.player.getData("species"));
		headerPanel.add(lblSpecies, "cell 1 1,alignx center");
		
		JLabel lblMutLvl = new JLabel("MUT LVL / HUM VARIANT: " + this.player.getData("variant"));
		headerPanel.add(lblMutLvl, "cell 2 1,alignx center");
		
		JLabel lblAgentNumber = new JLabel("Agent Number: " + this.player.getData("agentNumber") );
		headerPanel.add(lblAgentNumber, "cell 3 1,alignx center");
	
		JLabel labelCharacterName = new JLabel("Character Name: " + this.player.getName() );
		headerPanel.add(labelCharacterName, "cell 0 0");
		
		JLabel lblAc = new JLabel("AC:");
		headerPanel.add(lblAc, "flowx,cell 1 2,alignx center");
		
		JLabel lblInitiative = new JLabel("INITIATIVE: " + this.player.getData("dexterityMod"));
		headerPanel.add(lblInitiative, "cell 2 2,alignx center");
		
		JLabel lblSpeed = new JLabel("SPEED:");
		headerPanel.add(lblSpeed, "flowx,cell 3 2,alignx center");
		
		JLabel lblAbility = new JLabel("Ability");
		abilityPanel.add(lblAbility, "cell 0 0");
		
		JLabel lblAbilityScore = new JLabel("Ability Score");
		abilityPanel.add(lblAbilityScore, "cell 1 0");
		
		JLabel lblModifier = new JLabel("Modifier");
		abilityPanel.add(lblModifier, "cell 2 0");
		
		JLabel lblInspiration = new JLabel(" : Inspiration");
		abilityPanel.add(lblInspiration, "cell 4 0,alignx right");
		
		JLabel lblAcrobatics = new JLabel(this.player.getData("dexterityMod") + " : Acrobatics (DEX)");
		abilityPanel.add(lblAcrobatics, "cell 6 0,alignx right");
		
		JLabel lblStrength = new JLabel("Strength: ");
		abilityPanel.add(lblStrength, "cell 0 1");
		
		JLabel lblStrscr = new JLabel(this.player.getData("strengthAbility"));
		abilityPanel.add(lblStrscr, "cell 1 1");
		
		JLabel lblStrmod = new JLabel(this.player.getData("strengthMod"));
		abilityPanel.add(lblStrmod, "cell 2 1,alignx center");
		
		JLabel lblAnimalHandling = new JLabel(this.player.getData("wisdomMod") + " : Animal Handling (WIS)");
		abilityPanel.add(lblAnimalHandling, "cell 6 1,alignx right");
		
		JLabel lblDexterity = new JLabel("Dexterity:");
		abilityPanel.add(lblDexterity, "cell 0 2");
		
		JLabel lblDexscr = new JLabel(this.player.getData("dexterityAbility"));
		abilityPanel.add(lblDexscr, "cell 1 2");
		
		JLabel lblDexmod = new JLabel(this.player.getData("dexterityMod"));
		abilityPanel.add(lblDexmod, "cell 2 2");
		
		JLabel lblStrength_1 = new JLabel(this.player.modLabelCreator("strength"));
		abilityPanel.add(lblStrength_1, "cell 4 2,alignx right");
		
		JLabel lblAthleticsstr = new JLabel(this.player.getData("strengthMod") + " : ATHLETICS (STR)");
		abilityPanel.add(lblAthleticsstr, "cell 6 2,alignx right");
		
		JLabel lblConstitution = new JLabel("Constitution:");
		abilityPanel.add(lblConstitution, "cell 0 3");
		
		JLabel lblConscr = new JLabel(this.player.getData("constitutionAbility"));
		abilityPanel.add(lblConscr, "cell 1 3");
		
		JLabel lblConmod = new JLabel(this.player.getData("consititutionMod"));
		abilityPanel.add(lblConmod, "cell 2 3");
		
		JLabel lblDexterity_1 = new JLabel(this.player.modLabelCreator("dexterity"));
		abilityPanel.add(lblDexterity_1, "cell 4 3,alignx right");
		
		JLabel lblIntelligence = new JLabel("Intelligence:");
		abilityPanel.add(lblIntelligence, "cell 0 4");
		
		JLabel lblIntscr = new JLabel(this.player.getData("intelligenceAbility"));
		abilityPanel.add(lblIntscr, "cell 1 4");
		
		JLabel lblIntmod = new JLabel(this.player.getData("intelligenceMod"));
		abilityPanel.add(lblIntmod, "cell 2 4");
		
		JLabel lblDeception = new JLabel(this.player.getData("charismaMod") + " : Deception (CHA)");
		abilityPanel.add(lblDeception, "cell 6 3,alignx right");
		
		JLabel lblConsititution = new JLabel(this.player.modLabelCreator("consititution"));
		abilityPanel.add(lblConsititution, "cell 4 4,alignx right");
		
		JLabel lblHistoryint = new JLabel(this.player.getData("intelligenceMod") + " : History (INT)");
		abilityPanel.add(lblHistoryint, "cell 6 4,alignx right");
		
		JLabel lblWisdom = new JLabel("Wisdom:");
		abilityPanel.add(lblWisdom, "cell 0 5");
		
		JLabel lblWisscr = new JLabel(this.player.getData("wisdomAbility"));
		abilityPanel.add(lblWisscr, "cell 1 5");
		
		JLabel lblWismod = new JLabel(this.player.getData("wisdomMod"));
		abilityPanel.add(lblWismod, "cell 2 5");
		
		JLabel lblWisdom_1 = new JLabel(this.player.modLabelCreator("wisdom"));
		abilityPanel.add(lblWisdom_1, "cell 4 5,alignx right");
		
		JLabel lblInsightwis = new JLabel(this.player.getData("wisdomMod") + " : Insight (WIS)");
		abilityPanel.add(lblInsightwis, "cell 6 5,alignx right");
		
		JLabel lblInterfacing = new JLabel("Interfacing:");
		abilityPanel.add(lblInterfacing, "cell 0 6");
		
		JLabel lblInterscr = new JLabel(this.player.getData("interfacingAbility"));
		abilityPanel.add(lblInterscr, "cell 1 6");
		
		JLabel lblIntermod = new JLabel(this.player.getData("interfacingMod"));
		abilityPanel.add(lblIntermod, "cell 2 6");
		
		JLabel lblInterfacing_1 = new JLabel(this.player.modLabelCreator("interfacing"));
		abilityPanel.add(lblInterfacing_1, "cell 4 6,alignx right");
		
		JLabel lblIntimidationcha = new JLabel(this.player.getData("charismaMod") + " : Intimidation (CHA)");
		abilityPanel.add(lblIntimidationcha, "cell 6 6,alignx right");
		
		JLabel lblCharisma = new JLabel("Charisma:");
		abilityPanel.add(lblCharisma, "cell 0 7");
		
		JLabel lblChrscr = new JLabel(this.player.getData("charismaAbility"));
		abilityPanel.add(lblChrscr, "cell 1 7");
		
		JLabel lblChrmod = new JLabel(this.player.getData("charismaMod"));
		abilityPanel.add(lblChrmod, "cell 2 7");
		
		JLabel lblCharisma_1 = new JLabel(this.player.modLabelCreator("charisma"));
		abilityPanel.add(lblCharisma_1, "cell 4 7,alignx right");
		
		JLabel lblInvestigationint = new JLabel(this.player.getData("intelligenceMod") + " : Investigation (INT)");
		abilityPanel.add(lblInvestigationint, "cell 6 7,alignx right");
		
		JLabel lblSavingThrows = new JLabel("SAVING THROWS");
		abilityPanel.add(lblSavingThrows, "cell 4 8,alignx center");
		
		JLabel lblMechanicsinf = new JLabel(this.player.getData("interfacingMod") + " : Mechanics (INF)");
		abilityPanel.add(lblMechanicsinf, "cell 6 8,alignx right");
		
		JLabel lblMedicinewis = new JLabel(this.player.getData("wisdomMod") + " : Medicine (WIS)");
		abilityPanel.add(lblMedicinewis, "cell 6 9,alignx right");
		
		JLabel lblNatureint = new JLabel(this.player.getData("intelligenceMod") + " : Nature (INT)");
		abilityPanel.add(lblNatureint, "cell 6 10,alignx right");
		
		JLabel lblPerceptionwis = new JLabel(this.player.getData("wisdomMod") + " : Perception (WIS)");
		abilityPanel.add(lblPerceptionwis, "cell 6 11,alignx right");
		
		JLabel lblPerformancecha = new JLabel(this.player.getData("charismaMod") + " : Performance (CHA)");
		abilityPanel.add(lblPerformancecha, "cell 6 12,alignx right");
		
		JLabel lblPersuasioncha = new JLabel(this.player.getData("charismaMod") + " : Persuasion (CHA)");
		abilityPanel.add(lblPersuasioncha, "cell 6 13,alignx right");
		
		JLabel lblProgramminginf = new JLabel(this.player.getData("interfacingMod") + " : Programming (INF)");
		abilityPanel.add(lblProgramminginf, "cell 6 14,alignx right");
		
		JLabel lblReligionint = new JLabel(this.player.getData("intelligenceMod") + " : Religion (INT)");
		abilityPanel.add(lblReligionint, "cell 6 15,alignx right");
		
		JLabel lblSleightOf = new JLabel(this.player.getData("dexterityMod") + " : Sleight of Hand (DEX)");
		abilityPanel.add(lblSleightOf, "cell 6 16,alignx right");

		JLabel lblNewLabel = new JLabel("Proficencies");
		bottomMainPanel.add(lblNewLabel, "cell 0 0,alignx center");
		
		JLabel lblHitDice = new JLabel("Hit Dice");
		bottomPanel.add(lblHitDice, "cell 0 0,alignx center");
		
		JLabel lblCurrentHitPoints = new JLabel("Current Hit Points: ");
		bottomPanel.add(lblCurrentHitPoints, "flowx,cell 1 0");
		
		JProgressBar healthBar = new JProgressBar();
		bottomPanel.add(healthBar, "cell 2 0");
		
		JLabel lblSpellcastingAbility = new JLabel("SpellCasting Ability: ");
		bottomPanel.add(lblSpellcastingAbility, "flowx,cell 3 0");
		
		JLabel lblDeathSave = new JLabel("Death Saves");
		bottomPanel.add(lblDeathSave, "cell 4 0");
		
		JLabel lblMaxHitPoints = new JLabel("Max Hit Points:");
		bottomPanel.add(lblMaxHitPoints, "flowx,cell 1 1");
		
		JLabel lblRevoAbilitySave = new JLabel("Revo Ability Save DC:");
		bottomPanel.add(lblRevoAbilitySave, "flowx,cell 3 1");
		
		JLabel lblSuccess = new JLabel("Success:");
		bottomPanel.add(lblSuccess, "flowx,cell 4 1");
		
		JLabel lblHitTotal = new JLabel("Hit Total: ");
		bottomPanel.add(lblHitTotal, "cell 0 2");
		
		JLabel lblRevoAbilityAttack = new JLabel("Revo Ability Attack Mod:");
		bottomPanel.add(lblRevoAbilityAttack, "flowx,cell 3 2");
		
		JLabel lblFailure = new JLabel("Failure:");
		bottomPanel.add(lblFailure, "flowx,cell 4 2,alignx trailing");
		
		JLabel label_1 = new JLabel("");
		bottomPanel.add(label_1, "cell 0 3");
		
		JLabel lblCurrentStaminaPoints = new JLabel("Current Stamina Points:");
		bottomPanel.add(lblCurrentStaminaPoints, "flowx,cell 1 3");
		
		JLabel lblMaxStaminaPoints = new JLabel("Max Stamina Points:");
		bottomPanel.add(lblMaxStaminaPoints, "flowx,cell 1 4");
		
		JLabel lblProficiencyBonus = new JLabel(" : Proficiency bonus");
		abilityPanel.add(lblProficiencyBonus, "cell 4 1,alignx right");
		
		JLabel lblStealthdex = new JLabel(this.player.getData("dexterityMod") + " : Stealth (DEX)");
		abilityPanel.add(lblStealthdex, "cell 6 17,alignx right");
		
		JLabel lblSurvivalwis = new JLabel(this.player.getData("wisdomMod") + " : Survival (WIS)");
		abilityPanel.add(lblSurvivalwis, "cell 6 18,alignx right");
		
		JLabel lblVehicleHandling = new JLabel(this.player.getData("interfacingMod") + " : Vehicle Handling (INF)");
		abilityPanel.add(lblVehicleHandling, "cell 6 19,alignx right");
		
		JLabel lblSkills = new JLabel("SKILLS");
		abilityPanel.add(lblSkills, "cell 6 20,alignx center");
		
		///////////////////////////////////////////////////////////
		// SCROLL PANELS
		//////////////////////////////////////////////////////////3
		
		JScrollPane scrollPane = new JScrollPane();
		bottomMainPanel.add(scrollPane, "cell 0 1,grow");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(100, 150));
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// TEXT FIELDS
		///////////////////////////////////////////////////////////////////////////////////////////
		
		JFormattedTextField formattedTextFieldMoney = new JFormattedTextField(this.player.getData("money"));
		formattedTextFieldMoney.setPreferredSize(new Dimension(80,20));
		headerPanel.add(formattedTextFieldMoney, "cell 0 1,alignx center");
		
		JFormattedTextField frmtdtxtfldXp = new JFormattedTextField();
		frmtdtxtfldXp.setPreferredSize(new Dimension(100, 20));
		frmtdtxtfldXp.setText("" + this.player.getXP());
		headerPanel.add(frmtdtxtfldXp, "cell 3 0");
		
		// Dependent on the XP text field
		JLabel lblLevel = new JLabel("Level: " + this.lvlCalc(Integer.parseInt(frmtdtxtfldXp.getText())));
		headerPanel.add(lblLevel, "cell 3 0");

		JTextField txtActextbox = new JTextField();
		headerPanel.add(txtActextbox, "cell 1 2");
		txtActextbox.setColumns(10);
		
		JTextField txtSpeedtextbox = new JTextField();
		headerPanel.add(txtSpeedtextbox, "cell 3 2");
		txtSpeedtextbox.setColumns(10);
		
		// TODO fix this...
		JTextField txtInspirationtextbox = new JTextField();
		abilityPanel.add(txtInspirationtextbox, "flowx,cell 4 0,alignx left");
		txtInspirationtextbox.setColumns(10);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		scrollPane.setViewportView(textArea_2);
		
		JTextField txtCurrenthittext = new JTextField();
		bottomPanel.add(txtCurrenthittext, "cell 1 0");
		txtCurrenthittext.setColumns(10);
		
		JTextField txtMaxhittext = new JTextField();
		bottomPanel.add(txtMaxhittext, "cell 1 1");
		txtMaxhittext.setColumns(10);
		
		JTextField txtStaminaPoints = new JTextField();
		bottomPanel.add(txtStaminaPoints, "cell 1 3");
		txtStaminaPoints.setColumns(10);
		
		JTextField txtMaxStaminaPoints = new JTextField();
		bottomPanel.add(txtMaxStaminaPoints, "cell 1 4");
		txtMaxStaminaPoints.setColumns(10);
		
		JTextField txtSpellcastingability = new JTextField();
		bottomPanel.add(txtSpellcastingability, "cell 3 0");
		txtSpellcastingability.setColumns(10);
		
		JTextField txtRevoabilitysavedc = new JTextField();
		bottomPanel.add(txtRevoabilitysavedc, "cell 3 1");
		txtRevoabilitysavedc.setColumns(10);
		
		JTextField txtRevoabilityattackmod = new JTextField();
		bottomPanel.add(txtRevoabilityattackmod, "cell 3 2");
		txtRevoabilityattackmod.setColumns(10);

		
		////////////////////////////////////////////////////////////////////
		// RADIO BUTTONS
		////////////////////////////////////////////////////////////////////
		JRadioButton rdbtnAcrrad = new JRadioButton();
		abilityPanel.add(rdbtnAcrrad, "cell 5 0");
		
		JRadioButton rdbtnAnihanrad = new JRadioButton();
		abilityPanel.add(rdbtnAnihanrad, "cell 5 1");

		JRadioButton rdbtnStrrad = new JRadioButton();
		abilityPanel.add(rdbtnStrrad, "cell 3 2");
		
		JRadioButton rdbtnAthrad = new JRadioButton();
		abilityPanel.add(rdbtnAthrad, "cell 5 2");
	
		JRadioButton rdbtnDexrad = new JRadioButton();
		abilityPanel.add(rdbtnDexrad, "cell 3 3");
		
		JRadioButton rdbtnDecrad = new JRadioButton();
		abilityPanel.add(rdbtnDecrad, "cell 5 3");
	
		JRadioButton rdbtnConrad = new JRadioButton();
		abilityPanel.add(rdbtnConrad, "cell 3 4");
		
		JRadioButton rdbtnHisrad = new JRadioButton();
		abilityPanel.add(rdbtnHisrad, "cell 5 4");
		
		JRadioButton rdbtnWisrad = new JRadioButton();
		abilityPanel.add(rdbtnWisrad, "cell 3 5");
		
		JRadioButton rdbtnInsrad = new JRadioButton();
		abilityPanel.add(rdbtnInsrad, "cell 5 5");
		
		JRadioButton rdbtnIntrad = new JRadioButton();
		abilityPanel.add(rdbtnIntrad, "cell 3 6");
		
		JRadioButton rdbtnIntrad_1 = new JRadioButton();
		abilityPanel.add(rdbtnIntrad_1, "cell 5 6");
		
		JRadioButton rdbtnCharad = new JRadioButton();
		abilityPanel.add(rdbtnCharad, "cell 3 7");
		
		JRadioButton rdbtnInvrad = new JRadioButton();
		abilityPanel.add(rdbtnInvrad, "cell 5 7");
		
		JRadioButton rdbtnMecrad = new JRadioButton();
		abilityPanel.add(rdbtnMecrad, "cell 5 8");
		
		JRadioButton rdbtnMedrad = new JRadioButton();
		abilityPanel.add(rdbtnMedrad, "cell 5 9");
		
		JRadioButton rdbtnNatrad = new JRadioButton();
		abilityPanel.add(rdbtnNatrad, "cell 5 10");
		
		JRadioButton rdbtnPerrad = new JRadioButton();
		abilityPanel.add(rdbtnPerrad, "cell 5 11");
		
		JRadioButton rdbtnPerfrad = new JRadioButton();
		abilityPanel.add(rdbtnPerfrad, "cell 5 12");
		
		JRadioButton rdbtnPersrad = new JRadioButton();
		abilityPanel.add(rdbtnPersrad, "cell 5 13");
		
		JRadioButton rdbtnProrad = new JRadioButton();
		abilityPanel.add(rdbtnProrad, "cell 5 14");
		
		JRadioButton rdbtnRelrad = new JRadioButton();
		abilityPanel.add(rdbtnRelrad, "cell 5 15");
		
		JRadioButton rdbtnSlerad = new JRadioButton();
		abilityPanel.add(rdbtnSlerad, "cell 5 16");
		
		JRadioButton rdbtnSuccess = new JRadioButton();
		bottomPanel.add(rdbtnSuccess, "cell 4 1");
		
		JRadioButton rdbtnSuccess_1 = new JRadioButton();
		bottomPanel.add(rdbtnSuccess_1, "cell 4 1");
		
		JRadioButton rdbtnSuccess_2 = new JRadioButton();
		bottomPanel.add(rdbtnSuccess_2, "cell 4 1");
		
		JRadioButton rdbtnFailure = new JRadioButton();
		bottomPanel.add(rdbtnFailure, "cell 4 2,alignx trailing");
		
		JRadioButton rdbtnFailure_1 = new JRadioButton();
		bottomPanel.add(rdbtnFailure_1, "cell 4 2,alignx trailing");
		
		JRadioButton rdbtnFailure_2 = new JRadioButton();
		bottomPanel.add(rdbtnFailure_2, "cell 4 2,alignx trailing");
		
		JRadioButton rdbtnSterad = new JRadioButton();
		abilityPanel.add(rdbtnSterad, "cell 5 17");

		JRadioButton rdbtnSurvrad = new JRadioButton();
		abilityPanel.add(rdbtnSurvrad, "cell 5 18");
		
		JRadioButton rdbtnVehrad = new JRadioButton();
		abilityPanel.add(rdbtnVehrad, "cell 5 19");
		
		///////////////////////////////////////////////////////////////////
		// BUTTON MAP
		///////////////////////////////////////////////////////////////////
		
		buttonMap.put(lblAcrobatics, rdbtnAcrrad);
		buttonMap.put(lblAnimalHandling, rdbtnAnihanrad);
		buttonMap.put(lblStrength_1, rdbtnStrrad);
		buttonMap.put(lblAthleticsstr, rdbtnAthrad);
		buttonMap.put(lblDexterity_1, rdbtnDexrad);	
		buttonMap.put(lblDeception, rdbtnDecrad);
		buttonMap.put(lblConsititution, rdbtnConrad);
		buttonMap.put(lblHistoryint, rdbtnHisrad);
		buttonMap.put(lblWisdom_1, rdbtnWisrad);
		buttonMap.put(lblInsightwis, rdbtnInsrad);
		buttonMap.put(lblInterfacing_1, rdbtnIntrad);
		buttonMap.put(lblIntimidationcha, rdbtnIntrad_1);
		buttonMap.put(lblCharisma_1, rdbtnCharad);
		buttonMap.put(lblInvestigationint, rdbtnInvrad);
		buttonMap.put(lblMechanicsinf, rdbtnMecrad);
		buttonMap.put(lblMedicinewis, rdbtnMedrad);
		buttonMap.put(lblNatureint, rdbtnNatrad);
		buttonMap.put(lblPerceptionwis, rdbtnPerrad);	
		buttonMap.put(lblPerformancecha, rdbtnPerfrad);	
		buttonMap.put(lblPersuasioncha, rdbtnPersrad);
		buttonMap.put(lblProgramminginf, rdbtnProrad);
		buttonMap.put(lblReligionint, rdbtnRelrad);
		buttonMap.put(lblSleightOf, rdbtnSlerad);
		buttonMap.put(lblStealthdex, rdbtnSterad);	
		buttonMap.put(lblSurvivalwis, rdbtnSurvrad);
		buttonMap.put(lblVehicleHandling, rdbtnVehrad);

		// List of Item in Hit Dice Box
		String[] diceChoices = { "D4" , "D6", "D8" , "D10", "D12"};
		JComboBox<Object> comboBox = new JComboBox<Object>(diceChoices);
		bottomPanel.add(comboBox, "cell 0 1,growx");
	
		JProgressBar staminaBar = new JProgressBar();
		bottomPanel.add(staminaBar, "cell 2 3");
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		String data[][] = new String[][]{{"","","","","",""},
										{"","","","","",""},
										{"","","","","",""},
										{"","","","","",""},
										{"","","","","",""},
										{"","","","","",""},
										{"","","","","",""},
										{"","","","","",""}};
		String column[] = new String[]{"Weapon Name", "+ To Hit", "Dmg", "Mod", "Ammo","Dmg Type"};
		
		JTable table_2 = new JTable(data,column);
		
		table_2.getColumnModel().getColumn(0).setPreferredWidth(300);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(25);
		
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		panel_5.add(scrollPane_1, "cell 0 0,grow");
		scrollPane_1.setViewportView(table_2);
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		
		JTextField txtChangeabletitle_1 = new JTextField();
		txtChangeabletitle_1.setText("Changeable Title");
		
		panel_1.add(txtChangeabletitle_1, "cell 0 0,growx");
		txtChangeabletitle_1.setColumns(10);
		
		JTextField txtChangeabletitle = new JTextField();
		txtChangeabletitle.setText("Changeable Title");
		panel_1.add(txtChangeabletitle, "cell 1 0,growx");
		txtChangeabletitle.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_1.add(scrollPane_2, "cell 0 1,grow");
		
		JTextArea textPane = new JTextArea();
		textPane.setLineWrap(true);
		scrollPane_2.setViewportView(textPane);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_1.add(scrollPane_3, "cell 1 1,grow");
		
		JTextArea textPane_1 = new JTextArea();
		textPane_1.setLineWrap(true);
		scrollPane_3.setViewportView(textPane_1);
		
		JTextField txtProficiencybonustextbox = new JTextField();
		abilityPanel.add(txtProficiencybonustextbox, "flowx,cell 4 1,alignx right");
		txtProficiencybonustextbox.setColumns(10);
		
		//////////////////////////////////////////////////////////////
		// LISTENERS
		/////////////////////////////////////////////////////////////
		
		// XP text box
//		frmtdtxtfldXp.getDocument().addDocumentListener(new XpListener(frmtdtxtfldXp, lblLevel, lvlExp));
//		frmtdtxtfldXp.getDocument().addDocumentListener(new DocumentListener(){
//
//			@Override
//			public void changedUpdate(DocumentEvent arg0) {
//				// Don't need
//			}
//
//			@Override
//			public void insertUpdate(DocumentEvent arg0) {
//				if(!frmtdtxtfldXp.getText().equals("")){
//					int lvl;
//					try {
//						lvl = lvlCalc(Integer.parseUnsignedInt(frmtdtxtfldXp.getText()));
//					}catch (NumberFormatException e){
//						lvl = 19;
//					}
//					
//					lblLevel.setText("Level: " + lvl);
//				}
//
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent arg0) {
//				if(!frmtdtxtfldXp.getText().equals("")){
//					int lvl;
//					try {
//						lvl = lvlCalc(Integer.parseUnsignedInt(frmtdtxtfldXp.getText()));
//					}catch (NumberFormatException e){
//						lvl = 19;
//					}
//					lblLevel.setText("Level: " + lvl);
//				}
//
//				
//			}});
		
		// TODO fix this duplicate code.
//		txtProficiencybonustextbox.getDocument().addDocumentListener(new DocumentListener(){
//
//			int lastNumber;
//			
//			@Override
//			public void changedUpdate(DocumentEvent arg0) {
//				// don't need
//			}
//
//			// Remove this code duplication eventually
//			@Override
//			public void insertUpdate(DocumentEvent arg0) {
//				String bonus = txtProficiencybonustextbox.getText();
//				
//				for(JLabel key: buttonMap.keySet()){
//					if(buttonMap.get(key).isSelected()){
//						
//						String txt = key.getText();
//						String num = txt.replaceAll("[\\D]", "");
//						
//						if(txt.startsWith("-")){
//							num = "-" + num;
//						}
//						
//						String newTxt = txt.replaceAll(num, "");
//
//						int numberConverted = Integer.parseInt(num);
//						
//						int bonusNum;
//						
//						try{
//							bonusNum = Integer.parseInt(bonus);
//						}catch(NumberFormatException exp){
//							JOptionPane.showMessageDialog(frame, "Please make sure that the Proficency Bonus text box is a valid int!");
//							return;
//						}
//						
//						key.setText((numberConverted + bonusNum) + newTxt);
//						
//					}
//	
//				}
//				
//				lastNumber = Integer.parseInt(bonus);
//				
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent arg0) {
//				String bonus = txtProficiencybonustextbox.getText();
//				int numberConverted;
//				for(JLabel key: buttonMap.keySet()){
//					
//					if(buttonMap.get(key).isSelected()){
//						String txt = key.getText();
//						String num = txt.replaceAll("[\\D]", "");
//						if(txt.startsWith("-")){
//							num = "-" + num;
//						}
//		
//						numberConverted = Integer.parseInt(num);
//	
//						String newTxt = txt.replaceAll(num, "");
//						
//						int bonusNum;
//						try{
//							if(bonus.equals("")){
//								bonusNum = lastNumber;
//							}else{
//								bonusNum = Integer.parseInt(bonus);
//							}
//						}catch(NumberFormatException exp){
//							JOptionPane.showMessageDialog(frame, "Please make sure that the Proficency Bonus text box is a valid int!");
//							return;
//						}
//
//						key.setText((numberConverted - bonusNum) + newTxt);
//
//					}
//				
//			}
//
//				
//			}});

		// attach the radio listener to each radio button
//		for(JLabel key: buttonMap.keySet()){
//			buttonMap.get(key).addActionListener(new RadioListener(key, txtProficiencybonustextbox, buttonMap.get(key), this.frame)) ;
//			
//		}		
		
		
		
		
//		MigLayout layoutTest = (MigLayout) this.frame.getContentPane().getLayout();
//	     Object constraintsForNamePanel = layout.getComponentConstraints(lblConsititution);
//	     constraintsForNamePanel.
//	     pane.remove(this.namePanel);
//
//	      this.namePanel = newNamePanel;
//	      pane.add(newNamePanel, constraintsForNamePanel);		
//		
	}
	
	/**
	 *  Used to check the level based on the level arraylist and the amount typed in.
	 */
	public int lvlCalc(int xpAmount){
		int lvl = 0;
		
		for(int i = 0; i <= this.lvlExp.size() - 1; i++){
			if((i + 1) == 20){ // check the end
				lvl = i;
				return lvl;
			}
			if(xpAmount >= this.lvlExp.get(i) && xpAmount < this.lvlExp.get(i + 1)){
				lvl = i + 1;
				return lvl;
			}
		}
		return lvl;
	}

}

