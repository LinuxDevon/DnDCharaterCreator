package source;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import net.miginfocom.swing.MigLayout;

public class MainWindow {

	private JFrame frame;
	
	//////////////////////////////////////////////////////
	// Panels
	private JPanel headerPanel;
	private JPanel bottomPanel;
	private JPanel abilityPanel;
	private JPanel bottomMainPanel;
	private JPanel tablePanel;
	
	///////////////////////////////////////////////////////
	// All of the variables for the JLables so that the
	// xml parser can set them back when you create a 
	// new MainWindow.
	///////////////////////////////////////////////////////
	private Character player;
	private JPanel textAreaPanel;

	private HashMap<JLabel, String> checkedButtonList;

	private JPanel bottomLogoPanel;


	public MainWindow(JFrame frame, Character character){
		
		this.player = character;
		this.frame = frame;
		this.checkedButtonList = new HashMap<>();
		init();
	}
	
	/**
	 * Calls the methods to create the gui.
	 */
	private void init(){
		
		createPanels();
	
		createLabels();
		
		createRadioLayout(CharacterWindow.savingThrowList, 4, 2);
		createRadioLayout(CharacterWindow.skillLabelList, 5, 0);
		
		createTable();
		createSpecialElements();
		
		createTextFields();
		
	}
	
