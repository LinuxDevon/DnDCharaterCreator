package source;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTextField txtStrength;
	private JTextField txtDexterity;
	private JTextField txtConstitution;
	private JTextField txtIntelligence;
	private JTextField txtWisdom;
	private JTextField txtInterfacing;
	private JTextField txtCharisma;
	
	private JLabel lblTotalPoints;
	
//	private final Character character;
	
	private JFormattedTextField frmtdtxtfldCharacterinput;
	private JFormattedTextField formattedStartingXP;
	private JTextField txtMoney;
	private JTextField txtClass;
	private JTextField txtRank;
	private JTextField txtSpecies;
	private JTextField txtVariant;
	private JTextField txtAgentnum;
	private JLabel lblChamod;
	private JLabel lblCharisma;
	private JLabel lblIntmod_1;
	private JLabel lblStrmod;
	private JLabel lblDexmod;
	private JLabel lblConmod;
	private JLabel lblIntmod;
	private JLabel lblWismod;
	// Need to create array list of of the fields to pass to the Document Listener
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewCharacterWindow dialog = new NewCharacterWindow(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the dialog.
	 * @param frame 
	 * @param window 
	 */
	public NewCharacterWindow(JFrame frame, Character character, ApplicationGUI window) {
		
		
		setBounds(100, 100, 669, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[100px][150px][100px][150px][150px]", "[][20px][20px][][20px][20px][20px][20px][20px][20px][20px][20px][20px]"));
		{
			JLabel lblClass = new JLabel("Class:");
			contentPanel.add(lblClass, "cell 3 0,alignx trailing");
		}
		{
			txtClass = new JTextField();
//			txtClass.setText("Class");
			contentPanel.add(txtClass, "cell 4 0,growx");
			txtClass.setColumns(10);
		}
		{
			JLabel lblRank = new JLabel("Rank:");
			contentPanel.add(lblRank, "cell 3 1,alignx trailing");
		}
		{
			txtRank = new JTextField();
//			txtRank.setText("Rank");
			contentPanel.add(txtRank, "cell 4 1,growx");
			txtRank.setColumns(10);
		}
		{
			JLabel lblStartingMoney = new JLabel("Starting Money:");
			contentPanel.add(lblStartingMoney, "cell 0 2,alignx trailing");
		}
		{
			txtMoney = new JTextField();
			contentPanel.add(txtMoney, "cell 1 2,growx");
			txtMoney.setColumns(10);
		}
		{
			JLabel lblSpecies = new JLabel("Species:");
			contentPanel.add(lblSpecies, "cell 3 2,alignx trailing");
		}
		{
			txtSpecies = new JTextField();
//			txtSpecies.setText("Species");
			contentPanel.add(txtSpecies, "cell 4 2,growx");
			txtSpecies.setColumns(10);
		}
		{
			JLabel lblMutLvl = new JLabel("MUT LVL / HUM Variant:");
			contentPanel.add(lblMutLvl, "cell 3 3,alignx trailing");
		}
		{
			txtVariant = new JTextField();
//			txtVariant.setText("Variant");
			contentPanel.add(txtVariant, "cell 4 3,growx");
			txtVariant.setColumns(10);
		}
		{
			JLabel lblAgentNumber = new JLabel("Agent Number:");
			contentPanel.add(lblAgentNumber, "cell 3 4,alignx trailing");
		}
		{
			txtAgentnum = new JTextField();
//			txtAgentnum.setText("AgentNum");
			contentPanel.add(txtAgentnum, "cell 4 4,growx");
			txtAgentnum.setColumns(10);
		}

		{
			JLabel lblCharacterName = new JLabel("Character Name:");
			contentPanel.add(lblCharacterName, "cell 0 0,alignx trailing");
		}
		{
			frmtdtxtfldCharacterinput = new JFormattedTextField();
			frmtdtxtfldCharacterinput.setText("");
			contentPanel.add(frmtdtxtfldCharacterinput, "cell 1 0,growx");
			
		}
		{
			JLabel lblStartingxp = new JLabel("StartingXP:");
			contentPanel.add(lblStartingxp, "cell 0 1,alignx trailing");
		}
		{
			formattedStartingXP = new JFormattedTextField();
			contentPanel.add(formattedStartingXP, "cell 1 1,growx");
		}
		{
			JLabel labelSpacer = new JLabel("---------------------------");
			contentPanel.add(labelSpacer, "cell 0 3");
		}
		{
			JLabel label = new JLabel("-----------------------------------");
			contentPanel.add(label, "cell 1 3");
		}
		{
			JLabel lblAbilityScore = new JLabel("Ability Scores");
			contentPanel.add(lblAbilityScore, "cell 0 4,alignx center");
		}
		{
			JLabel lblModifier = new JLabel("Modifier");
			contentPanel.add(lblModifier, "cell 2 4,alignx center");
		}
		{
			JLabel lblStrength = new JLabel("Strength:");
			contentPanel.add(lblStrength, "cell 0 5,alignx trailing");
		}
		{
			txtStrength = new JTextField();
			txtStrength.setText("8");
			contentPanel.add(txtStrength, "cell 1 5,growx");
			txtStrength.setColumns(10);
		}
		{
			lblStrmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtStrength.getText()))));
			contentPanel.add(lblStrmod, "cell 2 5,alignx center");
		}
		{
			JLabel lblDexterity = new JLabel("Dexterity:");
			contentPanel.add(lblDexterity, "cell 0 6,alignx trailing");
		}
		{
			txtDexterity = new JTextField();
			txtDexterity.setText("8");
			contentPanel.add(txtDexterity, "cell 1 6,growx");
			txtDexterity.setColumns(10);
		}
		{
			lblDexmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtDexterity.getText()))));
			contentPanel.add(lblDexmod, "cell 2 6,alignx center");
		}
		{
			JLabel lblConsitution = new JLabel("Consitution:");
			contentPanel.add(lblConsitution, "cell 0 7,alignx trailing");
		}
		{
			txtConstitution = new JTextField();
			txtConstitution.setText("8");
			contentPanel.add(txtConstitution, "cell 1 7,growx");
			txtConstitution.setColumns(10);
		}
		{
			lblConmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtConstitution.getText()))));
			contentPanel.add(lblConmod, "cell 2 7,alignx center");
		}
		{
			JLabel lblIntelligence = new JLabel("Intelligence:");
			contentPanel.add(lblIntelligence, "cell 0 8,alignx trailing");
		}
		{
			txtIntelligence = new JTextField();
			txtIntelligence.setText("8");
			contentPanel.add(txtIntelligence, "cell 1 8,growx");
			txtIntelligence.setColumns(10);
		}
		{
			lblIntmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtIntelligence.getText()))));
			contentPanel.add(lblIntmod, "cell 2 8,alignx center");
		}
		{
			JLabel lblWisdom = new JLabel("Wisdom:");
			contentPanel.add(lblWisdom, "cell 0 9,alignx trailing");
		}
		{
			txtWisdom = new JTextField();
			txtWisdom.setText("8");
			contentPanel.add(txtWisdom, "cell 1 9,growx");
			txtWisdom.setColumns(10);
		}
		{
			lblWismod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtWisdom.getText()))));
			contentPanel.add(lblWismod, "cell 2 9,alignx center");
		}
		{
			JLabel lblInterfacing = new JLabel("Interfacing:");
			contentPanel.add(lblInterfacing, "cell 0 10,alignx trailing");
		}
		{
			txtInterfacing = new JTextField();
			txtInterfacing.setText("8");
			contentPanel.add(txtInterfacing, "cell 1 10,growx");
			txtInterfacing.setColumns(10);
		}
		{
			lblIntmod_1 = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtInterfacing.getText()))));
			contentPanel.add(lblIntmod_1, "cell 2 10,alignx center");
		}
		{
			lblCharisma = new JLabel("Charisma:");
			contentPanel.add(lblCharisma, "cell 0 11,alignx trailing");
		}
		{
			txtCharisma = new JTextField();
			txtCharisma.setText("8");
			contentPanel.add(txtCharisma, "cell 1 11,growx");
			txtCharisma.setColumns(10);
		}
		{
			lblChamod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtCharisma.getText()))));
			contentPanel.add(lblChamod, "cell 2 11,alignx center");
			
			
		}
		{
			lblTotalPoints = new JLabel("31");
			contentPanel.add(lblTotalPoints, "cell 1 12");
		}
		{
			JLabel lblTotalRemaining = new JLabel("Total Remaining:");
			contentPanel.add(lblTotalRemaining, "cell 0 12,alignx trailing");
		}
		
		// make for loop for doc listener eventually
