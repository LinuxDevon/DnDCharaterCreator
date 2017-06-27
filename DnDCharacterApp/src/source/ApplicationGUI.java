package source;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;

/**
 * 
 * @author Devon Adair
 *
 *
 *
 * Changes eventually:
 * 
 * make method in character to handle this: this.player.getData(variable)": Strength"
 */
public class ApplicationGUI {
	
	public static final String VERSION = "Beta 1.0";

	private JFrame frame;
	private Character player = null;
	private JTable table;
	private JTable table_1;
	
	private NewCharacterWindow dialog;
	private JTable table_2;
	
	private FileIO fileManager;
	private JTextField txtChangeabletitle_1;
	private JTextField txtChangeabletitle;
	private JTextField txtActextbox;
	private JTextField txtSpeedtextbox;
	private JTextField txtProficiencybonustextbox;
	private JTextField txtInspirationtextbox;
	
	private HashMap<JLabel, JRadioButton> buttonMap = new HashMap<>();
	private JTextField txtCurrenthittext;
	private JTextField txtMaxhittext;


	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ApplicationGUI() {
//		this.player = new Character("", 0, null);
//		initialize(player);
		initializeOptionPanel();
	}
	
	/**
	 * 
	 */
	
	public void initializeOptionPanel(){
		
		String characterName;
		int xpAmount;
		HashMap<String, String> data = new HashMap<>();
		
		if (JOptionPane.showConfirmDialog(null, "Do you want to create a new character?", "New Character?",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			

			dialog = new NewCharacterWindow(this.frame, this.player, this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setAutoRequestFocus(true);
			dialog.setAlwaysOnTop(true);

			
			
		} else {
			// need to make a template and load it when the load feature is implemented
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
	 * @param player2 
	 */
	public void initialize(Character player2) {
		
		this.player = player2;
//		System.out.println(this.player.getXP());
		// Verify that the correct folders and files are in place.
		fileManager = new FileIO();
		
		fileManager.check();
		fileManager.saveCharacter("temp");
		
		// Create the app
		frame = new JFrame();
		
//		initializeOptionPanel();
		
		
		frame.setBounds(100, 100, 1547, 1027);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
				
				// need to add file checking to make sure there is no overwriting
				
//				while(true){
					String fileName = (String) JOptionPane.showInputDialog(frame,"Please enter the file name you wish to save.");
//					try{
						fileManager.saveCharacter(fileName);
//					}
//				}
				
			}});
		
		JMenuItem load = new JMenuItem("Load");
		mnFile.add(load);
		
		load.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Loading");
				
			}});
		
		JMenuItem newChar = new JMenuItem("New Character");
		mnFile.add(newChar);
		
		JMenu mnReference = new JMenu("Reference");
		menuBar.add(mnReference);
		
		JMenuItem spellBook = new JMenuItem("Spell Book Website");
		mnReference.add(spellBook);
		
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
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenu mnEditCharacter = new JMenu("Edit Character");
		menuBar.add(mnEditCharacter);
		
		JMenu mnUpdate = new JMenu("Update");
		menuBar.add(mnUpdate);
		
		JMenuItem version = new JMenuItem("version");
		mnUpdate.add(version);
		
		version.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, VERSION);
				
			}});
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[144px,grow][75px,grow][150px,grow][100px,grow][]", "[30px][30px][30px]"));
		
//		String characterName = null;
//		String className = null;
		
		/////////////////////////////////////////////////////////////////////////
		// Header of the APP
		JLabel lblNewLabel_3 = new JLabel("Class: " + this.player.getData("class"));
		panel.add(lblNewLabel_3, "cell 1 0,alignx center");
		
		JLabel lblRank = new JLabel("Rank: " + this.player.getData("rank"));
		panel.add(lblRank, "cell 2 0,alignx center");
		
