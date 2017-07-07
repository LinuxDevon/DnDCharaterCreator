package source;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class NewCharacterWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JLabel lblTotalPoints;
	
	private HashMap<JLabel, JTextField> abilityFields = new HashMap<>();
//	private ArrayList<JTextField> textboxList = new ArrayList<>();
	private ArrayList<JLabel> scrLabelList	= new ArrayList<>();
	private ArrayList<JLabel> modLabelList	= new ArrayList<>();
//	private final Character character;
	
//	private JFormattedTextField frmtdtxtfldCharacterinput;
//	private JFormattedTextField formattedStartingXP;
//	private JTextField txtMoney;
//	private JTextField txtClass;
//	private JTextField txtRank;
//	private JTextField txtSpecies;
//	private JTextField txtVariant;
//	private JTextField txtAgentnum;
//	private JLabel lblChamod;
//	private JLabel lblCharisma;
//	private JLabel lblIntmod_1;
//	private JLabel lblStrmod;
//	private JLabel lblDexmod;
//	private JLabel lblConmod;
//	private JLabel lblIntmod;
//	private JLabel lblWismod;
	// Need to create array list of of the fields to pass to the Document Listener
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			NewCharacterWindow dialog = new NewCharacterWindow(null, null, null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	/**
	 * Create the dialog.
	 * @param frame 
	 * @param window 
	 */
	public NewCharacterWindow(JFrame frame, Character character, ApplicationGUI window) {
		
		
		setBounds(100, 100, 720, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[100px][150px][100px][75px][75px][150px][150px]", "[][20px][20px][][20px][20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		JLabel lblClass = new JLabel("Class:");
		contentPanel.add(lblClass, "cell 5 0,alignx trailing");
	
	
		JTextField txtClass = new JTextField();
//			txtClass.setText("Class");
		contentPanel.add(txtClass, "cell 6 0,growx");
		txtClass.setColumns(10);
	
		JLabel lblRank = new JLabel("Rank:");
		contentPanel.add(lblRank, "cell 5 1,alignx trailing");
	
	
		JTextField txtRank = new JTextField();
//			txtRank.setText("Rank");
		contentPanel.add(txtRank, "cell 6 1,growx");
		txtRank.setColumns(10);
	
		JLabel lblStartingMoney = new JLabel("Starting Money:");
		contentPanel.add(lblStartingMoney, "cell 0 2,alignx trailing");
	
	
		JTextField txtMoney = new JTextField();
		contentPanel.add(txtMoney, "cell 1 2,growx");
		txtMoney.setColumns(10);
	
		
		JLabel lblSpecies = new JLabel("Species:");
		contentPanel.add(lblSpecies, "cell 5 2,alignx trailing");
	
	
		JTextField txtSpecies = new JTextField();
//			txtSpecies.setText("Species");
		contentPanel.add(txtSpecies, "cell 6 2,growx");
		txtSpecies.setColumns(10);
	
	
		
		JLabel lblMutLvl = new JLabel("MUT LVL / HUM Variant:");
		contentPanel.add(lblMutLvl, "cell 5 3,alignx trailing");
	
	
		JTextField txtVariant = new JTextField();
//			txtVariant.setText("Variant");
		contentPanel.add(txtVariant, "cell 6 3,growx");
		txtVariant.setColumns(10);
	
	
		JLabel lblAgentNumber = new JLabel("Agent Number:");
		contentPanel.add(lblAgentNumber, "cell 5 4,alignx trailing");
	
	
		JTextField txtAgentnum = new JTextField();
//			txtAgentnum.setText("AgentNum");
		contentPanel.add(txtAgentnum, "cell 6 4,growx");
		txtAgentnum.setColumns(10);
	

	
		JLabel lblCharacterName = new JLabel("Character Name:");
		contentPanel.add(lblCharacterName, "cell 0 0,alignx trailing");
	
	
		JFormattedTextField frmtdtxtfldCharacterinput = new JFormattedTextField();
		frmtdtxtfldCharacterinput.setText("");
		contentPanel.add(frmtdtxtfldCharacterinput, "cell 1 0,growx");
		
	
	
		JLabel lblStartingxp = new JLabel("StartingXP:");
		contentPanel.add(lblStartingxp, "cell 0 1,alignx trailing");

		JFormattedTextField formattedStartingXP = new JFormattedTextField();
		contentPanel.add(formattedStartingXP, "cell 1 1,growx");

		JLabel labelSpacer = new JLabel("---------------------------");
		contentPanel.add(labelSpacer, "cell 0 3");

		JLabel label = new JLabel("-----------------------------------");
		contentPanel.add(label, "cell 1 3");

		JLabel lblAbilityScore = new JLabel("Ability Scores");
		contentPanel.add(lblAbilityScore, "cell 0 4,alignx center");
		
		JLabel lblModifier = new JLabel("Modifier");
		contentPanel.add(lblModifier, "cell 2 4,alignx center");

		JLabel lblStrength = new JLabel("Strength:");
		contentPanel.add(lblStrength, "cell 0 5,alignx trailing");
		
		JLabel lblStrscr = new JLabel("8");
		contentPanel.add(lblStrscr, "cell 1 5");
		scrLabelList.add(lblStrscr);
		
		JLabel lblStrmod = new JLabel("" + modifierCalc(Integer.parseInt(lblStrscr.getText())));
		contentPanel.add(lblStrmod, "cell 2 5,alignx center");
		modLabelList.add(lblStrmod);

		JLabel lblDexterity = new JLabel("Dexterity:");
		contentPanel.add(lblDexterity, "cell 0 6,alignx trailing");
		
		JLabel lblDexscr = new JLabel("8");
		contentPanel.add(lblDexscr, "cell 1 6");
		scrLabelList.add(lblDexscr);
		
		JLabel lblDexmod = new JLabel("" + modifierCalc(Integer.parseInt(lblDexscr.getText())));
		contentPanel.add(lblDexmod, "cell 2 6,alignx center");
		modLabelList.add(lblDexmod);

		JLabel lblConsitution = new JLabel("Consitution:");
		contentPanel.add(lblConsitution, "cell 0 7,alignx trailing");
		
		JLabel lblConscr = new JLabel("8");
		contentPanel.add(lblConscr, "cell 1 7");
		scrLabelList.add(lblConscr);
		
		JLabel lblConmod = new JLabel("" + modifierCalc(Integer.parseInt(lblConscr.getText())));
		contentPanel.add(lblConmod, "cell 2 7,alignx center");
		modLabelList.add(lblConmod);

		JLabel lblIntelligence = new JLabel("Intelligence:");
		contentPanel.add(lblIntelligence, "cell 0 8,alignx trailing");
		
		JLabel lblIntscr = new JLabel("8");
		contentPanel.add(lblIntscr, "cell 1 8");
		scrLabelList.add(lblIntscr);
		
		JLabel lblIntmod = new JLabel("" + modifierCalc(Integer.parseInt(lblIntscr.getText())));
		contentPanel.add(lblIntmod, "cell 2 8,alignx center");
		modLabelList.add(lblIntmod);

		JLabel lblWisdom = new JLabel("Wisdom:");
		contentPanel.add(lblWisdom, "cell 0 9,alignx trailing");
		
		JLabel lblWisscr = new JLabel("8");
		contentPanel.add(lblWisscr, "cell 1 9");
		scrLabelList.add(lblWisscr);
		
		JLabel lblWismod = new JLabel("" + modifierCalc(Integer.parseInt(lblWisscr.getText())));
		contentPanel.add(lblWismod, "cell 2 9,alignx center");
		modLabelList.add(lblWismod);
		
		JLabel lblInterfacing = new JLabel("Interfacing:");
		contentPanel.add(lblInterfacing, "cell 0 10,alignx trailing");
		
		JLabel lblInterscr = new JLabel("8");
		contentPanel.add(lblInterscr, "cell 1 10");
		scrLabelList.add(lblInterscr);
		
		JLabel lblIntmod_1 = new JLabel("" + modifierCalc(Integer.parseInt(lblInterscr.getText())));
		contentPanel.add(lblIntmod_1, "cell 2 10,alignx center");
		modLabelList.add(lblIntmod_1);
		
		JLabel lblCharisma = new JLabel("Charisma:");
		contentPanel.add(lblCharisma, "cell 0 11,alignx trailing");
		
		JLabel lblChrscr = new JLabel("8");
		contentPanel.add(lblChrscr, "cell 1 11");
		scrLabelList.add(lblChrscr);
		
		JLabel lblChamod = new JLabel("" + modifierCalc(Integer.parseInt(lblChrscr.getText())));
		contentPanel.add(lblChamod, "cell 2 11,alignx center");
		modLabelList.add(lblChamod);
		
		lblTotalPoints = new JLabel("31");
		contentPanel.add(lblTotalPoints, "cell 1 12");

		JLabel lblTotalRemaining = new JLabel("Total Remaining:");
		contentPanel.add(lblTotalRemaining, "cell 0 12,alignx trailing");
	
		
		// make for loop for doc listener eventually
//		for(JLabel key: abilityFields.keySet()){
//			textboxList.add(abilityFields.get(key));
//			DocListener listener1 = new DocListener(abilityFields.get(key), lblTotalPoints, key, textboxList);
//			abilityFields.get(key).getDocument().addDocumentListener(listener1);
//		}
//		DocListener listener1 = new DocListener(txtCharisma, lblTotalPoints, lblChamod);
//		txtCharisma.getDocument().addDocumentListener(listener1);
		
		// Buttons that might be in edit character page.
		for(int i = 0; i < 7; i++){
			JButton btnUp_i = new JButton("up");
			int index = i;
			btnUp_i.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JLabel label = scrLabelList.get(index);
					int labelNumber = Integer.parseInt(label.getText());
					if(labelNumber < 0 ){
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
			contentPanel.add(btnUp_i, "cell 3 " + (i + 5));
		}
		
		for(int i = 0; i < 7; i++){
			JButton btnUp_i = new JButton("down");
			int index = i;
			btnUp_i.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JLabel label = scrLabelList.get(index);
					int labelNumber = Integer.parseInt(label.getText());
					if(labelNumber < 0 ){
						label.setText("0");
						return;
					}else if(labelNumber > 40){
						label.setText("40");
						return;
					}
					label.setText("" + (labelNumber - 1));
//					label = scrLabelList.get(index);
					labelNumber = Integer.parseInt(label.getText());
					
					modLabelList.get(index).setText("" + modifierCalc(labelNumber));
//					System.out.println(modLabelList.get(index).getText());
					lblTotalPoints.setText("" + (Integer.parseInt(lblTotalPoints.getText()) + 1));
				}});
			contentPanel.add(btnUp_i, "cell 4 " + (i + 5));
		}
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("DONE");
//				okButton.setActionCommand("OK");
//				okButton.addActionListener(new DoneButtonListener(character, window , this, formattedStartingXP, frmtdtxtfldCharacterinput));
				okButton.addActionListener(new ActionListener(){

					private Character player;
					HashMap<String, String> data = new HashMap<>();

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// save here with xml maybe
						//exit this app and focus the main one
						data.put("strengthAbility", scrLabelList.get(0).getText());
						data.put("dexterityAbility", scrLabelList.get(1).getText());
						data.put("constitutionAbility", scrLabelList.get(2).getText());
						data.put("intelligenceAbility", scrLabelList.get(3).getText());
						data.put("wisdomAbility", scrLabelList.get(4).getText());
						data.put("interfacingAbility", scrLabelList.get(5).getText());
						data.put("charismaAbility", scrLabelList.get(6).getText());
						
						data.put("strengthMod", lblStrmod.getText());
						data.put("dexterityMod", lblDexmod.getText());
						data.put("consititutionMod", lblConmod.getText());
						data.put("intelligenceMod", lblIntmod.getText());
						data.put("wisdomMod", lblWismod.getText());
						data.put("interfacingMod", lblIntmod_1.getText());
						data.put("charismaMod", lblChamod.getText());
						
						data.put("name", frmtdtxtfldCharacterinput.getText());
						data.put("money", txtMoney.getText());
						data.put("class", txtClass.getText());
						data.put("rank", txtRank.getText());
						data.put("species", txtSpecies.getText());
						data.put("variant", txtVariant.getText());
						data.put("agentNumber", txtAgentnum.getText());	
						
						this.player = new Character(Integer.valueOf(formattedStartingXP.getText()), data);
//						modifierCalc(5);
//						final character = null;
						
						dispose(); // kill the frame
						window.initialize(this.player);
						
					}});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}});
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	public int modifierCalc(int abilityScore){
		double abilityMod;
//		System.out.println((((double) abilityScore -10)/2));
		abilityMod = Math.floor((((double) abilityScore -10)/2));
		return (int) abilityMod;
	}

}