	/**
	 * Creates the JLabels for the GUI.
	 */
	private void createLabels(){
		////////////////////////////////////////////////////////////////////////
		// 	LABELS
		///////////////////////////////////////////////////////////////////////
		JLabel lblClass = new JLabel("Class: " + this.player.getData(Character.CLASS));
		headerPanel.add(lblClass, "cell 1 0,alignx center");
		
		JLabel labelCharacterName = new JLabel("Character Name: " + this.player.getData(Character.NAME) );
		headerPanel.add(labelCharacterName, "cell 0 0");
		
		JLabel lblVariant = new JLabel("Variant: " + this.player.getData(Character.VARIANT));
		headerPanel.add(lblVariant, "cell 2 0,alignx center");
		
		JLabel lblXp = new JLabel("XP: ");
		headerPanel.add(lblXp, "flowx,cell 3 0,alignx center");
	
		JLabel lblMoney = new JLabel("Money: ");
		headerPanel.add(lblMoney, "flowx,cell 0 1");

		JLabel lblSpecies = new JLabel("Species: " + this.player.getData(Character.SPECIES));
		headerPanel.add(lblSpecies, "cell 1 1,alignx center");
	
		JLabel lblAge = new JLabel("Age: " + this.player.getData(Character.AGE));
		headerPanel.add(lblAge, "cell 2 1,alignx center");

//		JLabel lblStatus = new JLabel("Wanted Status: " + this.player.getData(Character.STATUS));
//		headerPanel.add(lblStatus, "cell 3 1,alignx center");
		
		JLabel lblAc = new JLabel("AC:");
		headerPanel.add(lblAc, "flowx,cell 1 2,alignx center");
		
		JLabel lblInitiative = new JLabel("INITIATIVE: " + this.player.getData(Character.DEXMOD));
		headerPanel.add(lblInitiative, "cell 2 2,alignx center");
		
		JLabel lblSpeed = new JLabel("SPEED:");
		headerPanel.add(lblSpeed, "flowx,cell 3 2,alignx center");

		JLabel lblAbilityScore = new JLabel("Ability Score");
		abilityPanel.add(lblAbilityScore, "cell 1 0");
		
		JLabel lblModifier = new JLabel("Modifier");
		abilityPanel.add(lblModifier, "cell 2 0");
		
		JLabel lblStrength = new JLabel("Strength: ");
		abilityPanel.add(lblStrength, "cell 0 1");
		
		JLabel lblStrscr = new JLabel(this.player.getData(Character.STRABILITY));
		abilityPanel.add(lblStrscr, "cell 1 1");
		
		JLabel lblStrmod = new JLabel(this.player.getData(Character.STRMOD));
		abilityPanel.add(lblStrmod, "cell 2 1,alignx center");

		JLabel lblDexterity = new JLabel("Dexterity:");
		abilityPanel.add(lblDexterity, "cell 0 2");
		
		JLabel lblDexscr = new JLabel(this.player.getData(Character.DEXABILITY));
		abilityPanel.add(lblDexscr, "cell 1 2");
		
		JLabel lblDexmod = new JLabel(this.player.getData(Character.DEXMOD));
		abilityPanel.add(lblDexmod, "cell 2 2");
		
		JLabel lblConstitution = new JLabel("Constitution:");
		abilityPanel.add(lblConstitution, "cell 0 3");
		
		JLabel lblConscr = new JLabel(this.player.getData(Character.CONABILITY));
		abilityPanel.add(lblConscr, "cell 1 3");
		
		JLabel lblConmod = new JLabel(this.player.getData(Character.CONMOD));
		abilityPanel.add(lblConmod, "cell 2 3");
		
		JLabel lblIntelligence = new JLabel("Intelligence:");
		abilityPanel.add(lblIntelligence, "cell 0 4");
		
		JLabel lblIntscr = new JLabel(this.player.getData(Character.INTELABILITY));
		abilityPanel.add(lblIntscr, "cell 1 4");
		
		JLabel lblIntmod = new JLabel(this.player.getData(Character.INTELMOD));
		abilityPanel.add(lblIntmod, "cell 2 4");
		
		JLabel lblWisdom = new JLabel("Wisdom:");
		abilityPanel.add(lblWisdom, "cell 0 5");
		
		JLabel lblWisscr = new JLabel(this.player.getData(Character.WISABILITY));
		abilityPanel.add(lblWisscr, "cell 1 5");
		
		JLabel lblWismod = new JLabel(this.player.getData(Character.WISMOD));
		abilityPanel.add(lblWismod, "cell 2 5");
		
		JLabel lblInterfacing = new JLabel("Interfacing:");
		abilityPanel.add(lblInterfacing, "cell 0 6");
		
		JLabel lblInterscr = new JLabel(this.player.getData(Character.INTERABILITY));
		abilityPanel.add(lblInterscr, "cell 1 6");
		
		JLabel lblIntermod = new JLabel(this.player.getData(Character.INTERMOD));
		abilityPanel.add(lblIntermod, "cell 2 6");
		
		JLabel lblCharisma = new JLabel("Charisma:");
		abilityPanel.add(lblCharisma, "cell 0 7");
		
		JLabel lblChrscr = new JLabel(this.player.getData(Character.CHAABILITY));
		abilityPanel.add(lblChrscr, "cell 1 7");
		
		JLabel lblChrmod = new JLabel(this.player.getData(Character.CHAMOD));
		abilityPanel.add(lblChrmod, "cell 2 7");
		
		JLabel lblSavingThrows = new JLabel("SAVING THROWS");
		abilityPanel.add(lblSavingThrows, "cell 4 9,alignx center");
		
		JLabel lblSkills = new JLabel("SKILLS");
		abilityPanel.add(lblSkills, "cell 5 20,alignx center");
		
		JLabel lblInspiration = new JLabel("Inspiration : ");
		abilityPanel.add(lblInspiration, "cell 4 0,alignx right");
		
		JLabel lblProficiencyBonus = new JLabel("Proficiency bonus : ");
		abilityPanel.add(lblProficiencyBonus, "cell 4 1,alignx right");
		
		JLabel lblProficencies = new JLabel("Proficencies");
		bottomMainPanel.add(lblProficencies, "cell 0 0,alignx center");
		
		JLabel lblHitDice = new JLabel("Hit Dice");
		bottomPanel.add(lblHitDice, "cell 0 0,alignx center");
		
		JLabel lblCurrentHitPoints = new JLabel("Current Hit Points: ");
		bottomPanel.add(lblCurrentHitPoints, "flowx,cell 1 0");
		
		JLabel lblMaxHitPoints = new JLabel("Max Hit Points:");
		bottomPanel.add(lblMaxHitPoints, "flowx,cell 1 1");
		
		JLabel lblHitTotal = new JLabel("Hit Total: ");
		bottomPanel.add(lblHitTotal, "cell 0 2");
		
		JLabel lblCurrentStaminaPoints = new JLabel("Current Stamina Points:");
		bottomPanel.add(lblCurrentStaminaPoints, "flowx,cell 1 3");
		
		JLabel lblMaxStaminaPoints = new JLabel("Max Stamina Points:");
		bottomPanel.add(lblMaxStaminaPoints, "flowx,cell 1 4");
		
		JLabel lblSpellcastingAbility = new JLabel("SpellCasting Ability: ");
		bottomPanel.add(lblSpellcastingAbility, "flowx,cell 3 0");
		
		JLabel lblRevoAbilitySave = new JLabel("Revo Ability Save DC:");
		bottomPanel.add(lblRevoAbilitySave, "flowx,cell 3 1");
		
		JLabel lblDeathSave = new JLabel("Death Saves");
		bottomPanel.add(lblDeathSave, "cell 4 0");
		
		JLabel lblRevoAbilityAttack = new JLabel("Revo Ability Attack Mod:");
		bottomPanel.add(lblRevoAbilityAttack, "flowx,cell 3 2");
		
		JLabel lblSuccess = new JLabel("Success:");
		bottomPanel.add(lblSuccess, "flowx,cell 4 1");
		
		JLabel lblFailure = new JLabel("Failure:");
		bottomPanel.add(lblFailure, "flowx,cell 4 2,alignx trailing");
		
		JLabel lblCreator = new JLabel("Created By " + Application.AUTHOR + " for Re-Evolution: NRT Redacted © 2017" );
		lblCreator.setFont(new Font("", Font.PLAIN, 10));
		bottomPanel.add(lblCreator, "cell 8 4,alignx right");
	}
	