//		System.out.println(this.player.getName());
		JLabel lblXp = new JLabel("XP: ");
		panel.add(lblXp, "flowx,cell 3 0,alignx center");
		
		JLabel lblMoney = new JLabel("Money: " );
		panel.add(lblMoney, "flowx,cell 0 1");
		
		JLabel lblSpecies = new JLabel("Species: " + this.player.getData("species"));
		panel.add(lblSpecies, "cell 1 1,alignx center");
		
		JLabel lblMutLvl = new JLabel("MUT LVL / HUM VARIANT: " + this.player.getData("variant"));
		panel.add(lblMutLvl, "cell 2 1,alignx center");
		
		JLabel lblAgentNumber = new JLabel("Agent Number: " + this.player.getData("AgentNumber") );
		panel.add(lblAgentNumber, "cell 3 1,alignx center");
		JLabel labelCharacterName = new JLabel("Character Name: " + this.player.getName() );
		panel.add(labelCharacterName, "cell 0 0");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setPreferredSize(new Dimension(80,20));
		panel.add(formattedTextField, "cell 0 1,alignx center");
		
		JLabel lblAc = new JLabel("AC:");
		panel.add(lblAc, "flowx,cell 1 2,alignx center");
		
		JLabel lblInitiative = new JLabel("INITIATIVE: " + this.player.getData("dexterityMod"));
		panel.add(lblInitiative, "cell 2 2,alignx center");
		
		JLabel lblSpeed = new JLabel("SPEED:");
		panel.add(lblSpeed, "flowx,cell 3 2,alignx center");
		
		JFormattedTextField frmtdtxtfldXp = new JFormattedTextField();
		frmtdtxtfldXp.setPreferredSize(new Dimension(100, 20));
		frmtdtxtfldXp.setText("" + this.player.getXP());
		panel.add(frmtdtxtfldXp, "cell 3 0");
		
		txtActextbox = new JTextField();
		panel.add(txtActextbox, "cell 1 2");
		txtActextbox.setColumns(10);
		
		txtSpeedtextbox = new JTextField();
		panel.add(txtSpeedtextbox, "cell 3 2");
		txtSpeedtextbox.setColumns(10);
		
		JLabel lblLevel = new JLabel("Level:");
		panel.add(lblLevel, "cell 3 0");
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Left side with ability score, saving throws, and skills
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		MigLayout layout = new MigLayout("", "[65px,center][65px,center][65px,center][20px][200px][20px][175px]", "[30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][25px,center][25px,center][25px,center]");
		
		panel_3.setLayout(layout);
		
		JLabel lblAbility = new JLabel("Ability");
		panel_3.add(lblAbility, "cell 0 0");
		
		JLabel lblAbilityScore = new JLabel("Ability Score");
		panel_3.add(lblAbilityScore, "cell 1 0");
		
		JLabel lblModifier = new JLabel("Modifier");
		panel_3.add(lblModifier, "cell 2 0");
		
		txtInspirationtextbox = new JTextField();
		panel_3.add(txtInspirationtextbox, "flowx,cell 4 0,alignx right");
		txtInspirationtextbox.setColumns(10);
		
		JLabel lblInspiration = new JLabel(" : Inspiration");
		panel_3.add(lblInspiration, "cell 4 0,alignx right");
		
		JRadioButton rdbtnAcrrad = new JRadioButton();
		panel_3.add(rdbtnAcrrad, "cell 5 0");
		
		JLabel lblAcrobatics = new JLabel(this.player.getData("dexterityMod") + " : Acrobatics (DEX)");
		panel_3.add(lblAcrobatics, "cell 6 0,alignx right");
		
		buttonMap.put(lblAcrobatics, rdbtnAcrrad);
		
		JLabel lblStrength = new JLabel("Strength: ");
		panel_3.add(lblStrength, "cell 0 1");
		
		JLabel lblStrscr = new JLabel(this.player.getData("strengthAbility"));
		panel_3.add(lblStrscr, "cell 1 1");
		
