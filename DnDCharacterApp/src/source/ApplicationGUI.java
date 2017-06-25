package source;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Panel;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.border.EtchedBorder;
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

public class ApplicationGUI {

	private JFrame frame;
	private Character player;
	private JTable table;
	private JTable table_1;
	
	private NewCharacterWindow dialog;
	private JTable table_2;

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
	
	public void initializeOptionPanel(){
		String characterName;
		int xpAmount;
		HashMap<String, Integer> abilityScores = new HashMap<>();
		
		if (JOptionPane.showConfirmDialog(null, "Do you want to create a new character?", "New Character?",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			
			this.frame.setVisible(false);
			
			// Add some try in case mistype the input!!!!
			//
			//
//			characterName = JOptionPane.showInputDialog(frame,
//	                "What is your name?", null);
//			xpAmount = Integer.parseInt(JOptionPane.showInputDialog(frame,
//	                "How much XP do you start with?", null));
//			
//			JTextField str = new JTextField(5);
//		    JTextField dex = new JTextField(5);
//		    JTextField con = new JTextField(5);
//		    JTextField intel = new JTextField(5);
//		    JTextField wis = new JTextField(5);
//		    JTextField inter = new JTextField(5);
//		    JTextField cha = new JTextField(5);
//
//		    JPanel myPanel = new JPanel();
//		    myPanel.add(new JLabel("Strength:"));
//		    myPanel.add(str);
//		    myPanel.add(Box.createVerticalStrut(15)); // a spacer
//		    myPanel.add(new JLabel("Dexterity:"));
//		    myPanel.add(dex);
//		    
//		    myPanel.add(new JLabel("Constitution:"));
//		    myPanel.add(con);
//		    myPanel.add(Box.createVerticalStrut(15)); // a spacer
//		    
//		    myPanel.add(new JLabel("Intelligence:"));
//		    myPanel.add(intel);
//		    myPanel.add(Box.createVerticalStrut(15)); // a spacer
//		    
//		    myPanel.add(new JLabel("Wisdom:"));
//		    myPanel.add(wis);
//		    myPanel.add(Box.createVerticalStrut(15)); // a spacer
//		    
//		    myPanel.add(new JLabel("Interfacing:"));
//		    myPanel.add(inter);
//		    myPanel.add(Box.createVerticalStrut(15)); // a spacer
//		    
//		    myPanel.add(new JLabel("Charisma:"));
//		    myPanel.add(cha);
//		    myPanel.add(Box.createVerticalStrut(15)); // a spacer
//
//		    int result = JOptionPane.showConfirmDialog(null, myPanel,
//		        "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
//		    if (result == JOptionPane.OK_OPTION) {
//		    	abilityScores.put("strength", Integer.parseInt(str.getText()));
//		    	abilityScores.put("dexterity", Integer.parseInt(dex.getText()));
//		    	abilityScores.put("constitution", Integer.parseInt(con.getText()));
//		    	abilityScores.put("intelligence", Integer.parseInt(intel.getText()));
//		    	abilityScores.put("wisdom", Integer.parseInt(wis.getText()));
//		    	abilityScores.put("interfacing", Integer.parseInt(inter.getText()));
//		    	abilityScores.put("charisma", Integer.parseInt(cha.getText()));
//		    }
			dialog = new NewCharacterWindow(this.frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setAutoRequestFocus(true);
			dialog.setAlwaysOnTop(true);
			
		} else {
			characterName = null;
			xpAmount = 0;
			abilityScores = null;
			
		}
//		Character player = new Character(characterName, xpAmount, abilityScores);
		this.player = player;
		
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		initializeOptionPanel();

		
		frame.setBounds(100, 100, 1547, 1027);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/////////////////////////////////////////////////////////////////////////
		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnReference = new JMenu("Reference");
		menuBar.add(mnReference);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenu mnEditCharacter = new JMenu("Edit Character");
		menuBar.add(mnEditCharacter);
		
		JMenu mnUpdate = new JMenu("Update");
		menuBar.add(mnUpdate);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[144px,grow][75px,grow][150px,grow][100px,grow][]", "[30px][30px][30px]"));
		
		String characterName = null;
		String className = null;
		
		/////////////////////////////////////////////////////////////////////////
		// Header of the APP
		JLabel lblNewLabel_3 = new JLabel("Class: " + className);
		panel.add(lblNewLabel_3, "cell 1 0,alignx center");
		
		JLabel lblRank = new JLabel("Rank:");
		panel.add(lblRank, "cell 2 0,alignx center");
		
		JLabel lblXp = new JLabel("XP:");
		panel.add(lblXp, "cell 3 0,alignx center");
		
		JLabel lblMoney = new JLabel("Money!!!!!!!!!!");
		panel.add(lblMoney, "flowx,cell 0 1");
		
		JLabel lblSpecies = new JLabel("Species:");
		panel.add(lblSpecies, "cell 1 1,alignx center");
		
		JLabel lblMutLvl = new JLabel("MUT LVL / HUM VARIANT");
		panel.add(lblMutLvl, "cell 2 1,alignx center");
		
		JLabel lblAgentNumber = new JLabel("Agent Number:");
		panel.add(lblAgentNumber, "cell 3 1,alignx center");
		JLabel labelCharacterName = new JLabel("Character Name: " + characterName );
		panel.add(labelCharacterName, "cell 0 0");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setPreferredSize(new Dimension(80,20));
		panel.add(formattedTextField, "cell 0 1,alignx center");
		
		JLabel lblAc = new JLabel("AC:");
		panel.add(lblAc, "cell 1 2,alignx center");
		
		JLabel lblInitiative = new JLabel("INITIATIVE: ");
		panel.add(lblInitiative, "cell 2 2,alignx center");
		
		JLabel lblSpeed = new JLabel("SPEED:");
		panel.add(lblSpeed, "cell 3 2,alignx center");
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Left side with ability score, saving throws, and skills
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		MigLayout layout = new MigLayout("", "[65px,center][65px,center][65px,center][175px][175px]", "[30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center]");
		
		panel_3.setLayout(layout);
		
		JLabel lblAbility = new JLabel("Ability");
		panel_3.add(lblAbility, "cell 0 0");
		
		JLabel lblAbilityScore = new JLabel("Ability Score");
		panel_3.add(lblAbilityScore, "cell 1 0");
		
		JLabel lblModifier = new JLabel("Modifier");
		panel_3.add(lblModifier, "cell 2 0");
		
		JLabel lblInspiration = new JLabel(": Inspiration");
		panel_3.add(lblInspiration, "cell 3 0,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel(": Acrobatics (DEX)");
		panel_3.add(lblNewLabel_4, "cell 4 0,alignx center");
		
		JLabel lblStrength = new JLabel("Strength: ");
		panel_3.add(lblStrength, "cell 0 1");
		
		JLabel lblProficiencyBonus = new JLabel(": Proficiency bonus");
		panel_3.add(lblProficiencyBonus, "cell 3 1,alignx center");
		
		JLabel lblAnimalHandling = new JLabel(": Animal Handling (WIS)");
		panel_3.add(lblAnimalHandling, "cell 4 1,alignx center");
		
//		JLabel lblStrScore = new JLabel(this.player.getAbilityScore("strength"));
//		panel_3.add(lblStrScore, "cell 1 1");
		
		JLabel lblDexterity = new JLabel("Dexterity:");
		panel_3.add(lblDexterity, "cell 0 2");
		
		JLabel lblStrength_1 = new JLabel(": Strength");
		panel_3.add(lblStrength_1, "cell 3 2,alignx center");
		
		JLabel lblAthleticsstr = new JLabel(": ATHLETICS (STR)");
		panel_3.add(lblAthleticsstr, "cell 4 2,alignx center");
		
		JLabel lblConstitution = new JLabel("Constitution:");
		panel_3.add(lblConstitution, "cell 0 3");
		
		JLabel lblDexterity_1 = new JLabel(": Dexterity");
		panel_3.add(lblDexterity_1, "cell 3 3,alignx center");
		
		JLabel lblDeceptioncha = new JLabel(": Deception (CHA)");
		panel_3.add(lblDeceptioncha, "cell 4 3,alignx center");
		
		JLabel lblIntelligence = new JLabel("Intelligence:");
		panel_3.add(lblIntelligence, "cell 0 4");
		
		JLabel lblConsititution = new JLabel(": Consititution");
		panel_3.add(lblConsititution, "cell 3 4,alignx center");
		
		JLabel lblHistoryint = new JLabel(": History (INT)");
		panel_3.add(lblHistoryint, "cell 4 4,alignx center");
		
		JLabel lblWisdom = new JLabel("Wisdom:");
		panel_3.add(lblWisdom, "cell 0 5");
		
		JLabel lblWisdom_1 = new JLabel(": Wisdom");
		panel_3.add(lblWisdom_1, "cell 3 5,alignx center");
		
		JLabel lblInsightwis = new JLabel(": Insight (WIS)");
		panel_3.add(lblInsightwis, "cell 4 5,alignx center");
		
		JLabel lblInterfacing = new JLabel("Interfacing:");
		panel_3.add(lblInterfacing, "cell 0 6");
		
		JLabel lblInterfacing_1 = new JLabel(": Interfacing");
		panel_3.add(lblInterfacing_1, "cell 3 6,alignx center");
		
		JLabel lblIntimidationcha = new JLabel(": Intimidation (CHA)");
		panel_3.add(lblIntimidationcha, "cell 4 6,alignx center");
		
		JLabel lblCharisma = new JLabel("Charisma:");
		panel_3.add(lblCharisma, "cell 0 7");
		
		JLabel lblCharisma_1 = new JLabel(": Charisma");
		panel_3.add(lblCharisma_1, "cell 3 7,alignx center");
		
		JLabel lblInvestigationint = new JLabel(": Investigation (INT)");
		panel_3.add(lblInvestigationint, "cell 4 7,alignx center");
		
		JLabel lblSavingThrows = new JLabel("SAVING THROWS");
		panel_3.add(lblSavingThrows, "cell 3 8,alignx center");
		
		JLabel lblMechanicsinf = new JLabel(": Mechanics (INF)");
		panel_3.add(lblMechanicsinf, "cell 4 8,alignx center");
		
		JLabel lblMedicinewis = new JLabel(": Medicine (WIS)");
		panel_3.add(lblMedicinewis, "cell 4 9,alignx center");
		
		JLabel lblNatureint = new JLabel(": Nature (INT)");
		panel_3.add(lblNatureint, "cell 4 10,alignx center");
		
		JLabel lblPerceptionwis = new JLabel(": Perception (WIS)");
		panel_3.add(lblPerceptionwis, "cell 4 11,alignx center");
		
		JLabel lblPerformancecha = new JLabel(": Performance (CHA)");
		panel_3.add(lblPerformancecha, "cell 4 12,alignx center");
		
		JLabel lblNewLabel_5 = new JLabel(": Persuasion (CHA)");
		panel_3.add(lblNewLabel_5, "cell 4 13,alignx center");
		
		JLabel lblProgramminginf = new JLabel(": Programming (INF)");
		panel_3.add(lblProgramminginf, "cell 4 14,alignx center");
		
		JLabel lblReligionint = new JLabel(": Religion (INT)");
		panel_3.add(lblReligionint, "cell 4 15,alignx center");
		
		JLabel lblSleightOf = new JLabel(": Sleight of Hand (DEX)");
		panel_3.add(lblSleightOf, "cell 4 16,alignx center");
		
		JLabel lblStealthdex = new JLabel(": Stealth (DEX)");
		panel_3.add(lblStealthdex, "cell 4 17,alignx center");
		
		JLabel lblSurvivalwis = new JLabel(": Survival (WIS)");
		panel_3.add(lblSurvivalwis, "cell 4 18,alignx center");
		
		JLabel lblVehicleHandling = new JLabel(": Vehicle Handling (INF)");
		panel_3.add(lblVehicleHandling, "cell 4 19,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(100,300));
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new MigLayout("", "[:10px:300px,grow,left]", "[][10px,grow]"));
		
		JLabel lblNewLabel = new JLabel("Proficencies");
		panel_4.add(lblNewLabel, "cell 0 0,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, "cell 0 1,grow");
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane.setViewportView(textArea_2);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_1.add(lblNewLabel_2, "cell 1 0,alignx center");
		
		JTextPane textPane = new JTextPane();
		panel_1.add(textPane, "cell 0 1,grow");
		
		JTextPane textPane_1 = new JTextPane();
		panel_1.add(textPane_1, "cell 1 1,grow");
		
		// Buttons that might be in edit character page.
//		for(int i = 0; i < 7; i++){
//			JButton btnUp_i = new JButton("up");
//			panel_3.add(btnUp_i, "cell 3 " + (i + 1));
//		}
//		
//		for(int i = 0; i < 7; i++){
//			JButton btnUp_i = new JButton("down");
//			panel_3.add(btnUp_i, "cell 4 " + (i + 1));
//		}
		
	
		
	}

}
