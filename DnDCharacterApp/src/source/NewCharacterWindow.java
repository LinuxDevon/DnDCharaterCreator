package source;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	// Need to create array list of of the fields to pass to the Document Listener
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			NewCharacterWindow dialog = new NewCharacterWindow(null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param frame 
	 */
	public NewCharacterWindow(JFrame frame) {
		setBounds(100, 100, 555, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[100px][150px][100px]", "[][20px][][20px][20px][20px][20px][20px][20px][20px][20px][20px]"));
		{
			lblTotalPoints = new JLabel("30");
			contentPanel.add(lblTotalPoints, "cell 1 11");
		}
		{
			JLabel lblCharacterName = new JLabel("Character Name:");
			contentPanel.add(lblCharacterName, "cell 0 0,alignx trailing");
		}
		{
			JFormattedTextField frmtdtxtfldCharacterinput = new JFormattedTextField();
			frmtdtxtfldCharacterinput.setText("");
			contentPanel.add(frmtdtxtfldCharacterinput, "cell 1 0,growx");
			
		}
		{
			JLabel lblStartingxp = new JLabel("StartingXP:");
			contentPanel.add(lblStartingxp, "cell 0 1,alignx trailing");
		}
		{
			JFormattedTextField formattedTextField = new JFormattedTextField();
			contentPanel.add(formattedTextField, "cell 1 1,growx");
		}
		{
			JLabel labelSpacer = new JLabel("---------------------------");
			contentPanel.add(labelSpacer, "cell 0 2");
		}
		{
			JLabel label = new JLabel("-----------------------------------");
			contentPanel.add(label, "cell 1 2");
		}
		{
			JLabel lblAbilityScore = new JLabel("Ability Scores");
			contentPanel.add(lblAbilityScore, "cell 0 3,alignx center");
		}
		{
			JLabel lblModifier = new JLabel("Modifier");
			contentPanel.add(lblModifier, "cell 2 3,alignx center");
		}
		{
			JLabel lblStrength = new JLabel("Strength:");
			contentPanel.add(lblStrength, "cell 0 4,alignx trailing");
		}
		{
			txtStrength = new JTextField();
			txtStrength.setText("7");
			contentPanel.add(txtStrength, "cell 1 4,growx");
			txtStrength.setColumns(10);
		}
		{
			JLabel lblStrmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtStrength.getText()))));
			contentPanel.add(lblStrmod, "cell 2 4,alignx center");
		}
		{
			JLabel lblDexterity = new JLabel("Dexterity:");
			contentPanel.add(lblDexterity, "cell 0 5,alignx trailing");
		}
		{
			txtDexterity = new JTextField();
			txtDexterity.setText("7");
			contentPanel.add(txtDexterity, "cell 1 5,growx");
			txtDexterity.setColumns(10);
		}
		{
			JLabel lblDexmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtDexterity.getText()))));
			contentPanel.add(lblDexmod, "cell 2 5,alignx center");
		}
		{
			JLabel lblConsitution = new JLabel("Consitution:");
			contentPanel.add(lblConsitution, "cell 0 6,alignx trailing");
		}
		{
			txtConstitution = new JTextField();
			txtConstitution.setText("7");
			contentPanel.add(txtConstitution, "cell 1 6,growx");
			txtConstitution.setColumns(10);
		}
		{
			JLabel lblConmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtConstitution.getText()))));
			contentPanel.add(lblConmod, "cell 2 6,alignx center");
		}
		{
			JLabel lblIntelligence = new JLabel("Intelligence:");
			contentPanel.add(lblIntelligence, "cell 0 7,alignx trailing");
		}
		{
			txtIntelligence = new JTextField();
			txtIntelligence.setText("7");
			contentPanel.add(txtIntelligence, "cell 1 7,growx");
			txtIntelligence.setColumns(10);
		}
		{
			JLabel lblIntmod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtIntelligence.getText()))));
			contentPanel.add(lblIntmod, "cell 2 7,alignx center");
		}
		{
			JLabel lblWisdom = new JLabel("Wisdom:");
			contentPanel.add(lblWisdom, "cell 0 8,alignx trailing");
		}
		{
			txtWisdom = new JTextField();
			txtWisdom.setText("7");
			contentPanel.add(txtWisdom, "cell 1 8,growx");
			txtWisdom.setColumns(10);
		}
		{
			JLabel lblWismod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtWisdom.getText()))));
			contentPanel.add(lblWismod, "cell 2 8,alignx center");
		}
		{
			JLabel lblInterfacing = new JLabel("Interfacing:");
			contentPanel.add(lblInterfacing, "cell 0 9,alignx trailing");
		}
		{
			txtInterfacing = new JTextField();
			txtInterfacing.setText("7");
			contentPanel.add(txtInterfacing, "cell 1 9,growx");
			txtInterfacing.setColumns(10);
		}
		{
			JLabel lblIntmod_1 = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtInterfacing.getText()))));
			contentPanel.add(lblIntmod_1, "cell 2 9,alignx center");
		}
		{
			JLabel lblCharisma = new JLabel("Charisma:");
			contentPanel.add(lblCharisma, "cell 0 10,alignx trailing");
		}
		{
			txtCharisma = new JTextField();
			txtCharisma.setText("7");
			contentPanel.add(txtCharisma, "cell 1 10,growx");
			txtCharisma.setColumns(10);
		}
		{
			JLabel lblChamod = new JLabel(String.valueOf(modifierCalc(Integer.parseInt(txtCharisma.getText()))));
			contentPanel.add(lblChamod, "cell 2 10,alignx center");
			DocListener listener1 = new DocListener(txtCharisma, lblTotalPoints, lblChamod);
			txtCharisma.getDocument().addDocumentListener(listener1);
		}
		{
			JLabel lblTotalRemaining = new JLabel("Total Remaining:");
			contentPanel.add(lblTotalRemaining, "cell 0 11,alignx trailing");
		}
		

		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("DONE");
//				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// save here with xml maybe
						//exit this app and focus the main one
						frame.setVisible(true); 
						dispose(); // kill the frame
						
					}});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
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