//		System.out.println(this.player.getData("strengthMod"));
		JLabel lblStrmod = new JLabel(this.player.getData("strengthMod"));
		panel_3.add(lblStrmod, "cell 2 1,alignx center");
		
		JRadioButton rdbtnAnihanrad = new JRadioButton();
		panel_3.add(rdbtnAnihanrad, "cell 5 1");
		
		JLabel lblAnimalHandling = new JLabel(this.player.getData("wisdomMod") + " : Animal Handling (WIS)");
		panel_3.add(lblAnimalHandling, "cell 6 1,alignx right");
		
		buttonMap.put(lblAnimalHandling, rdbtnAnihanrad);
		
		JLabel lblDexterity = new JLabel("Dexterity:");
		panel_3.add(lblDexterity, "cell 0 2");
		
		JLabel lblDexscr = new JLabel(this.player.getData("dexterityAbility"));
		panel_3.add(lblDexscr, "cell 1 2");
		
		JLabel lblDexmod = new JLabel(this.player.getData("dexterityMod"));
		panel_3.add(lblDexmod, "cell 2 2");
		
		JRadioButton rdbtnStrrad = new JRadioButton();
		panel_3.add(rdbtnStrrad, "cell 3 2");
		
		JLabel lblStrength_1 = new JLabel(this.player.modLabelCreator("strength"));
		panel_3.add(lblStrength_1, "cell 4 2,alignx right");
		
		buttonMap.put(lblStrength_1, rdbtnStrrad);
		
		
		JRadioButton rdbtnAthrad = new JRadioButton();
		panel_3.add(rdbtnAthrad, "cell 5 2");
		
		JLabel lblAthleticsstr = new JLabel(this.player.getData("strengthMod") + " : ATHLETICS (STR)");
		panel_3.add(lblAthleticsstr, "cell 6 2,alignx right");
		
		buttonMap.put(lblAthleticsstr, rdbtnAthrad);
		
		JLabel lblConstitution = new JLabel("Constitution:");
		panel_3.add(lblConstitution, "cell 0 3");
		
		JLabel lblConscr = new JLabel(this.player.getData("constitutionAbility"));
		panel_3.add(lblConscr, "cell 1 3");
		
		JLabel lblConmod = new JLabel(this.player.getData("consititutionMod"));
		panel_3.add(lblConmod, "cell 2 3");
		
		JRadioButton rdbtnDexrad = new JRadioButton();
		panel_3.add(rdbtnDexrad, "cell 3 3");
		
		JLabel lblDexterity_1 = new JLabel(this.player.modLabelCreator("dexterity"));
		panel_3.add(lblDexterity_1, "cell 4 3,alignx right");
		
		buttonMap.put(lblDexterity_1, rdbtnDexrad);
		
		JRadioButton rdbtnDecrad = new JRadioButton();
		panel_3.add(rdbtnDecrad, "cell 5 3");
		
		
		JLabel lblDeception = new JLabel(this.player.getData("charismaMod") + " : Deception (CHA)");
		panel_3.add(lblDeception, "cell 6 3,alignx right");
		
		buttonMap.put(lblDeception, rdbtnDecrad);
		
		JLabel lblIntelligence = new JLabel("Intelligence:");
		panel_3.add(lblIntelligence, "cell 0 4");
		
		JLabel lblIntscr = new JLabel(this.player.getData("intelligenceAbility"));
		panel_3.add(lblIntscr, "cell 1 4");
		
		JLabel lblIntmod = new JLabel(this.player.getData("intelligenceMod"));
		panel_3.add(lblIntmod, "cell 2 4");
		
		JRadioButton rdbtnConrad = new JRadioButton();
		panel_3.add(rdbtnConrad, "cell 3 4");
		
		JLabel lblConsititution = new JLabel(this.player.modLabelCreator("consititution"));
		panel_3.add(lblConsititution, "cell 4 4,alignx right");
		
		buttonMap.put(lblConsititution, rdbtnConrad);
		
		JRadioButton rdbtnHisrad = new JRadioButton();
		panel_3.add(rdbtnHisrad, "cell 5 4");
		
		JLabel lblHistoryint = new JLabel(this.player.getData("intelligenceMod") + " : History (INT)");
		panel_3.add(lblHistoryint, "cell 6 4,alignx right");
		
		buttonMap.put(lblHistoryint, rdbtnHisrad);
		
		JLabel lblWisdom = new JLabel("Wisdom:");
		panel_3.add(lblWisdom, "cell 0 5");
		
		JLabel lblWisscr = new JLabel(this.player.getData("wisdomAbility"));
		panel_3.add(lblWisscr, "cell 1 5");
		
		JLabel lblWismod = new JLabel(this.player.getData("wisdomMod"));
		panel_3.add(lblWismod, "cell 2 5");
		
		JRadioButton rdbtnWisrad = new JRadioButton();
		panel_3.add(rdbtnWisrad, "cell 3 5");
		
		JLabel lblWisdom_1 = new JLabel(this.player.modLabelCreator("wisdom"));
		panel_3.add(lblWisdom_1, "cell 4 5,alignx right");
		
		buttonMap.put(lblWisdom_1, rdbtnWisrad);
		
		JRadioButton rdbtnInsrad = new JRadioButton();
		panel_3.add(rdbtnInsrad, "cell 5 5");
		
		JLabel lblInsightwis = new JLabel(this.player.getData("wisdomMod") + " : Insight (WIS)");
		panel_3.add(lblInsightwis, "cell 6 5,alignx right");
		
		buttonMap.put(lblInsightwis, rdbtnInsrad);
		
		JLabel lblInterfacing = new JLabel("Interfacing:");
		panel_3.add(lblInterfacing, "cell 0 6");
		
		JLabel lblInterscr = new JLabel(this.player.getData("interfacingAbility"));
		panel_3.add(lblInterscr, "cell 1 6");
		
		JLabel lblIntermod = new JLabel(this.player.getData("interfacingMod"));
		panel_3.add(lblIntermod, "cell 2 6");
		
		JRadioButton rdbtnIntrad = new JRadioButton();
		panel_3.add(rdbtnIntrad, "cell 3 6");
		
		JLabel lblInterfacing_1 = new JLabel(this.player.modLabelCreator("interfacing"));
		panel_3.add(lblInterfacing_1, "cell 4 6,alignx right");
		
		buttonMap.put(lblInterfacing_1, rdbtnIntrad);
		
		JRadioButton rdbtnIntrad_1 = new JRadioButton();
		panel_3.add(rdbtnIntrad_1, "cell 5 6");
		
		JLabel lblIntimidationcha = new JLabel(this.player.getData("charismaMod") + " : Intimidation (CHA)");
		panel_3.add(lblIntimidationcha, "cell 6 6,alignx right");
		
		buttonMap.put(lblIntimidationcha, rdbtnIntrad_1);
		
		JLabel lblCharisma = new JLabel("Charisma:");
		panel_3.add(lblCharisma, "cell 0 7");
		
		JLabel lblChrscr = new JLabel(this.player.getData("charismaAbility"));
		panel_3.add(lblChrscr, "cell 1 7");
		
		JLabel lblChrmod = new JLabel(this.player.getData("charismaMod"));
		panel_3.add(lblChrmod, "cell 2 7");
		
		JRadioButton rdbtnCharad = new JRadioButton();
		panel_3.add(rdbtnCharad, "cell 3 7");
		
		JLabel lblCharisma_1 = new JLabel(this.player.modLabelCreator("charisma"));
		panel_3.add(lblCharisma_1, "cell 4 7,alignx right");
		
		buttonMap.put(lblCharisma_1, rdbtnCharad);
		
		JRadioButton rdbtnInvrad = new JRadioButton();
		panel_3.add(rdbtnInvrad, "cell 5 7");
		
		JLabel lblInvestigationint = new JLabel(this.player.getData("intelligenceMod") + " : Investigation (INT)");
		panel_3.add(lblInvestigationint, "cell 6 7,alignx right");
		
		buttonMap.put(lblInvestigationint, rdbtnInvrad);
		
		JLabel lblSavingThrows = new JLabel("SAVING THROWS");
		panel_3.add(lblSavingThrows, "cell 4 8,alignx center");
		
		JRadioButton rdbtnMecrad = new JRadioButton();
		panel_3.add(rdbtnMecrad, "cell 5 8");
		
		JLabel lblMechanicsinf = new JLabel(this.player.getData("interfacingMod") + " : Mechanics (INF)");
		panel_3.add(lblMechanicsinf, "cell 6 8,alignx right");
		
		buttonMap.put(lblMechanicsinf, rdbtnMecrad);
		
		JRadioButton rdbtnMedrad = new JRadioButton();
		panel_3.add(rdbtnMedrad, "cell 5 9");
		
		JLabel lblMedicinewis = new JLabel(this.player.getData("wisdomMod") + " : Medicine (WIS)");
		panel_3.add(lblMedicinewis, "cell 6 9,alignx right");
		
		buttonMap.put(lblMedicinewis, rdbtnMedrad);
		
		JRadioButton rdbtnNatrad = new JRadioButton();
		panel_3.add(rdbtnNatrad, "cell 5 10");
		
		JLabel lblNatureint = new JLabel(this.player.getData("intelligenceMod") + " : Nature (INT)");
		panel_3.add(lblNatureint, "cell 6 10,alignx right");
		
		buttonMap.put(lblNatureint, rdbtnNatrad);
		
		JRadioButton rdbtnPerrad = new JRadioButton();
		panel_3.add(rdbtnPerrad, "cell 5 11");
		
		JLabel lblPerceptionwis = new JLabel(this.player.getData("wisdomMod") + " : Perception (WIS)");
		panel_3.add(lblPerceptionwis, "cell 6 11,alignx right");
		
		buttonMap.put(lblPerceptionwis, rdbtnPerrad);
		
		JRadioButton rdbtnPerfrad = new JRadioButton();
		panel_3.add(rdbtnPerfrad, "cell 5 12");
		
		JLabel lblPerformancecha = new JLabel(this.player.getData("charismaMod") + " : Performance (CHA)");
		panel_3.add(lblPerformancecha, "cell 6 12,alignx right");
		
		buttonMap.put(lblPerformancecha, rdbtnPerfrad);
		
		JRadioButton rdbtnPersrad = new JRadioButton();
		panel_3.add(rdbtnPersrad, "cell 5 13");
		
		JLabel lblPersuasioncha = new JLabel(this.player.getData("charismaMod") + " : Persuasion (CHA)");
		panel_3.add(lblPersuasioncha, "cell 6 13,alignx right");
		
		buttonMap.put(lblPersuasioncha, rdbtnPersrad);
		
		JRadioButton rdbtnSterad = new JRadioButton();
		panel_3.add(rdbtnSterad, "cell 3 14");
		
		JLabel lblStealthdex = new JLabel(this.player.getData("dexterityMod") + " : Stealth (DEX)");
		panel_3.add(lblStealthdex, "cell 4 14,alignx right");
		
		buttonMap.put(lblStealthdex, rdbtnSterad);
		
		JRadioButton rdbtnProrad = new JRadioButton();
		panel_3.add(rdbtnProrad, "cell 5 14");
		
		JLabel lblProgramminginf = new JLabel(this.player.getData("interfacingMod") + " : Programming (INF)");
		panel_3.add(lblProgramminginf, "cell 6 14,alignx right");
		
		buttonMap.put(lblProgramminginf, rdbtnProrad);
		
		JRadioButton rdbtnSurvrad = new JRadioButton();
		panel_3.add(rdbtnSurvrad, "cell 3 15");
		
		JLabel lblSurvivalwis = new JLabel(this.player.getData("wisdomMod") + " : Survival (WIS)");
		panel_3.add(lblSurvivalwis, "cell 4 15,alignx right");
		
		buttonMap.put(lblSurvivalwis, rdbtnSurvrad);
		
		JRadioButton rdbtnRelrad = new JRadioButton();
		panel_3.add(rdbtnRelrad, "cell 5 15");
		
		JLabel lblReligionint = new JLabel(this.player.getData("intelligenceMod") + " : Religion (INT)");
		panel_3.add(lblReligionint, "cell 6 15,alignx right");
		
		buttonMap.put(lblReligionint, rdbtnRelrad);
		
		JRadioButton rdbtnVehrad = new JRadioButton();
		panel_3.add(rdbtnVehrad, "cell 3 16");
		
		JLabel lblVehicleHandling = new JLabel(this.player.getData("interfacingMod") + " : Vehicle Handling (INF)");
		panel_3.add(lblVehicleHandling, "cell 4 16,alignx right");
		
		buttonMap.put(lblVehicleHandling, rdbtnVehrad);
		
		JRadioButton rdbtnSlerad = new JRadioButton();
		panel_3.add(rdbtnSlerad, "cell 5 16");
		
		JLabel lblSleightOf = new JLabel(this.player.getData("dexterityMod") + " : Sleight of Hand (DEX)");
		panel_3.add(lblSleightOf, "cell 6 16,alignx right");
		
		buttonMap.put(lblSleightOf, rdbtnSlerad);
		
		JLabel label = new JLabel("SKILLS");
		panel_3.add(label, "cell 4 17,alignx center");
		
		JLabel lblSkills = new JLabel("SKILLS");
		panel_3.add(lblSkills, "cell 6 17,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(100,300));
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new MigLayout("", "[:10px:300px,grow,left][grow]", "[][10px,grow]"));
		
		JLabel lblNewLabel = new JLabel("Proficencies");
		panel_4.add(lblNewLabel, "cell 0 0,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, "cell 0 1,grow");
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		scrollPane.setViewportView(textArea_2);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new MigLayout("", "[60px][200px]", "[40px][40px][40px][]"));
		
		JLabel lblHitDice = new JLabel("Hit Dice");
		panel_2.add(lblHitDice, "cell 0 0,alignx center");
		
		// List of Item in Hit Dice Box
		String[] diceChoices = { "D4" , "D6", "D8" , "D10", "D12"};
		
		JLabel lblCurrentHitPoints = new JLabel("Current Hit Points: ");
		panel_2.add(lblCurrentHitPoints, "flowx,cell 1 0");
		JComboBox comboBox = new JComboBox(diceChoices);
		panel_2.add(comboBox, "cell 0 1,growx");
		
		JLabel lblMaxHitPoints = new JLabel("Max Hit Points:");
		panel_2.add(lblMaxHitPoints, "flowx,cell 1 1");
		
		JLabel lblHitTotal = new JLabel("Hit Total: ");
		panel_2.add(lblHitTotal, "cell 0 2");
		
		JLabel label_1 = new JLabel("");
		panel_2.add(label_1, "cell 0 3");
		
		txtCurrenthittext = new JTextField();