//		for(int i = 0; i < 8; i++){
//			DocListener listener1 = new DocListener(txtCharisma, lblTotalPoints, lblChamod);
//			txtCharisma.getDocument().addDocumentListener(listener1);
//		}
		DocListener listener1 = new DocListener(txtCharisma, lblTotalPoints, lblChamod);
		txtCharisma.getDocument().addDocumentListener(listener1);
		
		
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
						data.put("strengthAbility", txtStrength.getText());
						data.put("dexterityAbility", txtDexterity.getText());
						data.put("constitutionAbility", txtConstitution.getText());
						data.put("intelligenceAbility", txtIntelligence.getText());
						data.put("wisdomAbility", txtWisdom.getText());
						data.put("interfacingAbility", txtInterfacing.getText());
						data.put("charismaAbility", txtCharisma.getText());
						
						data.put("strengthMod", lblStrmod.toString());
						data.put("dexterityMod", lblDexmod.toString());
						data.put("consititutionMod", lblConmod.toString());
						data.put("intelligenceMod", lblIntmod.toString());
						data.put("wisdomMod", lblWismod.toString());
						data.put("interfacingMod", lblIntmod_1.toString());
						data.put("charismaAbility", lblChamod.toString());
						
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
		int abilityMod;
		abilityMod = (int) Math.floor(((abilityScore -10)/2));
		return abilityMod;
	}

}