	private void createTextFields(){
		JTextField textFieldMoney = new JTextField(this.player.getData(Character.MONEY));
		textFieldMoney.setPreferredSize(new Dimension(80,20));
		textFieldMoney.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.MONEY, textFieldMoney, this.player));
		headerPanel.add(textFieldMoney, "cell 0 1,alignx center");
		
		JTextField textFieldXp = new JTextField(this.player.getData(Character.XP));
//		System.out.println("\nstarting = " + this.player.getData(Character.XP));
		textFieldXp.setPreferredSize(new Dimension(100, 20));
		headerPanel.add(textFieldXp, "cell 3 0");
		
		// Dependent on the XP text field
		if (this.player.getData(Character.XP).equals("")){
			this.player.saveVariable(this.player.XP, "0");
		}
		this.player.setLevel(this.player.getData(Character.XP));
		JLabel lblLevel = new JLabel("Level: " + this.player.getData(Character.LEVEL));
		headerPanel.add(lblLevel, "cell 3 0");
		
		textFieldXp.getDocument().addDocumentListener(new XpListener(textFieldXp, lblLevel, this.player));
		
		JTextField txtActextbox = new JTextField(this.player.getData(Character.AC));
		txtActextbox.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.AC, txtActextbox, this.player));
		txtActextbox.setColumns(10);
		headerPanel.add(txtActextbox, "cell 1 2");
		
		JTextField txtSpeedtextbox = new JTextField(this.player.getData(Character.SPEED));
		txtSpeedtextbox.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.SPEED, txtSpeedtextbox, this.player));
		txtSpeedtextbox.setColumns(10);
		headerPanel.add(txtSpeedtextbox, "cell 3 2");
		
		JTextField txtInspirationtextbox = new JTextField(this.player.getData(Character.INSPIRATION));
		txtInspirationtextbox.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.INSPIRATION, txtInspirationtextbox, this.player));
		txtInspirationtextbox.setColumns(10);
		abilityPanel.add(txtInspirationtextbox, "flowx,cell 4 0,alignx left");
		
		JTextField txtProficiencybonustextbox = new JTextField(this.player.getData(Character.PROFICIENCY));
		txtProficiencybonustextbox.getDocument().addDocumentListener(new DocumentListener(){
			int lastNumber = 0;
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// don't need
			}

			// Remove this code duplication eventually
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				String bonus = txtProficiencybonustextbox.getText();

				for(JLabel key: checkedButtonList.keySet()){			
					int bonusNum;
					
					try{
						bonusNum = Integer.parseInt(bonus);
						// Still need to save 
						player.saveVariable(Character.PROFICIENCY, String.valueOf(bonusNum));
						
						String modKey = checkedButtonList.get(key);
						String modifier = player.getData(modKey);
						
						int total = bonusNum + Integer.parseInt(modifier);
						String totalString = String.valueOf(total);
						
//						player.saveVariable(key, totalString);
						
						JLabel label = key;
						
						label.setText(totalString);
						
						this.lastNumber = bonusNum;
					}catch(NumberFormatException exp){
						JLabel label = key;
						String modKey = checkedButtonList.get(key);
						String modifier = player.getData(modKey);
						label.setText(modifier);
//						JOptionPane.showMessageDialog(frame, "Please make sure that the Proficency Bonus text box is a valid int! \n"
//														+ " Saving this value as 0 for now.");
					}
	
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String bonus = txtProficiencybonustextbox.getText();
				for(JLabel key: checkedButtonList.keySet()){
					int bonusNum;
					
					try{
						bonusNum = Integer.parseInt(bonus);
						
						// Still need to save 
						player.saveVariable(Character.PROFICIENCY, String.valueOf(bonusNum));
						
						String modKey = checkedButtonList.get(key);
						String modifier = player.getData(modKey);
						
						int total = bonusNum + Integer.parseInt(modifier);
						String totalString = String.valueOf(total);
						
//						player.saveVariable(key, totalString);
						
						JLabel label = key;
						
						label.setText(totalString);
						
						this.lastNumber = bonusNum;
					}catch(NumberFormatException exp){
						JLabel label = key;
						String modKey = checkedButtonList.get(key);
						String modifier = player.getData(modKey);
						label.setText(modifier);
//						JOptionPane.showMessageDialog(frame, "Please make sure that the Proficency Bonus text box is a valid int! \n"
//														+ " Saving this value as 0 for now.");
					}
	
				}
				
				
			}});
		txtProficiencybonustextbox.setColumns(10);
		abilityPanel.add(txtProficiencybonustextbox, "flowx,cell 4 1,alignx right");
		
		String bonus = txtProficiencybonustextbox.getText();
		