//		txtCurrenthittext.setText("CurrentHitText");
		panel_2.add(txtCurrenthittext, "cell 1 0");
		txtCurrenthittext.setColumns(10);
		
		txtMaxhittext = new JTextField();
//		txtMaxhittext.setText("MaxHitText");
		panel_2.add(txtMaxhittext, "cell 1 1");
		txtMaxhittext.setColumns(10);
		
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(100, 150));
		panel_5.add(scrollPane_1, "cell 0 0,grow");
		table_2 = new JTable(data,column);
//		table_2.setPreferredSize(new Dimension(100,100));
		
		table_2.getColumnModel().getColumn(0).setPreferredWidth(300);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(25);
		
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		scrollPane_1.setViewportView(table_2);
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		
		txtChangeabletitle_1 = new JTextField();
		txtChangeabletitle_1.setText("Changeable Title");
		
		panel_1.add(txtChangeabletitle_1, "cell 0 0,growx");
		txtChangeabletitle_1.setColumns(10);
		
		txtChangeabletitle = new JTextField();
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
		
		txtProficiencybonustextbox = new JTextField();
		panel_3.add(txtProficiencybonustextbox, "flowx,cell 4 1,alignx right");
		txtProficiencybonustextbox.setColumns(10);
		
		txtProficiencybonustextbox.getDocument().addDocumentListener(new DocumentListener(){

			int lastNumber;
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			// Remove this code duplication eventually
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				String bonus = txtProficiencybonustextbox.getText();
				
				for(JLabel key: buttonMap.keySet()){
					if(buttonMap.get(key).isSelected()){
						String txt = key.getText();
						String num = txt.replaceAll("[\\D]", "");
						if(txt.startsWith("-")){
							num = "-" + num;
						}
						String newTxt = txt.replaceAll(num, "");

						int numberConverted = Integer.parseInt(num);
						
						int bonusNum;
						try{
							bonusNum = Integer.parseInt(bonus);
						}catch(NumberFormatException exp){
							JOptionPane.showMessageDialog(frame, "Please make sure that the Proficency Bonus text box is a valid int!");
							return;
						}

						
						
						key.setText((numberConverted + bonusNum) + newTxt);

					}
				
				}
				lastNumber = Integer.parseInt(bonus);
				System.out.println(lastNumber);
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				String bonus = txtProficiencybonustextbox.getText();
				int numberConverted;
				for(JLabel key: buttonMap.keySet()){
					
					if(buttonMap.get(key).isSelected()){
						String txt = key.getText();
						String num = txt.replaceAll("[\\D]", "");
						if(txt.startsWith("-")){
							num = "-" + num;
						}
		
						numberConverted = Integer.parseInt(num);
	
						String newTxt = txt.replaceAll(num, "");
						
						int bonusNum;
						try{
							if(bonus.equals("")){
								bonusNum = lastNumber;
								System.out.println(bonusNum);
							}else{
								bonusNum = Integer.parseInt(bonus);
							}
							
						}catch(NumberFormatException exp){
							JOptionPane.showMessageDialog(frame, "Please make sure that the Proficency Bonus text box is a valid int!");
							return;
						}

	
						key.setText((numberConverted - bonusNum) + newTxt);

					}
				
			}

				
			}});
		
		JLabel lblProficiencyBonus = new JLabel(" : Proficiency bonus");
		panel_3.add(lblProficiencyBonus, "cell 4 1,alignx right");
		
		for(JLabel key: buttonMap.keySet()){
			buttonMap.get(key).addActionListener(new RadioListener(key, txtProficiencybonustextbox, buttonMap.get(key), this.frame));
		}
		
		
		frame.setVisible(true);
	
		
	}
	public void initLabels(){
		
	}
}