//		System.out.println(bonus);

		for(JLabel key: checkedButtonList.keySet()){			
			int bonusNum;
			
			try{
				bonusNum = Integer.parseInt(bonus);
				// Still need to save 
				player.saveVariable(Character.PROFICIENCY, String.valueOf(bonusNum));
				
				String modKey = checkedButtonList.get(key);
				String modifier = player.getData(modKey);
				
				int total = bonusNum + Integer.parseInt(modifier);
				String totalString = String.valueOf(total);
				
//				player.saveVariable(key, totalString);
				
				JLabel label = key;
				
				label.setText(totalString);
				
//				this.lastNumber = bonusNum;
			}catch(NumberFormatException exp){
				JLabel label = key;
				String modKey = checkedButtonList.get(key);
				String modifier = player.getData(modKey);
				label.setText(modifier);
//				JOptionPane.showMessageDialog(frame, "Please make sure that the Proficency Bonus text box is a valid int! \n"
//												+ " Saving this value as 0 for now.");
			}

		}
		
		JTextField txtStaminaPoints = new JTextField(this.player.getData(Character.CURSTAMPNTS));
		txtStaminaPoints.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.CURSTAMPNTS, txtStaminaPoints, this.player));
		txtStaminaPoints.setColumns(10);
		bottomPanel.add(txtStaminaPoints, "cell 1 3");
		
		JTextField txtMaxStaminaPoints = new JTextField(this.player.getData(Character.MAXSTAMPNTS));
		txtMaxStaminaPoints.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.MAXSTAMPNTS, txtMaxStaminaPoints, this.player));
		txtMaxStaminaPoints.setColumns(10);
		bottomPanel.add(txtMaxStaminaPoints, "cell 1 4");
		
		JTextField txtChangeabletitle1 = new JTextField(this.player.getData(Character.TITLE1));
		txtChangeabletitle1.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.TITLE1, txtChangeabletitle1, this.player));
		this.textAreaPanel.add(txtChangeabletitle1, "cell 0 0,growx");
		txtChangeabletitle1.setColumns(10);
		
		JTextField txtChangeabletitle2 = new JTextField(this.player.getData(Character.TITLE2));
		txtChangeabletitle2.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.TITLE2, txtChangeabletitle2, this.player));
		this.textAreaPanel.add(txtChangeabletitle2, "cell 1 0,growx");
		txtChangeabletitle2.setColumns(10);
		
		JTextField txtCurrenthittext = new JTextField(this.player.getData(Character.CURHITPNTS));
		txtCurrenthittext.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.CURHITPNTS, txtCurrenthittext, this.player));
		txtCurrenthittext.setColumns(10);
		this.bottomPanel.add(txtCurrenthittext, "cell 1 0");
		
		JTextField txtMaxhittext = new JTextField(this.player.getData(Character.MAXHITPNTS));
		txtMaxhittext.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.MAXHITPNTS, txtMaxhittext, this.player));
		txtMaxhittext.setColumns(10);
		bottomPanel.add(txtMaxhittext, "cell 1 1");
		
		JTextField txtSpellcastingability = new JTextField(this.player.getData(Character.SPELLCASTING));
		txtSpellcastingability.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.SPELLCASTING, txtSpellcastingability, this.player));
		txtSpellcastingability.setColumns(10);
		bottomPanel.add(txtSpellcastingability, "cell 3 0");
		
		JTextField txtRevoabilitysavedc = new JTextField(this.player.getData(Character.ABLSAVEDC));
		txtRevoabilitysavedc.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.ABLSAVEDC, txtRevoabilitysavedc, this.player));
		txtRevoabilitysavedc.setColumns(10);
		bottomPanel.add(txtRevoabilitysavedc, "cell 3 1");
		
		JTextField txtRevoabilityattackmod = new JTextField(this.player.getData(Character.ABLATTMOD));
		txtRevoabilityattackmod.getDocument().addDocumentListener(new SavingJTextFieldListener(Character.ABLATTMOD, txtRevoabilityattackmod, this.player));
		txtRevoabilityattackmod.setColumns(10);
		bottomPanel.add(txtRevoabilityattackmod, "cell 3 2");
		
		JScrollPane scrollPaneTextPane1 = new JScrollPane();
		this.textAreaPanel.add(scrollPaneTextPane1, "cell 0 1,grow");
		
		JTextArea textPane1 = new JTextArea(this.player.getData(Character.TEXTAREA1));
		textPane1.getDocument().addDocumentListener(new SavingJTextAreaListener(Character.TEXTAREA1, textPane1, this.player));
		
		
		textPane1.setLineWrap(true);
		textPane1.setWrapStyleWord(true);
		scrollPaneTextPane1.setViewportView(textPane1);
		
		JScrollPane scrollPaneTextPane2 = new JScrollPane();
		this.textAreaPanel.add(scrollPaneTextPane2, "cell 1 1,grow");
		
		JTextArea textPane2 = new JTextArea(this.player.getData(Character.TEXTAREA2));
		textPane2.getDocument().addDocumentListener(new SavingJTextAreaListener(Character.TEXTAREA2, textPane2, this.player));
		textPane2.setLineWrap(true);
		textPane2.setWrapStyleWord(true);
		scrollPaneTextPane2.setViewportView(textPane2);
		
		JScrollPane scrollPaneTextPane3 = new JScrollPane();
		this.bottomMainPanel.add(scrollPaneTextPane3, "cell 0 1,grow");
		
		JTextArea textPane3 = new JTextArea(this.player.getData(Character.TEXTAREA3));
		textPane3.getDocument().addDocumentListener(new SavingJTextAreaListener(Character.TEXTAREA3, textPane3, this.player));
		textPane3.setLineWrap(true);
		scrollPaneTextPane3.setViewportView(textPane3);
		
	}
	
	private void createSpecialElements(){
		
		String[] diceChoices = { "D4" , "D6", "D8" , "D10", "D12"};
		JComboBox<Object> comboBox = new JComboBox<Object>(diceChoices);
		
		// TODO maybe turn this into a class when add more comboboxes
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				player.setDiceCombo(index);
				
			}
			
		});
		comboBox.setSelectedIndex(this.player.getDiceCombo());
		this.bottomPanel.add(comboBox, "cell 0 1,growx");
		
		//TODO add in when i find out what i need.
		