//this.frame.setVisible(false);

// Add some try in case mistype the input!!!!
//
//
//characterName = JOptionPane.showInputDialog(frame,
//        "What is your name?", null);
//xpAmount = Integer.parseInt(JOptionPane.showInputDialog(frame,
//        "How much XP do you start with?", null));
//
//JTextField str = new JTextField(5);
//JTextField dex = new JTextField(5);
//JTextField con = new JTextField(5);
//JTextField intel = new JTextField(5);
//JTextField wis = new JTextField(5);
//JTextField inter = new JTextField(5);
//JTextField cha = new JTextField(5);
//
//JPanel myPanel = new JPanel();
//myPanel.add(new JLabel("Strength:"));
//myPanel.add(str);
//myPanel.add(Box.createVerticalStrut(15)); // a spacer
//myPanel.add(new JLabel("Dexterity:"));
//myPanel.add(dex);
//
//myPanel.add(new JLabel("Constitution:"));
//myPanel.add(con);
//myPanel.add(Box.createVerticalStrut(15)); // a spacer
//
//myPanel.add(new JLabel("Intelligence:"));
//myPanel.add(intel);
//myPanel.add(Box.createVerticalStrut(15)); // a spacer
//
//myPanel.add(new JLabel("Wisdom:"));
//myPanel.add(wis);
//myPanel.add(Box.createVerticalStrut(15)); // a spacer
//
//myPanel.add(new JLabel("Interfacing:"));
//myPanel.add(inter);
//myPanel.add(Box.createVerticalStrut(15)); // a spacer
//
//myPanel.add(new JLabel("Charisma:"));
//myPanel.add(cha);
//myPanel.add(Box.createVerticalStrut(15)); // a spacer
//
//int result = JOptionPane.showConfirmDialog(null, myPanel,
//    "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
//if (result == JOptionPane.OK_OPTION) {
//	abilityScores.put("strength", Integer.parseInt(str.getText()));
//	abilityScores.put("dexterity", Integer.parseInt(dex.getText()));
//	abilityScores.put("constitution", Integer.parseInt(con.getText()));
//	abilityScores.put("intelligence", Integer.parseInt(intel.getText()));
//	abilityScores.put("wisdom", Integer.parseInt(wis.getText()));
//	abilityScores.put("interfacing", Integer.parseInt(inter.getText()));
//	abilityScores.put("charisma", Integer.parseInt(cha.getText()));
//}