//		JProgressBar staminaBar = new JProgressBar();
//		bottomPanel.add(staminaBar, "cell 2 3");
		
//		JProgressBar healthBar = new JProgressBar();
//		bottomPanel.add(healthBar, "cell 2 0");
	
		for(int i = 0; i < 3; i++){
			JRadioButton rdbtnSuccess = new JRadioButton();
			JRadioButton rdbtnFailure = new JRadioButton();
			String labelSuccess = "success" + (i + 1);
			String labelFailure = "failure" + (i + 1);
			
			rdbtnFailure.setSelected(this.player.getDeathSaves(labelFailure));
			rdbtnSuccess.setSelected(this.player.getDeathSaves(labelSuccess));
			
			rdbtnFailure.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					player.setDeathSaves(labelFailure, rdbtnFailure.isSelected());
					
				}});
			
			rdbtnSuccess.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					player.setDeathSaves(labelSuccess, rdbtnSuccess.isSelected());
					
				}});
			
			bottomPanel.add(rdbtnSuccess, "cell 4 1");
			bottomPanel.add(rdbtnFailure, "cell 4 2,alignx trailing");
		}
		JPanel test = new JPanel();
		ImageIcon imageIcon = new ImageIcon("Images/AppLogo.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(355, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		JLabel lblImage = new JLabel(imageIcon, SwingConstants.LEFT);
		this.bottomLogoPanel.add(lblImage);
	}
	
	private void createTable(){
		JScrollPane tableScrollPanel = new JScrollPane();
		tableScrollPanel.setPreferredSize(new Dimension(100, 150));
		
		String column[] = new String[]{"Weapon Name", "+ To Hit", "Dmg", "Mod", "Ammo","Dmg Type"};
		
		JTable mainTable = new JTable(this.player.getMainTableData(), column);
		
		mainTable.getColumnModel().getColumn(0).setPreferredWidth(300);
		mainTable.getColumnModel().getColumn(1).setPreferredWidth(25);
		mainTable.getColumnModel().getColumn(2).setPreferredWidth(25);
		mainTable.getColumnModel().getColumn(3).setPreferredWidth(25);
		mainTable.getColumnModel().getColumn(4).setPreferredWidth(25);
		
		mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		this.tablePanel.add(tableScrollPanel, "cell 0 0,grow");
		tableScrollPanel.setViewportView(mainTable);
		
		tableScrollPanel.setPreferredSize(new Dimension(500, 160));
		tableScrollPanel.setMinimumSize(new Dimension(400, 160));

		DefaultCellEditor dce = (DefaultCellEditor)mainTable.getDefaultEditor(Object.class);
		JTextField editor = (JTextField)dce.getComponent();
		editor.getDocument().addDocumentListener(new SavingTableListener(mainTable, this.player, editor));

	}

	private void createPanels() {
		///////////////////////////////////////////////////////////////////////
		//	PANELS
		headerPanel = new JPanel();
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new MigLayout("", "[144px,grow][75px,grow][150px,grow][100px,grow][]", "[30px][30px][30px]"));
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(100,250));
		bottomPanel.setLayout(new MigLayout("", "[60px][250px][][250px][100px][25px][25px][25px]", "[40px][40px][40px][40px][40px]"));
		
		bottomLogoPanel = new JPanel();
		
		abilityPanel = new JPanel();
		frame.getContentPane().add(abilityPanel, BorderLayout.WEST);
		//		MigLayout layout = new MigLayout("", "[65px,center][65px,center][65px,center][20px][200px][20px][175px]", "[30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][25px,center][25px,center][25px,center]");
		MigLayout layout = new MigLayout("", "[65px,center][65px,center][65px,center][20px][200px]", "[30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][30px,center][25px,center][25px,center][25px,center]");
		abilityPanel.setLayout(layout);
		
		bottomMainPanel = new JPanel();
		bottomMainPanel.setPreferredSize(new Dimension(150,250));
		frame.getContentPane().add(bottomMainPanel, BorderLayout.SOUTH);
		bottomMainPanel.setLayout(new MigLayout("", "[:10px:300px,grow,left][grow]", "[][grow]"));
		
		bottomMainPanel.add(bottomPanel, "cell 1 1,grow");
		bottomMainPanel.add(bottomLogoPanel, "cell 2 1,grow");
		
		tablePanel = new JPanel();
		this.frame.getContentPane().add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		this.tablePanel.add(this.textAreaPanel, "cell 0 1,grow");
		
	}
	
	/**
	 * Creates the layout based on the given list of strings. It makes the
	 * Radio buttons associate with the appropriate label.
	 * 
	 */
	private void createRadioLayout(ArrayList<String> list, int startingColumn, int startingRow){
		int index = startingRow;
		boolean select = false;
		System.out.print(list.size());
		for(String labelName: list){
			JRadioButton radioButton = new JRadioButton();
			if(this.player.getRadioButton(labelName) == 1){
				radioButton.setSelected(true);
				select = true;
			} else {
				radioButton.setSelected(false);
				select = false;
			}
			radioButton.setEnabled(false);
			
			this.abilityPanel.add(radioButton, "cell " + startingColumn + " " + index);
			
			String modifier = this.player.getRadioButtonModifier(list, labelName);
			JLabel modifierLabel = new JLabel(modifier);
			this.abilityPanel.add(modifierLabel, "cell " + startingColumn + " " + index);

			if(select){
				 this.checkedButtonList.put(modifierLabel, this.player.getModifier(list, labelName));
			}
			JLabel label = new JLabel(" : " + labelName);
			this.abilityPanel.add(label, "cell " + startingColumn + " " + index);
			index++;
 
		}
	}
}
